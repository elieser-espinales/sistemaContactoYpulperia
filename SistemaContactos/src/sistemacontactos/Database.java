package sistemacontactos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    private String ConnString = "jdbc:mysql://127.0.0.1:3307/practicalab1";
    private String dbUser = "root";
    private String dbPass = "";
    private Connection conn;
    
     Connection getConnection(){
       return this.conn;
    }

    public Database(){
        try {
            this.conn = DriverManager.getConnection(this.ConnString, this.dbUser, this.dbPass);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   

}
