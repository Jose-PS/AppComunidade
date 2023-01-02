/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

import Modelo.Comunidade;
import Vista.MainFX;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author Jose PS
 */
public class QRController implements Initializable {

    @FXML
    private TextField lector;
    @FXML
    private TextFlow panelLectura;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lector.requestFocus();
    }    

    
    /**
     * Volve o menu principal.
     * @param event 
     */
    @FXML
    private void atras(ActionEvent event) {
        MainFX.getBack();
    }

    
    /**
     * Encargarase de recoller os datos do TextField e mostrar a info dese usuario no TextFlow.
     * @param event 
     */
    @FXML
    private void mostraLectura(InputMethodEvent event) {
       
    }
    
}
