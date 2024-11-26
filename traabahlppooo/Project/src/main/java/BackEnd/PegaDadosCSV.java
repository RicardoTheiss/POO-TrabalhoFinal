package BackEnd;

import java.io.BufferedReader;
import java.io.FileReader;

public class PegaDadosCSV {
    private String caminhoArquivo;

    public PegaDadosCSV(String caminho){
        setCaminho(caminho);
        LancaDados();
    }

    public String getCaminho() {
        return caminhoArquivo;
    }

    public void setCaminho(String caminho) {
        this.caminhoArquivo = caminho;
    }

    private void LancaDados(){
        final String separador = ";";
        ControladorFinanceiro cf = ControladorFinanceiro.getInstancia();
        String linha;

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            br.readLine();

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(separador);

                int data = Integer.parseInt(dados[0]);
                String categoria = dados[1];
                double valor = Double.parseDouble(dados[2]);

                Lancamento lancto;
                if(valor > 0){
                    lancto = new Receita(valor, categoria, data);
                }else {
                    lancto = new Despesa(valor, categoria, data);
                }
                cf.adicionarLancto(lancto);
            }
        } catch (Exception e) {
            System.out.println("Erro no metodo LancaDados()" + e.getMessage());
        }
    }
}
