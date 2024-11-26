package BackEnd;

/// Interface que representa um lançamento financeiro.

public interface Lancamento {
    /// Valor do lançamento financeiro.
    public double valor = 0;

    /// Tipo do lançamento financeiro.
    /// Representa a categoria do lançamento.
    public TipoLancamento tipo = null;

    /// Data do lançamento financeiro no formato yyyyMMdd.
    public int data = 0;

    /// @return a data no formato yyyyMMdd.
    public default int getData() {
        return data;
    }

    /// @return o valor do lançamento.
    public default double getValor() {
        return valor;
    }

    /// @return o tipo do lançamento.
    public default TipoLancamento getTipo() {
        return tipo;
    }

    /// @param data a data no formato yyyyMMdd.
    void setData(int data);

    /// @param tipo o tipo do lançamento como String.
    void setTipo(String tipo);

    /// @param valor: o valor do lançamento.
    void setValor(double valor);
}
