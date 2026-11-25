package visao;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import controle.Conexao;
import controle.ControleUsuario;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;
import modelo.ModeloTabela;
import modelo.ModeloUsuario;

public final class FrmUsuario extends javax.swing.JFrame {

    int opcao = 0;
    Conexao connUsuario = new Conexao();
    ModeloUsuario mod = new ModeloUsuario();
    ControleUsuario controleLogin = new ControleUsuario();

    String sqlpreenchertabela = "SELECT * FROM usuario INNER JOIN permissao ON usuario.codpermissao = permissao.codpermissao";

    public FrmUsuario() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/imagens/icone.png")).getImage());
        preencherTabelaUsuario(sqlpreenchertabela);
        connUsuario.desconectar();
        //connUsuario.conectar();
        connUsuario.executaSQL("SELECT * FROM permissao");
        cbPermissao.removeAllItems();
        try {
            connUsuario.rs.first();
            do {
                cbPermissao.addItem(connUsuario.rs.getString("permissao"));
            } while (connUsuario.rs.next());
            connUsuario.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher o combo box com usuarios \n ERRO: " + ex);
        }

        botao();
        bloqueia_campos();
        btnSalvar.setEnabled(false);
        txtConfSenha.setEnabled(false);
        //connUsuario.desconectar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCadUsuario = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUsuarios = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNomeUsuario = new javax.swing.JTextField();
        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtIdUsuario = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        txtConfSenha = new javax.swing.JPasswordField();
        cbPermissao = new javax.swing.JComboBox<>();
        jCheckBoxBlock = new javax.swing.JCheckBox();
        btnModifica = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de usuários");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanelCadUsuario.setBackground(new java.awt.Color(255, 255, 255));

        jTableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableUsuariosMouseClicked(evt);
            }
        });
        jTableUsuarios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableUsuariosKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTableUsuariosKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTableUsuarios);

        jLabel5.setText("Senha:");

        jLabel4.setText("Confirme:");

        jLabel3.setText("Permissão:");

        txtLogin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLoginFocusLost(evt);
            }
        });

        jLabel2.setText("Login:");

        jLabel1.setText("Nome:");

        txtNomeUsuario.setEditable(false);

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/new.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/edit.png"))); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/done.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/update.png"))); // NOI18N
        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/delete.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jLabel6.setText("Código:");

        txtIdUsuario.setEditable(false);

        txtSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSenhaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSenhaFocusLost(evt);
            }
        });
        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });
        txtSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSenhaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSenhaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSenhaKeyTyped(evt);
            }
        });

        txtConfSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtConfSenhaFocusLost(evt);
            }
        });
        txtConfSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConfSenhaActionPerformed(evt);
            }
        });

        jCheckBoxBlock.setText("Bloqueado");

        btnModifica.setText("Modificar Permissões");
        btnModifica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificaMouseClicked(evt);
            }
        });
        btnModifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCadUsuarioLayout = new javax.swing.GroupLayout(jPanelCadUsuario);
        jPanelCadUsuario.setLayout(jPanelCadUsuarioLayout);
        jPanelCadUsuarioLayout.setHorizontalGroup(
            jPanelCadUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCadUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanelCadUsuarioLayout.createSequentialGroup()
                        .addGroup(jPanelCadUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelCadUsuarioLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(14, 14, 14)
                                .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSenha))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelCadUsuarioLayout.createSequentialGroup()
                                .addGroup(jPanelCadUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtIdUsuario))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelCadUsuarioLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(13, 13, 13)
                                .addComponent(txtNomeUsuario)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelCadUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelCadUsuarioLayout.createSequentialGroup()
                                .addComponent(btnAtualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelCadUsuarioLayout.createSequentialGroup()
                                .addGroup(jPanelCadUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCadUsuarioLayout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18))
                                    .addGroup(jPanelCadUsuarioLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(13, 13, 13)))
                                .addGroup(jPanelCadUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cbPermissao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtConfSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelCadUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnModifica)
                                    .addComponent(jCheckBoxBlock))
                                .addGap(15, 15, 15)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelCadUsuarioLayout.setVerticalGroup(
            jPanelCadUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCadUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCadUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelCadUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNovo)
                        .addComponent(btnAlterar)
                        .addComponent(btnSalvar)
                        .addComponent(btnAtualizar)
                        .addComponent(btnCancelar)
                        .addComponent(btnExcluir))
                    .addGroup(jPanelCadUsuarioLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelCadUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCadUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel3)
                        .addComponent(cbPermissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jCheckBoxBlock))
                .addGap(4, 4, 4)
                .addGroup(jPanelCadUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtConfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btnModifica))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelCadUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelCadUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpa_campos();
        bloqueia_campos();
        botao();
        jTableUsuarios.setEnabled(true);
        jTableUsuarios.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        try {
            connUsuario.executaSQL("select * from usuario where login='" + txtLogin.getText() + "'");
            if (connUsuario.rs.next()) {
                JOptionPane.showMessageDialog(null, "Login já cadastrado!");
                connUsuario.desconectar();
            } else {
                mod.setNomeUsuario(txtNomeUsuario.getText());
                mod.setLoginUsuario(txtLogin.getText());
                mod.setSenhaUsuario(txtSenha.getText());
                mod.setBloqueado("N");
                connUsuario.executaSQL("select * from permissao where permissao = '" + cbPermissao.getSelectedItem() + "'");
                connUsuario.rs.first();
                mod.setNivelUsuario(connUsuario.rs.getInt("codpermissao"));
                //controleLogin.salvar(mod);
                jTableUsuarios.setEnabled(true);
                //connUsuario.desconectar();
                preencherTabelaUsuario(sqlpreenchertabela);
                botao();
                bloqueia_campos();
                connUsuario.desconectar();
            }
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao salvar o usuario \nERRO:" + e);
            txtSenha.setText("");
            connUsuario.desconectar();
        }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
