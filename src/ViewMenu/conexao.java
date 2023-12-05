package ViewMenu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class conexao {
   static String jdbcUrl = "jdbc:mysql://localhost:3306/trabfico";
    static String user = "root";
    static String password = "root";
    public Connection conectar=conectou1();
    public Connection conectou1()
    {
    	Connection conn = null;
    	Boolean ret=false;
    try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    	} catch (ClassNotFoundException e) {
    		System.out.println("Conexao nao realizada");
    	}
    try {
        conn = DriverManager.getConnection(jdbcUrl,user, password);
        System.out.println("Conexao bem sucedida");
        conn.close();
        ret=true;
    } catch ( SQLException e) {
        System.out.println("Conexão mal sucedida!");
        ret=false;
    }
    return conn;
    }
}



  
