/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BBDD;

import Modelo.Comuneiro;
import Modelo.Direccion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mariadb.jdbc.Connection;

/**
 * En esta clase definiremos os metodos pra gardar informacion na base de datos
 *
 * @author DAW
 */
public class BBDDCom {

    private static final String insert = "INSERT INTO comuneiros (NOME, APELIDOS, DNI, TELEFONO, MAIL) VALUES (?, ?, ?, ?, ?)";
    private static final String insertDir = "INSERT INTO direccion (NUMSOCIO, RUA, PROVINCIA, LOCALIDADE, ALDEA, NUMERO, CP ) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String delete = "DELETE FROM comuneiros, direccions WHERE ID = ?";
    private static final String getByAldea = "SELECT * FROM comuneiros WHERE ALDEA = ?";
    private static final String getByNome = "SELECT * FROM comuneiros WHERE NOME = ?";
    private static final String getByDni = "SELECT * FROM comuneiros WHERE DNI = ?";
    private static final String getByApelido = "SELECT * FROM comuneiros WHERE APELIDOS LIKE ?";
    private static final String listByApelido = "SELECT * FROM comuneiros ORDER BY APELIDOS";
    private static final String listByAldea = "SELECT * FROM comuneiros ORDER BY ALDEA";
    private static final String listByNome = "SELECT * FROM comuneiros ORDER BY NOME";
    private static final String update = "";

    /**
     * Con este metodo insertamos comuneiros na base de datos, devolve o numero
     * que se lle asocie ou -1 se falla
     *
     * @param nome
     * @param apelidos
     * @param dni
     * @param dir
     * @param telefono
     * @param mail
     * @param con
     * @return
     */
    public static int insertComuneiro(Comuneiro c, Connection con) {
        int numero = -1;
        String getNum = "SELECT NUMSOCIO FROM comuneiros WHERE DNI=?";
        try ( PreparedStatement ins = con.prepareStatement(insert)) {
            ins.setString(1, c.getNome());
            ins.setString(2, c.getApelidos());
            ins.setString(3, c.getDni());
            ins.setString(4, c.getTelefono());
            ins.setString(5, c.getMail());
            ins.executeUpdate();
            try ( PreparedStatement num = con.prepareStatement(getNum)) {
                num.setString(1, c.getDni());
                ResultSet data = num.executeQuery();
                while (data.next()) {
                    numero = data.getInt(1);
                }
                c.setNumSocio(numero);
            }
            insertDireccion(c, con);
        } catch (SQLException ex) {
            Logger.getLogger(BBDDCom.class.getName()).log(Level.SEVERE, null, ex);
        }
        ;
        return numero;
    }

    /**
     * Este metodo inserta a direccion co id de cada comuneiro na taboa de
     * direccions.
     *
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
    public static int insertDireccion(Comuneiro c, Connection con) {
        Direccion d = c.getDir();
        try ( PreparedStatement ins = con.prepareStatement(insertDir)) {
            ins.setInt(1, c.getNumSocio());
            ins.setString(2, d.getRua());
            ins.setString(3, d.getProvincia());
            ins.setString(4, d.getLocalidade());
            ins.setString(5, d.getAldea());
            ins.setString(6, d.getNumero());
            ins.setString(7, d.getCp());
            return ins.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BBDDCom.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    /**
     *
     * @param nome
     * @return
     */
    public static ArrayList<Comuneiro> buscaNome(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param aldea
     * @return
     */
    public static ArrayList<Comuneiro> buscaAldea(String aldea) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param numero
     * @return
     */
    public static ArrayList<Comuneiro> buscaNumero(String numero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return
     */
    public static ArrayList<Comuneiro> listaNome() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return
     */
    public static ArrayList<Comuneiro> listaAldea() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return
     */
    public static ArrayList<Comuneiro> listaNumero() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
