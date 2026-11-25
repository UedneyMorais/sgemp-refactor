package visao;

import controle.Conexao;
import controle.ControleProduto;
import controle.LimitaDigitos;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.Clock;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import modelo.ModeloProduto;
import modelo.ModeloTabela;

public final class FrmProduto extends javax.swing.JFrame {

    final String frm = "FrmProduto";
    String id = "";
    Conexao connProduto = new Conexao();
    Conexao connCategoria = new Conexao();
    Conexao connFornecedor = new Conexao();
    ModeloProduto mod = new ModeloProduto();
    ControleProduto control = new ControleProduto();
    String sql = "SELECT * FROM produto\n"
            + "INNER JOIN categoriaprod ON produto.codcategoriaprod = categoriaprod.codcategoriaprod\n"
            + "INNER JOIN fornecedor ON produto.codfornec = fornecedor.codfornec\n"
            + "WHERE ativo='S' ORDER BY produto.descricao";

    public FrmProduto(String id) {
        initComponents();
        this.id = id;
        this.setIconImage(new ImageIcon(getClass().getResource("/imagens/icone.png")).getImage());
        txtCodProduto.setDocument(new LimitaDigitos(13));
        bloqueia_campos();
        botao();
        PreencherTabelaProdutos(sql);
        connCategoria.conectar();
        connCategoria.executaSQL("SELECT * FROM CATEGORIAPROD");
        cbCategoria.removeAllItems();
        try {
            connCategoria.rs.first();
            do {
                cbCategoria.addItem(connCategoria.rs.getString("descricao"));
            } while (connCategoria.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher o combo box com categorias \n ERRO: " + ex);
        }
        connFornecedor.executaSQL("select * from fornecedor");
        cbFornecedor.removeAllItems();
        try {
            connFornecedor.rs.first();
            do {
                cbFornecedor.addItem(connFornecedor.rs.getString("fornecedor"));
            } while (connFornecedor.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher o combo box com fornecedores \n ERRO: " + ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtIdProd = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtBuscaProd = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtCodProduto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDescProd = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPrecoVenda = new javax.swing.JTextField();
        lblEstoque = new javax.swing.JLabel();
        txtEstoque = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEstoqueMin = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtEstoqueMax = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProduto = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        cbFornecedor = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        txtPrecoComp = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtMargenLuc = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtSugerido = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de produtos");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

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

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/save.png"))); // NOI18N
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnAlterar)
                    .addComponent(btnSalvar)
                    .addComponent(btnAtualizar)
                    .addComponent(btnCancelar)
                    .addComponent(btnExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setText("Código: ");

        jLabel2.setText("Busca pelo nome do produto:");

        txtBuscaProd.setBackground(new java.awt.Color(255, 255, 102));
        txtBuscaProd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscaProdFocusLost(evt);
            }
        });
        txtBuscaProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscaProdActionPerformed(evt);
            }
        });
        txtBuscaProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscaProdKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscaProdKeyTyped(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1409426505_search.png"))); // NOI18N

        jLabel10.setText("Código do produto: ");

        txtCodProduto.setToolTipText("Use o leitor de código de barras ou digite o código do produto.");
        txtCodProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodProdutoActionPerformed(evt);
            }
        });

        jLabel3.setText("Descrição: ");

        txtDescProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescProdActionPerformed(evt);
            }
        });

        jLabel4.setText("Preço de venda:");

        lblEstoque.setText("Qtde estoque:");

        txtEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstoqueActionPerformed(evt);
            }
        });

        jLabel6.setText("Estoque Mínimo:");

        jLabel7.setText("Estoque Máximo: ");

        jTableProduto.setAutoCreateRowSorter(true);
        jTableProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableProduto.setGridColor(new java.awt.Color(255, 255, 255));
        jTableProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProdutoMouseClicked(evt);
            }
        });
        jTableProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableProdutoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProduto);

        jLabel11.setText("Categoria:");

        jLabel12.setText("Fornecedor: ");

        jLabel8.setText("Preço de compra:");

        jLabel13.setText("Margem de lucro: ");

        txtMargenLuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMargenLucKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMargenLucKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMargenLucKeyTyped(evt);
            }
        });

        jLabel14.setText("Preço sugerido:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(1, 1, 1)
                        .addComponent(txtCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(179, 179, 179)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbFornecedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdProd, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscaProd, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(lblEstoque))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtDescProd, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel12))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6)
                                        .addGap(24, 24, 24)
                                        .addComponent(txtEstoqueMin, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtPrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtPrecoComp, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtEstoqueMax))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtMargenLuc, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSugerido)))))
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(txtIdProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBuscaProd, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel12)
                    .addComponent(cbFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(txtPrecoComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtMargenLuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txtSugerido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtEstoqueMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtEstoqueMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblEstoque)
                        .addComponent(jLabel6)))
                .addGap(0, 262, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(154, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int n = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir o produto do sistema?", "", JOptionPane.YES_NO_OPTION);
        if (n == 0) {
            mod.setCod(Integer.parseInt(txtIdProd.getText()));
            control.ExcluirProduto(mod);
            PreencherTabelaProdutos(sql);

            jTableProduto.setVisible(true);
            connCategoria.desconectar();
            connFornecedor.desconectar();
            connProduto.desconectar();
        } else {
            limpa_campos();
            bloqueia_campos();
            botao();
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void txtBuscaProdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaProdKeyTyped
        // TODO add your handling code here:
        PreencherTabelaProdutos("SELECT * FROM produto\n"
                + "INNER JOIN categoriaprod ON produto.codcategoriaprod = categoriaprod.codcategoriaprod\n"
                + "INNER JOIN fornecedor ON produto.codfornec = fornecedor.codfornec\n"
                + "WHERE produto.descricao LIKE '%" + txtBuscaProd.getText() + "%' AND `ativo`='S' ORDER BY produto.descricao");
    }//GEN-LAST:event_txtBuscaProdKeyTyped

    private void txtDescProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescProdActionPerformed

    private void txtEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstoqueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstoqueActionPerformed

    private void jTableProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProdutoMouseClicked

        int indice = jTableProduto.getSelectedRow();
        DecimalFormat df = new DecimalFormat();
        df.applyPattern("###,##0.00");
        txtIdProd.setText(jTableProduto.getValueAt(indice, 0).toString());
        txtDescProd.setText(jTableProduto.getValueAt(indice, 1).toString());
        double pvenda = Double.parseDouble(jTableProduto.getValueAt(indice, 2).toString());
        double pcompra = Double.parseDouble(jTableProduto.getValueAt(indice, 3).toString());
        txtPrecoVenda.setText(df.format(pvenda));
        txtPrecoComp.setText(df.format(pcompra));
        txtMargenLuc.setText(jTableProduto.getValueAt(indice, 4).toString());
        txtEstoque.setText(jTableProduto.getValueAt(indice, 5).toString());
        txtCodProduto.setText(jTableProduto.getValueAt(indice, 6).toString());
        txtEstoqueMin.setText(jTableProduto.getValueAt(indice, 7).toString());
        txtEstoqueMax.setText(jTableProduto.getValueAt(indice, 8).toString());
        cbCategoria.setSelectedItem(jTableProduto.getValueAt(indice, 9).toString());
        cbFornecedor.setSelectedItem(jTableProduto.getValueAt(indice, 10).toString());

        double pc = pcompra;
        double marg = Double.parseDouble(txtMargenLuc.getText());
        double cc_porc = (pc * marg) / 100;
        double t = pc + cc_porc;
        txtSugerido.setText(df.format(t));
        verificaQtde();

    }//GEN-LAST:event_jTableProdutoMouseClicked

    private void txtBuscaProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaProdActionPerformed

    }//GEN-LAST:event_txtBuscaProdActionPerformed

    private void txtBuscaProdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaProdKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscaProdKeyReleased

    private void jTableProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableProdutoKeyReleased
        int indice = jTableProduto.getSelectedRow();
        DecimalFormat df = new DecimalFormat();
        df.applyPattern("#,##0.00");
        txtIdProd.setText(jTableProduto.getValueAt(indice, 0).toString());
        txtDescProd.setText(jTableProduto.getValueAt(indice, 1).toString());
        double pvenda = Double.parseDouble(jTableProduto.getValueAt(indice, 2).toString());
        double pcompra = Double.parseDouble(jTableProduto.getValueAt(indice, 3).toString());
        txtPrecoVenda.setText(df.format(pvenda));
        txtPrecoComp.setText(df.format(pcompra));
        txtMargenLuc.setText(jTableProduto.getValueAt(indice, 4).toString());
        txtEstoque.setText(jTableProduto.getValueAt(indice, 5).toString());
        txtCodProduto.setText(jTableProduto.getValueAt(indice, 6).toString());
        txtEstoqueMin.setText(jTableProduto.getValueAt(indice, 7).toString());
        txtEstoqueMax.setText(jTableProduto.getValueAt(indice, 8).toString());
        cbCategoria.setSelectedItem(jTableProduto.getValueAt(indice, 9).toString());
        cbFornecedor.setSelectedItem(jTableProduto.getValueAt(indice, 10).toString());

        double pc = pcompra;
        double marg = Double.parseDouble(txtMargenLuc.getText());
        double cc_porc = (pc * marg) / 100;
        double t = pc + cc_porc;
        txtSugerido.setText(df.format(t));
        verificaQtde();

    }//GEN-LAST:event_jTableProdutoKeyReleased

    private void txtBuscaProdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscaProdFocusLost
        txtBuscaProd.setText("");
    }//GEN-LAST:event_txtBuscaProdFocusLost

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        btnNovo.setEnabled(false);
        btnSalvar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnAlterar.setEnabled(false);
        jTableProduto.setVisible(false);
        txtCodProduto.requestFocus();
        libera_campos();
        limpa_campos();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpa_campos();
        bloqueia_campos();
        botao();
        jTableProduto.setEnabled(true);
        jTableProduto.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        btnNovo.setEnabled(false);
        btnSalvar.setEnabled(false);
        btnCancelar.setEnabled(true);
        btnAtualizar.setEnabled(true);
        btnAlterar.setEnabled(false);
        libera_campos();
        permissao();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        try {
            connProduto.conectar();
            connProduto.stmt = connProduto.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, connProduto.rs.CONCUR_READ_ONLY);
            connProduto.rs = connProduto.stmt.executeQuery("select * from produto where codprod='" + txtCodProduto.getText() + "'");

            if (connProduto.rs.next()) {
                JOptionPane.showMessageDialog(null, "Produto já cadastrado\n Verifique o código do produto!");
            } else {
                mod.setCodProd(txtCodProduto.getText());
                mod.setDesc(txtDescProd.getText());
                connProduto.executaSQL("select * from fornecedor where codfornec = '" + cbFornecedor.getSelectedItem() + "'");
                connProduto.rs.first();
                mod.setCodFornec(connProduto.rs.getInt("codfornec"));
                connProduto.executaSQL("select * from categoriaprod where categoriaprod = '" + cbCategoria.getSelectedItem() + "'");
                connProduto.rs.first();
                mod.setCodCateg(connProduto.rs.getInt("codcategoriaprod"));
                mod.setValor(Double.parseDouble(txtPrecoVenda.getText()));
                mod.setValorCompra(Double.parseDouble(txtPrecoComp.getText()));
                //mod.setPrecoSug(Double.parseDouble(txtSugerido.getText()));
                mod.setPorc(Double.parseDouble(txtMargenLuc.getText()));
                mod.setQtde(Integer.parseInt(txtEstoque.getText()));
                mod.setEstMin(Integer.parseInt(txtEstoqueMin.getText()));
                mod.setEstMax(Integer.parseInt(txtEstoqueMax.getText()));
                control.InserirProduto(mod);
                jTableProduto.setVisible(true);
                PreencherTabelaProdutos(sql);
                botao();
                bloqueia_campos();
                connCategoria.desconectar();
                connFornecedor.desconectar();
                connProduto.desconectar();
            }
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao salvar o produto \nERRO:" + e);
//            txtSenha.setText("");
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed

        try {
            mod.setCod(Integer.parseInt(txtIdProd.getText()));
            mod.setCodProd(txtCodProduto.getText());
            mod.setDesc(txtDescProd.getText());
            connProduto.executaSQL("select * from categoriaprod where categoriaprod.descricao = '" + cbCategoria.getSelectedItem() + "'");
            connProduto.rs.first();
            mod.setCodCateg(connProduto.rs.getInt("codcategoriaprod"));
            connProduto.executaSQL("select * from fornecedor where fornecedor.fornecedor = '" + cbFornecedor.getSelectedItem() + "'");
            connProduto.rs.first();
            mod.setCodFornec(connProduto.rs.getInt("codfornec"));
            mod.setValor(Double.parseDouble(txtPrecoVenda.getText().replaceAll(",", ".")));
            mod.setValorCompra(Double.parseDouble(txtPrecoComp.getText().replaceAll(",", ".")));
            mod.setPorc(Double.parseDouble(txtMargenLuc.getText()));
            mod.setQtde(Integer.parseInt(txtEstoque.getText()));
            mod.setEstMin(Integer.parseInt(txtEstoqueMin.getText()));
            mod.setEstMax(Integer.parseInt(txtEstoqueMax.getText()));
            control.AlterarProduto(mod);
            jTableProduto.setVisible(true);
            PreencherTabelaProdutos(sql);
            botao();
            bloqueia_campos();
            connCategoria.desconectar();
            connFornecedor.desconectar();
            connProduto.desconectar();

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(rootPane, "Não calculou \nERRO:" + e);
//            txtSenha.setText("");
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void txtMargenLucKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMargenLucKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_txtMargenLucKeyTyped

    private void txtMargenLucKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMargenLucKeyPressed

    }//GEN-LAST:event_txtMargenLucKeyPressed

    private void txtMargenLucKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMargenLucKeyReleased

    }//GEN-LAST:event_txtMargenLucKeyReleased

    private void txtCodProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodProdutoActionPerformed

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
//            java.util.logging.Logger.getLogger(FrmProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new FrmProduto().setVisible(true);
//            }
//        });
//    }
    public void PreencherTabelaProdutos(String SQL) {

        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Código", "Descrição do Produto", "Preço", "Valor compra", "Margem", "Qtde", "Código do produto", "Est Mín", "Est Máx", "Categoria", "Fornecedor"};
        connProduto.executaSQL(SQL);
        try {
            connProduto.rs.first();
            do {
                DecimalFormat df = new DecimalFormat();
                df.applyPattern("#,##0.00");
                dados.add(new Object[]{connProduto.rs.getInt("codprod"), connProduto.rs.getString("descricao"), connProduto.rs.getString("preco"), connProduto.rs.getString("valorcompra"), connProduto.rs.getString("margem"), connProduto.rs.getString("qtde"), connProduto.rs.getString("codprod"), connProduto.rs.getString("estmin"), connProduto.rs.getString("estmax"), connProduto.rs.getString("descricao"), connProduto.rs.getString("fornecedor")});
            } while (connProduto.rs.next());
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Erro ao preencher o ArrayList de produtos \n ERRO:" + e);
            JOptionPane.showMessageDialog(null, "Produto não encontrado");
            txtBuscaProd.setText("");
        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTableProduto.setModel(modelo);
        jTableProduto.getColumnModel().getColumn(0).setPreferredWidth(50);//Código
        jTableProduto.getColumnModel().getColumn(0).setResizable(false);
        jTableProduto.getColumnModel().getColumn(1).setPreferredWidth(200);//Descrição do Produto
        jTableProduto.getColumnModel().getColumn(1).setResizable(false);
        jTableProduto.getColumnModel().getColumn(2).setPreferredWidth(55);//Preço
        jTableProduto.getColumnModel().getColumn(2).setResizable(false);
        jTableProduto.getColumnModel().getColumn(3).setPreferredWidth(85);//Valor compra
        jTableProduto.getColumnModel().getColumn(3).setResizable(false);
        jTableProduto.getColumnModel().getColumn(4).setPreferredWidth(60);//Margem
        jTableProduto.getColumnModel().getColumn(4).setResizable(false);
//        jTableProduto.getColumnModel().getColumn(5).setPreferredWidth(60);//Preço sugerido
//        jTableProduto.getColumnModel().getColumn(5).setResizable(false);
        jTableProduto.getColumnModel().getColumn(5).setPreferredWidth(38);//Quantidade
        jTableProduto.getColumnModel().getColumn(5).setResizable(false);
        jTableProduto.getColumnModel().getColumn(6).setPreferredWidth(113);//Código do produto
        jTableProduto.getColumnModel().getColumn(6).setResizable(true);
        jTableProduto.getColumnModel().getColumn(7).setPreferredWidth(50);//Est Mín
        jTableProduto.getColumnModel().getColumn(7).setResizable(false);
        jTableProduto.getColumnModel().getColumn(8).setPreferredWidth(53);//Est Máx
        jTableProduto.getColumnModel().getColumn(8).setResizable(false);
        jTableProduto.getColumnModel().getColumn(9).setPreferredWidth(100);//Categoria
        jTableProduto.getColumnModel().getColumn(9).setResizable(false);
        jTableProduto.getColumnModel().getColumn(10).setPreferredWidth(113);//Fornecedor
        jTableProduto.getColumnModel().getColumn(10).setResizable(false);
        jTableProduto.getTableHeader().setReorderingAllowed(false);
        jTableProduto.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTableProduto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void botao() {
        btnNovo.setEnabled(true);
        btnAlterar.setEnabled(true);
        btnAtualizar.setEnabled(false);
        btnExcluir.setEnabled(true);
        btnCancelar.setEnabled(false);
        btnSalvar.setEnabled(false);
    }

    public void libera_campos() {
        txtCodProduto.setEnabled(true);
        txtPrecoVenda.setEnabled(true);
        txtPrecoComp.setEnabled(true);
        txtMargenLuc.setEnabled(true);
        //txtSugerido.setEnabled(true);
        cbCategoria.setEnabled(true);
        cbFornecedor.setEnabled(true);
        txtBuscaProd.setEnabled(true);
        //txtDescProd.setEnabled(true);
        txtEstoque.setEnabled(true);
        txtEstoqueMin.setEnabled(true);
        txtEstoqueMax.setEnabled(true);
    }

    public void limpa_campos() {
        txtCodProduto.setText("");
        txtPrecoVenda.setText("");
        txtPrecoComp.setText("");
        txtMargenLuc.setText("");
        txtSugerido.setText("");
        cbCategoria.setEnabled(true);
        cbFornecedor.setEnabled(true);
        txtBuscaProd.setText("");
        txtDescProd.setText("");
        txtEstoque.setText("");
        txtEstoqueMin.setText("");
        txtEstoqueMax.setText("");
    }

    public void bloqueia_campos() {
        txtIdProd.setEnabled(false);
        txtCodProduto.setEnabled(false);
        txtPrecoVenda.setEnabled(false);
        txtPrecoComp.setEnabled(false);
        txtMargenLuc.setEnabled(false);
        txtSugerido.setEnabled(false);
        cbCategoria.setEnabled(false);
        cbFornecedor.setEnabled(false);
        //txtBuscaProd.setEnabled(false);
        txtDescProd.setEnabled(false);
        txtEstoque.setEnabled(false);
        txtEstoqueMin.setEnabled(false);
        txtEstoqueMax.setEnabled(false);
    }

    public void verificaQtde() {
        int qtde = Integer.parseInt(txtEstoque.getText());
        int min = Integer.parseInt(txtEstoqueMin.getText());
        if (qtde < min) {
            lblEstoque.setForeground(Color.RED);
            txtEstoque.setForeground(Color.RED);
        } else {
            lblEstoque.setForeground(Color.BLACK);
            txtEstoque.setForeground(Color.BLACK);
        }
    }

    public void acertaValor() {

//        String pve = txtPrecoVenda.getText();
//        String spve = pve.replace(" ", "").replace(".", ",");
//        Double precVenda = new Double(spve);
////        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
//        DecimalFormat df = new DecimalFormat(spve);
//        df.applyPattern("00.00");
//        String pVendaFormatado = df.format(precVenda);
//        txtPrecoVenda.setText(pVendaFormatado);
    }

    public void permissao() {
        try {
            connProduto.executaSQL("SELECT `libacesso`.`codlibacesso`,`libcampo`.`codframe`,`libcampo`.`nomecampo`,libcampo.`permite`,codusuario FROM libcampo \n"
                    + "INNER JOIN libacesso ON libacesso.`codframe` = libcampo.`codframe`\n"
                    + "INNER JOIN campo ON `libcampo`.`nomecampo`   = `campo`.`nomecampo`\n"
                    + "WHERE codusuario='" + id + "' AND libcampo.codframe='" + frm + "';");
            connProduto.rs.first();

            if (connProduto.rs.next()) {
                 if (connProduto.rs.getString("libcampo.codframe").equals(frm) && connProduto.rs.getString("libcampo.nomecampo").equals("txtDescProd")&&connProduto.rs.getString("libcampo.permite").equals("S")) {
                txtDescProd.setEnabled(true);
                System.err.println("caiu no S");
            } else if (connProduto.rs.getString("libcampo.codframe").equals(frm) && connProduto.rs.getString("libcampo.nomecampo").equals("txtDescProd")&&connProduto.rs.getString("libcampo.permite").equals("N")) {
                txtDescProd.setEnabled(false);
                System.err.println("caiu no N");      
            }
            } else {
                JOptionPane.showMessageDialog(this, "Usuario sem permissoes, por favor atualize as permissões");
                bloqueia_campos();
                btnAtualizar.setEnabled(false);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro do buscar a permissão \nERRO:" + ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cbCategoria;
    private javax.swing.JComboBox cbFornecedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProduto;
    private javax.swing.JLabel lblEstoque;
    private javax.swing.JTextField txtBuscaProd;
    private javax.swing.JTextField txtCodProduto;
    private javax.swing.JTextField txtDescProd;
    private javax.swing.JTextField txtEstoque;
    private javax.swing.JTextField txtEstoqueMax;
    private javax.swing.JTextField txtEstoqueMin;
    private javax.swing.JTextField txtIdProd;
    private javax.swing.JTextField txtMargenLuc;
    private javax.swing.JTextField txtPrecoComp;
    private javax.swing.JTextField txtPrecoVenda;
    private javax.swing.JTextField txtSugerido;
    // End of variables declaration//GEN-END:variables
}
