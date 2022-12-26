/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package Vista;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author DAW
 */
public class MainFX extends Application {
    private static Stage mainStage;
    private static SplitPane mainPane;
    private static Scene scn;

    @Override
    public void start(Stage mainStage) {
        this.mainStage=mainStage;
        this.mainStage.setTitle("Montes do Hio");
        
        
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainFX.class.getResource("/Vista/MainVista.fxml"));
            Image img1=new Image(new FileInputStream(getRutaRecurso("/src/Vista/forest.png")));
            ImageView imgv=new ImageView(img1);
            Pane stpane=new Pane(imgv);
            mainPane=(SplitPane)loader.load();
            mainPane.getItems().set(1, stpane);
            scn=new Scene(mainPane);
            mainStage.setScene(scn);
            mainStage.show();
            
        } catch (IOException e){
            System.out.println(e.getMessage());
        } catch (URISyntaxException ex) {
            Logger.getLogger(MainFX.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /**
     * Metodo pra obter a url do arquivo pra que funcione en calquer equipo
     * @param filename
     * @return
     * @throws URISyntaxException
     * @throws IOException 
     */
    public static String getRutaRecurso(String filename) throws URISyntaxException, IOException {
    final ProtectionDomain domain;
    final CodeSource source;
    final URL url;
    final URI uri;
    String DirectoryPath;
    String separador_directorios=System.getProperty("file.separator");
    String JarURL;
    File auxiliar;
    domain = MainFX.class.getProtectionDomain();
    source = domain.getCodeSource();
    url = source.getLocation();
    uri = url.toURI();
    JarURL = uri.getPath();
    auxiliar = new File(JarURL);
    if (auxiliar.isDirectory()) {
        auxiliar = new File(auxiliar.getParentFile().getParentFile().getPath());
        DirectoryPath = auxiliar.getCanonicalPath() + separador_directorios;
    } else {
        JarURL=auxiliar.getCanonicalPath();
        DirectoryPath = JarURL.substring(0, JarURL.lastIndexOf(separador_directorios) + 1);

    }

    System.out.println(DirectoryPath + filename);
    return DirectoryPath + filename;
}
    
    public static void switchPane (Pane stp){
        mainPane.getItems().set(1, stp);
        scn.setRoot(mainPane);
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
