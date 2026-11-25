package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.ModeloCidade;

public class ControleCidade {

    Conexao connCidade = new Conexao();
    ModeloCidade mod = new ModeloCidade();

    public void InserirCidade(ModeloCidade mod) {
        connCidade.conectar();
        try {
            PreparedStatement pstm = connCidade.connection.prepareStatement("insert into cidade (cidade,cep,codestado,bloqueado) values(?,?,?,'N')");
            pstm.setString(1, mod.getNome());
            pstm.setString(2, mod.getCep());
            pstm.setInt(3, mod.getCod_estado());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Inserido com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro do inserir os dados! \nERRO: " + ex,"ERRO",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void AlterarCidade(ModeloCidade mod) {
        connCidade.conectar();
        try {
            PreparedStatement pstm = connCidade.connection.prepareStatement("update cidade set cidade = ?,cep=?,codestado = ? where codcidade = ?");
            pstm.setString(1, mod.getNome());
            pstm.setString(2, mod.getCep());
            pstm.setInt(3, mod.getCod_estado());
            pstm.setInt(4, mod.getCod());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso","Sucesso",JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro do atualizar os dados! \nERRO: "," ERRO" + ex,JOptionPane.ERROR_MESSAGE);
        }
    }

    public void ExcluirCidade(ModeloCidade mod) {
        connCidade.conectar();
        try {
            PreparedStatement pstm = connCidade.connection.prepareStatement("UPDATE cidade SET bloqueado='S' WHERE codcidade = ?");
            pstm.setInt(1, mod.getCod());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro do excluir os dados! \nERRO: " + ex,"ERRO",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void RetirarExcluido(ModeloCidade mod) {
        connCidade.conectar();
        try {
            PreparedStatement pstm = connCidade.connection.prepareStatement("update cidade set bloqueado = 'N' where codcidade = ?");
            pstm.setInt(1, mod.getCod());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Retirado com sucesso!");
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao retirar os dados da exclusão! \nERRO: " + ex,"ERRO",JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
