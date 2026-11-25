package visao;

import controle.Conexao;
import controle.ControleContasPg;
import controle.FormatoData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import modelo.ModeloContasPg;
import modelo.ModeloTabela;

/**
 *
 * @author Uedney
 */
public final class FrmContasPg extends javax.swing.JFrame {

    Conexao connContaspg = new Conexao();
    Conexao connFornecedor = new Conexao();
    ModeloContasPg mod = new ModeloContasPg();
    ControleContasPg control = new ControleContasPg();
    FormatoData form = new FormatoData();

    public FrmContasPg() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/imagens/icone.png")).getImage());
        mascara();
        bloqueia_campos();
        botao();
        preencherTabelaContaspg("SELECT * FROM `cad_contaspg`\n"
                + "INNER JOIN `cad_fornec` ON `cad_contaspg`.`id_fornecedor` = `cad_fornec`.`id_fornec`\n"
                + "INNER JOIN `cad_bairro` ON `cad_fornec`.`id_bairro` = cad_bairro.`id_bairro`\n"
                + "INNER JOIN `cad_cidade` ON `cad_bairro`.`id_cidade` = `cad_cidade`.`id_cidade`\n"
                + "INNER JOIN `cad_estado` ON `cad_cidade`.`id_estado` = `cad_estado`.`id_estado`\n"
                + "INNER JOIN `cad_categoriapg` ON `cad_contaspg`.`id_categoriapg` = `cad_categoriapg`.`id_categoriapg`\n");

