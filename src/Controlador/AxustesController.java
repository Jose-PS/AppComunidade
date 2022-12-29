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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

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

    File arquivo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        explorador.setOnAction((ActionEvent event) -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Buscar Arquivo");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Todo", "*.*"),
                    new FileChooser.ExtensionFilter("DAT", "*.dat"),
                    new FileChooser.ExtensionFilter("CSV", "*.csv")
            );

            arquivo = fileChooser.showOpenDialog(null);
        });

    }

    @FXML
    private void atras(ActionEvent event) {
        MainFX.getBack();
    }

    @FXML
    private void gardaConf(ActionEvent event) {
    }

}
