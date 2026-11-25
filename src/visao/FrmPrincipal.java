package visao;

import controle.Conexao;
import java.awt.Component;
//import java.awt.Image;
//import java.awt.Toolkit;
//import java.net.URL;
import javax.swing.JOptionPane;
import controle.data;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Base64;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Uedney Morais
 */
public class FrmPrincipal extends javax.swing.JFrame {

    private Component frame;
    /**
     * Cria a Janela Principal
     */
    //metodo mostra data para Timer
    data mostra_data;
    Conexao conn = new Conexao();

    public FrmPrincipal(String id, String user, String versao) {
        initComponents();
        String idp = id;
        this.setIconImage(new ImageIcon(getClass().getResource("/imagens/icone.png")).getImage());
        //connPrincipal.conectar();
        setExtendedState(MAXIMIZED_BOTH);

        mostra_data = new data();
        mostra_data.le_data();
        jLblMostraData.setText(mostra_data.dia_semana + " - " + mostra_data.dia + "/" + mostra_data.mes + "/" + mostra_data.ano);
        //inicia o timer
        timer1.start();
        jLabelCod.setText(idp);
        jLabelNome.setText(" "+user);

        permissao(idp);
        mostraDataExpira();

    }

    private FrmPrincipal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        timer1 = new org.netbeans.examples.lib.timerbean.Timer();
        jPanelPrincipal = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();
        jLblData = new javax.swing.JLabel();
        jLblMostraData = new javax.swing.JLabel();
        jLblHora = new javax.swing.JLabel();
        jLblMostraHora = new javax.swing.JLabel();
        jLabelLicenca = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JLabelVersao = new javax.swing.JLabel();
        jLabelCod = new javax.swing.JLabel();
        jdarea = new javax.swing.JDesktopPane();
        jMenuBarPrincipal = new javax.swing.JMenuBar();
        JMenuCadastro = new javax.swing.JMenu();
        jMenuItemclientes = new javax.swing.JMenuItem();
        jMenuItemfornecedores = new javax.swing.JMenuItem();
        jMenuItemprodutos = new javax.swing.JMenuItem();
        jMenuItemusuarios = new javax.swing.JMenuItem();
        jMenuItemCidade = new javax.swing.JMenuItem();
        jMenuItemEstados = new javax.swing.JMenuItem();
        jMenuSistema = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuFinanceiro = new javax.swing.JMenu();
        jMenuItemContasPg = new javax.swing.JMenuItem();
        jMenuItemContasReceber = new javax.swing.JMenuItem();
        jMenuManutenção = new javax.swing.JMenu();
        jMenuItemBackup = new javax.swing.JMenuItem();
        jMenuItemAtualizar = new javax.swing.JMenuItem();
        jMenuAtualizacao = new javax.swing.JMenuItem();
        JMenuVendas = new javax.swing.JMenu();
        jMenuItemPedido = new javax.swing.JMenuItem();
        jMenuItemPedidos = new javax.swing.JMenuItem();
        jMenuItemCaixa = new javax.swing.JMenuItem();
        jMenuRelatorios = new javax.swing.JMenu();
        jMenuVendas = new javax.swing.JMenu();
        jMenuItemData = new javax.swing.JMenuItem();
        jMenuItemCliente = new javax.swing.JMenuItem();
        Cadastro = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        timer1.addTimerListener(new org.netbeans.examples.lib.timerbean.TimerListener() {
            public void onTime(java.awt.event.ActionEvent evt) {
                timer1OnTime(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SGEmp");

        jPanelPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Usuário.:");

        jLabelNome.setText("Nome");

        jLblData.setText("Data.:");

        jLblMostraData.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLblMostraData.setText("labeldata");

        jLblHora.setText("Hora.:");

        jLblMostraHora.setText("labelhora");

        jLabelLicenca.setText("jLabel2");

        jLabel2.setText("Versão.:");

        JLabelVersao.setText("vs");

        jLabelCod.setText("Cod");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCod)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelNome)
                .addGap(79, 79, 79)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLabelVersao)
                .addGap(37, 37, 37)
                .addComponent(jLabelLicenca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
                .addComponent(jLblData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLblMostraData, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLblHora)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLblMostraHora, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblData)
                    .addComponent(jLabelNome)
                    .addComponent(jLabel1)
                    .addComponent(jLblMostraData, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLblHora)
                    .addComponent(jLblMostraHora, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelLicenca)
                    .addComponent(jLabel2)
                    .addComponent(JLabelVersao)
                    .addComponent(jLabelCod)))
        );

        jdarea.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jdareaLayout = new javax.swing.GroupLayout(jdarea);
        jdarea.setLayout(jdareaLayout);
        jdareaLayout.setHorizontalGroup(
            jdareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jdareaLayout.setVerticalGroup(
            jdareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 492, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jdarea)
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
                .addComponent(jdarea)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        JMenuCadastro.setMnemonic('C');
        JMenuCadastro.setText("Cadastro");
        JMenuCadastro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JMenuCadastroMouseEntered(evt);
            }
        });

        jMenuItemclientes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemclientes.setText("Clientes");
        jMenuItemclientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemclientesActionPerformed(evt);
            }
        });
        JMenuCadastro.add(jMenuItemclientes);

        jMenuItemfornecedores.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemfornecedores.setText("Fornecedores");
        jMenuItemfornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemfornecedoresActionPerformed(evt);
            }
        });
        JMenuCadastro.add(jMenuItemfornecedores);

        jMenuItemprodutos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemprodutos.setText("Produtos");
        jMenuItemprodutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemprodutosActionPerformed(evt);
            }
        });
        JMenuCadastro.add(jMenuItemprodutos);

        jMenuItemusuarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemusuarios.setText("Usuarios");
        jMenuItemusuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemusuariosActionPerformed(evt);
            }
        });
        JMenuCadastro.add(jMenuItemusuarios);

        jMenuItemCidade.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemCidade.setText("Cidades");
        jMenuItemCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCidadeActionPerformed(evt);
            }
        });
        JMenuCadastro.add(jMenuItemCidade);

        jMenuItemEstados.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemEstados.setText("Estados");
        jMenuItemEstados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEstadosActionPerformed(evt);
            }
        });
        JMenuCadastro.add(jMenuItemEstados);

        jMenuSistema.setText("Sistema");

        jMenuItem12.setText("Validar Sistema");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenuSistema.add(jMenuItem12);

        JMenuCadastro.add(jMenuSistema);

        jMenuBarPrincipal.add(JMenuCadastro);

        jMenuFinanceiro.setMnemonic('F');
        jMenuFinanceiro.setText("Financeiro");

        jMenuItemContasPg.setText("Contas a pagar");
        jMenuItemContasPg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemContasPgActionPerformed(evt);
            }
        });
        jMenuFinanceiro.add(jMenuItemContasPg);

        jMenuItemContasReceber.setText("Contas a receber");
        jMenuFinanceiro.add(jMenuItemContasReceber);

        jMenuBarPrincipal.add(jMenuFinanceiro);

        jMenuManutenção.setText("Manutenção");

        jMenuItemBackup.setText("Backup");
        jMenuItemBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemBackupActionPerformed(evt);
            }
        });
        jMenuManutenção.add(jMenuItemBackup);

        jMenuItemAtualizar.setText("Atualizar Banco de dados");
        jMenuManutenção.add(jMenuItemAtualizar);

        jMenuAtualizacao.setText("Atualização");
        jMenuAtualizacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAtualizacaoActionPerformed(evt);
            }
        });
        jMenuManutenção.add(jMenuAtualizacao);

        jMenuBarPrincipal.add(jMenuManutenção);

        JMenuVendas.setMnemonic('V');
        JMenuVendas.setText("Vendas");

        jMenuItemPedido.setText("Pedidos");
        jMenuItemPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPedidoActionPerformed(evt);
            }
        });
        JMenuVendas.add(jMenuItemPedido);

        jMenuItemPedidos.setText("Pedidos");
        jMenuItemPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPedidosActionPerformed(evt);
            }
        });
        JMenuVendas.add(jMenuItemPedidos);

        jMenuItemCaixa.setText("Caixa");
        jMenuItemCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCaixaActionPerformed(evt);
            }
        });
        JMenuVendas.add(jMenuItemCaixa);

        jMenuBarPrincipal.add(JMenuVendas);

        jMenuRelatorios.setText("Relatórios");

        jMenuVendas.setText("Vendas");

        jMenuItemData.setText("Por data");
        jMenuItemData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDataActionPerformed(evt);
            }
        });
        jMenuVendas.add(jMenuItemData);

        jMenuItemCliente.setText("Por cliente");
        jMenuVendas.add(jMenuItemCliente);

        jMenuRelatorios.add(jMenuVendas);

        Cadastro.setText("Cadastro");

        jMenu1.setText("Produtos");

        jMenuItem6.setText("Por nome");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenuItem6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMenuItem6KeyPressed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem7.setText("jMenuItem7");
        jMenu1.add(jMenuItem7);

        Cadastro.add(jMenu1);

        jMenuItem8.setText("Cidades");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        Cadastro.add(jMenuItem8);

        jMenuItem9.setText("Fornecedores");
        Cadastro.add(jMenuItem9);

        jMenuItem10.setText("Usuarios");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        Cadastro.add(jMenuItem10);

        jMenuRelatorios.add(Cadastro);

        jMenuBarPrincipal.add(jMenuRelatorios);

        setJMenuBar(jMenuBarPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
   //Metodo ao clicar no botão fechar do JFrame

    @Override
    public void dispose() {
        int n = JOptionPane.showConfirmDialog(
                frame,
                "Deseja realmente sair do sistema?",
                "",
                JOptionPane.YES_NO_OPTION);
        if (n == 0) {
            
            try {
                Runtime.getRuntime().exec("cmd /c start C:\\Sgemp\\sgemp.jar");
                        } catch (IOException ex) {
                Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.exit(0);
        } else {
        }
    }

    private void jMenuItemprodutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemprodutosActionPerformed
        //código de manipulação aqui:
        FrmProduto cad_Prod = new FrmProduto(jLabelCod.getText());
        cad_Prod.setVisible(true);
    }//GEN-LAST:event_jMenuItemprodutosActionPerformed

    private void jMenuItemclientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemclientesActionPerformed
        //código de manipulação aqui:
        FrmCliente cad_Cli = new FrmCliente();
        cad_Cli.setVisible(true);
    }//GEN-LAST:event_jMenuItemclientesActionPerformed

    private void jMenuItemfornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemfornecedoresActionPerformed
        FrmFornecedores cad_Fornec = new FrmFornecedores();
        cad_Fornec.setVisible(true);
    }//GEN-LAST:event_jMenuItemfornecedoresActionPerformed

    private void jMenuItemusuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemusuariosActionPerformed
        FrmUsuario cad_User = new FrmUsuario();
        cad_User.setVisible(true);
        //frmTeste cad_User = new frmTeste();
        //cad_User.setVisible(true);
        conn.desconectar();
    }//GEN-LAST:event_jMenuItemusuariosActionPerformed

    private void JMenuCadastroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JMenuCadastroMouseEntered
        // TODO add your handling code here:
        JMenuCadastro.setToolTipText("Cadastra");
    }//GEN-LAST:event_JMenuCadastroMouseEntered

    private void timer1OnTime(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timer1OnTime
        mostra_data.le_hora();
        jLblMostraHora.setText(mostra_data.hora);
    }//GEN-LAST:event_timer1OnTime

    private void jMenuItemBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemBackupActionPerformed
        FrmBackup bkp = new FrmBackup();
        bkp.setVisible(true);

    }//GEN-LAST:event_jMenuItemBackupActionPerformed

    private void jMenuItemCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCidadeActionPerformed
        // TODO add your handling code here:
        FrmCidade cad_cid = new FrmCidade();
        cad_cid.setVisible(true);

    }//GEN-LAST:event_jMenuItemCidadeActionPerformed

    private void jMenuItemEstadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEstadosActionPerformed
        // TODO add your handling code here:
        FrmEstado cad_estado = new FrmEstado();
        cad_estado.setVisible(true);
    }//GEN-LAST:event_jMenuItemEstadosActionPerformed

    private void jMenuItemContasPgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemContasPgActionPerformed
        // TODO add your handling code here:
        FrmContasPg cad_contaspg = new FrmContasPg();
        cad_contaspg.setVisible(true);
    }//GEN-LAST:event_jMenuItemContasPgActionPerformed

    private void jMenuItemPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPedidoActionPerformed
        // TODO add your handling code here:
        FrmVenda pedido = new FrmVenda(jLabelNome.getText());//,"","","");
        pedido.setVisible(true);
        

    }//GEN-LAST:event_jMenuItemPedidoActionPerformed

    private void jMenuItemCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCaixaActionPerformed
        // TODO add your handling code here:
