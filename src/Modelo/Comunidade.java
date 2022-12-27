/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Nesta clase almacenarase toda a informacion, os comuneiros nun treemap pra despois poder ir ordenando e sacando listados.
 * @author Jose PS
 */
public class Comunidade {
    public static TreeMap<Integer, Comuneiro> comuneiros;
    public static ArrayList<String> cartas;
    
    public static void xeraCorreo (String txt){
        
    }
    
    public static void engadeComuneiro(Comuneiro c){
        comuneiros.put(c.getNumSocio(), c);
    }
    
    public static void eliminaComuneiro(Comuneiro c){
        comuneiros.remove(c.getNumSocio());
    }
    
}
