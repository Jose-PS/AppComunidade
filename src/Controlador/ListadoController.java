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
import javafx.scene.text.TextFlow;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author Jose PS
 */
public class ListadoController implements Initializable {

    @FXML
    private TextFlow listado;


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
    private void exportaPdf(ActionEvent event) {
    }

    @FXML
    private void imprimeListado(ActionEvent event) {
    }
    
}
