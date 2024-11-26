package BackEnd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DespesaTest {

    private Despesa despesa;

    @BeforeEach
    public void setUp() {
        // Criaremos uma despesa com valor, tipo e data válidos antes de cada teste
        despesa = new Despesa(100.0, "alimentacao", 20231126);
    }

    /**
     * Testa o método getData da classe Despesa.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        int expResult = 20231126;
        int result = despesa.getData();
        assertEquals(expResult, result);
    }

    /**
     * Testa o método getValor da classe Despesa (o valor deve ser negativo).
     */
    @Test
    public void testGetValor() {
        System.out.println("getValor");
        double expResult = -100.0; // O valor é armazenado como negativo
        double result = despesa.getValor();
        assertEquals(expResult, result, 0);
    }

    /**
     * Testa o método getTipo da classe Despesa.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        TipoLancamento expResult = TipoLancamento.ALIMENTACAO; // Assume-se que 'alimentacao' seja uma categoria válida
        TipoLancamento result = despesa.getTipo();
        assertEquals(expResult, result);
    }

    /**
     * Testa o método setData da classe Despesa com uma data válida.
     */
    @Test
    public void testSetDataValido() {
        System.out.println("setData - válido");
        int novaData = 20231201;
        despesa.setData(novaData);
        assertEquals(novaData, despesa.getData());
    }

    /**
     * Testa o método setData da classe Despesa com uma data inválida (<= 0).
     */
    @Test
    public void testSetDataInvalido() {
        System.out.println("setData - inválido");
        assertThrows(IllegalArgumentException.class, () -> despesa.setData(-1), "Data inválida");
    }

    /**
     * Testa o método setTipo da classe Despesa com tipo válido.
     */
    @Test
    public void testSetTipoValido() {
        System.out.println("setTipo - válido");
        despesa.setTipo("ALIMENTACAO");
        assertEquals(TipoLancamento.ALIMENTACAO, despesa.getTipo());
    }

    /**
     * Testa o método setTipo da classe Despesa com tipo inválido.
     */
    @Test
    public void testSetTipoInvalido() {
        System.out.println("setTipo - inválido");
        assertThrows(IllegalArgumentException.class, () -> despesa.setTipo("invalid"), "Categoria informada inválida");
    }

    /**
     * Testa o método setValor da classe Despesa com valor válido.
     */
    @Test
    public void testSetValorValido() {
        System.out.println("setValor - válido");
        double novoValor = 200.0;
        despesa.setValor(novoValor);
        assertEquals(-200.0, despesa.getValor());
    }

    /**
     * Testa o método setValor da classe Despesa com valor inválido (<= 0).
     */
    @Test
    public void testSetValorInvalido() {
        System.out.println("setValor - inválido");
        assertThrows(IllegalArgumentException.class, () -> despesa.setValor(0), "Valor de receita inválido");
        assertThrows(IllegalArgumentException.class, () -> despesa.setValor(-50), "Valor de receita inválido");
    }
}
