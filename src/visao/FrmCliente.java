
package visao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import controle.Conexao;
import controle.ControleCliente;
import javax.swing.ImageIcon;
import modelo.ModeloCliente;
import modelo.ModeloTabela;

public final class FrmCliente extends javax.swing.JFrame {

    Conexao conecta = new Conexao();
    ModeloCliente mod = new ModeloCliente();
    ControleCliente control = new ControleCliente();

    //Conexao connEstado = new Conexao();

    public FrmCliente() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/imagens/icone.png")).getImage());
        bloqueia_campos();
        botao();
        preencherTabela("select * from cliente order by codcliente");
        //Mostra as Siglas no jcomboBox
        conecta.executaSQL("SELECT * FROM estado");
        cbUf.removeAllItems();
        try {
            conecta.rs.first();
            do {
                cbUf.addItem(conecta.rs.getString("sigla"));

            } while (conecta.rs.next());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher o combo box com estados\n ERRO: " + ex);
        }
        //
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBotoes = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        lblCodigo = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        btnAtualizar = new javax.swing.JToggleButton();
        jPanelDados = new javax.swing.JPanel();
        txtNome = new javax.swing.JTextField();
        txtNasc = new javax.swing.JFormattedTextField();
        txtCpf = new javax.swing.JTextField();
        cbCivil = new javax.swing.JComboBox();
        lblNome = new javax.swing.JLabel();
        lblCpf = new javax.swing.JLabel();
        lblCivil = new javax.swing.JLabel();
        lblDatNasc = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        lblRg = new javax.swing.JLabel();
        cbSexo = new javax.swing.JComboBox();
        txtRg = new javax.swing.JFormattedTextField();
        jPanelRenda = new javax.swing.JPanel();
        lblEmpresa = new javax.swing.JLabel();
        cbCompr = new javax.swing.JComboBox();
        lblSalario = new javax.swing.JLabel();
        txtSalario = new javax.swing.JTextField();
        lblComprovado = new javax.swing.JLabel();
        txtEmp = new javax.swing.JTextField();
        lblTelEmp = new javax.swing.JLabel();
        txtTelEmp = new javax.swing.JFormattedTextField();
        lblEndereco = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jPanelEndereco = new javax.swing.JPanel();
        txtBairro = new javax.swing.JTextField();
        cbUf = new javax.swing.JComboBox();
        lblCidade = new javax.swing.JLabel();
        lblBairro = new javax.swing.JLabel();
        lblUf = new javax.swing.JLabel();
        lblComplemento = new javax.swing.JLabel();
        lblLogradouro = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        txtLogra = new javax.swing.JTextField();
        txtCompl = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanelContato = new javax.swing.JPanel();
        txtTelCon = new javax.swing.JFormattedTextField();
        lblEmail = new javax.swing.JLabel();
        lblTelCon = new javax.swing.JLabel();
        txtTelCel = new javax.swing.JFormattedTextField();
        lblRes = new javax.swing.JLabel();
        lblTelCel = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtTelRes = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCliente = new javax.swing.JTable();
        btnExcluir = new javax.swing.JButton();
        btnCancela = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de clientes");
        setName("jFrameClientes"); // NOI18N
        setResizable(false);

        jPanelBotoes.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBotoes.setPreferredSize(new java.awt.Dimension(111, 41));

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/new.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.setPreferredSize(new java.awt.Dimension(111, 41));
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/done.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setMaximumSize(new java.awt.Dimension(111, 41));
        btnSalvar.setMinimumSize(new java.awt.Dimension(111, 41));
        btnSalvar.setPreferredSize(new java.awt.Dimension(111, 41));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        lblCodigo.setText("Cliente:");

        txtID.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        btnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/update.png"))); // NOI18N
        btnAtualizar.setText("Atualizar");
        btnAtualizar.setMaximumSize(new java.awt.Dimension(111, 40));
        btnAtualizar.setMinimumSize(new java.awt.Dimension(111, 40));
        btnAtualizar.setPreferredSize(new java.awt.Dimension(111, 40));
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        jPanelDados.setBackground(new java.awt.Color(255, 255, 255));
        jPanelDados.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do cliente"));
        jPanelDados.setForeground(new java.awt.Color(0, 102, 102));
        jPanelDados.setPreferredSize(new java.awt.Dimension(380, 160));
        jPanelDados.setRequestFocusEnabled(false);