//        try {
//            connUsuario.conectar();
//            connUsuario.stmt = connUsuario.connection.createStatement(connUsuario.rs.TYPE_SCROLL_INSENSITIVE, connUsuario.rs.CONCUR_READ_ONLY);
//            connUsuario.rs = connUsuario.stmt.executeQuery("select * from usuario where login='" + txtLogin.getText() + "'");
//            if (connUsuario.rs.next()) {
//                JOptionPane.showMessageDialog(null, "Login já cadastrado!");
//            } else {
        try {
            if (jCheckBoxBlock.isSelected()) {
                bloqueado = "S";
            } else {
                bloqueado = "N";
            }
            if (txtSenha.getText().equals("") || txtConfSenha.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Preencha o campo senha e confirme");
            } else if (txtSenha.getText().equals(txtConfSenha.getText())) {
                mod.setIdUsuario(Integer.parseInt(txtIdUsuario.getText()));
                mod.setNomeUsuario(txtNomeUsuario.getText());
                mod.setSenhaUsuario(txtSenha.getText());
                mod.setLoginUsuario(txtLogin.getText());
                mod.setBloqueado(bloqueado);
                connUsuario.executaSQL("select * from permissao where permissao = '" + cbPermissao.getSelectedItem() + "'");
                connUsuario.rs.first();
                mod.setNivelUsuario(connUsuario.rs.getInt("codpermissao"));
                controleLogin.atualizar(mod);
                connUsuario.desconectar();
                JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!");
                preencherTabelaUsuario(sqlpreenchertabela);
                botao();
                bloqueia_campos();
                jTableUsuarios.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "As senhas não correspondem!");
                txtSenha.setText("");
                txtConfSenha.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao atualizar o usuario! \nERRO:" + e);
        }
