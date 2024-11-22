public class Receita implements Lancamento{
    public double valor = 0;
    public TipoLancamento tipo;
    public int data = 0;

    public Receita(double valor, String tipo, int data){
        setValor(valor);
        setTipo(tipo);
        setData(data);
    }

    public int getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }

    public TipoLancamento getTipo() {
        return tipo;
    }

    @Override
    public void setData(int data) {
        if(data <= 0){
            throw new IllegalArgumentException("Data inválida");
        }
        this.data = data;
    }

    @Override
    public void setTipo(String tipo) {
        try{
            TipoLancamento tipoLancamento = TipoLancamento.valueOf(tipo.toUpperCase());
            this.tipo = tipoLancamento;
        }catch(Exception e){
            throw new IllegalArgumentException("Categora informada inválida");
        }
    }

    @Override
    public void setValor(double valor) {
        if(valor <= 0){
            throw new IllegalArgumentException("Valor de receita inválido");
        }
        this.valor = valor;
    }
}
