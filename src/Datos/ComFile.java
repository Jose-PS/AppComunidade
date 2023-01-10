/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Modelo.Comuneiro;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/**
 * Esta clase encargariase das operacions con arquivos locais
 * @author Jose PS
 */
public class ComFile {
    
    
   /**
    * Usariase pra gardar os datos da comunidade nun arquivo local
    * @param c
    * @param fileName
    * @throws IOException 
    */
   public static void save(HashMap c, String fileName) throws IOException  {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(c);
        } catch (FileNotFoundException ex) {
        } 
    } 
   
   
   /**
    * Este metodo e o que se encarga de cargar os datos do arquivo seleccionado
    * @param fileName
    * @return
    * @throws IOException
    * @throws ClassNotFoundException 
    */
   public static HashMap<String, Comuneiro> load(String fileName) throws IOException, ClassNotFoundException   {
       HashMap<String, Comuneiro> comuneiros=new HashMap<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            comuneiros=(HashMap<String, Comuneiro>) in.readObject();
        } catch (FileNotFoundException ex) {
        } 
        return comuneiros;
    }

}
