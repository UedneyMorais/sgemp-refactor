package controle;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.ModeloContasPg;

public class FormatoData {

    ModeloContasPg mod = new ModeloContasPg();
    String data_br;
    java.util.Date data;
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    Date hoje = new Date();

    public String getDataBR(java.util.Date data) {
        try {
            data_br = df.format(data);
        } catch (Exception e) {
            data_br = "";
        }
        return data_br;
    }

    public java.util.Date getData(String data_br) {
        try {
            data = df.parse(data_br.trim());
        } catch (ParseException ex) {
            data = null;
        }
        return data;
    }
    
    public String dtFormatada(Date dtBanco){
        String dataHoje = (String) df.format(hoje);
       //Monta a data decodificada para o padrão DD/MM/YYYY
            String dia = dataHoje.substring(0, 2);
            String mes = dataHoje.substring(3, 5);
            String ano = dataHoje.substring(6, 10);
            String dataSisModificada = dia + "/" + mes + "/" + ano; 
            
            return dataSisModificada;
    }
}
