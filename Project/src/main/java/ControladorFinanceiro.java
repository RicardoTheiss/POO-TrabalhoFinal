import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ControladorFinanceiro {
    private ArrayList <Lancamento> listaLanctos = new ArrayList<>();

    public ControladorFinanceiro(Lancamento lancto){
        listaLanctos.add(lancto);
    }

    public ArrayList<Lancamento> retornaLancamentos(){
        return listaLanctos;
    }

    public double pegaSaldo(final boolean indicaSemDataBase) throws Exception {
        try{
            double saldo = 0;
            final int dataHoje = pegaDataAtual();
            for (int i = 0; i < listaLanctos.size(); i++) {
                Lancamento lancto = listaLanctos.get(i);
                if(!indicaSemDataBase && lancto.getData() < dataHoje){
                    saldo += lancto.getValor();
                }else if(indicaSemDataBase){
                    saldo += lancto.getValor();
                }
            }
            return saldo;
        }catch(NumberFormatException e){
            throw e;
        }catch(Exception e){
            System.out.println("Erro no metodo pegaSaldo()" + e.getMessage());
            throw new Exception("Erro inesperado ao calclar o saldo");
        }
    }


    private int pegaDataAtual(){
        try{
            LocalDate dataAtual = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
            return Integer.parseInt(dataAtual.format(formatter));
        }catch(NumberFormatException e){
            System.out.println("Erro no metodo formata data -> " + e.getMessage());
            throw new NumberFormatException("Erro ao pegar a data atual");
        }
    }
}
