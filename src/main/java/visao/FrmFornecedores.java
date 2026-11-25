package visao;

import controle.Conexao;
import controle.ControleFornecedor;
import controle.FormatoData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import modelo.ModeloFornecedor;
import modelo.ModeloTabela;

/**
 *
 * @author uedney
 */
public final class FrmFornecedores extends javax.swing.JFrame {

    Conexao connFornec = new Conexao();
    Conexao connBairro = new Conexao();
    ModeloFornecedor mod = new ModeloFornecedor();
    ControleFornecedor control = new ControleFornecedor();
    FormatoData form = new FormatoData();
    
    String sql = "SELECT codfornec,fornecedor,fone,cel,email,cnpj,rg,endereco,bairro,cidade FROM fornecedor\n" +
"INNER JOIN bairro ON fornecedor.codbairro = bairro.codbairro \n" +
"INNER JOIN cidade ON bairro.codcidade = cidade.codcidade ORDER BY fornecedor";
    public FrmFornecedores() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/imagens/icone.png")).getImage());
        bloqueia_campos_fornec();
        botao_fornec();
         
        preencherTabelaFornecedor(sql);
        connBairro.conectar();
        connBairro.executaSQL("select * from bairro order by bairro");
        cbBairro.removeAllItems();
        try {
            connBairro.rs.first();
            do {
                cbBairro.addItem(connBairro.rs.getString("bairro"));
            } while (connBairro.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher o combo box com bairros\n ERRO: " + ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCadFornecedores = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFornecedor = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnNovoFornec = new javax.swing.JButton();
        btnAlterarFornec = new javax.swing.JButton();
        btnSalvarFornec = new javax.swing.JButton();
        btnAtualizarFornec = new javax.swing.JButton();
        btnCancelarFornec = new javax.swing.JButton();
        btnExcluirFornec = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtIdFornec = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNomeFornec = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCnpj = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEnderecoFornec = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbBairro = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTelFornec = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCelFornec = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtEmailFornec = new javax.swing.JTextField();
        txtRgFornec = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de fornecedores");

        jPanelCadFornecedores.setBackground(new java.awt.Color(255, 255, 255));

        jTableFornecedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableFornecedorMouseClicked(evt);
            }
        });
        jTableFornecedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableFornecedorKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableFornecedor);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnNovoFornec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/new.png"))); // NOI18N
        btnNovoFornec.setText("Novo");
        btnNovoFornec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoFornecActionPerformed(evt);
            }
        });

        btnAlterarFornec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/edit.png"))); // NOI18N
        btnAlterarFornec.setText("Alterar");
        btnAlterarFornec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarFornecActionPerformed(evt);
            }
        });

        btnSalvarFornec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/done.png"))); // NOI18N
        btnSalvarFornec.setText("Salvar");
        btnSalvarFornec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarFornecActionPerformed(evt);
            }
        });

        btnAtualizarFornec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/update.png"))); // NOI18N
        btnAtualizarFornec.setText("Atualizar");
        btnAtualizarFornec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarFornecActionPerformed(evt);
            }
        });

        btnCancelarFornec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancel.png"))); // NOI18N
        btnCancelarFornec.setText("Cancelar");
        btnCancelarFornec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarFornecActionPerformed(evt);
            }
        });

        btnExcluirFornec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/delete.png"))); // NOI18N
        btnExcluirFornec.setText("Excluir");
        btnExcluirFornec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirFornecActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNovoFornec, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAlterarFornec, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalvarFornec, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAtualizarFornec)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelarFornec)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluirFornec, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 8, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtualizarFornec)
                    .addComponent(btnSalvarFornec)
                    .addComponent(btnAlterarFornec)
                    .addComponent(btnNovoFornec)
                    .addComponent(btnExcluirFornec)
                    .addComponent(btnCancelarFornec)))
        );

        jLabel1.setText("Código:");

        jLabel2.setText("Nome:");

        jLabel3.setText("Cnpj:");

        jLabel4.setText("Endereço:");

        jLabel5.setText("Bairro:");

        jLabel6.setText("Cidade:");

        jLabel7.setText("Telefone:   ");

        txtTelFornec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelFornecActionPerformed(evt);
            }
        });

        jLabel8.setText("Celular:");

        jLabel9.setText("Email: ");

        jLabel10.setText("Rg:");

        javax.swing.GroupLayout jPanelCadFornecedoresLayout = new javax.swing.GroupLayout(jPanelCadFornecedores);
        jPanelCadFornecedores.setLayout(jPanelCadFornecedoresLayout);
        jPanelCadFornecedoresLayout.setHorizontalGroup(
            jPanelCadFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelCadFornecedoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCadFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanelCadFornecedoresLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTelFornec, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCelFornec, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txtEmailFornec)
                        .addGap(172, 172, 172))
                    .addGroup(jPanelCadFornecedoresLayout.createSequentialGroup()
                        .addGroup(jPanelCadFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelCadFornecedoresLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtEnderecoFornec, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(cbBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelCadFornecedoresLayout.createSequentialGroup()
                                .addGroup(jPanelCadFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(22, 22, 22)
                                .addGroup(jPanelCadFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIdFornec, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanelCadFornecedoresLayout.createSequentialGroup()
                                        .addComponent(txtNomeFornec, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(48, 48, 48)
                        .addGroup(jPanelCadFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelCadFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCidade)
                            .addComponent(txtRgFornec))))
                .addContainerGap())
        );
        jPanelCadFornecedoresLayout.setVerticalGroup(
            jPanelCadFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadFornecedoresLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCadFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdFornec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCadFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNomeFornec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRgFornec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCadFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEnderecoFornec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cbBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCadFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTelFornec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtCelFornec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtEmailFornec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelCadFornecedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanelCadFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoFornecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoFornecActionPerformed
        btnNovoFornec.setEnabled(false);
        btnSalvarFornec.setEnabled(true);
        btnCancelarFornec.setEnabled(true);
        btnAlterarFornec.setEnabled(false);
        jTableFornecedor.setVisible(false);
        txtNomeFornec.requestFocus();
        libera_campos_fornec();
        limpa_campos_fornec();
    }//GEN-LAST:event_btnNovoFornecActionPerformed

    private void btnAlterarFornecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarFornecActionPerformed
        btnNovoFornec.setEnabled(false);
        btnSalvarFornec.setEnabled(false);
        btnCancelarFornec.setEnabled(true);
        btnAtualizarFornec.setEnabled(true);
        btnAlterarFornec.setEnabled(false);
        libera_campos_fornec();
    }//GEN-LAST:event_btnAlterarFornecActionPerformed

    private void btnSalvarFornecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarFornecActionPerformed
        try {
            mod.setNome(txtNomeFornec.getText());
            mod.setEndereco(txtEnderecoFornec.getText());
            mod.setCnpj(txtCnpj.getText());
            mod.setFone(txtTelFornec.getText());
            mod.setCel(txtCelFornec.getText());
            mod.setRg(txtRgFornec.getText());
            mod.setEmail(txtEmailFornec.getText());
            connBairro.executaSQL("select * from bairro where bairro = '" + cbBairro.getSelectedItem() + "'");
            connBairro.rs.first();
            mod.setCodBairro(connBairro.rs.getInt("id_bairro"));
            control.InserirFornecedor(mod);
            preencherTabelaFornecedor(sql);
            jTableFornecedor.setVisible(true);
            connFornec.desconectar();
            botao_fornec();
        } catch (SQLException ex) {
            Logger.getLogger(FrmCidade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSalvarFornecActionPerformed

    private void btnAtualizarFornecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarFornecActionPerformed
        try {
            mod.setCod(Integer.parseInt(txtIdFornec.getText()));
            mod.setNome(txtNomeFornec.getText());
            mod.setEndereco(txtEnderecoFornec.getText());
            mod.setCnpj(txtCnpj.getText());
            mod.setFone(txtTelFornec.getText());
            mod.setCel(txtCelFornec.getText());
            mod.setRg(txtRgFornec.getText());
            mod.setEmail(txtEmailFornec.getText());
            connBairro.executaSQL("select * from bairro where bairro = '" + cbBairro.getSelectedItem() + "'");
            connBairro.rs.first();
            mod.setCodBairro(connBairro.rs.getInt("codbairro"));
            control.AlterarFornecedor(mod);
            preencherTabelaFornecedor(sql);
            jTableFornecedor.setVisible(true);
            connFornec.desconectar();
            botao_fornec();
            bloqueia_campos_fornec();
        } catch (SQLException ex) {
            Logger.getLogger(FrmCidade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAtualizarFornecActionPerformed

    private void btnCancelarFornecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarFornecActionPerformed
        // TODO add your handling code here:
        limpa_campos_fornec();
        bloqueia_campos_fornec();
        botao_fornec();
        jTableFornecedor.setEnabled(true);
        jTableFornecedor.setVisible(true);

    }//GEN-LAST:event_btnCancelarFornecActionPerformed

    private void btnExcluirFornecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirFornecActionPerformed
        int n = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir os dados do sistema?", "", JOptionPane.YES_NO_OPTION);
        if (n == 0) {
            try {
                mod.setCod(Integer.parseInt(txtIdFornec.getText()));
                mod.setNome(txtNomeFornec.getText());
                mod.setEndereco(txtEnderecoFornec.getText());
                mod.setCnpj(txtCnpj.getText());
                mod.setFone(txtTelFornec.getText());
                mod.setCel(txtCelFornec.getText());
                mod.setRg(txtRgFornec.getText());
                mod.setEmail(txtEmailFornec.getText());
                connBairro.executaSQL("select * from bairro where bairro = '" + cbBairro.getSelectedItem() + "'");
                connBairro.rs.first();
                mod.setCodBairro(connBairro.rs.getInt("codbairro"));
                control.ExcluirFornecedor(mod);
                preencherTabelaFornecedor(sql);
                jTableFornecedor.setVisible(true);
                connFornec.desconectar();
                botao_fornec();
                bloqueia_campos_fornec();
            } catch (SQLException ex) {
                Logger.getLogger(FrmCidade.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            limpa_campos_fornec();
            bloqueia_campos_fornec();
            botao_fornec();
        }
    }//GEN-LAST:event_btnExcluirFornecActionPerformed

    private void jTableFornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFornecedorMouseClicked
        // TODO add your handling code here:
        int indice = jTableFornecedor.getSelectedRow();
        txtIdFornec.setText(jTableFornecedor.getValueAt(indice, 0).toString());
        txtNomeFornec.setText(jTableFornecedor.getValueAt(indice, 1).toString());
        txtTelFornec.setText(jTableFornecedor.getValueAt(indice, 2).toString());
        txtCelFornec.setText(jTableFornecedor.getValueAt(indice, 3).toString());
        txtCnpj.setText(jTableFornecedor.getValueAt(indice, 4).toString());
        txtEnderecoFornec.setText(jTableFornecedor.getValueAt(indice, 5).toString());
        cbBairro.setSelectedItem(jTableFornecedor.getValueAt(indice, 6).toString());
        txtCidade.setText(jTableFornecedor.getValueAt(indice, 7).toString());
        txtEmailFornec.setText(jTableFornecedor.getValueAt(indice, 8).toString());

    }//GEN-LAST:event_jTableFornecedorMouseClicked

    private void txtTelFornecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelFornecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelFornecActionPerformed

    private void jTableFornecedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableFornecedorKeyPressed
        // TODO add your handling code here:
        int indice = jTableFornecedor.getSelectedRow();
        txtIdFornec.setText(jTableFornecedor.getValueAt(indice, 0).toString());
        txtNomeFornec.setText(jTableFornecedor.getValueAt(indice, 1).toString());
        txtTelFornec.setText(jTableFornecedor.getValueAt(indice, 2).toString());
        txtCelFornec.setText(jTableFornecedor.getValueAt(indice, 3).toString());
        txtCnpj.setText(jTableFornecedor.getValueAt(indice, 4).toString());
        txtEnderecoFornec.setText(jTableFornecedor.getValueAt(indice, 5).toString());
        cbBairro.setSelectedItem(jTableFornecedor.getValueAt(indice, 6).toString());
        txtCidade.setText(jTableFornecedor.getValueAt(indice, 7).toString());
        txtEmailFornec.setText(jTableFornecedor.getValueAt(indice, 8).toString());
    }//GEN-LAST:event_jTableFornecedorKeyPressed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FrmFornecedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new FrmFornecedores().setVisible(true);
//            }
//        });
//    }

    public void preencherTabelaFornecedor(String SQL) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Código", "Nome do fornecedor", "Telefone", "Celular", "Cnpj", "Endereço", "Bairro", "Cidade", "Email"};
        connFornec.executaSQL(SQL);
        try {
            connFornec.rs.first();
            do {
                dados.add(new Object[]{connFornec.rs.getInt("codfornec"), connFornec.rs.getString("fornecedor"), connFornec.rs.getString("fone"), connFornec.rs.getString("cel"), connFornec.rs.getString("cnpj"), connFornec.rs.getString("endereco"), connFornec.rs.getString("bairro"), connFornec.rs.getString("cidade"), connFornec.rs.getString("email")});
            } while (connFornec.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher o ArrayList de fornecedores\n ERRO:" + ex);
        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTableFornecedor.setModel(modelo);
        jTableFornecedor.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTableFornecedor.getColumnModel().getColumn(0).setResizable(false);
        jTableFornecedor.getColumnModel().getColumn(1).setPreferredWidth(180);
        jTableFornecedor.getColumnModel().getColumn(1).setResizable(true);
        jTableFornecedor.getColumnModel().getColumn(2).setPreferredWidth(75);
        jTableFornecedor.getColumnModel().getColumn(2).setResizable(false);
        jTableFornecedor.getColumnModel().getColumn(3).setPreferredWidth(75);
        jTableFornecedor.getColumnModel().getColumn(3).setResizable(false);
        jTableFornecedor.getColumnModel().getColumn(4).setPreferredWidth(130);
        jTableFornecedor.getColumnModel().getColumn(4).setResizable(false);
        jTableFornecedor.getColumnModel().getColumn(5).setPreferredWidth(190);
        jTableFornecedor.getColumnModel().getColumn(5).setResizable(false);
        jTableFornecedor.getColumnModel().getColumn(6).setPreferredWidth(80);
        jTableFornecedor.getColumnModel().getColumn(5).setResizable(false);
        jTableFornecedor.getColumnModel().getColumn(7).setPreferredWidth(80);
        jTableFornecedor.getColumnModel().getColumn(7).setResizable(false);
        jTableFornecedor.getColumnModel().getColumn(8).setPreferredWidth(80);
        jTableFornecedor.getColumnModel().getColumn(8).setResizable(false);
        jTableFornecedor.getTableHeader().setReorderingAllowed(false);
        jTableFornecedor.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTableFornecedor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void botao_fornec() {
        btnNovoFornec.setEnabled(true);
        btnAlterarFornec.setEnabled(true);
        btnAtualizarFornec.setEnabled(false);
        btnExcluirFornec.setEnabled(true);
        btnCancelarFornec.setEnabled(false);
        btnSalvarFornec.setEnabled(false);
    }

    public void libera_campos_fornec() {
        txtNomeFornec.setEnabled(true);
        txtEnderecoFornec.setEnabled(true);
        txtTelFornec.setEnabled(true);
        txtCelFornec.setEnabled(true);
        txtCnpj.setEnabled(true);
        txtRgFornec.setEnabled(true);
        txtEmailFornec.setEnabled(true);
        cbBairro.setEnabled(true);
    }

    public void limpa_campos_fornec() {
        txtIdFornec.setText("");
        txtNomeFornec.setText("");
        txtEnderecoFornec.setText("");
        txtTelFornec.setText("");
        txtCelFornec.setText("");
        txtCnpj.setText("");
        txtRgFornec.setText("");
        txtEmailFornec.setText("");
    }

    public void bloqueia_campos_fornec() {
        txtIdFornec.setEnabled(false);
        txtNomeFornec.setEnabled(false);
        txtEnderecoFornec.setEnabled(false);
        txtTelFornec.setEnabled(false);
        txtCelFornec.setEnabled(false);
        txtCnpj.setEnabled(false);
        txtRgFornec.setEnabled(false);
        txtEmailFornec.setEnabled(false);
        txtCidade.setEnabled(false);
        cbBairro.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarFornec;
    private javax.swing.JButton btnAtualizarFornec;
    private javax.swing.JButton btnCancelarFornec;
    private javax.swing.JButton btnExcluirFornec;
    private javax.swing.JButton btnNovoFornec;
    private javax.swing.JButton btnSalvarFornec;
    private javax.swing.JComboBox cbBairro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelCadFornecedores;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableFornecedor;
    private javax.swing.JTextField txtCelFornec;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtCnpj;
    private javax.swing.JTextField txtEmailFornec;
    private javax.swing.JTextField txtEnderecoFornec;
    private javax.swing.JTextField txtIdFornec;
    private javax.swing.JTextField txtNomeFornec;
    private javax.swing.JTextField txtRgFornec;
    private javax.swing.JTextField txtTelFornec;
    // End of variables declaration//GEN-END:variables

}
