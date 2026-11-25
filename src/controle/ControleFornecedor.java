package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.ModeloFornecedor;

public class ControleFornecedor {

    Conexao connFornec = new Conexao();
    ModeloFornecedor mod = new ModeloFornecedor();

    public void InserirFornecedor(ModeloFornecedor mod) {
        connFornec.conectar();
        try {
            PreparedStatement pstm = connFornec.connection.prepareStatement("insert into fornecedor (fornecedor,fone,cel,email,cnpj,rg,endereco,codbairro) values(?,?,?,?,?,?,?,?)");
            pstm.setString(1, mod.getNome());
            pstm.setString(2, mod.getFone());
            pstm.setString(3, mod.getCel());
            pstm.setString(4, mod.getEmail());
            pstm.setString(5, mod.getCnpj());
            pstm.setString(6, mod.getRg());
            pstm.setString(7, mod.getEndereco());
            pstm.setInt(8, mod.getCodBairro());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Inserido com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro do inserir os dados. \nERRO: " + ex);
        }
    }

    public void AlterarFornecedor(ModeloFornecedor mod) {
        connFornec.conectar();
        try {
            PreparedStatement pstm = connFornec.connection.prepareStatement("update fornecedor set fornecedor=?,fone=?,cel=?,email=?,cnpj=?,rg=?,endereco=?,codbairro=? where codfornec=?");
            pstm.setString(1, mod.getNome());
            pstm.setString(2, mod.getFone());
            pstm.setString(3, mod.getCel());
            pstm.setString(4, mod.getEmail());
            pstm.setString(5, mod.getCnpj());
            pstm.setString(6, mod.getRg());
            pstm.setString(7, mod.getEndereco());
            pstm.setInt(8, mod.getCodBairro());
            pstm.setInt(9, mod.getCod());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro do atualizar os dados. \nERRO: " + ex);
        }
    }

    public void ExcluirFornecedor(ModeloFornecedor mod) {
        connFornec.conectar();
        try {
            PreparedStatement pstm = connFornec.connection.prepareStatement("DELETE FROM fornecedor WHERE codfornec = ?");
            pstm.setInt(1, mod.getCod());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro do Excluir os dados. \nERRO: " + e);
        }
        //connCidade.desconectar();
    }
}
