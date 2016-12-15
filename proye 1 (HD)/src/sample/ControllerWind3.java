package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

//import java.io.*;

public class ControllerWind3 {

    @FXML private Button btn_regresar;
    @FXML private TextArea txtarea_result;
//    @FXML private Button btn_guardar;


    //atributos
    private String marca;
    private int rpm; //Revoluciones por segundo.
    private double acceso;
    private double capacidad;
    private int puntuacionfinal;

    private int puntos_rpm = 1;
    private int puntos_acceso =+200;
    private int puntos_capacidad = 500;


    /**
     * Metodo que se encarga de salir del programa
     * @param actionEvent Parametro generado por el metodo salir
     */
    public void salir(ActionEvent actionEvent) {

        Platform.exit();
    }

    /**
     * Metodo que se encarga de cambiar de una pantalla a otra
     * @param actionEvent Parametro generado por el metodo cambiar pantalla
     * @throws IOException Excepcion en caso de que se cometa un error
     */
    public void cambiar_pantalla(ActionEvent actionEvent) throws IOException {

        Stage stage;
        Parent root;
        if (actionEvent.getSource() == btn_regresar) {
            stage = (Stage) btn_regresar.getScene().getWindow();
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);

            alerta.setTitle("Ventana de informacion");
            alerta.setHeaderText("Bien, regresaremos a la pantalla 2.");
            alerta.setContentText("Asi' podras ingresa nuevos datos.");
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
            alerta.setTitle("Information Importante");
            alerta.setHeaderText("No me vas a ignorar");
            alerta.setContentText("Vas a cambiar de pantalla");
            Optional<ButtonType> resultado = alerta.showAndWait();
            if (resultado.get() == ButtonType.OK){
                root = FXMLLoader.load(getClass().getResource("window1.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }
    }

    /**
     * Metodo que se encarga de dar el resultado
     * @param r Parametro que indica el resultado
     */
    public void setResultado(String r){

        txtarea_result.setText(r);

    }

    /**
     * Metodo que se encarga de guardar la informacion que ingresa en usuario en un File(archivo?
     * @param actionEvent Parametro generado por el metodo guardar
     * @throws IOException Excepcion en caso de que se cometa un error
     */
    public void guardar(ActionEvent actionEvent)throws IOException {

        File archivo = new File("archivo.txt");
        FileWriter fw = new FileWriter(archivo.getAbsoluteFile(), true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(txtarea_result.getText()+"\n");
        bw.write("\n\n");
        bw.close();

    }

/*    public int TotPuntuacion(){
        int punt =0;
        punt += (int) (rpm * puntos_rpm);
        punt += (int) (acceso * puntos_rpm);
        punt += (int) (capacidad * puntos_rpm);

        return punt;
    }*/



}