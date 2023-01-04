/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Nesta clase almacenarase toda a informacion, os comuneiros nun treemap pra despois poder ir ordenando e sacando listados.
 * @author Jose PS
 */
public class Comunidade {
    private static TreeMap<String, Comuneiro> comuneiros=new TreeMap<>();
    private static ArrayList<String> direccions;
    
    public static void xeraCorreo (String txt){
        
    }
    
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

    public static ArrayList<Comuneiro> buscaNome(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Recibe un String coa aldea e devolve un ArrayList cos comuneiros de esa aldea.
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
