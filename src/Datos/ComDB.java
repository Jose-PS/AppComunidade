/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Modelo.Comuneiro;
import Modelo.Direccion;
import Vista.MainFX;
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
public class ComDB {

    private static final Connection con = MainFX.getCon();
    private static final String insert = "INSERT INTO comuneiros (NOME, APELIDOS, DNI, TELEFONO, MAIL) VALUES (?, ?, ?, ?, ?)";
    private static final String insertDir = "INSERT INTO direccion (NUMSOCIO, RUA, PROVINCIA, LOCALIDADE, ALDEA, NUMERO, CP ) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String delete = "DELETE FROM comuneiros, direccions WHERE NUMSOCIO = ?";
    private static final String getByAldea = "SELECT * FROM comuneiros c left JOIN direccion d ON c.NUMSOCIO=d.NUMSOCIO WHERE aldea LIKE ?";
    private static final String getByNome = "SELECT * FROM comuneiros c left JOIN direccion d ON c.NUMSOCIO=d.NUMSOCIO WHERE nome LIKE ?";
    private static final String getByDni = "SELECT * FROM comuneiros c left JOIN direccion d ON c.NUMSOCIO=d.NUMSOCIO WHERE dni LIKE ?";
    private static final String getByApelido = "SELECT * FROM comuneiros c left JOIN direccion d ON c.NUMSOCIO=d.NUMSOCIO WHERE apelido LIKE ?";
    private static final String listByApelido = "SELECT * FROM comuneiros c left JOIN direccion d ON c.NUMSOCIO=d.NUMSOCIO ORDER BY apelido";
    private static final String listByAldea = "SELECT * FROM comuneiros c left JOIN direccion d ON c.NUMSOCIO=d.NUMSOCIO ORDER BY aldea";
    private static final String listByNome = "SELECT * FROM comuneiros c left JOIN direccion d ON c.NUMSOCIO=d.NUMSOCIO ORDER BY nome";
    private static final String update = "";

    /**
     * Con este metodo insertamos comuneiros na base de datos, devolve o numero
     * que se lle asocie ou -1 se falla
     *
     * @param c
     * @return
     */
    public static int insertComuneiro(Comuneiro c) {
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
            insertDireccion(c);
        } catch (SQLException ex) {
            Logger.getLogger(ComDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numero;
    }

    /**
     * Este metodo inserta a direccion co id de cada comuneiro na taboa de
     * direccions.
     *
     * @param c
     * @return
     */
    public static int insertDireccion(Comuneiro c) {
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
            Logger.getLogger(ComDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    /**
     * Recibe un nome por parametro e devolve un arraylist cos comuneiros que se
     * chamen asi.
     *
     * @param nome
     * @return
     */
    public static ArrayList<Comuneiro> buscaNome(String nome) {
        ArrayList<Comuneiro> lista = new ArrayList<>();
        try ( PreparedStatement find = con.prepareStatement(getByNome)) {
            ResultSet list = find.executeQuery();
            lista = getComuneirosFromBD(list);
        } catch (SQLException ex) {
            Logger.getLogger(ComDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    /**
     * Recibe un String coa aldea e devolve un ArrayList cos comuneiros de esa
     * aldea.
     *
     * @param aldea
     * @return
     */
    public static ArrayList<Comuneiro> buscaAldea(String aldea) {
        ArrayList<Comuneiro> lista = new ArrayList<>();
        try ( PreparedStatement find = con.prepareStatement(getByNome)) {
            ResultSet list = find.executeQuery();
            lista = getComuneirosFromBD(list);
        } catch (SQLException ex) {
            Logger.getLogger(ComDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    /**
     * Recibe un numero por parametro e devolve os comuneiros que coincidan con
     * ese numero.
     *
     * @param numero
     * @return
     */
    public static ArrayList<Comuneiro> buscaNumero(String numero) {
        ArrayList<Comuneiro> lista = new ArrayList<>();
        try ( PreparedStatement find = con.prepareStatement(getByNome)) {
            ResultSet list = find.executeQuery();
            lista = getComuneirosFromBD(list);
        } catch (SQLException ex) {
            Logger.getLogger(ComDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    /**
     * Devolve un listado dos comuneiros ordenados polo nome.
     *
     * @return
     */
    public static ArrayList<Comuneiro> listaNome() {
        ArrayList<Comuneiro> lista = new ArrayList<>();
        try ( PreparedStatement find = con.prepareStatement(getByNome)) {
            ResultSet list = find.executeQuery();
            lista = getComuneirosFromBD(list);
        } catch (SQLException ex) {
            Logger.getLogger(ComDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    /**
     * Devolve un listado dos comuneiros ordeados pola aldea.
     *
     * @return
     */
    public static ArrayList<Comuneiro> listaAldea() {
        ArrayList<Comuneiro> lista = new ArrayList<>();
        try ( PreparedStatement find = con.prepareStatement(getByNome)) {
            ResultSet list = find.executeQuery();
            lista = getComuneirosFromBD(list);
        } catch (SQLException ex) {
            Logger.getLogger(ComDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    /**
     * Devolve un listado dos comuneiros ordeados polo numero de socio.
     *
     * @return
     */
    public static ArrayList<Comuneiro> listaNumero() {
        ArrayList<Comuneiro> lista = new ArrayList<>();
        try ( PreparedStatement find = con.prepareStatement(getByNome)) {
            ResultSet list = find.executeQuery();
            lista = getComuneirosFromBD(list);
        } catch (SQLException ex) {
            Logger.getLogger(ComDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    /**
     * Recibe o resultset da consulta e mete os resultados nun arraylist, serve
     * tanto para os metodos de busqueda como para os de listar.
     *
     * @param list
     * @return
     */
    private static ArrayList<Comuneiro> getComuneirosFromBD(ResultSet list) {
        ArrayList<Comuneiro> lista = new ArrayList<>();
        try {
            while (list.next()) {
                Comuneiro c = new Comuneiro(
                        list.getInt("NUMSOCIO"),
                        list.getString("NOME"),
                        list.getString("APELIDOS"),
                        list.getString("DNI"),
                        new Direccion(
                                list.getString("RUA"),
                                list.getString("PROVINCIA"),
                                list.getString("LOCALIDADE"),
                                list.getString("ALDEA"),
                                list.getString("NUMERO"),
                                list.getString("CP")),
                        list.getString("INFO"),
                        list.getString("TELEFONO"),
                        list.getString("MAIL"));
                lista.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ComDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

}
