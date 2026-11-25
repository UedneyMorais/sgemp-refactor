package controle;

import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import modelo.ModeloFrame;

/**
 *
 * @author uedney
 */
public class ControleFrame {
    
    Conexao connFrame = new Conexao();
    
    public void atualizar(ModeloFrame mod) {
        try {
            connFrame.conectar();
            PreparedStatement pstm = connFrame.connection.prepareStatement("UPDATE frame SET frmBackup= ?,frmCidade= ?,frmCliente= ?,frmCompra= ?,frmContasPg= ?,frmEstado=?,frmFornecedor=?,frmNivel=?,frmOrcamento=?,frmPedido=?,frmPesquisaCli=?,frmProduto=?,frmUsuario=?,frmVenda=? where codframe =?");
            pstm.setString(1, mod.getFrmBackup());
            pstm.setString(2, mod.getFrmCidade());
            pstm.setString(3, mod.getFrmClientes());
            pstm.setString(4, mod.getFrmCompra());
            pstm.setString(5, mod.getFrmContasPg());
            pstm.setString(6, mod.getFrmEstado());
            pstm.setString(7, mod.getFrmFornecedores());
            pstm.setString(8, mod.getFrmNivel());
            pstm.setString(9, mod.getFrmOrcamento());
            pstm.setString(10, mod.getFrmPedidos());
            pstm.setString(11, mod.getFrmPesquisaCli());
            pstm.setString(12, mod.getFrmProdutos());
            pstm.setString(13, mod.getFrmUsuarios());
            pstm.setString(14, mod.getFrmVenda());         
            pstm.setInt(15, mod.getId_frame());     
            pstm.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro(controle) ao Atualizar os dados! \nOerro é:" + e);
        }
    }
    
}
