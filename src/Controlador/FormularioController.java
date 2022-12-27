/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

import Vista.MainFX;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author Jose PS
 */
public class FormularioController implements Initializable {

    @FXML
    private TextField apelidos;
    @FXML
    private TextField nome;
    @FXML
    private TextField dni;
    @FXML
    private TextField aldea;
    @FXML
    private TextField rua;
    @FXML
    private TextField telefono;
    @FXML
    private Label tipoc;
    @FXML
    private TextField email;
    @FXML
    private TextField numero;
    @FXML
    private TextField lectorQR;
    @FXML
    private WebView mostraLectura;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void atras(ActionEvent event) {
        MainFX.getBack();
    }
    
    @FXML
    private void xeraCorreo(ActionEvent event){
        
    }

    @FXML
    private void altaComuneiro(ActionEvent event) {
    }
    
    @FXML
    private void mostraQR(){
        
    }
    
}
