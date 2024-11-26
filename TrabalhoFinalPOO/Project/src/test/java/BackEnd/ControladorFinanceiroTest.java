/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package BackEnd;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author kauan
 */
public class ControladorFinanceiroTest {
    
    public ControladorFinanceiroTest() {
    }
    
    private ControladorFinanceiro controlador;
    
    @BeforeEach
    public void setUp() {
        // Reseta a instância antes de cada teste
        controlador = ControladorFinanceiro.getInstancia();
        // Limpa a lista de lançamentos (pode ser necessário implementar um método auxiliar para limpar os lançamentos)
        controlador.retornaLancamentos().clear();
    }

    /**
     * Test of getInstancia method, of class ControladorFinanceiro.
     */
   @Test
    public void testGetInstancia() {
        System.out.println("Teste: getInstancia");
        ControladorFinanceiro instancia1 = ControladorFinanceiro.getInstancia();
        ControladorFinanceiro instancia2 = ControladorFinanceiro.getInstancia();
        assertSame(instancia1, instancia2, "A instância deve ser única (singleton)");
    }

    @Test
    public void testAdicionarLancto() {
        System.out.println("Teste: adicionarLancto");
        Lancamento receita = new Receita(500.0, "SALARIO", 20240101);
        controlador.adicionarLancto(receita);

        ArrayList<Lancamento> lancamentos = controlador.retornaLancamentos();
        assertFalse(lancamentos.isEmpty(), "A lista de lançamentos não deve estar vazia após adicionar um lançamento");
        assertEquals(1, lancamentos.size(), "A lista de lançamentos deve conter exatamente 1 item");
        assertEquals(receita, lancamentos.get(0), "O lançamento adicionado deve ser igual ao primeiro item da lista");
    }

    @Test
    public void testRetornaLancamentos() {
        System.out.println("Teste: retornaLancamentos");
        Lancamento despesa = new Despesa(100.0, "ALIMENTACAO", 20240101);
        controlador.adicionarLancto(despesa);

        ArrayList<Lancamento> lancamentos = controlador.retornaLancamentos();
        assertNotNull(lancamentos, "A lista de lançamentos não deve ser nula");
        assertEquals(1, lancamentos.size(), "A lista de lançamentos deve conter exatamente 1 item");
        assertEquals(despesa, lancamentos.get(0), "O lançamento retornado deve corresponder ao que foi adicionado");
    }

    @Test
    public void testPegaSaldoComDataBase() throws Exception {
        System.out.println("Teste: pegaSaldo (com data base)");
        controlador.adicionarLancto(new Receita(500.0, "SALARIO", 20240101));
        controlador.adicionarLancto(new Despesa(100.0, "ALIMENTACAO", 20231201));

        double saldo = controlador.pegaSaldo(false);
        assertEquals(400.0, saldo, 0.01, "O saldo deve considerar apenas os lançamentos até a data de hoje");
    }

    @Test
    public void testPegaSaldoSemDataBase() throws Exception {
        System.out.println("Teste: pegaSaldo (sem data base)");
        controlador.adicionarLancto(new Receita(500.0, "SALARIO", 20240101));
        controlador.adicionarLancto(new Despesa(100.0, "ALIMENTACAO", 20250101));

        double saldo = controlador.pegaSaldo(true);
        assertEquals(400.0, saldo, 0.01, "O saldo deve considerar todos os lançamentos, independente da data");
    }

    @Test
    public void testPegaSaldoSemLancamentos() throws Exception {
        System.out.println("Teste: pegaSaldo (sem lançamentos)");
        double saldo = controlador.pegaSaldo(true);
        assertEquals(0.0, saldo, 0.01, "O saldo deve ser 0.0 quando não houver lançamentos");
    }
}