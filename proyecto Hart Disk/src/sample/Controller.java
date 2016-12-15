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

    //atributos
    private String marca;
    public int rpm; //Rotaciones por minuto.
    public double acceso;
    public double capacidad;
    public int puntuacionfinal;

    //Constantes
    private int puntos_rpm = 1;
    private int puntos_acceso = +200;
    private int puntos_capacidad = 500;

    final int MAX_HD = 5;

    //Variables
    int totalPuntuacion = 0;
    int puntajeMedio = 0;

    Object mejor, peor;

    //Array de objetos
    Object hd[] = new Object[MAX_HD];

    int i = 0;

    /**
     * Metodo que se encarga de salir del programa
     * @param actionEvent Parametro generado por el metodo salir
     */
    public void salir(ActionEvent actionEvent) {

        Platform.exit();
    }

    /**
     * Metodo que se encarga de cambiar de una pantalla a otra
     * @param actionEvent Parametro generado por el boton siguiente y el metodo cambiar_pantalla
     * @throws IOException Excepcion en caso de que se produzca un error
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
    }

/*    public void promedio_mejor_peor(){

        //Crea los Hard Disk y los lee
        for( i = 0;i<hd.length; i++)
        {

            hd[i] = new ControllerWind3();

            try {
                marca = txt_marca.getText();
            } catch (Exception e) {
                System.err.println("El valor no es aceptado.");
                e.printStackTrace();
            }
            try {
                rpm = Integer.parseInt(txt_rpm.getText());
            } catch (NumberFormatException e) {
                System.err.println("No se puede convertir a numero");
                e.printStackTrace();
            }
            try {
                acceso = Double.parseDouble(txt_tacceso.getText());
            } catch (Exception e) {
                System.err.println("El valor no es aceptado.");
                e.printStackTrace();
            }
            try {
                capacidad = Double.parseDouble(txt_capacidad.getText());
            } catch (Exception e) {
                System.err.println("El valor no es aceptado.");
                e.printStackTrace();
            }
        }

        peor =hd[0];
        mejor =hd[0];


    }
*/


}