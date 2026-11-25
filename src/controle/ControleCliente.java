package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.ModeloCliente;

public class ControleCliente {

    Conexao connCliente = new Conexao();
    ModeloCliente mod = new ModeloCliente();

    public void Salvar(ModeloCliente mod) {
        try {
            connCliente.conectar();
            PreparedStatement pstm = connCliente.connection.prepareStatement("insert into cliente (NOME,CPF,RG,DATNASC,SEXO,ESTCIVIL,LOGRADOURO,COMPL,BAIRRO,TELCEL,TELRES,TELCON,EMAIL,SALARIO,EMPRESA,ENDEMP,TELEMPRESA,COMPROVADO) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pstm.setString(1, mod.getNome());
            pstm.setString(2, mod.getCpf());
            pstm.setString(3, mod.getRg());
            pstm.setString(4, mod.getNasc());
            pstm.setString(5, mod.getSexo());
            pstm.setString(6, mod.getCivil());
            pstm.setString(7, mod.getLogra());
            pstm.setString(8, mod.getCompl());
            pstm.setString(9, mod.getBairro());
            pstm.setString(10, mod.getTelCel());
            pstm.setString(11, mod.getTelRes());
            pstm.setString(12, mod.getTelCon());
            pstm.setString(13, mod.getEmail());
            pstm.setString(14, mod.getSalario());
            pstm.setString(15, mod.getEmp());
            pstm.setString(16, mod.getEndereco());
            pstm.setString(17, mod.getTelEmp());
            pstm.setString(18, mod.getCompr());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Dados gravados com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar os dados!\nERRO:"+ex);
        }

    }

    public void Atualizar(ModeloCliente mod) {
        try {
                connCliente.conectar();
                PreparedStatement pstm = connCliente.connection.prepareStatement("update cliente set CLIENTE=?,CPF=?,RG=?,DATNASC=?,SEXO=?,ESTCIVIL=?,LOGRADOURO=?,COMPLEMENTO=?,BAIRRO=?,TELCEL=?,TELRES=?,TELCON=?,EMAIL=?,SALARIO=?,EMPRESA=?,ENDEMP=?,TELEMP=?,COMPLEMP=? where id_cliente=?");
                pstm.setString(1, mod.getNome());
                pstm.setString(2, mod.getCpf());
                pstm.setString(3, mod.getRg());
                pstm.setString(4, mod.getNasc());
                pstm.setString(5, mod.getSexo());
                pstm.setString(6, mod.getCivil());
                pstm.setString(7, mod.getLogra());
                pstm.setString(8, mod.getCompl());
                pstm.setString(9, mod.getBairro());
                pstm.setString(10, mod.getTelCel());
                pstm.setString(11, mod.getTelRes());
                pstm.setString(12, mod.getTelCon());
                pstm.setString(13, mod.getEmail());
                pstm.setString(14, mod.getSalario());
                pstm.setString(15, mod.getEmp());
                pstm.setString(16, mod.getEndereco());
                pstm.setString(17, mod.getTelEmp());
                pstm.setString(18, mod.getCompr());
                pstm.setInt(19, mod.getCod());
                pstm.executeUpdate();
               
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao gravar os dados: \n ERRO: " + e);
            }
        
        
        
    }

    public void Excluir(ModeloCliente mod) {

    }
}
