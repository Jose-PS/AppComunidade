/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BBDD;

import Modelo.Direccion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mariadb.jdbc.Connection;

/**
 * En esta clase definiremos os metodos pra gardar informacion na base de datos
 * @author DAW
 */
public class BBDDCom {
    private static String insert="INSERT INTO comuneiros (NOME, APELIDOS, DNI, DIR, TELEFONO, MAIL) VALUES (?, ?, ?, ?, ?, ?)";
    private static String delete="";
    private static String getByAldea="";
    private static String getByNome="";
    private static String getByDni="";
    private static String getByApelido="";
    private static String update="";
    
    
    
    /**
     * Con este metodo insertamos comuneiros na base de datos, devolve o numero que se lle asocie ou -1 se falla
     * @param nome
     * @param apelidos
     * @param dni
     * @param dir
     * @param telefono
     * @param mail
     * @param con
     * @return 
     */
    public static int insertComuneiro (String nome, String apelidos, String dni, Direccion dir, int telefono, String mail, Connection con){
        int numero=-1;
        String getNum = "SELECT NUM FROM comuneiros WHERE DNI=?";
        try (PreparedStatement ins = con.prepareStatement(insert)){
            ins.setString(1, nome);
            ins.setString(2, apelidos);
            ins.setString(3, dni);
            ins.setString(4, "dir");
            ins.setInt(5, telefono);
            ins.setString(6, mail);
            ins.executeUpdate();
            try(PreparedStatement num=con.prepareStatement(getNum)){
                num.setString(1, dni);
                ResultSet data=num.executeQuery();
                while(data.next()){
                    numero=data.getInt(1);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BBDDCom.class.getName()).log(Level.SEVERE, null, ex);
        }
;
     return numero;   
    }
    
}
