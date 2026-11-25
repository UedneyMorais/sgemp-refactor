package controle;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.ModeloTabela;
import modelo.ModeloUsuario;
import modelo.ModeloVenda;

/**
 *
 * @author uedney
 */
public class ControleVenda {
    //Conexao connVenda = new Conexao();
    
//    public void abreVenda(ModeloVenda mod) {
//        try {
//            connVenda.conectar();
//            PreparedStatement pstm = connVenda.connection.prepareStatement("SELECT `proxnumvenda_parametro` FROM cad_parametro FOR UPDATE");
//            pstm.execute();
//            pstm = connVenda.connection.prepareCall("UPDATE `cad_parametro` SET `proxnumvenda_parametro`=`proxnumvenda_parametro`+1");
//            pstm.execute();
//            JOptionPane.showMessageDialog(null, "Venda aberta com sucesso!");
//        } catch (SQLException | HeadlessException e) {
//            JOptionPane.showMessageDialog(null, "Erro ao cadastrar a venda! \nOerro é:" + e);
//        }
//    }
//    
        public void salvar(ModeloVenda mod,Conexao connVenda) {
        try {
            //connVenda.conectar();
            PreparedStatement pstm = connVenda.connection.prepareStatement("INSERT INTO itemvenda (numvenda,codprod,qtde,preco) values(?,?,?,?)");
            pstm.setInt(1, mod.getIdVenda());
            pstm.setInt(2, mod.getIdProd());
            pstm.setDouble(3, mod.getQtdeItem());
            pstm.setDouble(4, mod.getValorVenda());
            pstm.execute();
            connVenda.desconectar();
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar a venda! \nOerro é:" + e);
        }
    }

}
