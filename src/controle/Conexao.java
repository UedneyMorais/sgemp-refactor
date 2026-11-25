package controle;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexao {

//    //------------------BANCO DE DADOS POSTGRESQL--------------------------
//    static final String JDBC_DRIVER = "org.postgresql.Driver";
//    static String DATABASE_URL = "";
//    public Connection connection = null; // gerencia a conexão  
//    PreparedStatement pstmt = null;
//    public Statement stmt;
//    public ResultSet rs;
//    String login = "postgres";
//    String senha = "senha-de-estudo";
//    Config Config = new Config();
//
//    public void conectar() {
//        XStream xstream = new XStream(new DomDriver());
//        xstream.alias("Servidor", Config.class);
//        try {
//            Config = (Config) xstream.fromXML(new FileInputStream(new File("C:\\sgemp\\Config\\Config.xml")));
//        } catch (FileNotFoundException ex) {
//            JOptionPane.showMessageDialog(null, "Erro ao Conectar! \nERRO:" + ex, "ERRO", JOptionPane.ERROR_MESSAGE);
//        }
//
//        try {
//            DATABASE_URL = "jdbc:postgresql://" + Config.getHost() + ":" + Config.getPorta() + "/" + Config.getBanco() + "";
//            Class.forName(JDBC_DRIVER);
//            // estabelece conexão com o banco de dados  
//            connection = DriverManager.getConnection(DATABASE_URL, login, senha);
//            //JOptionPane.showMessageDialog(null, "Conectado com Sucesso!!!");
//            //statement = connection.createStatement();
//        } catch (ClassNotFoundException ex) {
//            JOptionPane.showMessageDialog(null, "Não conectado!\n" + ex);
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "O sistema encontrou um erro,verifique o arquivo de conexão (Config.xml).\n Por favor avise ao administrador.\n O erro encontrado é\nERRO : " + ex, "ERRO", JOptionPane.ERROR_MESSAGE);
//        }
//    }
//---------------------BANCO DE DADOS MARIADB-----------------------------------
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static String DATABASE_URL = "";
    public Connection connection = null; // gerencia a conexão  
    PreparedStatement pstmt = null;
    public Statement stmt;
    public ResultSet rs;
    protected String login = "root";
    protected String senha = "senha-de-estudo";
    protected String porta = "3306";
    Config config = new Config();

    public void conectar() {
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("Servidor", Config.class);
        try {
            config = (Config) xstream.fromXML(new FileInputStream(new File("C:\\sgemp\\config\\config.xml")));
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Conectar! \nERRO:" + ex, "ERRO", JOptionPane.ERROR_MESSAGE);
        }

        try {
            DATABASE_URL = "jdbc:mysql://" + config.getHost() + ":" + porta + "/" + config.getBanco() + "";
            Class.forName(JDBC_DRIVER);
            // estabelece conexão com o banco de dados  
            connection = DriverManager.getConnection(DATABASE_URL, login, senha);
            System.out.println("iniciada C"+connection);
            //JOptionPane.showMessageDialog(null, "Conectado com Sucesso!!!");
            //statement = connection.createStatement();
            //desconectar();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Não conectado!\n" + ex);
            desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "O sistema encontrou um erro,verifique o arquivo de conexão (config.xml).\n Por favor avise ao administrador.\n O erro encontrado é\nERRO : " + ex, "ERRO", JOptionPane.ERROR_MESSAGE);
        desconectar();
        }
        
    }

    public void desconectar() {
        if (connection != null) {
            try {
                stmt.close();
                connection.close();
                System.out.println("fechada"+connection);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao desconectar o banco!\n o erro ocorrido é: " + ex, "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void executaSQL(String SQL) {
        try {
            conectar();
            stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(SQL);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no executaSQL!\n ERRO: " + ex, "ERRO", JOptionPane.ERROR_MESSAGE);
            desconectar();
        }
    }

    public void executaUpdate(String SQL) {
        try {
            conectar();
            stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt.executeUpdate(SQL);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no executaUpdate!\n ERRO: " + ex, "ERRO", JOptionPane.ERROR_MESSAGE);
            desconectar();
        }
    }

    public Connection getSgempConnection() throws SQLException {

        return connection = DriverManager.getConnection(DATABASE_URL, login, senha);
    }

    public Statement createStatement(int TYPE_SCROLL_INSENSITIVE, int CONCUR_READ_ONLY) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
