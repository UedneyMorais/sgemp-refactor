package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.ModeloDtLogin;

public class ControleDtLogin {
    ModeloDtLogin mod = new ModeloDtLogin();
    Conexao con = new Conexao();
    public void InserirDtLogin(ModeloDtLogin mod,Conexao conn) {
        try {
            PreparedStatement pstm = conn.connection.prepareStatement("insert into datalogin (datalogin) values(?);");
            pstm.setString(1, mod.getDtLogin());
            pstm.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO: " + ex);
        }
    }
    
    public void DeletarDtLogin(ModeloDtLogin mod,Conexao conn) {
        try {  
            PreparedStatement pstm = conn.connection.prepareStatement("DELETE FROM datalogin");
            pstm.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO: " + ex);
        }
    }   
}