        connContaspg.conectar();
        connContaspg.executaSQL("SELECT * FROM CAD_CATEGORIAPG");
        cbCategoria.removeAllItems();
        try {
            connContaspg.rs.first();
            do {
                cbCategoria.addItem(connContaspg.rs.getString("desc_categoriapg"));
            } while (connContaspg.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher o combo box com categorias \n ERRO: " + ex);
        }
        connFornecedor.conectar();
        connFornecedor.executaSQL("SELECT * FROM CAD_FORNEC");
        cbFornecedor.removeAllItems();
        try {
            connFornecedor.rs.first();
            do {
                cbFornecedor.addItem(connFornecedor.rs.getString("NOME_FORNEC"));
            } while (connFornecedor.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher o combo box com fornecedores \n ERRO: " + ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableContasPg = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtCodPg = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cbFornecedor = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        txtDesc = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        jCheckBoxContaPaga = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtDesconto = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtMulta = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtValorPago = new javax.swing.JTextField();
        txtDtPago = new javax.swing.JFormattedTextField();
        btnCalcular = new javax.swing.JButton();
        txtVencimento = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Contas a pagar");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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

        jTableContasPg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableContasPg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableContasPgMouseClicked(evt);
            }
        });
        jTableContasPg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableContasPgKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableContasPg);

        jLabel1.setText("Código: ");

        txtCodPg.setEditable(false);
        txtCodPg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodPgActionPerformed(evt);
            }
        });

        jLabel2.setText("Categoria :");

        cbCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Fornecedor: ");

        cbFornecedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Descrição: ");

        jLabel5.setText("Vencimento: ");

        jLabel6.setText("Valor: ");

        jCheckBoxContaPaga.setText("Conta Paga");
        jCheckBoxContaPaga.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBoxContaPagaMouseClicked(evt);
            }
        });
        jCheckBoxContaPaga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxContaPagaActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setText("Pago em: ");

        jLabel8.setText("(-) Descontos: ");

        txtDesconto.setText("0");

        jLabel9.setText("(+) Juros/Multa:");

        txtMulta.setText("0");

        jLabel10.setText("(=) Valor Pago: ");

        txtValorPago.setEditable(false);
        txtValorPago.setText("0");

        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDtPago, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMulta, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCalcular)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtValorPago, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(txtDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtMulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtValorPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDtPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCalcular))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxContaPaga)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtDesc))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel1)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtCodPg))
                                                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnAtualizar)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(cbFornecedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(18, 18, 18)
                                            .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnCancelar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtValor, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                                            .addComponent(txtVencimento))))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtualizar)
                    .addComponent(btnSalvar)
                    .addComponent(btnAlterar)
                    .addComponent(btnNovo)
                    .addComponent(btnExcluir)
                    .addComponent(btnCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodPg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jCheckBoxContaPaga)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        btnNovo.setEnabled(false);
        btnSalvar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnAlterar.setEnabled(false);
        jTableContasPg.setVisible(false);
        cbCategoria.requestFocus();
        libera_campos();
        limpa_campos();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        try {
            connContaspg.rs.first();
            connContaspg.executaSQL("select * from cad_contaspg where id_contaspg ='" + txtCodPg.getText() + "'");
            while (connContaspg.rs.next()) {
                String result = connContaspg.rs.getString("pago_contaspg");
                if (result.equals("S")) {
                    JOptionPane.showMessageDialog(rootPane, "A conta já foi paga, impossível alterar o pagamento,\n Entre em contato com o administrador!");
                } else {
                    btnNovo.setEnabled(false);
                    btnSalvar.setEnabled(false);
                    btnCancelar.setEnabled(true);
                    btnAtualizar.setEnabled(true);
                    btnAlterar.setEnabled(false);
                    jTableContasPg.setEnabled(false);
                    libera_campos();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmContasPg.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (jCheckBoxContaPaga.isSelected()) {
            pagou = "S";
        } else {
            pagou = "N";
        }
        if (jCheckBoxContaPaga.isSelected()) {
            try {
                mod.setDesc(txtDesc.getText());
                mod.setVencimento(dataVenc(txtVencimento.getText()));
                mod.setValor(txtValor.getText());
                mod.setPagou(pagou);
                mod.setDtPago(dataPago(txtDtPago.getText()));
                mod.setDesconto(txtDesconto.getText());
                mod.setMulta(txtMulta.getText());
                mod.setValorPago(txtValorPago.getText());
                connContaspg.executaSQL("select * from cad_fornec where nome_fornec = '" + cbFornecedor.getSelectedItem() + "'");
                connContaspg.rs.first();
                mod.setFornecedor(connContaspg.rs.getInt("id_fornec"));
                connContaspg.executaSQL("select * from cad_categoriapg where desc_categoriapg= '" + cbCategoria.getSelectedItem() + "'");
                connContaspg.rs.first();
                mod.setCategoria(connContaspg.rs.getInt("id_categoriapg"));
                control.InserirContasPG(mod);
                preencherTabelaContaspg("SELECT * FROM `cad_contaspg`\n"
                        + "INNER JOIN `cad_fornec` ON `cad_contaspg`.`id_fornecedor` = `cad_fornec`.`id_fornec`\n"
                        + "INNER JOIN `cad_bairro` ON `cad_fornec`.`id_bairro` = cad_bairro.`id_bairro`\n"
                        + "INNER JOIN `cad_cidade` ON `cad_bairro`.`id_cidade` = `cad_cidade`.`id_cidade`\n"
                        + "INNER JOIN `cad_estado` ON `cad_cidade`.`id_estado` = `cad_estado`.`id_estado`\n"
                        + "INNER JOIN `cad_categoriapg` ON `cad_contaspg`.`id_categoriapg` = `cad_categoriapg`.`id_categoriapg`\n");
                jTableContasPg.setVisible(true);
                bloqueia_campos();
                botao();
            } catch (SQLException ex) {
                Logger.getLogger(FrmContasPg.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                mod.setDesc(txtDesc.getText());
                mod.setVencimento(dataVenc(txtVencimento.getText()));
                mod.setValor(txtValor.getText());
                mod.setPagou(pagou);
                connContaspg.executaSQL("select * from cad_fornec where nome_fornec = '" + cbFornecedor.getSelectedItem() + "'");
                connContaspg.rs.first();
                mod.setFornecedor(connContaspg.rs.getInt("id_fornec"));
                connContaspg.executaSQL("select * from cad_categoriapg where desc_categoriapg= '" + cbCategoria.getSelectedItem() + "'");
                connContaspg.rs.first();
                mod.setCategoria(connContaspg.rs.getInt("id_categoriapg"));
                control.InserirContasNpg(mod);
                preencherTabelaContaspg("SELECT * FROM `cad_contaspg`\n"
                        + "INNER JOIN `cad_fornec` ON `cad_contaspg`.`id_fornecedor` = `cad_fornec`.`id_fornec`\n"
                        + "INNER JOIN `cad_bairro` ON `cad_fornec`.`id_bairro` = cad_bairro.`id_bairro`\n"
                        + "INNER JOIN `cad_cidade` ON `cad_bairro`.`id_cidade` = `cad_cidade`.`id_cidade`\n"
                        + "INNER JOIN `cad_estado` ON `cad_cidade`.`id_estado` = `cad_estado`.`id_estado`\n"
                        + "INNER JOIN `cad_categoriapg` ON `cad_contaspg`.`id_categoriapg` = `cad_categoriapg`.`id_categoriapg`\n");
                jTableContasPg.setVisible(true);
                bloqueia_campos();
                botao();
            } catch (SQLException ex) {
                Logger.getLogger(FrmContasPg.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        if (jCheckBoxContaPaga.isSelected()) {
            pagou = "S";
        } else {
            pagou = "N";
        }
        if (jCheckBoxContaPaga.isSelected()) {
            try {
                mod.setCod(Integer.parseInt(txtCodPg.getText()));
                mod.setDesc(txtDesc.getText());
                mod.setVencimento(dataVenc(txtVencimento.getText()));
                mod.setValor(txtValor.getText());
                mod.setPagou(pagou);
                mod.setDtPago(dataPago(txtDtPago.getText()));
                mod.setDesconto(txtDesconto.getText());
                mod.setMulta(txtMulta.getText());
                mod.setValorPago(txtValorPago.getText());
                connContaspg.executaSQL("select * from cad_fornec where nome_fornec = '" + cbFornecedor.getSelectedItem() + "'");
                connContaspg.rs.first();
                mod.setFornecedor(connContaspg.rs.getInt("id_fornec"));
                connContaspg.executaSQL("select * from cad_categoriapg where desc_categoriapg= '" + cbCategoria.getSelectedItem() + "'");
                connContaspg.rs.first();
                mod.setCategoria(connContaspg.rs.getInt("id_categoriapg"));
                control.AlterarContasPg(mod);
                preencherTabelaContaspg("SELECT * FROM `cad_contaspg`\n"
                        + "INNER JOIN `cad_fornec` ON `cad_contaspg`.`id_fornecedor` = `cad_fornec`.`id_fornec`\n"
                        + "INNER JOIN `cad_bairro` ON `cad_fornec`.`id_bairro` = cad_bairro.`id_bairro`\n"
                        + "INNER JOIN `cad_cidade` ON `cad_bairro`.`id_cidade` = `cad_cidade`.`id_cidade`\n"
                        + "INNER JOIN `cad_estado` ON `cad_cidade`.`id_estado` = `cad_estado`.`id_estado`\n"
                        + "INNER JOIN `cad_categoriapg` ON `cad_contaspg`.`id_categoriapg` = `cad_categoriapg`.`id_categoriapg`\n");
                bloqueia_campos();
                botao();
                jTableContasPg.setEnabled(true);
            } catch (SQLException ex) {
                Logger.getLogger(FrmContasPg.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                mod.setCod(Integer.parseInt(txtCodPg.getText()));
                mod.setDesc(txtDesc.getText());
                mod.setVencimento(dataVenc(txtVencimento.getText()));
                mod.setValor(txtValor.getText());
                mod.setPagou(pagou);
                connContaspg.executaSQL("select * from cad_fornec where nome_fornec = '" + cbFornecedor.getSelectedItem() + "'");
                connContaspg.rs.first();
                mod.setFornecedor(connContaspg.rs.getInt("id_fornec"));
                connContaspg.executaSQL("select * from cad_categoriapg where desc_categoriapg= '" + cbCategoria.getSelectedItem() + "'");
                connContaspg.rs.first();
                mod.setCategoria(connContaspg.rs.getInt("id_categoriapg"));
                control.AlterarContasNpg(mod);
                preencherTabelaContaspg("SELECT * FROM `cad_contaspg`\n"
                        + "INNER JOIN `cad_fornec` ON `cad_contaspg`.`id_fornecedor` = `cad_fornec`.`id_fornec`\n"
                        + "INNER JOIN `cad_bairro` ON `cad_fornec`.`id_bairro` = cad_bairro.`id_bairro`\n"
                        + "INNER JOIN `cad_cidade` ON `cad_bairro`.`id_cidade` = `cad_cidade`.`id_cidade`\n"
                        + "INNER JOIN `cad_estado` ON `cad_cidade`.`id_estado` = `cad_estado`.`id_estado`\n"
                        + "INNER JOIN `cad_categoriapg` ON `cad_contaspg`.`id_categoriapg` = `cad_categoriapg`.`id_categoriapg`\n");

                bloqueia_campos();
                botao();
            } catch (SQLException ex) {
                JOptionPane.showInternalMessageDialog(rootPane, ex);
            }
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        limpa_campos();
        bloqueia_campos();
        botao();
        jTableContasPg.setEnabled(true);
        jTableContasPg.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
//        int n = JOptionPane.showConfirmDialog(rootPane,"Deseja realmente excluir os dados do sistema?","",JOptionPane.YES_NO_OPTION);
//        if (n == 0)
//        try {
//            mod.setCod(Integer.parseInt(txtId_cidade.getText()));
//            mod.setNome(txtNomeCidade.getText());
//            connEstado.executaSQL("select * from cad_estado where nome_estado = '"+cbNomeEstado.getSelectedItem()+"'");
//            connEstado.rs.first();
//            mod.setCod_estado(connEstado.rs.getInt("id_estado"));
//            control.ExcluirCidade(mod);
//            preencherTabelaCidade("SELECT * FROM cad_cidade INNER JOIN cad_estado ON cad_cidade.id_estado = cad_estado.id_estado");
//            jTableCidade.setVisible(true);
//        } catch (SQLException ex) {
//            Logger.getLogger(FrmCidade.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        else{
//            limpa_campos_cid();
//            bloqueia_campos_cid();
//            botao_cid();
//        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void txtCodPgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodPgActionPerformed

//        try {
//            connContaspg.rs.first();
//            connContaspg.executaSQL("select * from cad_contaspg where id_contaspg ='" + txtCodPg.getText() + "'");
//            while (connContaspg.rs.next()) {
//                String result = connContaspg.rs.getString("pago_contaspg");
//                if (result.equals("S")) {
//                    jCheckBoxContaPaga.isSelected();
//                    JOptionPane.showMessageDialog(rootPane, result);
//                    //jCheckBoxContaPaga.setSelected(true);
//                } else {
//                    jCheckBoxContaPaga.setSelected(false);
//                    JOptionPane.showMessageDialog(rootPane, result);
//                }
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(FrmContasPg.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_txtCodPgActionPerformed

    private void jTableContasPgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableContasPgMouseClicked

        int indice = jTableContasPg.getSelectedRow();
        txtCodPg.setText(jTableContasPg.getValueAt(indice, 0).toString());
        txtDesc.setText(jTableContasPg.getValueAt(indice, 1).toString());
        txtVencimento.setText(jTableContasPg.getValueAt(indice, 2).toString());
        txtValor.setText(jTableContasPg.getValueAt(indice, 3).toString());
//        txtDtPago.setText(jTableContasPg.getValueAt(indice, 5).toString());
//        txtDesconto.setText(jTableContasPg.getValueAt(indice, 6).toString());
//        txtMulta.setText(jTableContasPg.getValueAt(indice, 7).toString());
//        txtValorPago.setText(jTableContasPg.getValueAt(indice, 8).toString());
        cbFornecedor.setSelectedItem(jTableContasPg.getValueAt(indice, 9).toString());
        cbCategoria.setSelectedItem(jTableContasPg.getValueAt(indice, 10).toString());
        try {
            connContaspg.rs.first();
            connContaspg.executaSQL("select * from cad_contaspg where id_contaspg ='" + txtCodPg.getText() + "'");
            while (connContaspg.rs.next()) {
                String result = connContaspg.rs.getString("pago_contaspg");
                if (result.equals("S")) {
                    jCheckBoxContaPaga.doClick();
                    txtDtPago.setText(jTableContasPg.getValueAt(indice, 5).toString());
                    txtDesconto.setText(jTableContasPg.getValueAt(indice, 6).toString());
                    txtMulta.setText(jTableContasPg.getValueAt(indice, 7).toString());
                    txtValorPago.setText(jTableContasPg.getValueAt(indice, 8).toString());
                } else {
                    jCheckBoxContaPaga.setSelected(false);
                    txtDtPago.setText("");
                    txtDesconto.setText("");
                    txtMulta.setText("");
                    txtValorPago.setText("");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmContasPg.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jTableContasPgMouseClicked

    private void jCheckBoxContaPagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxContaPagaActionPerformed
        if (!jCheckBoxContaPaga.isSelected()) {
            txtDtPago.setText("");
        }
    }//GEN-LAST:event_jCheckBoxContaPagaActionPerformed

    private void jCheckBoxContaPagaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxContaPagaMouseClicked
        try {
            connContaspg.rs.first();
            connContaspg.executaSQL("select * from cad_contaspg where id_contaspg ='" + txtCodPg.getText() + "'");
            while (connContaspg.rs.next()) {
                String result = connContaspg.rs.getString("pago_contaspg");
                if (result.equals("S")) {
                    JOptionPane.showMessageDialog(rootPane, "A conta já foi paga, impossível alterar o pagamento,\n Entre em contato com o administrador!");
                    btnAtualizar.setEnabled(false);
                    txtDtPago.setEnabled(false);
                    txtDesconto.setEnabled(false);
                    txtMulta.setEnabled(false);
                } else {
                    if (jCheckBoxContaPaga.isSelected() && !btnNovo.isEnabled() && !btnAlterar.isEnabled()) {
                        txtDtPago.setEnabled(true);
                        txtDtPago.setEnabled(true);
                        txtDesconto.setEnabled(true);
                        txtMulta.setEnabled(true);
                        txtValorPago.setEnabled(true);
                        //limpa os campos
                        txtDesconto.setText("");
                        txtMulta.setText("");
                        txtValorPago.setText("");
                    } else {
                        txtDtPago.setEnabled(false);
                        txtDtPago.setEnabled(false);
                        txtDesconto.setEnabled(false);
                        txtMulta.setEnabled(false);
                        txtValorPago.setEnabled(false);
                        //popula os
                        txtDesconto.setText("0");
                        txtMulta.setText("0");
                        txtValorPago.setText("0");
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmContasPg.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jCheckBoxContaPagaMouseClicked

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        // TODO add your handling code here:

        double desconto = Double.parseDouble(this.txtDesconto.getText());
        double multa = Double.parseDouble(this.txtMulta.getText());
        double valor = Double.parseDouble(this.txtValor.getText());
        double resultado = valor - desconto + multa;
        txtValorPago.setText(String.valueOf(resultado));
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void jTableContasPgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableContasPgKeyPressed
        int indice = jTableContasPg.getSelectedRow();
        txtCodPg.setText(jTableContasPg.getValueAt(indice, 0).toString());
        txtDesc.setText(jTableContasPg.getValueAt(indice, 1).toString());
        txtVencimento.setText(jTableContasPg.getValueAt(indice, 2).toString());
        txtValor.setText(jTableContasPg.getValueAt(indice, 3).toString());
//        txtDtPago.setText(jTableContasPg.getValueAt(indice, 5).toString());
//        txtDesconto.setText(jTableContasPg.getValueAt(indice, 6).toString());
//        txtMulta.setText(jTableContasPg.getValueAt(indice, 7).toString());
//        txtValorPago.setText(jTableContasPg.getValueAt(indice, 8).toString());
        cbFornecedor.setSelectedItem(jTableContasPg.getValueAt(indice, 9).toString());
        cbCategoria.setSelectedItem(jTableContasPg.getValueAt(indice, 10).toString());
        try {
            connContaspg.rs.first();
            connContaspg.executaSQL("select * from cad_contaspg where id_contaspg ='" + txtCodPg.getText() + "'");
            while (connContaspg.rs.next()) {
                String result = connContaspg.rs.getString("pago_contaspg");
                if (result.equals("S")) {
                    jCheckBoxContaPaga.doClick();
                    txtDtPago.setText(jTableContasPg.getValueAt(indice, 5).toString());
                    txtDesconto.setText(jTableContasPg.getValueAt(indice, 6).toString());
                    txtMulta.setText(jTableContasPg.getValueAt(indice, 7).toString());
                    txtValorPago.setText(jTableContasPg.getValueAt(indice, 8).toString());
                } else {
                    jCheckBoxContaPaga.setSelected(false);
                    txtDtPago.setText("");
                    txtDesconto.setText("");
                    txtMulta.setText("");
                    txtValorPago.setText("");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmContasPg.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTableContasPgKeyPressed

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
//            java.util.logging.Logger.getLogger(FrmContasPg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new FrmContasPg().setVisible(true);
//            }
//        });
//    }

    public void preencherTabelaContaspg(String SQL) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Código", "Descrição", "Vencimento", "Valor", "Pago", "Data pgto", "Desconto", "Multa", "Valor pago", "Fornecedor", "Categoria"};
        connContaspg.executaSQL(SQL);
        try {
            connContaspg.rs.first();
            FormatoData dataFormatada = new FormatoData();
            do {
                dados.add(new Object[]{connContaspg.rs.getInt("id_contaspg"), connContaspg.rs.getString("desc_contaspg"), dataFormatada.getDataBR(connContaspg.rs.getDate("venc_contaspg")), connContaspg.rs.getString("valor_contaspg"), connContaspg.rs.getString("pago_contaspg"), dataFormatada.getDataBR(connContaspg.rs.getDate("dtpago_contaspg")), connContaspg.rs.getString("descont_contaspg"), connContaspg.rs.getString("multa_contaspg"), connContaspg.rs.getString("vlpago_contaspg"), connContaspg.rs.getString("nome_fornec"), connContaspg.rs.getString("desc_categoriapg")});

            } while (connContaspg.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher o ArrayList de contas\n ERRO:" + ex);
        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTableContasPg.setModel(modelo);
        jTableContasPg.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTableContasPg.getColumnModel().getColumn(0).setResizable(false);
        jTableContasPg.getColumnModel().getColumn(1).setPreferredWidth(130);
        jTableContasPg.getColumnModel().getColumn(1).setResizable(true);
        jTableContasPg.getColumnModel().getColumn(2).setPreferredWidth(75);
        jTableContasPg.getColumnModel().getColumn(2).setResizable(false);
        jTableContasPg.getColumnModel().getColumn(3).setPreferredWidth(50);
        jTableContasPg.getColumnModel().getColumn(3).setResizable(false);
        jTableContasPg.getColumnModel().getColumn(4).setPreferredWidth(40);
        jTableContasPg.getColumnModel().getColumn(4).setResizable(false);
        jTableContasPg.getColumnModel().getColumn(5).setPreferredWidth(75); //dtPago
        jTableContasPg.getColumnModel().getColumn(5).setResizable(false);
        jTableContasPg.getColumnModel().getColumn(6).setPreferredWidth(75); //desconto
        jTableContasPg.getColumnModel().getColumn(6).setResizable(false);
        jTableContasPg.getColumnModel().getColumn(7).setPreferredWidth(50); //multa
        jTableContasPg.getColumnModel().getColumn(7).setResizable(false);
        jTableContasPg.getColumnModel().getColumn(8).setPreferredWidth(70); //dtPago
        jTableContasPg.getColumnModel().getColumn(8).setResizable(false);
        jTableContasPg.getColumnModel().getColumn(9).setPreferredWidth(150);
        jTableContasPg.getColumnModel().getColumn(9).setResizable(false);
        jTableContasPg.getColumnModel().getColumn(10).setPreferredWidth(150);
        jTableContasPg.getColumnModel().getColumn(10).setResizable(false);
        jTableContasPg.getTableHeader().setReorderingAllowed(false);
        jTableContasPg.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTableContasPg.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    public String dataVenc(String data) {
        String dia = txtVencimento.getText().substring(0, 2);
        String mes = txtVencimento.getText().substring(3, 5);
        String ano = txtVencimento.getText().substring(6);
        String dataMysql = ano + "-" + mes + "-" + dia;
        return dataMysql;
    }

    public String dataPago(String data) {
        String dia = txtDtPago.getText().substring(0, 2);
        String mes = txtDtPago.getText().substring(3, 5);
        String ano = txtDtPago.getText().substring(6);
        String dataMysql = ano + "-" + mes + "-" + dia;
        return dataMysql;
    }

    public void mascara() {
        try {
            MaskFormatter mf;
            mf = new MaskFormatter("##/##/####");
            txtVencimento.setFormatterFactory(new DefaultFormatterFactory(mf));
            txtDtPago.setFormatterFactory(new DefaultFormatterFactory(mf));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao converter a data");
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cbCategoria;
    private javax.swing.JComboBox cbFornecedor;
    private javax.swing.JCheckBox jCheckBoxContaPaga;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableContasPg;
    private javax.swing.JTextField txtCodPg;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JTextField txtDesconto;
    private javax.swing.JFormattedTextField txtDtPago;
    private javax.swing.JTextField txtMulta;
    private javax.swing.JTextField txtValor;
    private javax.swing.JTextField txtValorPago;
    private javax.swing.JFormattedTextField txtVencimento;
    // End of variables declaration//GEN-END:variables
private String pagou;

    public void botao() {
        btnNovo.setEnabled(true);
        btnAlterar.setEnabled(true);
        btnAtualizar.setEnabled(false);
        btnExcluir.setEnabled(true);
        btnCancelar.setEnabled(false);
        btnSalvar.setEnabled(false);
    }

    public void libera_campos() {
        txtDesc.setEnabled(true);
        txtValor.setEnabled(true);
        txtVencimento.setEnabled(true);
        //jCheckBoxContaPaga.
        cbCategoria.setEnabled(true);
        cbFornecedor.setEnabled(true);
    }

    public void limpa_campos() {
        txtCodPg.setText("");
        txtDesc.setText("");
        //txtDesconto.setText("");
        //txtMulta.setText("");
        //txtDtPago.setText("");
        txtValor.setText("");
        cbCategoria.setEnabled(true);
        cbFornecedor.setEnabled(true);
        //txtValorPago.setText("");
    }

    public void bloqueia_campos() {
        txtCodPg.setEnabled(false);
        txtDesc.setEnabled(false);
        txtDesconto.setEnabled(false);
        txtMulta.setEnabled(false);
        txtDtPago.setEnabled(false);
        txtValor.setEnabled(false);
        txtValorPago.setEnabled(false);
        txtVencimento.setEnabled(false);
        //jCheckBoxContaPaga.setC;
        cbCategoria.setEnabled(false);
        cbFornecedor.setEnabled(false);
    }
}
