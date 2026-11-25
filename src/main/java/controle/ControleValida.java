package controle;

import static controle.HashMd5.HashMd5;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Base64;
import javax.swing.JOptionPane;
import visao.FrmLogin;

/**
 *
 * @author uedney
 */
public class ControleValida {

    Conexao conn = new Conexao();
    int valida;

    public void valida(String senha) {

        try {
            conn.conectar();
            conn.executaSQL("select * from vencimento");
            conn.rs.last();
            //valida = Integer.parseInt(conn.rs.getString("data_venc"));
            //Busca o ultimo registro do banco
            char[] dataMostravalida = conn.rs.getString("datavenc").toCharArray();
            String dataMostravalida2 = String.valueOf(dataMostravalida[0] + "" + dataMostravalida[1] + "" + dataMostravalida[2] + "" + dataMostravalida[3] + "" + dataMostravalida[4] + "" + dataMostravalida[5] + "" + dataMostravalida[6] + "" + dataMostravalida[7] + "" + dataMostravalida[8] + "" + dataMostravalida[9] + "" + dataMostravalida[10] + "" + dataMostravalida[11]);
 
            //Decodifica o hash
            byte[] decodificaDataValida = Base64.getDecoder().decode(dataMostravalida2);
            String dataDecodificadaValida = new String(decodificaDataValida);

//Transforma o resultado do banco em um inteiro para calcular
            valida = Integer.parseInt(dataDecodificadaValida);
      
            int operacao = (valida + 132) / 4;
            String operacaoMD5 = HashMd5(String.valueOf(operacao));
            //int senhaValidacao = Integer.parseInt(senha);

            if (operacaoMD5.equals(senha)) {
                int dia, mes, ano;
                String acertaMes, acertaDia, proxSenha;
                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                Date hoje = new Date();
                String data = df.format(hoje);
                char[] senhaChar = data.toCharArray();
                dia = Integer.parseInt("" + senhaChar[0] + senhaChar[1]);
                mes = Integer.parseInt("" + senhaChar[3] + senhaChar[4]);
                ano = Integer.parseInt("" + senhaChar[6] + senhaChar[7] + senhaChar[8] + senhaChar[9]);

                if (mes < 12) {
                    mes++;
                    if (mes < 10) {
                        acertaMes = "0" + mes;
                    } else {
                        acertaMes = "" + mes;
                    }
                } else {
                    mes = 1;
                    ano++;
                    acertaMes = "0" + mes;
                }
                if (dia < 10) {
                    acertaDia = "0" + dia;
                } else {
                    acertaDia = "" + dia;
                }

                proxSenha = acertaDia + acertaMes + ano;
                String proxSenhaCodificada = Base64.getEncoder().encodeToString(proxSenha.getBytes());
                
                    PreparedStatement pst = conn.connection.prepareStatement("insert into vencimento(datavenc,sec)values(?,?)");
                    pst.setString(1, proxSenhaCodificada);
                    pst.setString(2, HashMd5.HashMd5(proxSenhaCodificada));
                    pst.execute();

                conn.executaSQL("select * from vencimento");
                conn.rs.last();
                char[] dataMostra = conn.rs.getString("datavenc").toCharArray();
                String dataMostra2 = String.valueOf(dataMostra[0]+""+dataMostra[1]+""+dataMostra[2]+""+dataMostra[3]+""+dataMostra[4]+""+dataMostra[5]+""+dataMostra[6]+""+dataMostra[7]+""+dataMostra[8]+""+dataMostra[9]+""+dataMostra[10]+""+dataMostra[11]);
                //Decodifica o hash
                byte[] decodificaProxdata = Base64.getDecoder().decode(dataMostra2);
                String dataDecodificada = new String(decodificaProxdata);
                
                //Cria um array para organizar a data para mostrar.
                char[] dataParaMostrar = dataDecodificada.toCharArray();
          
                //JOptionPane.showMessageDialog(null, dataDecodificada);
                JOptionPane.showMessageDialog(null, "Sistema validado com sucesso!\n Proximo vencimento será: " + dataParaMostrar[0] + dataParaMostrar[1] + "/" + dataParaMostrar[2] + "" + dataParaMostrar[3] + "/" + dataParaMostrar[4] + dataParaMostrar[5] + dataParaMostrar[6] + dataParaMostrar[7]);
            } else {
                JOptionPane.showMessageDialog(null, "Senha incorreta, não validou!");
            }

            //JOptionPane.showMessageDialog(null, valida);
            conn.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao validar!\n ERRO:" + ex);
        }
    }
}
