/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author uedney
 */
public class ControleDataVenc {
    
    Conexao conn = new Conexao();
    
    public void SalvarData(String data){
        conn.conectar();
        try {
            PreparedStatement pst = conn.connection.prepareStatement("INSERT INTO vencimento(dtvenc) VALUE(?)");
            pst.setString(1, data);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data cadastrada com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar a data de vencimento!\nERRO: "+ex);
        }
        
    }
    
}
