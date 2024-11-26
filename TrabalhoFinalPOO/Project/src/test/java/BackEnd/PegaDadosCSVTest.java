package BackEnd;

import BackEnd.ControladorFinanceiro;
import BackEnd.PegaDadosCSV;
import BackEnd.Lancamento;
import BackEnd.Receita;
import BackEnd.Despesa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PegaDadosCSVTest {
    private ControladorFinanceiro controlador;
    private PegaDadosCSV pegaDadosCSV;
    private final String caminhoTeste = "teste.csv";

    @BeforeEach
    public void setUp() throws Exception {
        controlador = ControladorFinanceiro.getInstancia();
        controlador.retornaLancamentos().clear();
        criaArquivoCSVDeTeste();
        pegaDadosCSV = new PegaDadosCSV(caminhoTeste);
    }

    /// Cria um arquivo CSV de teste com dados fictícios.
    private void criaArquivoCSVDeTeste() throws Exception {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoTeste))) {
            writer.write("Data;Categoria;Valor");
            writer.newLine();
            writer.write("01/11/2024;SALARIO;1000.00");
            writer.newLine();
            writer.write("15/11/2024;ALUGUEL;-500.00");
            writer.newLine();
        }
    }

    @Test
    public void testLancaDados() {
        pegaDadosCSV.lancaDados();
        ArrayList<Lancamento> lancamentos = controlador.retornaLancamentos();

        assertEquals(2, lancamentos.size());
        assertEquals(1000.00, lancamentos.get(0).getValor());
        assertEquals("SALARIO", lancamentos.get(0).getTipo());

        assertEquals(-500.00, lancamentos.get(1).getValor());
        assertEquals("ALUGUEL", lancamentos.get(1).getTipo());
    }

    @Test
    public void testSalvaDados() {
        ArrayList<Lancamento> lancamentos = new ArrayList<>();
        lancamentos.add(new Receita(1000.00, "SALARIO", 20241101));
        lancamentos.add(new Despesa(-500.00, "ALUGUEL", 20241115));

        pegaDadosCSV.salvaDados(lancamentos);
        
        PegaDadosCSV pegaDadosValidacao = new PegaDadosCSV(caminhoTeste);
        pegaDadosValidacao.lancaDados();
        ArrayList<Lancamento> lancamentosLidos = controlador.retornaLancamentos();

        assertEquals(2, lancamentosLidos.size());
        assertEquals(1000.00, lancamentosLidos.get(0).getValor());
        assertEquals(-500.00, lancamentosLidos.get(1).getValor());
    }
}
