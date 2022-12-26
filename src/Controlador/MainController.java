/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

import Vista.MainFX;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
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
    private Pane alta;
    private Pane correo;
    private Pane lectorQR;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            tipo.setItems(FXCollections.observableArrayList("Selecciona opcion", new Separator(),
                    "Por Nome", "Por Aldea", "Por Numero")
            );
            tipo.getSelectionModel().select(0);
            alta=FXMLLoader.load(this.getClass().getResource("/Vista/Alta.fxml"));
            correo=FXMLLoader.load(this.getClass().getResource("/Vista/Mail.fxml"));
            //lectorQR=FXMLLoader.load(this.getClass().getResource("/Vista/AccesoQR.fxml"));
            tipo.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue ov, Number t, Number t1) {
                    tipoc= t1.intValue();
                }
            });
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    

    @FXML
    private void alta(ActionEvent event) {
        MainFX.switchPane(alta);
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
        MainFX.switchPane(lectorQR);
    }

    @FXML
    private void novoMail(ActionEvent event) {
        MainFX.switchPane(correo);
    }

    @FXML
    private void sair(ActionEvent event) {
        System.exit(0);
    }
    
}
