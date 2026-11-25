package controle;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.ModeloUsuario;

public class ControleUsuario {

    Conexao connUsuario = new Conexao();
    public void salvar(ModeloUsuario mod) {
        try {
            //connUsuario.conectar();
            PreparedStatement pst = connUsuario.connection.prepareStatement("insert into frame (frmBackup) values ('N')");
            pst.execute();
            connUsuario.executaSQL("SELECT codframe FROM frame WHERE codframe= (SELECT MAX(codframe) FROM frame) LIMIT 1;");
            connUsuario.rs.next();
            String codframe = connUsuario.rs.getString("codframe");
            if (!codframe.isEmpty()) {
                PreparedStatement pstm = connUsuario.connection.prepareStatement("insert into usuario (usuario,senha,login,codpermissao,bloqueado,codframe)values(?,?,?,?,?,?)");
                pstm.setString(1, mod.getNomeUsuario());
                pstm.setString(2, mod.getSenhaUsuario());
                pstm.setString(3, mod.getLoginUsuario());
                pstm.setInt(4, mod.getNivelUsuario());
                pstm.setString(5, mod.getBloqueado());
                pstm.setString(6, codframe);
                pstm.execute();
                connUsuario.desconectar();
                JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
            } else {
                connUsuario.desconectar();
                JOptionPane.showMessageDialog(null, "Erro ao buscar cadastro de permissao\n", "ERRO", JOptionPane.ERROR_MESSAGE);               
            }
        } catch (SQLException | HeadlessException e) {
            connUsuario.desconectar();
            JOptionPane.showMessageDialog(null, "Erro(controle) ao cadastrar o usuário! \nOerro é:" + e);           
        }
    }

    public void atualizar(ModeloUsuario mod) {
        try {
            //connUsuario.conectar();
            PreparedStatement pstm = connUsuario.connection.prepareStatement("UPDATE usuario SET usuario= ?,senha= ?,login= ?,bloqueado= ?,codpermissao= ? where codusuario = ?");
            pstm.setString(1, mod.getNomeUsuario());
            pstm.setString(2, mod.getSenhaUsuario());
            pstm.setString(3, mod.getLoginUsuario());
            pstm.setString(4, mod.getBloqueado());
            pstm.setInt(5, mod.getNivelUsuario());
            pstm.setInt(6, mod.getIdUsuario());
            pstm.execute();
            connUsuario.desconectar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro(controle) ao Atualizar os dados! \nO erro é:" + e, "ERRO", JOptionPane.ERROR_MESSAGE);
            connUsuario.desconectar();
        }
    }

    public void excluir(ModeloUsuario mod) {
        //connUsuario.conectar();
        try {
            PreparedStatement pstm = connUsuario.connection.prepareStatement("UPDATE usuario SET bloqueado='S' where codusuario = ?");
            pstm.setInt(1, mod.getIdUsuario());
            pstm.execute();
            connUsuario.desconectar();
            JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso!");
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir o usuário! \nERRO: " + e);
            connUsuario.desconectar();
        }
    }
}
