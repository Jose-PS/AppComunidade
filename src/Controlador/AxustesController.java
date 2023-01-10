/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

import Vista.MainFX;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import java.sql.*;
import javafx.event.EventHandler;

/**
 * FXML Controller class
 *
 * @author Jose PS
 */
public class AxustesController implements Initializable {

    @FXML
    private TextField bbddConnection;
    @FXML
    private TextField user;
    @FXML
    private PasswordField pass;
    @FXML
    private TextField ruta;
    @FXML
    private Button explorador;
    private File arquivo;
    @FXML
    private Label avisos;
    private static String filename;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        explorador.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Buscar Arquivo");
                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("Todo", "*.*"),
                        new FileChooser.ExtensionFilter("DAT", "*.dat"),
                        new FileChooser.ExtensionFilter("CSV", "*.csv")
                );
                arquivo = fileChooser.showOpenDialog(null);
                try{
                ruta.setText(arquivo.getAbsolutePath());
                MainFX.setFile(true);
                filename = ruta.getText();
                }catch(NullPointerException e){    
                }
            }
        });
       
    }
    
    /**
     * Regresa ao menu principal.
     * @param event 
     */
    @FXML
    private void atras(ActionEvent event) {
        MainFX.getBack();
    }

    /**
     * Garda a configuracion nun arquivo RandomAccessFile que se creara no directorio.
     * @param event 
     */
    @FXML
    private void gardaConf(ActionEvent event) {
    }

    /**
     * Lee o arquivo local e o envia a base de datos.
     * @param event 
     */
    @FXML
    private void gardaBD(ActionEvent event) {
    }

    /**
     * Lee a base de datos e garda todo nun arquivo local pra poder traballar sin conexion.
     * @param event 
     */
    @FXML
    private void importaBD(ActionEvent event) {
    }

    /**
     * Crea unha conexion coa base de datos cos datos que se introduzan nos campos.
     * @param event 
     */
    @FXML
    private void conectaBD(ActionEvent event) {
        try {
            MainFX.conectaDB(bbddConnection.getText(), user.getText(), pass.getText());
            avisos.setText("Conectado con exito!!");
            MainFX.setConnected(true);
        } catch (SQLException| ClassNotFoundException ex) {
            avisos.setText("Houbo un fallo na conexion, revisa os datos.");
            MainFX.setConnected(false);
        } 
    }
    
    
    /**
     * Devolve a ruta do arquivo que se vai usar pra gardar/cargar datos.
     * @return 
     */
    public static String getRuta() {
        return filename;
    }


    
    

}
