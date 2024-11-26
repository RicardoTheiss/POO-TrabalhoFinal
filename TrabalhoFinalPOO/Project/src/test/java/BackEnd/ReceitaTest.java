package BackEnd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author kauan
 */
public class ReceitaTest {
    
    private Receita receita;

    @BeforeEach
    public void setUp() {
        // Cria uma instância de Receita antes de cada teste
        receita = new Receita(2000.0, "SALARIO", 20231125);
    }

    @Test
    public void testGetData() {
        // Verificar se o método getData retorna corretamente a data da receita
        int expResult = 20231125;
        int result = receita.getData();
        assertEquals(expResult, result, "O método getData não retornou o valor esperado.");
    }

    @Test
    public void testGetValor() {
        // Verificar se o método getValor retorna corretamente o valor da receita
        double expResult = 2000.0;
        double result = receita.getValor();
        assertEquals(expResult, result, 0.01, "O método getValor não retornou o valor esperado.");
    }

    @Test
    public void testGetTipo() {
        // Verificar se o método getTipo retorna corretamente o tipo da receita
        TipoLancamento expResult = TipoLancamento.SALARIO;
        TipoLancamento result = receita.getTipo();
        assertEquals(expResult, result, "O método getTipo não retornou o tipo esperado.");
    }

    @Test
    public void testSetData() {
        // Testar o método setData com um valor válido
        int novaData = 20231225;
        receita.setData(novaData);
        assertEquals(novaData, receita.getData(), "O método setData não alterou a data corretamente.");
    }

    @Test
    public void testSetDataInvalida() {
        // Testar o método setData com um valor inválido (menor ou igual a 0)
        assertThrows(IllegalArgumentException.class, () -> {
            receita.setData(0);
        }, "O método setData deveria lançar uma exceção para data inválida.");
    }

    @Test
    public void testSetValor() {
        // Testar o método setValor com um valor válido
        double novoValor = 2500.0;
        receita.setValor(novoValor);
        assertEquals(novoValor, receita.getValor(), 0.01, "O método setValor não alterou o valor corretamente.");
    }

    @Test
    public void testSetValorInvalido() {
        // Testar o método setValor com um valor inválido (menor ou igual a 0)
        assertThrows(IllegalArgumentException.class, () -> {
            receita.setValor(0);
        }, "O método setValor deveria lançar uma exceção para valor inválido.");
    }

    @Test
    public void testSetTipo() {
        // Testar o método setTipo com um tipo válido
        receita.setTipo("ALUGUEL");
        assertEquals(TipoLancamento.ALUGUEL, receita.getTipo(), "O método setTipo não alterou o tipo corretamente.");
    }

    @Test
    public void testSetTipoInvalido() {
        // Testar o método setTipo com um tipo inválido
        assertThrows(IllegalArgumentException.class, () -> {
            receita.setTipo("TIPO_INEXISTENTE");
        }, "O método setTipo deveria lançar uma exceção para tipo inválido.");
    }
}
