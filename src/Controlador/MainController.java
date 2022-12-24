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
import javafx.scene.control.MenuItem;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author DAW
 */
public class MainController implements Initializable {

    @FXML
    private MenuItem pecha;
    @FXML
    private MenuItem elimina;
    @FXML
    private MenuItem engade;
    @FXML
    private MenuItem acerca;
    @FXML
    private WebView web;
    @FXML
    private MenuItem pdf;
    @FXML
    private MenuItem busca;
    @FXML
    private MenuItem lista;
    @FXML
    private MenuItem novoMail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ExportaPdf(ActionEvent event) {
    }

    @FXML
    private void Imprime(ActionEvent event) {
    }

    @FXML
    private void pecha(ActionEvent event) {
    }

    @FXML
    private void busca(ActionEvent event) {
    }

    @FXML
    private void elimina(ActionEvent event) {
    }

    @FXML
    private void engade(ActionEvent event) {
    }

    @FXML
    private void lista(ActionEvent event) {
    }

    @FXML
    private void acerca(ActionEvent event) {
    }

    @FXML
    private void novoMail(ActionEvent event) {
    }
    
}
