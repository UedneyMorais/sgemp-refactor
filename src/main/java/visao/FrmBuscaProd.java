package visao;

import controle.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import modelo.ModeloBuscaProd;
import modelo.ModeloTabela;
import modelo.ModeloVenda;

/**
 *
 * @author uedney
 */
public class FrmBuscaProd extends javax.swing.JDialog {

    public FrmBuscaProd() {
    }

    ModeloBuscaProd modBuscaProd = new ModeloBuscaProd();
    ModeloVenda modVenda = new ModeloVenda();
    Conexao connProduto = new Conexao();
    public FrmBuscaProd(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/imagens/icone.png")).getImage());
        PreencherTabelaProdutos("select * from produto order by descricao");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscaProd = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBuscaProd = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Digite o nome do produto:");

        txtBuscaProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscaProdKeyTyped(evt);
            }
        });

        jTableBuscaProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableBuscaProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableBuscaProdMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableBuscaProd);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscaProd, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscaProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscaProdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaProdKeyTyped
        // TODO add your handling code here:
        PreencherTabelaProdutos("select * from produto where descricao like'%" + txtBuscaProd.getText() + "%'");
    }//GEN-LAST:event_txtBuscaProdKeyTyped

    private void jTableBuscaProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableBuscaProdMouseClicked
         //TODO add your handling code here:
        if (evt.getClickCount() == 2) {//aqui identifica 2 clicks na tabela, pra ocorrer o evento....
             String cod =  jTableBuscaProd.getModel().getValueAt(jTableBuscaProd.getSelectedRow(), 0).toString();
             String desc = jTableBuscaProd.getModel().getValueAt(jTableBuscaProd.getSelectedRow(), 1).toString();
             String valor = jTableBuscaProd.getModel().getValueAt(jTableBuscaProd.getSelectedRow(), 2).toString();
             String ean = jTableBuscaProd.getModel().getValueAt(jTableBuscaProd.getSelectedRow(), 3).toString();
            modBuscaProd.setCod(cod);
            modBuscaProd.setProduto(desc);
            modBuscaProd.setValor(valor);
            modBuscaProd.setEan(ean); 
            dispose();
        }
    }//GEN-LAST:event_jTableBuscaProdMouseClicked

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
            java.util.logging.Logger.getLogger(FrmBuscaProd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmBuscaProd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmBuscaProd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmBuscaProd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmBuscaProd dialog = new FrmBuscaProd(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableBuscaProd;
    private javax.swing.JTextField txtBuscaProd;
    // End of variables declaration//GEN-END:variables

public void PreencherTabelaProdutos(String SQL) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Código", "Descrição do Produto", "Preço","EAN"};
        connProduto.executaSQL(SQL);
        try {
            connProduto.rs.first();
            do {
                dados.add(new Object[]{connProduto.rs.getInt("codprod"), connProduto.rs.getString("descricao"), connProduto.rs.getString("preco"),connProduto.rs.getString("codbarra")});
            } while (connProduto.rs.next());
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Erro ao preencher o ArrayList de produtos \n ERRO:" + e);
            JOptionPane.showMessageDialog(null, "Produto não encontrado \n ERRO: "+e,"ERRO",JOptionPane.ERROR_MESSAGE);
            txtBuscaProd.setText("");
        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTableBuscaProd.setModel(modelo);
        jTableBuscaProd.getColumnModel().getColumn(0).setPreferredWidth(50);//Código
        jTableBuscaProd.getColumnModel().getColumn(0).setResizable(false);
        jTableBuscaProd.getColumnModel().getColumn(1).setPreferredWidth(200);//Descrição do Produto
        jTableBuscaProd.getColumnModel().getColumn(1).setResizable(false);
        jTableBuscaProd.getColumnModel().getColumn(2).setPreferredWidth(55);//Preço
        jTableBuscaProd.getColumnModel().getColumn(2).setResizable(false);
        jTableBuscaProd.getColumnModel().getColumn(3).setPreferredWidth(115);//EAN
        jTableBuscaProd.getColumnModel().getColumn(3).setResizable(false);
        jTableBuscaProd.getTableHeader().setReorderingAllowed(false);
        jTableBuscaProd.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTableBuscaProd.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        connProduto.desconectar();
    }
}
