/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

import Datos.ComDB;
import Modelo.Comuneiro;
import Modelo.Comunidade;
import Vista.MainFX;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import org.mariadb.jdbc.Connection;

/**
 * FXML Controller class
 *
 * @author Jose PS
 */
public class MainController implements Initializable {

    private static ArrayList<Comuneiro> busqueda = new ArrayList<>();
    private static ArrayList<Comuneiro> lista = new ArrayList<>();
    @FXML
    private ChoiceBox tipo;
    private int tipoc = 0;
    @FXML
    private TextField busca;
    private Pane alta;
    private Pane correo;
    private Pane accesoQR;
    private Pane listado;
    private Pane buscar;
    private Pane axustes;

    /**
     * Aqui cargamos os fxml pra despois usar esas variables nos metodos de
     * navegacion. Aparte tamen definimos o menu desplegable (ChoiceBox) de
     * busqueda ou listado.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            tipo.setItems(FXCollections.observableArrayList("Selecciona opcion", new Separator(),
                    "Por Nome", "Por Aldea", "Por Numero")
            );
            tipo.getSelectionModel().select(0);
            axustes = FXMLLoader.load(this.getClass().getResource("/Vista/Axustes.fxml"));
            listado = FXMLLoader.load(this.getClass().getResource("/Vista/Listado.fxml"));
            alta = FXMLLoader.load(this.getClass().getResource("/Vista/Alta.fxml"));
            correo = FXMLLoader.load(this.getClass().getResource("/Vista/Mail.fxml"));
            accesoQR = FXMLLoader.load(this.getClass().getResource("/Vista/Acceso.fxml"));
            buscar = FXMLLoader.load(this.getClass().getResource("/Vista/Busca.fxml"));

            tipo.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue ov, Number t, Number t1) {
                    tipoc = t1.intValue();
                }
            });
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
     *Metodo pra o boton de alta no menu principal, cambia o panel lateral para a seccion de alta.
     */
    @FXML
    private void alta(ActionEvent event) {
        MainFX.switchPane(alta);
    }

    /*
    *Fai a busqueda de comuneiros polo criterio que se seleccione e mostra os resultados en un webView
    *Cada comuneiro tera a opcion de editar ou eliminar.
     */
    @FXML
    private void buscaComuneiros(ActionEvent event) {
        MainFX.switchPane(buscar);
        if (MainFX.isConnected()) {
            switch (tipoc) {
                case 2 ->
                    busqueda = ComDB.buscaNome(busca.getText());
                case 3 ->
                    busqueda = ComDB.buscaAldea(busca.getText());
                case 4 ->
                    busqueda = ComDB.buscaNumero(busca.getText());
            }
        } else {
            switch (tipoc) {
                case 2 ->
                    busqueda = Comunidade.buscaNome(busca.getText());
                case 3 ->
                    busqueda = Comunidade.buscaAldea(busca.getText());
                case 4 ->
                    busqueda = Comunidade.buscaNumero(Integer.parseInt(busca.getText()));
            }
        }
    }

    /**
     * Getter pra obter a busqueda dende as outras clases.
     *
     * @return
     */
    public static ArrayList<Comuneiro> getBusqueda() {
        return busqueda;
    }

    /*
    *Lista os comuneiros polo criterio que se seleccione e mostra resultados nun webView
     */
    @FXML
    private void listaComuneiros(ActionEvent event) {
        MainFX.switchPane(listado);
        if (MainFX.isConnected()) {
            switch (tipoc) {
                case 2 ->
                    lista = ComDB.listaNome();
                case 3 ->
                    lista = ComDB.listaAldea();
                case 4 ->
                    lista = ComDB.listaNumero();
            }
        } else {
            switch (tipoc) {
                case 2 ->
                    lista = Comunidade.listaNome();
                case 3 ->
                    lista = Comunidade.listaAldea();
                case 4 ->
                    lista = Comunidade.listaNumero();
            }
        }
    }

    /**
     * Getter pra obter o listado dende as outras clases.
     *
     * @return
     */
    public static ArrayList<Comuneiro> getLista() {
        return lista;
    }

    /*
    *Abre o panel de lectura de codigos QR para as reunions.
     */
    @FXML
    private void accesoQR(ActionEvent event) {
        MainFX.switchPane(accesoQR);
    }

    /*
    *Encargase de imprimir o enderezo de cada comuneiro nun sobre para enviar por correo.
     */
    @FXML
    private void imprimeSobres() {

    }

    /*
    *Abre o panel de edicion de email pra xerar correos automaticamente.
     */
    @FXML
    private void novoMail(ActionEvent event) {
        MainFX.switchPane(correo);
    }

    /*
    *Boton de pechar a aplicacion.
     */
    @FXML
    private void sair(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void axustes(ActionEvent event) {
        MainFX.switchPane(axustes);
    }

}
