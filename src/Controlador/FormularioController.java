/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

import BBDD.BBDDCom;
import Modelo.Comuneiro;
import Modelo.Comunidade;
import Modelo.Direccion;
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
import javafx.stage.Popup;

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
    private TextField email;
    @FXML
    private TextField numero;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    /**
     * Volve a paxina principal e limpa os campos do formulario
     * @param event 
     */
    @FXML
    private void atras(ActionEvent event) {
        MainFX.getBack();
        apelidos.setText(null);
        nome.setText(null);
        dni.setText(null);
        aldea.setText(null);
        rua.setText(null);
        telefono.setText(null);
        email.setText(null);
        numero.setText(null);
    }
    
    /**
     * Engade o novo comuneiro no TreeMap da clase Comunidade
     * @param event 
     */
    @FXML
    private void altaComuneiro(ActionEvent event) {
        Direccion d=new Direccion(rua.getText(), aldea.getText(), numero.getText());
        Comuneiro c=new Comuneiro(nome.getText(), apelidos.getText(), dni.getText(), d, telefono.getText(), email.getText());
        Comunidade.engadeComuneiro(c);
        if(MainFX.isConnected()){
            BBDDCom.insertComuneiro(c);
        }
    }
    
    
    
}
