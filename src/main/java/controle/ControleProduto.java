package controle;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.ModeloProduto;

public class ControleProduto {

    Conexao connProduto = new Conexao();
    ModeloProduto mod = new ModeloProduto();

    public void InserirProduto(ModeloProduto mod) {
        try {
            connProduto.conectar();
            PreparedStatement pstm = connProduto.connection.prepareStatement("insert into cad_prod "
                    + "(cod_prod,desc_prod,id_fornec,id_categoriaprod,valor_prod,valorcompra_prod,margem_prod,qtde_prod,estmin_prod,estmax_prod,ativo_prod)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?)");
            pstm.setString(1, mod.getCodProd());
            pstm.setString(2, mod.getDesc());
            pstm.setInt(3, mod.getCodFornec());
            pstm.setInt(4, mod.getCodCateg());
            pstm.setDouble(5, mod.getValor());
            pstm.setDouble(6, mod.getValorCompra());
            pstm.setDouble(7, mod.getPorc());
            pstm.setInt(8, mod.getQtde());
            pstm.setInt(9, mod.getEstMin());
            pstm.setInt(10, mod.getEstMax());
            pstm.setString(11, "S");
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar o produto! \nOerro é:" + e);
        }
    }

    public void AlterarProduto(ModeloProduto mod) {
        try {
            connProduto.conectar();
            PreparedStatement pstm = connProduto.connection.prepareStatement("update cad_prod set cod_prod=?,desc_prod=?,id_categoriaprod=?,id_fornec=?,valor_prod=?,valorcompra_prod=?,margem_prod=?,qtde_prod=?,estmin_prod=?,estmax_prod=? where id_prod=?");
            pstm.setString(1, mod.getCodProd());
            pstm.setString(2, mod.getDesc());
            pstm.setInt(3, mod.getCodCateg());
            pstm.setInt(4, mod.getCodFornec());
            pstm.setDouble(5, mod.getValor());
            pstm.setDouble(6, mod.getValorCompra());
            pstm.setDouble(7, mod.getPorc());
            pstm.setInt(8, mod.getQtde());
            pstm.setInt(9, mod.getEstMin());
            pstm.setInt(10, mod.getEstMax());
            pstm.setInt(11, mod.getCod());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Produto Alterado com sucesso!");
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Alterar o produto! \nOerro é:" + e);
        }
    }

    public void ExcluirProduto(ModeloProduto mod) {
        connProduto.conectar();
        try {
            PreparedStatement pstm = connProduto.connection.prepareStatement("UPDATE cad_prod SET `ativo_prod`=\"N\" WHERE `id_prod`=?");
            pstm.setInt(1, mod.getCod());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Produto excluido com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro do excluir o produto. \nERRO: " + e);
        }
    }
}
