/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

import Vista.MainFX;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author DAW
 */
public class MainController implements Initializable {

    @FXML
    private ChoiceBox tipo;
    private int tipoc=0;
    @FXML
    private TextField busca;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tipo.setItems(FXCollections.observableArrayList("Selecciona opcion", new Separator(),
                "Por Nome", "Por Aldea", "Por Numero")
        );
        tipo.getSelectionModel().select(0);
        tipo.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue ov, Number t, Number t1) {
                tipoc= t1.intValue();
            }
        });
    }    
    

    @FXML
    private void alta(ActionEvent event) {
    }

    @FXML
    private void buscaComuneiros(ActionEvent event) {
    }


    @FXML
    private void listaComuneiros(ActionEvent event) {
    }

    @FXML
    private void exportaPdf(ActionEvent event) {
    }

    @FXML
    private void accesoQR(ActionEvent event) {
    }

    @FXML
    private void novoMail(ActionEvent event) {
    }

    @FXML
    private void sair(ActionEvent event) {
        System.exit(0);
    }
    
}
