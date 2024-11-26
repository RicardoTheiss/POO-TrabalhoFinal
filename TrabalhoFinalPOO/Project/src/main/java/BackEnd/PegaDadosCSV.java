package BackEnd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/// Classe responsável por carregar dados financeiros de um arquivo CSV e adicioná-los ao controlador financeiro.
public class PegaDadosCSV {
    /// Caminho do arquivo CSV a ser lido.
    private String caminhoArquivo;

    /// Construtor da classe PegaDadosCSV.
    /// @param caminho o caminho do arquivo CSV.
    public PegaDadosCSV(String caminho) {
        setCaminho(caminho);
    }

    /// @return o caminho do arquivo.
    public String getCaminho() {
        return caminhoArquivo;
    }

    /// Define o caminho do arquivo CSV.
    /// @param caminho: o caminho do arquivo.
    public void setCaminho(String caminho) {
        this.caminhoArquivo = caminho;
    }

    /// Lê os dados do arquivo CSV e lança os registros como receitas ou despesas no controlador financeiro.
    /// O arquivo deve ter o seguinte formato (separado por ponto e vírgula):
    /// - Coluna 1: Data no formato yyyyMMdd.
    /// - Coluna 2: Categoria do lançamento (String).
    /// - Coluna 3: Valor do lançamento (positivo para receitas, negativo para despesas).
    public void lancaDados() {
        System.out.println("caiu lancaDados");
        final String separador = ";";
        ControladorFinanceiro cf = ControladorFinanceiro.getInstancia();
        String linha;

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            br.readLine();
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
                String[] dados = linha.split(separador);

                // Converte os dados da linha para os tipos apropriados
                int data = Integer.parseInt(formataData(dados[0], "dd/MM/yyyy", "yyyyMMdd"));
                String categoria = dados[1];
                double valor = Double.parseDouble(dados[2]);
                
                System.out.println("valor ricardo " + valor);

                // Cria um lançamento como Receita ou Despesa com base no valor
                Lancamento lancto;
                if (valor > 0) {
                    lancto = new Receita(valor, categoria, data);
                } else {
                    lancto = new Despesa(valor, categoria, data);
                }

                // Adiciona o lançamento ao controlador financeiro
                cf.adicionarLancto(lancto);
            }
        } catch (Exception e) {
            System.out.println("Erro no método LancaDados(): " + e.getMessage());
        }
    }
    
    /// Salva os lançamentos financeiros em um arquivo CSV.
    /// @param lanctos a lista de lançamentos a ser salva no arquivo.
    public void salvaDados(ArrayList<Lancamento> lanctos) {
        try {
            String caminhoArquivo = "/Users/ricardoschmitztheiss/Documents/facul/POO/POO-TrabalhoFinal/TrabalhoFinalPOO/Csv/BancoCsv.csv";
            File arquivo = new File(caminhoArquivo);

            ArrayList<String> datas = new ArrayList<>();
            ArrayList<String> modalidades = new ArrayList<>();
            ArrayList<Double> valores = new ArrayList<>();

            for (int i = 0; i < lanctos.size(); i++) {
                Lancamento lancto = lanctos.get(i);
                String dataFormatada = formataData(String.valueOf(lancto.getData()), "yyyyMMdd", "dd/MM/yyyy");
                datas.add(dataFormatada);
                modalidades.add(String.valueOf(lancto.getTipo()));
                valores.add(lancto.getValor());
            }

            // Verifica e cria o diretório se necessário
            if (!arquivo.getParentFile().exists()) {
                arquivo.getParentFile().mkdirs(); // Cria as pastas se não existirem
            }

            // Cria o arquivo se ele não existir
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }

            // Limpa e escreve o conteúdo no arquivo
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
                // Escreve o cabeçalho do CSV
                writer.write("Data;Modalidade;Valor");
                writer.newLine();

                // Escreve os dados no CSV
                for (int i = 0; i < datas.size(); i++) {
                    writer.write(datas.get(i) + ";" + modalidades.get(i) + ";" + valores.get(i));
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Erro ao salvar os lançamentos: " + e.getMessage());
        }
    }

    /// Formata uma data de um formato para outro.
    /// @param dataInput a data de entrada como String.
    /// @param f1 o formato original da data.
    /// @param f2 o novo formato desejado da data.
    /// @return a data formatada como String.
    private String formataData(String dataInput, String f1, String f2){
        try{
            DateTimeFormatter formatterOriginal = DateTimeFormatter.ofPattern(f1);
            LocalDate data = LocalDate.parse(dataInput, formatterOriginal);
            DateTimeFormatter formatterNovo = DateTimeFormatter.ofPattern(f2);
            return data.format(formatterNovo);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "A data deve ser digitada no formato dd/MM/yyyy");
            throw new IllegalArgumentException();
        }
    }
}
