/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mariadb.jdbc.Connection;

/**
 * Clase con metodos static pra xestionar a conexion coa base de datos
 *
 * @author DAW
 */
public class ConnectionDB {

    private static String user = "";
    private static String pass = "";
    private static String url = "//localhost:3306/montesdohio";

    /**
     * Con este metodo creamos a conexion coa base de datos pasandolle os
     * parametros que se introduciran no menu da app
     *
     * @return
     */
    public static Connection openConnection(String url, String user, String pass) throws ClassNotFoundException, SQLException {
        Connection con = null;

        Class.forName("org.mariadb.jdbc.Driver");
        String conUrl = "jdbc:mariadb:" + url + "?user=" + user + "&password=" + pass;
        con = (Connection) DriverManager.getConnection(conUrl);

        return con;
    }

    /**
     * Con este metodo pecharemos a conexion
     *
     * @param con
     * @throws SQLException
     */
    public static void closeConnection(Connection con) throws SQLException {
        con.close();
    }
}
