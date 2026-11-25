package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.ModeloContasPg;

public class ControleContasPg {

    Conexao connContaspg = new Conexao();
    ModeloContasPg mod = new ModeloContasPg();
    FormatoData form = new FormatoData();

    public void InserirContasPG(ModeloContasPg mod) {
        connContaspg.conectar();
        try {
            PreparedStatement pstm = connContaspg.connection.prepareStatement("INSERT INTO contaspg (contaspg,vencimento,valor,pago,dtpago,desconto,multa,vlpago,codfornecedor,codcategoriapg) VALUES (?,?,?,?,?,?,?,?,?,?)");
            pstm.setString(1, mod.getDesc());
            pstm.setString(2, mod.getVencimento());
            pstm.setString(3, mod.getValor());
            pstm.setString(4, mod.getPagou());
            pstm.setString(5, mod.getDtPago());
            pstm.setString(6, mod.getDesconto());
            pstm.setString(7, mod.getMulta());
            pstm.setString(8, mod.getValorPago());
            pstm.setInt(9, mod.getFornecedor());
            pstm.setInt(10, mod.getCategoria());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Inserido com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro do inserir os dados. \nERRO: " + ex);
        }
    }

    public void InserirContasNpg(ModeloContasPg mod) {
        connContaspg.conectar();
        try {
            PreparedStatement pstm = connContaspg.connection.prepareStatement("INSERT INTO contaspg (contaspg,vencimento,valor,pago,codfornecedor,codcategoriapg) VALUES (?,?,?,?,?,?)");
            pstm.setString(1, mod.getDesc());
            pstm.setString(2, mod.getVencimento());
            pstm.setString(3, mod.getValor());
            pstm.setString(4, mod.getPagou());
            //pstm.setString(5, mod.getDtPago());
            //pstm.setString(6, mod.getDesconto());
            //pstm.setString(7, mod.getMulta());
            //pstm.setString(8, mod.getValorPago());
            pstm.setInt(5, mod.getFornecedor());
            pstm.setInt(6, mod.getCategoria());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Inserido com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro do inserir os dados. \nERRO: " + ex);
        }
    }

    public void AlterarContasPg(ModeloContasPg mod) {
        connContaspg.conectar();
        try {

            PreparedStatement pstm = connContaspg.connection.prepareStatement("update contaspg set contaspg=?,vencimento=?,valor=?,pago=?,dtpago=?,desconto=?,multa=?,vlpago=?,codfornecedor=?,codcategoriapg=? where codcontaspg=?");
            pstm.setString(1, mod.getDesc());
            pstm.setString(2, mod.getVencimento());
            pstm.setString(3, mod.getValor());
            pstm.setString(4, mod.getPagou());
            pstm.setString(5, mod.getDtPago());
            pstm.setString(6, mod.getDesconto());
            pstm.setString(7, mod.getMulta());
            pstm.setString(8, mod.getValorPago());
            pstm.setInt(9, mod.getFornecedor());
            pstm.setInt(10, mod.getCategoria());
            pstm.setInt(11, mod.getCod());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Dados atualizados com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro do atualizar os dados. \nERRO: " + ex);
        }
    }

    public void AlterarContasNpg(ModeloContasPg mod) {
        connContaspg.conectar();
        try {
            PreparedStatement pstm = connContaspg.connection.prepareStatement("update contaspg set contaspg=?,vencimento=?,valor=?,pago=?,codfornecedor=?,codcategoriapg=? where codcontaspg=?");
            pstm.setString(1, mod.getDesc());
            pstm.setString(2, mod.getVencimento());
            pstm.setString(3, mod.getValor());
            pstm.setString(4, mod.getPagou());
            pstm.setInt(5, mod.getFornecedor());
            pstm.setInt(6, mod.getCategoria());
            pstm.setInt(7, mod.getCod());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Dados atualizados com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro do atualizar os dados. \nERRO: " + ex);
        }
    }

    public void ExcluirContas(ModeloContasPg mod) {
        connContaspg.conectar();
        try {
            PreparedStatement pstm = connContaspg.connection.prepareStatement("insert into cad_cidade (nome_cidade,id_estado) values(?,?)");
            JOptionPane.showMessageDialog(null, "Inserido com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro do inserir os dados. \nERRO: " + ex);
        }
    }
}
