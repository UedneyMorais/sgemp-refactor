
package controle;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;
import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author notebook
 */
public class ControleBackup extends Conexao {

    Conexao conn = new Conexao();
    Config config = new Config();
    public static void main(String[] args) {
        
    }

    public  void gerarBackup() {
        try {
            conn.conectar();
            conn.executaSQL("select * from parametro");
            conn.rs.next();
            String dirbkp = conn.rs.getString("caminhobackup");
            
            XStream xstream = new XStream(new Dom4JDriver());
            xstream.alias("Servidor", Config.class);
            config = (Config)xstream.fromXML(new FileInputStream(new File("C:\\sgemp\\config\\config.xml")));
            DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss_");
            Date date = new Date();
            String dtFormatada=dateFormat.format(date);
            Runtime bkp = Runtime.getRuntime();
            String bkps = ("C:\\sgemp\\config\\mysqldump.exe -v -v -v --host="+config.getHost()+" --user="+conn.login+" --password="+conn.senha+" --port="+conn.porta+" --protocol=tcp --force --allow-keywords --compress  --add-drop-table --default-character-set=utf8 --hex-blob  --result-file="+dirbkp+dtFormatada+"BKP.sql --databases sgemp");
            bkp.exec(bkps);
            System.out.println(dtFormatada+bkps);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
