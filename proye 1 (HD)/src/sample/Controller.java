package sample;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
//import java.io.*;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

public class Controller {

    @FXML private Button btn_siguiente;
    @FXML public Button btn_regresar;

    /**
     * Metodo con la función de salir del programa
     * @param actionEvent Parametro generado por el metodo salir
     */
    public void salir(ActionEvent actionEvent) {

        Platform.exit();
    }

    /**
     * Metodo para cambiar de una pantalla a otra
     * @param actionEvent Parametro generado por el metodo cambiar_pantalla
     * @throws IOException Excepcion en de que se presente un error
     */
    public void cambiar_pantalla(ActionEvent actionEvent) throws IOException {
        Stage stage;
        Parent root;
        if (actionEvent.getSource() == btn_siguiente) {
            stage = (Stage) btn_siguiente.getScene().getWindow();
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);

            alerta.setTitle("Ventana de informacion");
            alerta.setHeaderText("sigamos..");
            alerta.setContentText("Vamos a cambiar a la segunda pantalla");
            Optional<ButtonType> resultado = alerta.showAndWait();
            if (resultado.get() == ButtonType.OK) {
                root = FXMLLoader.load(getClass().getResource("window2.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        } else {
            stage = (Stage) btn_regresar.getScene().getWindow();
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);  //Cambiar icono ej WARNING.
            alerta.setTitle("Ventana de informacion");
            alerta.setHeaderText("Ahora..");
            alerta.setContentText("Vas a cambiar a la pantalla inicial");
            Optional<ButtonType> resultado = alerta.showAndWait();
            if (resultado.get() == ButtonType.OK){
                root = FXMLLoader.load(getClass().getResource("window1.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
           }
        }

/*        Stage stage = (Stage) btn_siguiente.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("window2.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
*/
    }



}