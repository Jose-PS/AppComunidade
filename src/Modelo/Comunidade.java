/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * Nesta clase almacenarase toda a informacion, os comuneiros nun treemap pra despois poder ir ordenando e sacando listados.
 * @author Jose PS
 */
public class Comunidade {
    private static HashMap<String, Comuneiro> comuneiros=new HashMap<>();
    private static ArrayList<String> direccions;
    
    
    public static void engadeComuneiro(Comuneiro c){
        comuneiros.put(c.getDni(), c);
    }
    
    public static void eliminaComuneiro(Comuneiro c){
        comuneiros.remove(c.getNumSocio());
    }
    
    public static Collection<Comuneiro> getListado(){
        return comuneiros.values();
    }
    
    public static Comuneiro getComuneiro(int numSocio){
        return comuneiros.get(numSocio);
    }

    /**
     * Recibe un nome por parametro e devolve un arraylist cos comuneiros que se chamen asi.
     * @param nome
     * @return 
     */
    public static ArrayList<Comuneiro> buscaNome(String nome) {
        ArrayList<Comuneiro> lista=new ArrayList<>();
        comuneiros.values().stream().filter(c -> (c.getNome().toLowerCase().equals(nome.toLowerCase()))).forEachOrdered(c -> {
            lista.add(c);
        });
        return lista;
    }
    
    /**
     * Recibe un String coa aldea e devolve un ArrayList cos comuneiros de esa aldea.
     * @param aldea
     * @return 
     */
    public static ArrayList<Comuneiro> buscaAldea(String aldea) {
        ArrayList<Comuneiro> lista=new ArrayList<>();
        comuneiros.values().stream().filter(c -> (c.getDir().getAldea().toLowerCase().equals(aldea.toLowerCase()))).forEachOrdered(c -> {
            lista.add(c);
        });
        return lista;
    }
    
    /**
     * Recibe un numero por parametro e devolve os comuneiros que coincidan con ese numero.
     * @param numero
     * @return 
     */
    public static ArrayList<Comuneiro> buscaNumero(int numero) {
        ArrayList<Comuneiro> lista=new ArrayList<>();
        comuneiros.values().stream().filter(c -> (c.getNumSocio()==numero)).forEachOrdered(c -> {
            lista.add(c);
        });
        return lista;
    }

    /**
     * Devolve un listado dos comuneiros ordenados polo nome.
     * @return 
     */
    public static ArrayList<Comuneiro> listaNome() {
        return new ArrayList<>();
    }
    
    /**
     * Devolve un listado dos comuneiros ordeados pola aldea.
     * @return 
     */
    public static ArrayList<Comuneiro> listaAldea() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Devolve un listado dos comuneiros ordeados polo numero de socio.
     * @return 
     */
    public static ArrayList<Comuneiro> listaNumero() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