//            }
//        } catch (SQLException | HeadlessException e) {
//            JOptionPane.showMessageDialog(rootPane, "Erro ao Verificar existencia do usuario \nERRO:" + e);
//            txtSenha.setText("");
//        }


    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void jTableUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableUsuariosMouseClicked
        int indice = jTableUsuarios.getSelectedRow();
        txtIdUsuario.setText(jTableUsuarios.getValueAt(indice, 0).toString());
        txtNomeUsuario.setText(jTableUsuarios.getValueAt(indice, 1).toString());
        txtLogin.setText(jTableUsuarios.getValueAt(indice, 2).toString());
        cbPermissao.setSelectedItem(jTableUsuarios.getValueAt(indice, 3).toString());

        try {
            connUsuario.rs.first();

            connUsuario.executaSQL("select * from usuario where codusuario ='" + txtIdUsuario.getText() + "'");
            while (connUsuario.rs.next()) {
                String result = connUsuario.rs.getString("bloqueado");
                if (result.equals("S")) {
                    jCheckBoxBlock.setSelected(true);

                } else {
                    jCheckBoxBlock.setSelected(false);

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jTableUsuariosMouseClicked

    private void txtSenhaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenhaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaKeyTyped

    private void txtSenhaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenhaKeyReleased

    }//GEN-LAST:event_txtSenhaKeyReleased

    private void txtSenhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSenhaFocusLost

        if (txtSenha.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Preencha o campo senha");
            txtSenha.requestFocus();
        } else {
            txtConfSenha.setEnabled(true);
            txtConfSenha.setEditable(true);
            txtConfSenha.requestFocus();
        }

    }//GEN-LAST:event_txtSenhaFocusLost

    private void txtSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenhaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaKeyPressed

    private void txtConfSenhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtConfSenhaFocusLost

        if (!txtConfSenha.getText().equals("") && opcao == 1) {
            btnSalvar.setEnabled(false);
        }
        if (txtSenha.getText().equals(txtConfSenha.getText()) && opcao == 1) {
            btnSalvar.setEnabled(true);
        }
        if (!txtSenha.getText().equals(txtConfSenha.getText()) && opcao == 1) {
            JOptionPane.showMessageDialog(rootPane, "As senhas não conferem!");
            txtSenha.setText("");
            txtConfSenha.setText("");
            btnSalvar.setEnabled(false);
            txtSenha.requestFocus();
        }
    }//GEN-LAST:event_txtConfSenhaFocusLost

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        opcao = 1;
        btnNovo.setEnabled(false);
        btnSalvar.setEnabled(false);
        btnCancelar.setEnabled(true);
        btnAlterar.setEnabled(false);
        jTableUsuarios.setEnabled(false);
        txtNomeUsuario.requestFocus();
        cbPermissao.setEnabled(true);
        libera_campos();
        limpa_campos();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed

        if (txtIdUsuario.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Selecione o usuario que deseja alterar!", "ERRO", JOptionPane.ERROR_MESSAGE);
        } else {
            opcao = 2;
            btnNovo.setEnabled(false);
            btnSalvar.setEnabled(false);
            btnCancelar.setEnabled(true);
            btnAtualizar.setEnabled(true);
            btnAlterar.setEnabled(false);
            cbPermissao.setEnabled(true);
            jCheckBoxBlock.setEnabled(true);
            libera_campos();
            txtSenha.setText("");
            txtConfSenha.setText("");
            jTableUsuarios.setEnabled(false);
        }


    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

        int n = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir os dados do sistema?", "", JOptionPane.YES_NO_OPTION);
        if (n == 0) {
            mod.setIdUsuario(Integer.parseInt(txtIdUsuario.getText()));
            controleLogin.excluir(mod);
            preencherTabelaUsuario(sqlpreenchertabela);
            limpa_campos();
            bloqueia_campos();
            botao();
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jTableUsuariosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableUsuariosKeyTyped


    }//GEN-LAST:event_jTableUsuariosKeyTyped

    private void jTableUsuariosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableUsuariosKeyPressed

        int indice = jTableUsuarios.getSelectedRow();
        txtIdUsuario.setText(jTableUsuarios.getValueAt(indice, 0).toString());
        txtNomeUsuario.setText(jTableUsuarios.getValueAt(indice, 1).toString());
        txtLogin.setText(jTableUsuarios.getValueAt(indice, 2).toString());
        cbPermissao.setSelectedItem(jTableUsuarios.getValueAt(indice, 3).toString());
    }//GEN-LAST:event_jTableUsuariosKeyPressed

    private void txtConfSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConfSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConfSenhaActionPerformed

    private void txtLoginFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLoginFocusLost


    }//GEN-LAST:event_txtLoginFocusLost

    private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaActionPerformed

    private void txtSenhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSenhaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaFocusGained

    private void btnModificaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificaMouseClicked
        // TODO add your handling code here:
        String user = txtIdUsuario.getText();
        if (user.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecione um usuário para alterar as permissões");
        } else {
            FrmNivel cad_Niv = new FrmNivel(user);
            cad_Niv.setVisible(true);
        }

    }//GEN-LAST:event_btnModificaMouseClicked

    private void btnModificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificaActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnModifica;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbPermissao;
    private javax.swing.JCheckBox jCheckBoxBlock;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanelCadUsuario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableUsuarios;
    private javax.swing.JPasswordField txtConfSenha;
    private javax.swing.JTextField txtIdUsuario;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNomeUsuario;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
   public void preencherTabelaUsuario(String SQL) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Cód Usuario", "Nome", "Login", "Permissão", "Bloqueado"};
        connUsuario.executaSQL(SQL);
        try {
            connUsuario.rs.first();
            do {
                dados.add(new Object[]{connUsuario.rs.getInt("codusuario"), connUsuario.rs.getString("usuario"), connUsuario.rs.getString("login"), connUsuario.rs.getString("permissao"), connUsuario.rs.getString("bloqueado")});
            } while (connUsuario.rs.next());
            connUsuario.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher o ArrayList de usuarios\n ERRO:" + ex);
            connUsuario.desconectar();
        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTableUsuarios.setModel(modelo);
        jTableUsuarios.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTableUsuarios.getColumnModel().getColumn(0).setResizable(false);
        jTableUsuarios.getColumnModel().getColumn(1).setPreferredWidth(270);
        jTableUsuarios.getColumnModel().getColumn(1).setResizable(false);
        jTableUsuarios.getColumnModel().getColumn(2).setPreferredWidth(200);
        jTableUsuarios.getColumnModel().getColumn(2).setResizable(false);
        jTableUsuarios.getColumnModel().getColumn(3).setPreferredWidth(144);
        jTableUsuarios.getColumnModel().getColumn(3).setResizable(false);
        jTableUsuarios.getColumnModel().getColumn(4).setPreferredWidth(79);
        jTableUsuarios.getColumnModel().getColumn(4).setResizable(false);
        jTableUsuarios.getTableHeader().setReorderingAllowed(false);
        jTableUsuarios.setAutoResizeMode(jTableUsuarios.AUTO_RESIZE_OFF);
        jTableUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        connUsuario.desconectar();
    }
    private String bloqueado;

    public void botao() {
        btnNovo.setEnabled(true);
        btnAlterar.setEnabled(true);
        btnAtualizar.setEnabled(false);
        btnExcluir.setEnabled(true);
        btnCancelar.setEnabled(false);
        btnSalvar.setEnabled(false);
    }

    public void libera_campos() {
        txtNomeUsuario.setEditable(true);
        txtLogin.setEditable(true);
        txtSenha.setEditable(true);
    }

    public void limpa_campos() {
        txtNomeUsuario.setText("");;
        txtLogin.setText("");
        txtSenha.setText("");
        txtConfSenha.setText("");
    }

    public void bloqueia_campos() {
        txtIdUsuario.setEditable(false);
        txtNomeUsuario.setEditable(false);
        txtLogin.setEditable(false);
        txtSenha.setEditable(false);
        txtConfSenha.setEditable(false);
        cbPermissao.setEditable(false);
        //jCheckBoxBlock.setEnabled(false);
    }
    //Caminho para o icone da janela
    /*private void setIcon() {
     setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../imagens/icone.png")));
     }*/
}
