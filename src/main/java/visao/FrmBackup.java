package visao;

import java.io.File;
import java.sql.Connection;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import controle.ConexaoBkp;
import controle.ControleBackup;
import java.awt.HeadlessException;
import java.io.IOException;
import javax.swing.ImageIcon;

/**
 *
 * @author Uedney
 */
public class FrmBackup extends javax.swing.JFrame {

    Connection con = null; //variável para usar em conexão de banco de dados.

    /**
     * Creates new form FrmBackup
     */
    ControleBackup bk = new ControleBackup();
    public FrmBackup() {
        initComponents();
        bk.gerarBackup();
        try {
            con = ConexaoBkp.conectar();//Conecta ao banco de dados 
            JFC_Salvar_Backup.setVisible(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Erro!", 2);
        }
        this.setIconImage(new ImageIcon(getClass().getResource("/imagens/icone.png")).getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        JFC_Salvar_Backup = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JB_Backup = new javax.swing.JButton();

        JFC_Salvar_Backup.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        JFC_Salvar_Backup.setBackground(new java.awt.Color(255, 255, 255));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Este procedimento realiza o backup do banco de dados.");

        jLabel2.setText("Para que funcione corretamente é preciso estar no servidor.");

        JB_Backup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bkp.png"))); // NOI18N
        JB_Backup.setText("Fazer Backup");
        JB_Backup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_BackupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(JB_Backup, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JB_Backup)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JB_BackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_BackupActionPerformed
        // TODO add your handling code here:
        // Botão Backup
        try {
            String arquivo = null;

            JFC_Salvar_Backup.setVisible(true);

            int result = JFC_Salvar_Backup.showSaveDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                arquivo = JFC_Salvar_Backup.getSelectedFile().toString().concat(".sql");

                File file = new File(arquivo);

                if (file.exists()) {
                    Object[] options = {"Sim", "Não"};
                    int opcao = JOptionPane.showOptionDialog(null, "Este arquivo já existe. Quer sobreescrever este arquivo?", "Atenção!!!",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    if (opcao == JOptionPane.YES_OPTION) {
                        Runtime bck = Runtime.getRuntime();
                        bck.exec("C:\\sgemp\\config\\mysqldump.exe -v -v -v --host=localhost --user=root --password=senha-de-estudo --port=3306 --protocol=tcp --force --allow-keywords --compress  --add-drop-table --default-character-set=utf8 --hex-blob  --result-file=" + arquivo + " --databases sgemp");
                        JOptionPane.showMessageDialog(null, "Backup realizado com sucesso.", "", 1);
                    } else {
                        JB_BackupActionPerformed(evt);
                    }
                } else {

                    Runtime bck = Runtime.getRuntime();
                    bck.exec("C:\\sgemp\\config\\mysqldump.exe -v -v -v --host=localhost --user=root --password=senha-de-estudo --port=3306 --protocol=tcp --force --allow-keywords --compress  --add-drop-table --default-character-set=utf8 --hex-blob  --result-file=" + arquivo + " --databases sgemp");
                    JOptionPane.showMessageDialog(null, "Backup realizado com sucesso.", "", 1);
                }

            }

        } catch (HeadlessException | IOException e) {
            JOptionPane.showMessageDialog(null, e, "Erro!", 2);
        }

    }//GEN-LAST:event_JB_BackupActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new FrmBackup().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JB_Backup;
    private javax.swing.JFileChooser JFC_Salvar_Backup;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
