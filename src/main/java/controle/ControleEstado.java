package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.ModeloEstado;

/**
 *
 * @author uedney
 */
public class ControleEstado {

    Conexao connEstado = new Conexao();
    ModeloEstado mod = new ModeloEstado();

    public void SalvarEstado(ModeloEstado mod) {
        connEstado.conectar();
        try {
            PreparedStatement pstm = connEstado.connection.prepareStatement("insert into estado (estado,sigla) values(?,?)");
            pstm.setString(1, mod.getNome());
            pstm.setString(2, mod.getSigla());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro do salvar o estado! \nERRO: " + ex);
        }
    }

    public void AtualizarEstado(ModeloEstado mod) {
        connEstado.conectar();
        try {
            PreparedStatement pstm = connEstado.connection.prepareStatement("update estado set estado =?,sigla=? where codestado =?");
            pstm.setString(1, mod.getNome());
            pstm.setString(2, mod.getSigla());
            pstm.setInt(3, mod.getCod());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar o estado! \nERRO: " + ex);
        }
    }

    public void ExcluirEstado(ModeloEstado mod) {
        connEstado.conectar();
        try {
            PreparedStatement pstm = connEstado.connection.prepareStatement("delete from estado where codestado =?");
            pstm.setInt(1, mod.getCod());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Estado excluído com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir o esado! \nERRO: " + ex);
        }
    }
}
