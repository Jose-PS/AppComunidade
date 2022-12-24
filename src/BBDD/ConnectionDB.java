/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BBDD;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mariadb.jdbc.Connection;

/**
 *
 * @author DAW
 */
public class ConnectionDB {
    
    /**
     * 
     * @return 
     */
    public static Connection openConnection (){
        Connection con = null;
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            String conUrl="jdbc:mariadb://localhost:3306/concesionario?user=root&password=root";
            con=(Connection) DriverManager.getConnection(conUrl);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    /**
     * 
     * @param con
     * @throws SQLException 
     */
    public static void closeConnection (Connection con) throws SQLException{
        con.close();
    }
}
