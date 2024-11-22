public interface Lancamento {
    public double valor = 0;
    public TipoLancamento tipo = null;
    public int data = 0;

    public default int getData() {
        return data;
    }

    public default double getValor() {
        return valor;
    }

    public default TipoLancamento getTipo() {
        return tipo;
    }

    void setData(int data);

    void setTipo(String tipo);

    void setValor(double valor);
}
