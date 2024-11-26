package BackEnd;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ControladorFinanceiro {
    private static ControladorFinanceiro instancia;

    // Lista de lançamentos compartilhada
    private ArrayList<Lancamento> listaLanctos = new ArrayList<>();

    // Construtor privado para evitar múltiplas instâncias
    private ControladorFinanceiro() {}

    // Método para obter a instância única da classe
    public static ControladorFinanceiro getInstancia() {
        if (instancia == null) {
            instancia = new ControladorFinanceiro();
        }
        return instancia;
    }

    public void adicionarLancto(Lancamento lancto){
        System.out.println("incluir despesa ricardo - " + lancto.getValor());
        listaLanctos.add(lancto);
        System.out.println("incluiu despesa ricardo - " + listaLanctos.size());
    }

    public ArrayList<Lancamento> retornaLancamentos(){
        System.out.println("pegou despesa ricardo - " + listaLanctos.size());
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
