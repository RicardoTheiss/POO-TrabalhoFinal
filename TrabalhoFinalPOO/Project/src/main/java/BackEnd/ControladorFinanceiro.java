package BackEnd;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


 /// Classe responsável por gerenciar as operações financeiras de lançamentos e saldo.
 /// Permite adicionar lançamentos, retornar a lista de lançamentos, e calcular o saldo com base
 /// em uma data de base ou sem considerar a data.

public class ControladorFinanceiro {
    // Instância única da classe
    private static ControladorFinanceiro instancia;

    // Lista de lançamentos compartilhada
    private ArrayList<Lancamento> listaLanctos = new ArrayList<>();

    // Construtor privado para evitar múltiplas instâncias
    private ControladorFinanceiro() {}

     /// Obtém a instância única da classe.   
     /// @return a instância única de ControladorFinanceiro.

    public static ControladorFinanceiro getInstancia() {
        if (instancia == null) {
            instancia = new ControladorFinanceiro();
        }
        return instancia;
    }

    /// Adiciona um novo lançamento financeiro à lista de lançamentos.
    /// @param lancto o lançamento financeiro a ser adicionado.

    public void adicionarLancto(Lancamento lancto) {
        System.out.println("Incluir despesa - " + lancto.getValor());
        listaLanctos.add(lancto);
        System.out.println("Despesa incluída. Total de lançamentos: " + listaLanctos.size());
    }

    /// Retorna a lista de todos os lançamentos financeiros.  
    /// @return uma lista de lançamentos financeiros.
    
    public ArrayList<Lancamento> retornaLancamentos() {
        System.out.println("Total de lançamentos retornados: " + listaLanctos.size());
        return listaLanctos;
    }

     /// Calcula o saldo financeiro com base nos lançamentos armazenados.
     /// @param indicaSemDataBase se for true, calcula o saldo ignorando as datas dos lançamentos;
     /// se for false, considera apenas lançamentos com data inferior à data atual.
     /// @return o saldo financeiro calculado.
     /// @throws Exception se ocorrer um erro inesperado durante o cálculo do saldo.
    public double pegaSaldo(final boolean indicaSemDataBase) throws Exception {
        try {
            double saldo = 0;
            final int dataHoje = pegaDataAtual();
            for (int i = 0; i < listaLanctos.size(); i++) {
                Lancamento lancto = listaLanctos.get(i);
                if (!indicaSemDataBase && lancto.getData() < dataHoje) {
                    saldo += lancto.getValor();
                } else if (indicaSemDataBase) {
                    saldo += lancto.getValor();
                }
            }
            return saldo;
        } catch (NumberFormatException e) {
            throw e;
        } catch (Exception e) {
            System.out.println("Erro no método pegaSaldo(): " + e.getMessage());
            throw new Exception("Erro inesperado ao calcular o saldo");
        }
    }

    /// Obtém a data atual no formato yyyyMMdd.
    ///@return a data atual como um número inteiro.
    /// @throws NumberFormatException se ocorrer um erro ao formatar ou converter a data.
    
    private int pegaDataAtual() {
        try {
            LocalDate dataAtual = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
            return Integer.parseInt(dataAtual.format(formatter));
        } catch (NumberFormatException e) {
            System.out.println("Erro no método formataData: " + e.getMessage());
            throw new NumberFormatException("Erro ao pegar a data atual");
        }
    }
}
