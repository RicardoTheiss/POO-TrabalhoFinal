package BackEnd;
import java.text.Normalizer;

/// Representa uma despesa financeira, implementando a interface Lancamento.
/// Cada despesa possui um valor negativo, um tipo (categoria), e uma data associada.
public class Despesa implements Lancamento {
    /// Valor da despesa (sempre negativo)
    public double valor = 0;

    /// Tipo da despesa (categoria)
    public TipoLancamento tipo = null;

    /// Data da despesa no formato yyyyMMdd
    public int data = 0;

    /// Construtor da classe Despesa.
    /// Inicializa a despesa com um valor, tipo e data fornecidos.
    /// @param valor: o valor da despesa (positivo: será armazenado como negativo).
    /// @param tipo: o tipo (categoria) da despesa.
    /// @param data: a data da despesa no formato yyyyMMdd.
    public Despesa(double valor, String tipo, int data) {
        setValor(valor);
        setTipo(tipo);
        setData(data);
    }

    /// Retorna a data da despesa.
    /// @return a data no formato yyyyMMdd.
    public int getData() {
        return data;
    }

    /// Retorna o valor da despesa.
    /// @return o valor (sempre negativo).
    public double getValor() {
        return valor;
    }

    /// Retorna o tipo (categoria) da despesa.
    /// @return o tipo da despesa.
    public TipoLancamento getTipo() {
        return tipo;
    }

    /// Define a data da despesa.
    /// @param data a data no formato yyyyMMdd.
    /// @throws IllegalArgumentException se a data for inválida (<= 0).
    public void setData(int data) {
        if (data <= 0) {
            throw new IllegalArgumentException("Data inválida");
        }
        this.data = data;
    }

    /// Define o tipo (categoria) da despesa.
    /// @param tipo o tipo da despesa como String.
    /// @throws IllegalArgumentException se o tipo for inválido.
    public void setTipo(String tipo) {
        try {
            String formattedTipo = formatarParaEnum(tipo);
            TipoLancamento tipoLancamento = TipoLancamento.valueOf(formattedTipo);
            this.tipo = tipoLancamento;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Categoria informada inválida");
        }
    }

    /// Define o valor da despesa.
    /// @param valor o valor da despesa (positivo; será armazenado como negativo).
    /// @throws IllegalArgumentException se o valor for menor ou igual a 0.
    public void setValor(double valor) {
        this.valor = Math.abs(valor) * -1;
    }
    
    private String formatarParaEnum(String tipo) {
        // Remove acentos
        String normalized = Normalizer.normalize(tipo, Normalizer.Form.NFD);
        normalized = normalized.replaceAll("[^\\p{ASCII}]", ""); // Remove caracteres não-ASCII

        // Substitui espaços por "_" e converte para maiúsculas
        return normalized.replaceAll("\\s+", "_").toUpperCase();
    }
}
