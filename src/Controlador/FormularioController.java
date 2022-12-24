/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author DAW
 */
public class FormularioController implements Initializable {

    @FXML
    private Pane paneb;
    @FXML
    private Button busca;
    @FXML
    private ChoiceBox<?> opcion;
    @FXML
    private TextField param;
    @FXML
    private ScrollPane pane;
    @FXML
    private WebView web;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void busca(ActionEvent event) {
    }
    
}
