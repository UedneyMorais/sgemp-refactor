package controle;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.ModeloOrcamento;

/**
 *
 * @author Notebook
 */
public class ControleOrcamento {
    Conexao connOrc = new Conexao();
    ModeloOrcamento mod = new ModeloOrcamento();
    
    public void inserirOrcamento(ModeloOrcamento mod){
    
        try {
            connOrc.conectar();
            java.sql.PreparedStatement pstm = connOrc.connection.prepareStatement("INSERT INTO cad_orcamento (id_cliente,dt_iniorc,dt_fimorc) VALUES (?,?,?)");
            pstm.setInt(1, mod.getCodCli());
            pstm.setString(2, mod.getDtIniorc());
            pstm.setString(3, mod.getDtFimorc());
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Erro ao inserir o cliente: "+e);
        }
}
    
    
    
}