        txtNome.setDisabledTextColor(new java.awt.Color(51, 51, 51));

        try {
            txtNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtNasc.setDisabledTextColor(new java.awt.Color(51, 51, 51));

        txtCpf.setDisabledTextColor(new java.awt.Color(51, 51, 51));

        cbCivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Casado", "Solteiro" }));

        lblNome.setText("Nome:");

        lblCpf.setText("Cpf/cnpj:");

        lblCivil.setText("Estado civil:      ");

        lblDatNasc.setText("Data Nasc:");

        lblSexo.setText("Sexo: ");

        lblRg.setText("Rg:");

        cbSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Feminino" }));

        try {
            txtRg.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#############")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanelDadosLayout = new javax.swing.GroupLayout(jPanelDados);
        jPanelDados.setLayout(jPanelDadosLayout);
        jPanelDadosLayout.setHorizontalGroup(
            jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCpf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDatNasc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCivil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNome)
                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDadosLayout.createSequentialGroup()
                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                                        .addComponent(lblSexo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                                        .addComponent(lblRg)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(cbCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelDadosLayout.setVerticalGroup(
            jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosLayout.createSequentialGroup()
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCpf)
                    .addComponent(lblRg)
                    .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSexo)
                    .addComponent(txtNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDatNasc)
                    .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCivil))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jPanelRenda.setBackground(new java.awt.Color(255, 255, 255));
        jPanelRenda.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Renda")));
        jPanelRenda.setPreferredSize(new java.awt.Dimension(382, 160));

        lblEmpresa.setText("Empresa: ");

        cbCompr.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "S", "N" }));

        lblSalario.setText("Salario:    ");

        txtSalario.setDisabledTextColor(new java.awt.Color(51, 51, 51));

        lblComprovado.setText("Comprovado:");

        txtEmp.setDisabledTextColor(new java.awt.Color(51, 51, 51));

        lblTelEmp.setText("Tel empresa:");

        try {
            txtTelEmp.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelEmp.setDisabledTextColor(new java.awt.Color(51, 51, 51));

        lblEndereco.setText("Endereço:");

        txtEndereco.setDisabledTextColor(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanelRendaLayout = new javax.swing.GroupLayout(jPanelRenda);
        jPanelRenda.setLayout(jPanelRendaLayout);
        jPanelRendaLayout.setHorizontalGroup(
            jPanelRendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRendaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSalario, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmpresa, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTelEmp, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRendaLayout.createSequentialGroup()
                        .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblComprovado, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addComponent(cbCompr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtEmp)
                    .addGroup(jPanelRendaLayout.createSequentialGroup()
                        .addComponent(txtTelEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtEndereco))
                .addContainerGap())
        );
        jPanelRendaLayout.setVerticalGroup(
            jPanelRendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRendaLayout.createSequentialGroup()
                .addGroup(jPanelRendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblComprovado)
                    .addComponent(cbCompr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSalario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmpresa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelEmp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEndereco)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jPanelEndereco.setBackground(new java.awt.Color(255, 255, 255));
        jPanelEndereco.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Endereço", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanelEndereco.setToolTipText("Buscar cidade");
        jPanelEndereco.setPreferredSize(new java.awt.Dimension(382, 123));

        txtBairro.setDisabledTextColor(new java.awt.Color(51, 51, 51));

        cbUf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));

        lblCidade.setText("Cidade:");

        lblBairro.setText("Bairro:");

        lblUf.setText("UF:");

        lblComplemento.setText("Complemento:");

        lblLogradouro.setText("Logradouro:");

        txtCidade.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCidadeActionPerformed(evt);
            }
        });

        txtLogra.setDisabledTextColor(new java.awt.Color(51, 51, 51));

        txtCompl.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtCompl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtComplActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/search.png"))); // NOI18N
        jLabel1.setToolTipText("Buscar cidade");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelEnderecoLayout = new javax.swing.GroupLayout(jPanelEndereco);
        jPanelEndereco.setLayout(jPanelEnderecoLayout);
        jPanelEnderecoLayout.setHorizontalGroup(
            jPanelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEnderecoLayout.createSequentialGroup()
                        .addComponent(lblCidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(300, 300, 300))
                    .addGroup(jPanelEnderecoLayout.createSequentialGroup()
                        .addGroup(jPanelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblComplemento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblLogradouro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lblBairro))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelEnderecoLayout.createSequentialGroup()
                                .addComponent(txtBairro)
                                .addGap(156, 156, 156))
                            .addGroup(jPanelEnderecoLayout.createSequentialGroup()
                                .addGroup(jPanelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelEnderecoLayout.createSequentialGroup()
                                        .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel1))
                                    .addGroup(jPanelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanelEnderecoLayout.createSequentialGroup()
                                            .addComponent(txtCompl, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(lblUf)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cbUf, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(txtLogra, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanelEnderecoLayout.setVerticalGroup(
            jPanelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEnderecoLayout.createSequentialGroup()
                .addGroup(jPanelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelEnderecoLayout.createSequentialGroup()
                        .addGroup(jPanelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblLogradouro)
                            .addComponent(txtLogra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblComplemento)
                            .addComponent(txtCompl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUf)
                            .addComponent(cbUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCidade)
                            .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBairro)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelContato.setBackground(new java.awt.Color(255, 255, 255));
        jPanelContato.setBorder(javax.swing.BorderFactory.createTitledBorder("Contato"));
        jPanelContato.setPreferredSize(new java.awt.Dimension(382, 123));

        try {
            txtTelCon.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelCon.setDisabledTextColor(new java.awt.Color(51, 51, 51));

        lblEmail.setText("Email:     ");

        lblTelCon.setText("Tel contato: ");

        try {
            txtTelCel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelCel.setDisabledTextColor(new java.awt.Color(51, 51, 51));

        lblRes.setText("Res:   ");

        lblTelCel.setText("Tel celular: ");

        txtEmail.setDisabledTextColor(new java.awt.Color(51, 51, 51));

        try {
            txtTelRes.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelRes.setDisabledTextColor(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanelContatoLayout = new javax.swing.GroupLayout(jPanelContato);
        jPanelContato.setLayout(jPanelContatoLayout);
        jPanelContatoLayout.setHorizontalGroup(
            jPanelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContatoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTelCel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTelCon, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelContatoLayout.createSequentialGroup()
                        .addGroup(jPanelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTelCel, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                            .addComponent(txtTelCon))
                        .addGap(18, 18, 18)
                        .addComponent(lblRes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(txtTelRes, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtEmail))
                .addContainerGap())
        );
        jPanelContatoLayout.setVerticalGroup(
            jPanelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContatoLayout.createSequentialGroup()
                .addGroup(jPanelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelCel)
                    .addComponent(lblRes)
                    .addComponent(txtTelCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelRes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelCon)
                    .addComponent(txtTelCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableClienteMouseClicked(evt);
            }
        });
        jTableCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableClienteKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCliente);

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/delete.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setMaximumSize(new java.awt.Dimension(111, 41));
        btnExcluir.setMinimumSize(new java.awt.Dimension(111, 41));
        btnExcluir.setPreferredSize(new java.awt.Dimension(111, 41));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnCancela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancel.png"))); // NOI18N
        btnCancela.setText("Cancelar");
        btnCancela.setPreferredSize(new java.awt.Dimension(111, 40));
        btnCancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelaActionPerformed(evt);
            }
        });

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/edit.png"))); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.setPreferredSize(new java.awt.Dimension(111, 41));
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBotoesLayout = new javax.swing.GroupLayout(jPanelBotoes);
        jPanelBotoes.setLayout(jPanelBotoesLayout);
        jPanelBotoesLayout.setHorizontalGroup(
            jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanelBotoesLayout.createSequentialGroup()
                        .addGroup(jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanelDados, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                            .addGroup(jPanelBotoesLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jPanelEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addGroup(jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelRenda, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelContato, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelBotoesLayout.createSequentialGroup()
                        .addGroup(jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCodigo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancela, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelBotoesLayout.setVerticalGroup(
            jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCancela, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelBotoesLayout.createSequentialGroup()
                        .addComponent(lblCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelRenda, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelDados, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addComponent(jPanelContato, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBotoes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelaActionPerformed
        // TODO add your handling code here
        limpa_campos();
        bloqueia_campos();
        botao();
        jTableCliente.setEnabled(true);
        jTableCliente.setVisible(true);
    }//GEN-LAST:event_btnCancelaActionPerformed

    private void jTableClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableClienteKeyReleased
        int indice = jTableCliente.getSelectedRow();
        txtID.setText(jTableCliente.getValueAt(indice, 0).toString());
        txtNome.setText(jTableCliente.getValueAt(indice, 1).toString());
        txtCpf.setText(jTableCliente.getValueAt(indice, 2).toString());
        txtRg.setText(jTableCliente.getValueAt(indice, 3).toString());
        txtNasc.setText(jTableCliente.getValueAt(indice, 4).toString());
        cbSexo.setSelectedItem(jTableCliente.getValueAt(indice, 5).toString());
        cbCivil.setSelectedItem(jTableCliente.getValueAt(indice, 6).toString());
        txtLogra.setText(jTableCliente.getValueAt(indice, 7).toString());
        txtCompl.setText(jTableCliente.getValueAt(indice, 8).toString());
        txtBairro.setText(jTableCliente.getValueAt(indice, 9).toString());
        txtTelCel.setText(jTableCliente.getValueAt(indice, 10).toString());
        txtTelRes.setText(jTableCliente.getValueAt(indice, 11).toString());
        txtTelCon.setText(jTableCliente.getValueAt(indice, 12).toString());
        txtEmail.setText(jTableCliente.getValueAt(indice, 13).toString());
        txtSalario.setText(jTableCliente.getValueAt(indice, 14).toString());
        txtEmp.setText(jTableCliente.getValueAt(indice, 15).toString());
        txtEndereco.setText(jTableCliente.getValueAt(indice, 16).toString());
        txtTelEmp.setText(jTableCliente.getValueAt(indice, 17).toString());
        cbCompr.setSelectedItem(jTableCliente.getValueAt(indice, 18).toString());
        cbUf.setSelectedItem(jTableCliente.getValueAt(indice, 19).toString());

    }//GEN-LAST:event_jTableClienteKeyReleased

    private void jTableClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableClienteMouseClicked
        // TODO add your handling code here:
        int indice = jTableCliente.getSelectedRow();
        txtID.setText(jTableCliente.getValueAt(indice, 0).toString());
        txtNome.setText(jTableCliente.getValueAt(indice, 1).toString());
        txtCpf.setText(jTableCliente.getValueAt(indice, 2).toString());
        txtRg.setText(jTableCliente.getValueAt(indice, 3).toString());
        txtNasc.setText(jTableCliente.getValueAt(indice, 4).toString());
        cbSexo.setSelectedItem(jTableCliente.getValueAt(indice, 5).toString());
        cbCivil.setSelectedItem(jTableCliente.getValueAt(indice, 6).toString());
        txtLogra.setText(jTableCliente.getValueAt(indice, 7).toString());
        txtCompl.setText(jTableCliente.getValueAt(indice, 8).toString());
        txtBairro.setText(jTableCliente.getValueAt(indice, 9).toString());
        txtTelCel.setText(jTableCliente.getValueAt(indice, 10).toString());
        txtTelRes.setText(jTableCliente.getValueAt(indice, 11).toString());
        txtTelCon.setText(jTableCliente.getValueAt(indice, 12).toString());
        txtEmail.setText(jTableCliente.getValueAt(indice, 13).toString());
        txtSalario.setText(jTableCliente.getValueAt(indice, 14).toString());
        txtEmp.setText(jTableCliente.getValueAt(indice, 15).toString());
        txtEndereco.setText(jTableCliente.getValueAt(indice, 16).toString());
        txtTelEmp.setText(jTableCliente.getValueAt(indice, 17).toString());
        cbCompr.setSelectedItem(jTableCliente.getValueAt(indice, 18).toString());
        cbUf.setSelectedItem(jTableCliente.getValueAt(indice, 19).toString());
        //Lieberar botão Alterar ao selecionar uma linha no jTable

    }//GEN-LAST:event_jTableClienteMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Buscar");
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txtComplActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtComplActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtComplActionPerformed

    private void txtCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCidadeActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        // TODO add your handling code here:
        if (txtNome.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo Vazio!");
        } else {
            
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        //Ação do botão salvar
        if (txtNome.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo Vazio!");
        } else {
//            conecta.conectar();
            jTableCliente.setVisible(true);
            mod.setNome(txtNome.getText());
            mod.setCpf((String)txtCpf.getText());
            mod.setRg(txtRg.getText());
            mod.setNasc(txtNasc.getText());
            mod.setSexo(((String) cbSexo.getSelectedItem()));
            mod.setCivil((String) cbCivil.getSelectedItem());
            mod.setLogra(txtLogra.getText());
            mod.setCompl(txtCompl.getText());
            mod.setBairro(txtBairro.getText());
            mod.setSalario(txtSalario.getText());
            mod.setCompr((String) cbCompr.getSelectedItem());
            mod.setEmp(txtEmp.getText());
            mod.setTelEmp(txtTelEmp.getText());
            mod.setEndereco(txtEndereco.getText());
            mod.setTelCel(txtTelCel.getText());
            mod.setTelRes(txtTelRes.getText());
            mod.setTelCon(txtTelCon.getText());
            mod.setEmail(txtEmail.getText());
            control.Salvar(mod);
            preencherTabela("select * from cliente order by codcliente");
            bloqueia_campos();
            limpa_campos();
            botao();
            
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

//GEN-FIRST:event_btnNovoActionPerformed
    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {

        btnNovo.setEnabled(false);
        btnSalvar.setEnabled(true);
        btnCancela.setEnabled(true);
        btnAlterar.setEnabled(false);
        jTableCliente.setVisible(false);
        txtNome.requestFocus();
        libera_campos();
        limpa_campos();// TODO add your handling code here:
    }
//GEN-LAST:event_btnNovoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // TODO add your handling code here:
        btnNovo.setEnabled(false);
        btnSalvar.setEnabled(false);
        btnCancela.setEnabled(true);
        btnAtualizar.setEnabled(true);
        btnAlterar.setEnabled(false);
        libera_campos();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExcluirActionPerformed
    public void botao() {
        btnNovo.setEnabled(true);
        btnAlterar.setEnabled(true);
        btnAtualizar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnCancela.setEnabled(false);
        btnSalvar.setEnabled(false);
    }

    public void libera_campos() {
        txtNome.setEnabled(true);
        txtCpf.setEnabled(true);
        txtRg.setEnabled(true);
        txtNasc.setEnabled(true);
        cbUf.setEnabled(true);
        cbSexo.setEnabled(true);
        cbCivil.setEnabled(true);
        txtCidade.setEnabled(true);
        txtLogra.setEnabled(true);
        txtCompl.setEnabled(true);
        txtBairro.setEnabled(true);
        txtTelCel.setEnabled(true);
        txtTelRes.setEnabled(true);
        txtTelCon.setEnabled(true);
        txtEmail.setEnabled(true);
        txtSalario.setEnabled(true);
        txtEmp.setEnabled(true);
        txtEndereco.setEnabled(true);
        cbCompr.setEnabled(true);
        txtTelEmp.setEnabled(true);
    }

    public void limpa_campos() {
        txtNome.setText("");
        txtCpf.setText("");
        txtRg.setText("");
        txtNasc.setText("");
        txtCidade.setText("");
        txtLogra.setText("");
        txtCompl.setText("");
        txtBairro.setText("");
        txtTelCel.setText("");
        txtTelRes.setText("");
        txtTelCon.setText("");
        txtEmail.setText("");
        txtSalario.setText("");
        txtEmp.setText("");
        txtEndereco.setText("");
        txtTelEmp.setText("");
    }

    public void bloqueia_campos() {
        txtID.setEnabled(false);
        txtNome.setEnabled(false);
        txtCpf.setEnabled(false);
        txtRg.setEnabled(false);
        txtNasc.setEnabled(false);
        cbSexo.setEnabled(false);
        cbCivil.setEnabled(false);
        cbUf.setEnabled(false);
        txtCidade.setEnabled(false);
        txtLogra.setEnabled(false);
        txtCompl.setEnabled(false);
        txtBairro.setEnabled(false);
        txtTelCel.setEnabled(false);
        txtTelRes.setEnabled(false);
        txtTelCon.setEnabled(false);
        txtEmail.setEnabled(false);
        txtSalario.setEnabled(false);
        txtEmp.setEnabled(false);
        txtEndereco.setEnabled(false);
        cbCompr.setEnabled(false);
        txtTelEmp.setEnabled(false);
    }

//Evento clique do mouse para mudar os jTextField qnd selecionados na Jtable      //Evento clique do teclado para mudar os jTextField qnd selecionados na Jtable    //Preencher o arraylist para mostrar os dados do banco no jTabble
    public void preencherTabela(String SQL) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"id", "nome", "cpf", "rg", "datnasc", "sexo", "estcivil", "logradouro", "compl", "bairro", "telcel", "telres", "telcon", "email", "salario", "empresa", "endemp", "telemp", "compr"/*, "id estado"*/};
        conecta.executaSQL(SQL);
        try {
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("codcliente"), conecta.rs.getString("cliente"), conecta.rs.getString("cpf"), conecta.rs.getString("rg"), conecta.rs.getString("datnasc"), conecta.rs.getString("sexo"), conecta.rs.getString("estcivil"), conecta.rs.getString("logradouro"), conecta.rs.getString("complemento"), conecta.rs.getString("bairro"), conecta.rs.getString("telcel"), conecta.rs.getString("telres"), conecta.rs.getString("telcon"), conecta.rs.getString("email"), conecta.rs.getString("salario"), conecta.rs.getString("empresa"), conecta.rs.getString("endemp"), conecta.rs.getString("telempresa"), conecta.rs.getString("complemp")/*, conecta.rs.getString("id_estado")*/});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher o ArrayList\n ERRO:" + ex);
        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTableCliente.setModel(modelo);
        jTableCliente.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTableCliente.getColumnModel().getColumn(0).setResizable(false);
        jTableCliente.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTableCliente.getColumnModel().getColumn(1).setResizable(false);
        jTableCliente.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTableCliente.getColumnModel().getColumn(2).setResizable(false);
        jTableCliente.getTableHeader().setReorderingAllowed(false);
        jTableCliente.setAutoResizeMode(jTableCliente.AUTO_RESIZE_OFF);
        jTableCliente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

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
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JToggleButton btnAtualizar;
    private javax.swing.JButton btnCancela;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cbCivil;
    private javax.swing.JComboBox cbCompr;
    private javax.swing.JComboBox cbSexo;
    private javax.swing.JComboBox cbUf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelBotoes;
    private javax.swing.JPanel jPanelContato;
    private javax.swing.JPanel jPanelDados;
    private javax.swing.JPanel jPanelEndereco;
    private javax.swing.JPanel jPanelRenda;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCliente;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblCivil;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblComplemento;
    private javax.swing.JLabel lblComprovado;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblDatNasc;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmpresa;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblLogradouro;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblRes;
    private javax.swing.JLabel lblRg;
    private javax.swing.JLabel lblSalario;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTelCel;
    private javax.swing.JLabel lblTelCon;
    private javax.swing.JLabel lblTelEmp;
    private javax.swing.JLabel lblUf;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtCompl;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmp;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtLogra;
    private javax.swing.JFormattedTextField txtNasc;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtRg;
    private javax.swing.JTextField txtSalario;
    private javax.swing.JFormattedTextField txtTelCel;
    private javax.swing.JFormattedTextField txtTelCon;
    private javax.swing.JFormattedTextField txtTelEmp;
    private javax.swing.JFormattedTextField txtTelRes;
    // End of variables declaration//GEN-END:variables

}
