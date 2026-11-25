package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author michel
 */
public class ConexaoBkp {

    static Connection con=null;

 public static Connection conectar(){
    try {

        con = DriverManager.getConnection("jdbc:mysql://localhost/sgemp","root","senha-de-estudo");
    }
    catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return con;
    }

}
