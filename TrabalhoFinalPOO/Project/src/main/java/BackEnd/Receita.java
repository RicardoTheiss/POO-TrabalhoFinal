package BackEnd;
import java.text.Normalizer;

/// Representa uma receita financeira, implementando a interface Lancamento.

/// Cada receita possui um valor positivo, um tipo (categoria) e uma data associada.
public class Receita implements Lancamento {
    /// Valor da receita.
    public double valor = 0;

    /// Tipo da receita (categoria).
    public TipoLancamento tipo;

    /// Data da receita no formato yyyyMMdd.
    public int data = 0;

    /// Construtor da classe Receita.
    /// @param valor: o valor da receita (deve ser positivo).
    /// @param tipo: o tipo ou categoria da receita.
    /// @param data: a data da receita no formato yyyyMMdd.
    public Receita(double valor, String tipo, int data) {
        setValor(valor);
        setTipo(tipo);
        setData(data);
    }

    /// @return a data no formato yyyyMMdd.
    public int getData() {
        return data;
    }

    /// @return o valor da receita (sempre positivo).
    public double getValor() {
        return valor;
    }

    /// @return o tipo da receita.
    public TipoLancamento getTipo() {
        return tipo;
    }

    /// @param data a data no formato yyyyMMdd.
    /// @throws IllegalArgumentException se a data for menor ou igual a 0.
    @Override
    public void setData(int data) {
        if (data <= 0) {
            throw new IllegalArgumentException("Data inválida");
        }
        this.data = data;
    }

    /// @param tipo: o tipo da receita como String.
    /// @throws IllegalArgumentException se o tipo for inválido ou não existir em TipoLancamento.
    @Override
    public void setTipo(String tipo) {
        try {
            String formattedTipo = formatarParaEnum(tipo);
            TipoLancamento tipoLancamento = TipoLancamento.valueOf(formattedTipo);
            this.tipo = tipoLancamento;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Categoria informada inválida");
        }
    }

    /// @param valor o valor da receita (deve ser positivo).
    /// @throws IllegalArgumentException se o valor for menor ou igual a 0.
    @Override
    public void setValor(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de receita inválido");
        }
        this.valor = valor;
    }
    
    private String formatarParaEnum(String tipo) {
        // Remove acentos
        String normalized = Normalizer.normalize(tipo, Normalizer.Form.NFD);
        normalized = normalized.replaceAll("[^\\p{ASCII}]", ""); // Remove caracteres não-ASCII

        // Substitui espaços por "_" e converte para maiúsculas
        return normalized.replaceAll("\\s+", "_").toUpperCase();
    }
}
