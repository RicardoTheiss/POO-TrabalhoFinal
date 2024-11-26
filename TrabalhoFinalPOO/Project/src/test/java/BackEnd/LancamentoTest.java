package BackEnd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LancamentoTest {

    private Lancamento despesa;
    private Lancamento receita;

    @BeforeEach
    public void setUp() {
        // Instanciando objetos de Despesa e Receita para os testes.
        despesa = new Despesa(100.0, "ALUGUEL", 20231125);  // Exemplo de despesa
        receita = new Receita(500.0, "SALARIO", 20231101);  // Exemplo de receita
    }

    @Test
    public void testGetValor() {
        System.out.println("testGetValor");
        // Verificando se o valor das despesas e receitas são retornados corretamente
        assertEquals(-100.0, despesa.getValor(), 0.01);  // Valor negativo para despesas
        assertEquals(500.0, receita.getValor(), 0.01);   // Valor positivo para receitas
    }

    @Test
    public void testGetTipo() {
        System.out.println("testGetTipo");
        // Verificando se o tipo das despesas e receitas são retornados corretamente
        assertEquals(TipoLancamento.ALUGUEL, despesa.getTipo());
        assertEquals(TipoLancamento.SALARIO, receita.getTipo());
    }

    @Test
    public void testGetData() {
        System.out.println("testGetData");
        // Verificando se a data é retornada corretamente
        assertEquals(20231125, despesa.getData());
        assertEquals(20231101, receita.getData());
    }

    @Test
    public void testSetDataValido() {
        System.out.println("testSetDataValido");
        // Testando se a data é definida corretamente
        despesa.setData(20231201);
        assertEquals(20231201, despesa.getData());
    }

    @Test
    public void testSetDataInvalido() {
        System.out.println("testSetDataInvalido");
        // Testando se exceção é lançada quando a data é inválida
        assertThrows(IllegalArgumentException.class, () -> despesa.setData(0));
        assertThrows(IllegalArgumentException.class, () -> despesa.setData(-20231125));
    }

    @Test
    public void testSetTipoValido() {
        System.out.println("testSetTipoValido");
        // Testando se o tipo é definido corretamente
        despesa.setTipo("SAUDE");
        assertEquals(TipoLancamento.SAUDE, despesa.getTipo());
    }

    @Test
    public void testSetTipoInvalido() {
        System.out.println("testSetTipoInvalido");
        // Testando se exceção é lançada quando um tipo inválido é passado
        assertThrows(IllegalArgumentException.class, () -> despesa.setTipo("INVALIDO"));
    }

    @Test
    public void testSetValorValido() {
        System.out.println("testSetValorValido");
        // Testando se o valor é definido corretamente
        despesa.setValor(200.0);
        assertEquals(-200.0, despesa.getValor(), 0.01);  // O valor deve ser negativo para despesas
    }

    @Test
    public void testSetValorInvalido() {
        System.out.println("testSetValorInvalido");
        // Testando se exceção é lançada quando o valor é inválido
        assertThrows(IllegalArgumentException.class, () -> despesa.setValor(0));
        assertThrows(IllegalArgumentException.class, () -> despesa.setValor(-1));
    }
}
