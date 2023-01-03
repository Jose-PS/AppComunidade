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
    
    private static final String insert="INSERT INTO comuneiros (NOME, APELIDOS, DNI, TELEFONO, MAIL) VALUES (?, ?, ?, ?, ?)";
    private static final String insertDir="INSERT INTO direccions (ID, RUA, PROVINCIA, LOCALIDADE, ALDEA, NUMERO, CP ) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String delete="DELETE FROM comuneiros, direccions WHERE ID = ?";
    private static final String getByAldea="SELECT * FROM comuneiros WHERE ALDEA = ?";
    private static final String getByNome="SELECT * FROM comuneiros WHERE NOME = ?";
    private static final String getByDni="SELECT * FROM comuneiros WHERE DNI = ?";
    private static final String getByApelido="SELECT * FROM comuneiros WHERE APELIDOS LIKE ?";
    private static final String listByApelido="SELECT * FROM comuneiros ORDER BY APELIDOS";
    private static final String listByAldea="SELECT * FROM comuneiros ORDER BY ALDEA";
    private static final String listByNome="SELECT * FROM comuneiros ORDER BY NOME";
    private static final String update="";
    
    
    
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
    public static int insertComuneiro (String nome, String apelidos, String dni, Direccion dir, String telefono, String mail, Connection con){
        int numero=-1;
        String getNum = "SELECT NUM FROM comuneiros WHERE DNI=?";
        try (PreparedStatement ins = con.prepareStatement(insert)){
            ins.setString(1, nome);
            ins.setString(2, apelidos);
            ins.setString(3, dni);
            ins.setString(4, telefono);
            ins.setString(5, mail);
            ins.executeUpdate();
            try(PreparedStatement num=con.prepareStatement(getNum)){
                num.setString(1, dni);
                ResultSet data=num.executeQuery();
                while(data.next()){
                    numero=data.getInt(1);
                }
            }
            insertDireccion(numero, dir.getRua(), dir.getProvincia(), dir.getLocalidade(), dir.getAldea(), dir.getNumero(), dir.getCp(),con );
        } catch (SQLException ex) {
            Logger.getLogger(BBDDCom.class.getName()).log(Level.SEVERE, null, ex);
        }
;
     return numero;   
    }
    
    
    /**
     * Este metodo inserta a direccion co id de cada comuneiro na taboa de direccions.
     * @param id
     * @param rua
     * @param provincia
     * @param localidade
     * @param aldea
     * @param numero
     * @param cp
     * @param con
     * @return 
     */
    public static int insertDireccion (int id, String rua, String provincia, String localidade, String aldea, String numero, String cp, Connection con){
        try (PreparedStatement ins = con.prepareStatement(insertDir)){
            ins.setInt(1, id);
            ins.setString(2, rua);
            ins.setString(3, provincia);
            ins.setString(4, localidade);
            ins.setString(5, aldea);
            ins.setString(6, numero);
            ins.setString(7, cp);
            return ins.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BBDDCom.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
}
