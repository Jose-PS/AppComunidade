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

/**
 * FXML Controller class
 *
 * @author Jose PS
 */
public class BuscaController implements Initializable {

    @FXML
    private TextFlow resultados;

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
    private void modifica(ActionEvent event) {
    }

    @FXML
    private void elimina(ActionEvent event) {
    }
    
}
