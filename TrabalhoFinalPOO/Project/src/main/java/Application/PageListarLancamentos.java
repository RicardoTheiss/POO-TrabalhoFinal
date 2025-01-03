/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Application;

import BackEnd.ControladorFinanceiro;
import BackEnd.Lancamento;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author kauan
 */
public class PageListarLancamentos extends javax.swing.JFrame {

    /**
     * Creates new form PageListarLancamentos
     */
    public PageListarLancamentos() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonVoltar = new javax.swing.JButton();
        jScrollPaneLancamentos = new javax.swing.JScrollPane();
        lancamentos = new javax.swing.JTextArea();
        listar = new javax.swing.JButton();
        escolha = new javax.swing.JComboBox<>();
        erro = new javax.swing.JLabel();

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane1.setViewportView(jTextArea2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 65, 186));

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Lançamentos");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LogoFurb.png"))); // NOI18N

        jButtonVoltar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButtonVoltar.setForeground(new java.awt.Color(0, 30, 128));
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jButtonVoltar.setBorderPainted(false);
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        lancamentos.setColumns(20);
        lancamentos.setRows(5);
        jScrollPaneLancamentos.setViewportView(lancamentos);

        listar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        listar.setForeground(new java.awt.Color(0, 30, 128));
        listar.setText("Listar");
        listar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        listar.setBorderPainted(false);
        listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarActionPerformed(evt);
            }
        });

        escolha.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Todos", "Receitas", "Despesas"}));
        escolha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escolhaActionPerformed(evt);
            }
        });

        erro.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 89, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(escolha, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(listar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4))
                                .addGap(90, 90, 90))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(erro)
                                .addGap(181, 181, 181))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPaneLancamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addGap(7, 7, 7)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(escolha, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(erro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneLancamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        Home home = new Home();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void listarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarActionPerformed
        try{
            String escolhaSelect = (String) escolha.getSelectedItem();
            ControladorFinanceiro cf = ControladorFinanceiro.getInstancia();

            ArrayList<Lancamento> lanctos = cf.retornaLancamentos();
            
            System.out.println("tamanho ricardo lista " + lanctos.size());

            String retorno = "";

            Collections.sort(lanctos, Comparator.comparing(Lancamento::getData));

            double saldoAtual = 0;

            int larguraData = 12;
            int larguraCategoria = 15;
            int larguraValor = 10;
            int larguraSaldo = 12;
            
            lancamentos.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 12));

            retorno += "Data" + " ".repeat(larguraData - 4) +
                       "Categoria" + " ".repeat(larguraCategoria - 9) +
                       "Valor" + " ".repeat(larguraValor - 5) +
                       "Saldo Atual\n";

            for (Lancamento lancto : lanctos) {
                // Aplicar filtros
                if (escolhaSelect.trim().equalsIgnoreCase("Receitas") && lancto.getValor() < 0) {
                    saldoAtual += lancto.getValor();
                    continue;
                } else if (escolhaSelect.trim().equalsIgnoreCase("Despesas") && lancto.getValor() > 0) {
                    saldoAtual += lancto.getValor();
                    continue;
                }

                String dataFormat = formataData(lancto.getData(), "yyyyMMdd", "dd/MM/yyyy");
                saldoAtual += lancto.getValor(); 
                
                String espacoData = " ".repeat(larguraData - dataFormat.length());
                String espacoCategoria = " ".repeat(larguraCategoria - String.valueOf(lancto.getTipo()).length());
                String valorFormatado = String.format("%,.2f", lancto.getValor());
                String saldoFormatado = String.format("%,.2f", saldoAtual);

                retorno += dataFormat + espacoData +
                           lancto.getTipo() + espacoCategoria +
                           valorFormatado + " ".repeat(larguraValor - valorFormatado.length()) +
                           saldoFormatado + "\n";
            }
            lancamentos.setText(retorno);
        }catch(IllegalArgumentException e){
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado");
        }
    }//GEN-LAST:event_listarActionPerformed

    private void escolhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escolhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_escolhaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PageListarLancamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PageListarLancamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PageListarLancamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PageListarLancamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PageListarLancamentos().setVisible(true);
            }
        });
    }
    
    private String formataData(int dataInput, String f1, String f2){
        try{
            DateTimeFormatter formatterOriginal = DateTimeFormatter.ofPattern(f1);
            LocalDate data = LocalDate.parse(String.valueOf(dataInput), formatterOriginal);
            DateTimeFormatter formatterNovo = DateTimeFormatter.ofPattern(f2);
            return data.format(formatterNovo);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "A data deve ser informada no formato dd/MM/yyyy");
            throw new IllegalArgumentException();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel erro;
    private javax.swing.JComboBox<String> escolha;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneLancamentos;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea lancamentos;
    private javax.swing.JButton listar;
    // End of variables declaration//GEN-END:variables
}
