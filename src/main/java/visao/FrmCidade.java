package visao;

import controle.Conexao;
import controle.ControleCidade;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import modelo.ModeloCidade;
import modelo.ModeloTabela;

/**
 *
 * @author uedney
 */
public final class FrmCidade extends javax.swing.JFrame {

    Conexao connEstado = new Conexao();
    Conexao connCidade = new Conexao();
    ModeloCidade mod = new ModeloCidade();
    ControleCidade control = new ControleCidade();

    String sql = "SELECT * FROM cidade INNER JOIN estado ON cidade.codestado = estado.codestado and bloqueado='N'";
    public FrmCidade() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/imagens/icone.png")).getImage());
        bloqueia_campos_cid();
        botao_cid();
        preencherTabelaCidade(sql);
        connEstado.conectar();
        connEstado.executaSQL("select * from estado order by estado");
        cbNomeEstado.removeAllItems();
        try {
            connEstado.rs.first();
            do {
                cbNomeEstado.addItem(connEstado.rs.getString("estado"));
            } while (connEstado.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher o combo box com estados!\n ERRO: " + ex, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnNovoCid = new javax.swing.JButton();
        btnAlterarCid = new javax.swing.JButton();
        btnSalvarCid = new javax.swing.JButton();
        btnAtualizarCid = new javax.swing.JButton();
        btnCancelarCid = new javax.swing.JButton();
        btnExcluirCid = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtId_cidade = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNomeCidade = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbNomeEstado = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCidade = new javax.swing.JTable();
        jCheckBoxExcluidos = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        btnRetirar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtCep = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtBusca = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de cidades");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnNovoCid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/new.png"))); // NOI18N
        btnNovoCid.setText("Novo");
        btnNovoCid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoCidActionPerformed(evt);
            }
        });

        btnAlterarCid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/edit.png"))); // NOI18N
        btnAlterarCid.setText("Alterar");
        btnAlterarCid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarCidActionPerformed(evt);
            }
        });

        btnSalvarCid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/done.png"))); // NOI18N
        btnSalvarCid.setText("Salvar");
        btnSalvarCid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarCidActionPerformed(evt);
            }
        });

        btnAtualizarCid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/update.png"))); // NOI18N
        btnAtualizarCid.setText("Atualizar");
        btnAtualizarCid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarCidActionPerformed(evt);
            }
        });

        btnCancelarCid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancel.png"))); // NOI18N
        btnCancelarCid.setText("Cancelar");
        btnCancelarCid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCidActionPerformed(evt);
            }
        });

        btnExcluirCid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/delete.png"))); // NOI18N
        btnExcluirCid.setText("Excluir");
        btnExcluirCid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirCidActionPerformed(evt);
            }
        });

        jLabel1.setText("Código:");

        txtId_cidade.setEditable(false);

        jLabel2.setText("Cidade:");

        txtNomeCidade.setEditable(false);

        jLabel3.setText("Estado:");

        jTableCidade.setAutoCreateRowSorter(true);
        jTableCidade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableCidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCidadeMouseClicked(evt);
            }
        });
        jTableCidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableCidadeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableCidadeKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCidade);

        jCheckBoxExcluidos.setText("Mostrar excluidos");
        jCheckBoxExcluidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxExcluidosActionPerformed(evt);
            }
        });

        jButton1.setText("Localizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnRetirar.setText("Retirar Exclusão");
        btnRetirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetirarActionPerformed(evt);
            }
        });

        jLabel4.setText("CEP:");

        txtCep.setEditable(false);

        jLabel5.setText("Buscar cidade:");

        txtBusca.setBackground(new java.awt.Color(255, 255, 102));
        txtBusca.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscaFocusLost(evt);
            }
        });
        txtBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtId_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNovoCid, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlterarCid, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvarCid, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAtualizarCid)
                        .addGap(4, 4, 4)
                        .addComponent(btnCancelarCid)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluirCid, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(37, 37, 37)
                                .addComponent(txtNomeCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbNomeEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBoxExcluidos))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(btnRetirar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 737, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAtualizarCid)
                        .addComponent(btnSalvarCid)
                        .addComponent(btnAlterarCid)
                        .addComponent(btnNovoCid)
                        .addComponent(btnExcluirCid)
                        .addComponent(btnCancelarCid))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtId_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCheckBoxExcluidos)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnRetirar)
                    .addComponent(jLabel4)
                    .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtNomeCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbNomeEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRetirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetirarActionPerformed

        mod.setCod(Integer.parseInt(txtId_cidade.getText()));
        control.RetirarExcluido(mod);
        preencherTabelaCidade(sql);
        jTableCidade.setVisible(true);
        btnRetirar.setVisible(false);
        jCheckBoxExcluidos.setSelected(false);
        botao_cid();
        bloqueia_campos_cid();
    }//GEN-LAST:event_btnRetirarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (jCheckBoxExcluidos.isSelected()) {
            preencherTabelaCidade("SELECT * FROM cad_cidade INNER JOIN cad_estado ON cad_cidade.id_estado = cad_estado.id_estado and bloqueado='S'");
            btnRetirar.setEnabled(false);
        } else {
            preencherTabelaCidade(sql);
            btnRetirar.setVisible(false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckBoxExcluidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxExcluidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxExcluidosActionPerformed

    private void jTableCidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableCidadeKeyReleased
        int indice = jTableCidade.getSelectedRow();
        txtId_cidade.setText(jTableCidade.getValueAt(indice, 0).toString());
        txtNomeCidade.setText(jTableCidade.getValueAt(indice, 1).toString());
        txtCep.setText(jTableCidade.getValueAt(indice, 2).toString());
        cbNomeEstado.setSelectedItem(jTableCidade.getValueAt(indice, 3).toString());
        if (jCheckBoxExcluidos.isSelected()) {
            btnRetirar.setVisible(true);
            btnRetirar.setEnabled(false);
        } else {
            btnRetirar.setVisible(false);
        }
    }//GEN-LAST:event_jTableCidadeKeyReleased

    private void jTableCidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableCidadeKeyPressed

    }//GEN-LAST:event_jTableCidadeKeyPressed

    private void jTableCidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCidadeMouseClicked
        // TODO add your handling code here:
        int indice = jTableCidade.getSelectedRow();
        txtId_cidade.setText(jTableCidade.getValueAt(indice, 0).toString());
        txtNomeCidade.setText(jTableCidade.getValueAt(indice, 1).toString());
        txtCep.setText(jTableCidade.getValueAt(indice, 2).toString());
        cbNomeEstado.setSelectedItem(jTableCidade.getValueAt(indice, 3).toString());
        if (jCheckBoxExcluidos.isSelected()) {
            btnRetirar.setVisible(true);
            btnRetirar.setEnabled(false);
        } else {
            btnRetirar.setVisible(false);
        }
    }//GEN-LAST:event_jTableCidadeMouseClicked

    private void btnExcluirCidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirCidActionPerformed
        int n = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir os dados do sistema?", "", JOptionPane.YES_NO_OPTION);
        if (n == 0) {
            //            try {
                mod.setCod(Integer.parseInt(txtId_cidade.getText()));
                //                mod.setNome(txtNomeCidade.getText());
                //                connEstado.executaSQL("select * from cad_estado where nome_estado = '" + cbNomeEstado.getSelectedItem() + "'");
                //                connEstado.rs.first();
                //                mod.setCod_estado(connEstado.rs.getInt("id_estado"));
                //                control.ExcluirCidade(mod);
                //                preencherTabelaCidade("SELECT * FROM cad_cidade INNER JOIN cad_estado ON cad_cidade.id_estado = cad_estado.id_estado and block_cidade='N'");
                //                jTableCidade.setVisible(true);
                //            } catch (SQLException ex) {
                //                Logger.getLogger(FrmCidade.class.getName()).log(Level.SEVERE, null, ex);
                //            }
            control.ExcluirCidade(mod);
            preencherTabelaCidade(sql);
        } else {
            limpa_campos_cid();
            bloqueia_campos_cid();
            botao_cid();
        }
    }//GEN-LAST:event_btnExcluirCidActionPerformed

    private void btnCancelarCidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCidActionPerformed
        // TODO add your handling code here:
        limpa_campos_cid();
        bloqueia_campos_cid();
        botao_cid();
        jTableCidade.setEnabled(true);
        jTableCidade.setVisible(true);
    }//GEN-LAST:event_btnCancelarCidActionPerformed

    private void btnAtualizarCidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarCidActionPerformed
        if (txtId_cidade.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Selecione uma cidade para alterar: ", " ERRO", JOptionPane.ERROR_MESSAGE);
        } else {

            try {
                mod.setCod(Integer.parseInt(txtId_cidade.getText()));
                mod.setNome(txtNomeCidade.getText());
                mod.setCep(txtCep.getText());
                connEstado.executaSQL("select * from estado where estado = '" + cbNomeEstado.getSelectedItem() + "'");
                connEstado.rs.first();
                mod.setCod_estado(connEstado.rs.getInt("codestado"));
                control.AlterarCidade(mod);
                preencherTabelaCidade(sql);
                jTableCidade.setVisible(true);
                botao_cid();
                bloqueia_campos_cid();
            } catch (SQLException ex) {
                Logger.getLogger(FrmCidade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnAtualizarCidActionPerformed

    private void btnSalvarCidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarCidActionPerformed
        if (txtNomeCidade.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o nome da cidade!", "ERRO", JOptionPane.ERROR_MESSAGE);
            txtNomeCidade.requestFocus();
        }
        if (txtCep.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o CEP da cidade!", "ERRO", JOptionPane.ERROR_MESSAGE);
            txtCep.requestFocus();
        } else {
            try {
                connCidade.conectar();
                connCidade.stmt = connCidade.connection.createStatement(connCidade.rs.TYPE_SCROLL_INSENSITIVE, connCidade.rs.CONCUR_READ_ONLY);
                //connCidade.rs = connCidade.stmt.executeQuery("select * from cad_cidade where nome_cidade='" + txtNomeCidade.getText() + "'");
                connCidade.rs = connCidade.stmt.executeQuery("SELECT cidade,cep,estado FROM cidade INNER JOIN estado WHERE codcidade.codestado=estado.codestado"
                    + " AND cidade='" + txtNomeCidade.getText() + "' AND cep='" + txtCep.getText() + "' AND estado='" + cbNomeEstado.getSelectedItem() + "'");

                if (connCidade.rs.next()) {
                    JOptionPane.showMessageDialog(null, "Cidade já cadastrada!\n Verifique se a cidade está excluida!", "ERRO", JOptionPane.ERROR_MESSAGE);
                    limpa_campos_cid();
                    btnCancelarCid.doClick();
                } else {

                    mod.setNome(txtNomeCidade.getText());
                    mod.setCep(txtCep.getText());
                    connEstado.executaSQL("select * from estado where estado = '" + cbNomeEstado.getSelectedItem() + "'");
                    connEstado.rs.first();
                    mod.setCod_estado(connEstado.rs.getInt("codestado"));
                    control.InserirCidade(mod);
                    preencherTabelaCidade(sql);
                    jTableCidade.setVisible(true);
                    botao_cid();
                    bloqueia_campos_cid();
                }
            } catch (SQLException ex) {
                Logger.getLogger(FrmCidade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSalvarCidActionPerformed

    private void btnAlterarCidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarCidActionPerformed
        btnNovoCid.setEnabled(false);
        btnSalvarCid.setEnabled(false);
        btnCancelarCid.setEnabled(true);
        btnAtualizarCid.setEnabled(true);
        btnAlterarCid.setEnabled(false);
        libera_campos_cid();
        if (jCheckBoxExcluidos.isSelected()) {
            btnRetirar.setEnabled(true);
        } else {
            btnRetirar.setVisible(false);
        }
    }//GEN-LAST:event_btnAlterarCidActionPerformed

    private void btnNovoCidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoCidActionPerformed
        btnNovoCid.setEnabled(false);
        btnSalvarCid.setEnabled(true);
        btnCancelarCid.setEnabled(true);
        btnAlterarCid.setEnabled(false);
        jTableCidade.setVisible(false);
        txtNomeCidade.requestFocus();
        libera_campos_cid();
        limpa_campos_cid();
    }//GEN-LAST:event_btnNovoCidActionPerformed

    private void txtBuscaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscaFocusLost
        // TODO add your handling code here:
        txtBusca.setText("");
    }//GEN-LAST:event_txtBuscaFocusLost

    private void txtBuscaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaKeyTyped
        // TODO add your handling code here:
        preencherTabelaCidade("SELECT * FROM cidade INNER JOIN estado ON cidade.codestado=estado.codestado\n" +
"AND cidade.cidade LIKE '%"+txtBusca.getText()+"%' AND bloqueado='N';");
    }//GEN-LAST:event_txtBuscaKeyTyped

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
//            java.util.logging.Logger.getLogger(FrmCidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new FrmCidade().setVisible(true);
//            }
//        });
//    }
    public void preencherTabelaCidade(String SQL) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Código Cidade", "Cidade", "CEP", "Estado", "Sigla"};
        connEstado.executaSQL(SQL);
        try {
            connEstado.rs.first();
            do {
                dados.add(new Object[]{connEstado.rs.getInt("codcidade"), connEstado.rs.getString("cidade"), connEstado.rs.getString("cep"), connEstado.rs.getString("estado"), connEstado.rs.getString("sigla")});
            } while (connEstado.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nenhum registro excluido foi encontrado! ", "ERRO", JOptionPane.ERROR_MESSAGE);
            jCheckBoxExcluidos.setSelected(false);
            preencherTabelaCidade(sql);
            return;
        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTableCidade.setModel(modelo);
        jTableCidade.getColumnModel().getColumn(0).setPreferredWidth(100);
        jTableCidade.getColumnModel().getColumn(0).setResizable(false);
        jTableCidade.getColumnModel().getColumn(1).setPreferredWidth(258);
        jTableCidade.getColumnModel().getColumn(1).setResizable(false);
        jTableCidade.getColumnModel().getColumn(2).setPreferredWidth(150);
        jTableCidade.getColumnModel().getColumn(2).setResizable(false);
        jTableCidade.getColumnModel().getColumn(3).setPreferredWidth(150);
        jTableCidade.getColumnModel().getColumn(3).setResizable(false);
        jTableCidade.getColumnModel().getColumn(4).setPreferredWidth(84);
        jTableCidade.getColumnModel().getColumn(4).setResizable(false);
        jTableCidade.getTableHeader().setReorderingAllowed(false);
        jTableCidade.setAutoResizeMode(jTableCidade.AUTO_RESIZE_OFF);
        jTableCidade.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void botao_cid() {
        btnRetirar.setVisible(false);
        btnNovoCid.setEnabled(true);
        btnAlterarCid.setEnabled(true);
        btnAtualizarCid.setEnabled(false);
        btnExcluirCid.setEnabled(true);
        btnCancelarCid.setEnabled(false);
        btnSalvarCid.setEnabled(false);
    }

    public void libera_campos_cid() {
        txtNomeCidade.setEditable(true);
        txtCep.setEditable(true);
        cbNomeEstado.setEnabled(true);
    }

    public void limpa_campos_cid() {
        txtId_cidade.setText("");
        txtNomeCidade.setText("");
        txtCep.setText("");
    }

    public void bloqueia_campos_cid() {
        txtId_cidade.setEditable(false);
        txtNomeCidade.setEditable(false);
        txtCep.setEditable(false);
        cbNomeEstado.setEditable(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarCid;
    private javax.swing.JButton btnAtualizarCid;
    private javax.swing.JButton btnCancelarCid;
    private javax.swing.JButton btnExcluirCid;
    private javax.swing.JButton btnNovoCid;
    private javax.swing.JButton btnRetirar;
    private javax.swing.JButton btnSalvarCid;
    private javax.swing.JComboBox cbNomeEstado;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBoxExcluidos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCidade;
    private javax.swing.JTextField txtBusca;
    private javax.swing.JTextField txtCep;
    private javax.swing.JTextField txtId_cidade;
    private javax.swing.JTextField txtNomeCidade;
    // End of variables declaration//GEN-END:variables
}