//        controle.Abre.cadastro_venda();
//        FrmVenda2 cad_venda = new FrmVenda2(jLabelNome.getText());
//        cad_venda.setVisible(true);
    }//GEN-LAST:event_jMenuItemCaixaActionPerformed

    private void jMenuItemDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemDataActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
        FrmValidarSistema validaSis = new FrmValidarSistema();
        validaSis.setVisible(true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenuItem6KeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenuItem6KeyPressed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed

    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        try {
            conn.executaSQL("SELECT cidade.cidade,cidade.cep,cidade.codestado,cidade.bloqueado,estado.codestado,estado.estado,estado.sigla FROM CIDADE\n" +
"INNER JOIN ESTADO ON CIDADE.CODESTADO = ESTADO.CODESTADO");
            JRResultSetDataSource relatResult = new JRResultSetDataSource(conn.rs);
            JasperPrint jpPrint = JasperFillManager.fillReport("iReport/Cidade.jasper", new HashMap(), relatResult);
            JasperViewer jv = new JasperViewer(jpPrint, false);
            jv.setVisible(true);
            jv.toFront();
            conn.desconectar();
        } catch (JRException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(frame, "Erro ao gerar o relatório. \n" + ex, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        conn.desconectar();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItemPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPedidosActionPerformed
//         TODO add your handling code here:
//        FrmVenda2 vd = new FrmVenda2(jLabelNome.getText());//,"","","");
//        FrmVenda2 vd2 = new FrmVenda2();
//        vd2.setVisible(true);
    }//GEN-LAST:event_jMenuItemPedidosActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuAtualizacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAtualizacaoActionPerformed
        FrmUpdate frmUpdate = new FrmUpdate();
        frmUpdate.setVisible(true);
        
    }//GEN-LAST:event_jMenuAtualizacaoActionPerformed
    private void mostraDataExpira() {
        try {
            conn.executaSQL("select * from vencimento");
            conn.rs.last();
            char[] dataMostra = conn.rs.getString("datavenc").toCharArray();

            String dataMostra2 = String.valueOf(dataMostra[0] + "" + dataMostra[1] + "" + dataMostra[2] + "" + dataMostra[3] + "" + dataMostra[4] + "" + dataMostra[5] + "" + dataMostra[6] + "" + dataMostra[7] + "" + dataMostra[8] + "" + dataMostra[9] + "" + dataMostra[10] + "" + dataMostra[11]);
            //Decodifica o hash
            byte[] decodificaProxdata = Base64.getDecoder().decode(dataMostra2);
            String dataDecodificada = new String(decodificaProxdata);

            //Cria um array para organizar a data para mostrar.
            char[] dataParaMostrar = dataDecodificada.toCharArray();
            jLabelLicenca.setText("A licença do sistema irá expirar no dia: " + dataParaMostrar[0] + dataParaMostrar[1] + "/" + dataParaMostrar[2] + "" + dataParaMostrar[3] + "/" + dataParaMostrar[4] + dataParaMostrar[5] + dataParaMostrar[6] + dataParaMostrar[7]);
            conn.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        conn.desconectar();
    }

    private void permissao(String idpp) {
        try {
            conn.executaSQL("select * from usuario inner join frame on usuario.codframe=frame.codframe where usuario.codusuario='" + idpp + "'");
            conn.rs.first();
            System.out.println("ID: " + idpp);
            if (conn.rs.getString("frmbackup").equals("N")) {
                jMenuItemBackup.setEnabled(false);
            }
            if (conn.rs.getString("frmCidade").equals("N")) {
                jMenuItemCidade.setEnabled(false);
            }
            if (conn.rs.getString("frmCliente").equals("N")) {
                jMenuItemclientes.setEnabled(false);
            }
            if (conn.rs.getString("frmCompra").equals("N")) {
                jMenuItemclientes.setEnabled(false);
            }
            if (conn.rs.getString("frmContasPg").equals("N")) {
                jMenuItemContasPg.setEnabled(false);
            }
            if (conn.rs.getString("frmEstado").equals("N")) {
                jMenuItemEstados.setEnabled(false);
            }
            if (conn.rs.getString("frmFornecedor").equals("N")) {
                jMenuItemfornecedores.setEnabled(false);
            }
            if (conn.rs.getString("frmNivel").equals("N")) {
                //jMenuItem.setEnabled(false);
            }
            if (conn.rs.getString("frmPedido").equals("N")) {
                jMenuItemPedido.setEnabled(false);
            }
            if (conn.rs.getString("frmProduto").equals("N")) {
                jMenuItemprodutos.setEnabled(false);
            }
            if (conn.rs.getString("frmUsuario").equals("N")) {
                jMenuItemusuarios.setEnabled(false);
            }
            if (conn.rs.getString("frmVenda").equals("N")) {
                JMenuVendas.setEnabled(false);
            }
            //PER02
//            }
            conn.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(frame, "CODIGO DO ERRO: PER02 \n Erro ao executar a operação\n ERRO: " + ex);
            conn.desconectar();
        }
        conn.desconectar();
    }

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        /* Cria e mostra o form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new FrmPrincipal().setVisible(true);
//            }
//
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Cadastro;
    private javax.swing.JLabel JLabelVersao;
    private javax.swing.JMenu JMenuCadastro;
    private javax.swing.JMenu JMenuVendas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelCod;
    private javax.swing.JLabel jLabelLicenca;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLblData;
    private javax.swing.JLabel jLblHora;
    private javax.swing.JLabel jLblMostraData;
    private javax.swing.JLabel jLblMostraHora;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuAtualizacao;
    private javax.swing.JMenuBar jMenuBarPrincipal;
    private javax.swing.JMenu jMenuFinanceiro;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem jMenuItemAtualizar;
    private javax.swing.JMenuItem jMenuItemBackup;
    private javax.swing.JMenuItem jMenuItemCaixa;
    private javax.swing.JMenuItem jMenuItemCidade;
    private javax.swing.JMenuItem jMenuItemCliente;
    private javax.swing.JMenuItem jMenuItemContasPg;
    private javax.swing.JMenuItem jMenuItemContasReceber;
    private javax.swing.JMenuItem jMenuItemData;
    private javax.swing.JMenuItem jMenuItemEstados;
    private javax.swing.JMenuItem jMenuItemPedido;
    private javax.swing.JMenuItem jMenuItemPedidos;
    private javax.swing.JMenuItem jMenuItemclientes;
    private javax.swing.JMenuItem jMenuItemfornecedores;
    private javax.swing.JMenuItem jMenuItemprodutos;
    private javax.swing.JMenuItem jMenuItemusuarios;
    private javax.swing.JMenu jMenuManutenção;
    private javax.swing.JMenu jMenuRelatorios;
    private javax.swing.JMenu jMenuSistema;
    private javax.swing.JMenu jMenuVendas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelPrincipal;
    public static javax.swing.JDesktopPane jdarea;
    private org.netbeans.examples.lib.timerbean.Timer timer1;
    // End of variables declaration//GEN-END:variables

    // void setIcon() {
    //To change body of generated methods, choose Tools | Templates.
    //setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../imagens/icone.png")));
    // }
}
