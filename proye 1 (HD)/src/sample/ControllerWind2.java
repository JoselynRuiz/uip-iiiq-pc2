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

public class ControllerWind2 {

//    @FXML private Button btn_siguiente;
    @FXML private Button btn_regresar;
    @FXML private Label lbl_hd;
    @FXML private TextField txt_marca;
    @FXML private TextField txt_rpm;
    @FXML private TextField txt_tacceso;
    @FXML private TextField txt_capacidad;
    @FXML private Button btn_confirmar;

    //atributos
    private String marca;
    private int rpm; //Revoluciones por minuto.
    private double acceso;
    private double capacidad;
    private int puntuacionfinal;

    private int puntos_rpm = 1;
    private int puntos_acceso =+200;
    private int puntos_capacidad = 500;

    public ControllerWind2() {
    }

    public void limpiar(){

        txt_marca.setText("");
        txt_rpm.setText("");
        txt_tacceso.setText("");
        txt_capacidad.setText("");

    }

    /**
     * Metodo para salir del programa
     * @param actionEvent Parametro generado por el metodo salir
     */
    public void salir(ActionEvent actionEvent) {

        Platform.exit();
    }

    /**
     * Metodo para cambiar de una pantalla a otra
     * @param actionEvent Parametro generado por el metodo cambiar_pantalla
     * @throws IOException Excepción en caso de que se presente un error
     */
    public void cambiar_pantalla(ActionEvent actionEvent) throws IOException {

        Stage stage;
        Parent root;
        if (actionEvent.getSource() == btn_regresar) {
            stage = (Stage) btn_regresar.getScene().getWindow();
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);

            alerta.setTitle("Ventana de information");
            alerta.setHeaderText("Hola, a continuacion:");
            alerta.setContentText("Vas a pasar a la 1ra pantalla");
            Optional<ButtonType> resultado = alerta.showAndWait();
            if (resultado.get() == ButtonType.OK) {
                root = FXMLLoader.load(getClass().getResource("window1.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }
         else {}
    }

    /**
     * Metodo para guardar la informacion que ingresa el usuario en un File(archivo)
     * @param actionEvent Parametro generado por el metodo guardar
     */
    public void guardar(ActionEvent actionEvent) {
        File archivo = new File("archivo.txt");
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
            } catch (IOException e) {
                System.out.println("Problema creando el file...");
            }
        }

        try{
            FileWriter fw = new FileWriter(archivo.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Marca: " + marca + ";\r\n Rotaciones por minuto: "+ rpm + ";\r\n Tiempo de acceso: "+ acceso +";\r\n Capacidad: " + capacidad +";\r\n Puntuacion final: "+ puntuacionfinal );
            bw.write("\n");
            bw.close();
        } catch (IOException e){
            System.out.println("Problema con el escritor...");
        }
    }

    /**
     * Metodo que se encarga de enviar la informacion que el usuario ingresa a una pantalla a otra
     * @param actionEvent Parametro generado por el metodo enviar
     * @throws Exception Excepción en caso de que el usuario cometa un error al introducir los datos
     */
    public void enviar(ActionEvent actionEvent)throws Exception{

        try {
            marca = txt_marca.getText();
        }
        catch (Exception e) {
            System.err.println("El valor no es aceptado.");
            e.printStackTrace();
        }
        try {
            rpm = Integer.parseInt(txt_rpm.getText());
        }
        catch (NumberFormatException e) {
            System.err.println("No se puede convertir a numero");
            e.printStackTrace();
        }
        try {
            acceso = Double.parseDouble(txt_tacceso.getText());
        }
        catch (Exception e) {
            System.err.println("El valor no es aceptado.");
            e.printStackTrace();
        }
        try {
            capacidad = Double.parseDouble(txt_capacidad.getText());
        }
        catch (Exception e) {
            System.err.println("El valor no es aceptado.");
            e.printStackTrace();
        }

        rpm += (int) (rpm * puntos_rpm);
        acceso += (int) (acceso * puntos_acceso);
        capacidad += (int) (capacidad * puntos_capacidad);
        puntuacionfinal = (int) (rpm + acceso + capacidad);

        Stage stage = (Stage) btn_confirmar.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("window3.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        ControllerWind3 contoller = fxmlLoader.<ControllerWind3>getController();
        contoller.setResultado("Hard disk marca: " + marca +".\nRotaciones por minuto: " + rpm + ".\nTiempo de acceso: "+ acceso +".\nCapacidad: "+capacidad+".\nPuntuacion final: "+puntuacionfinal);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


/*    public void leerDatos(int i) throws IOException{

        try {
            marca = txt_marca.getText();
        }
        catch (Exception e) {
            System.err.println("El valor no es aceptado.");
            e.printStackTrace();
        }
        try {
            rpm = Integer.parseInt(txt_rpm.getText());
        }
        catch (NumberFormatException e) {
            System.err.println("No se puede convertir a numero");
            e.printStackTrace();
        }
        try {
            acceso = Double.parseDouble(txt_tacceso.getText());
        }
        catch (Exception e) {
            System.err.println("El valor no es aceptado.");
            e.printStackTrace();
        }
        try {
            capacidad = Double.parseDouble(txt_capacidad.getText());
        }
        catch (Exception e) {
            System.err.println("El valor no es aceptado.");
            e.printStackTrace();
        }

    }*/

    /**
     * Metodo que convierte los puntos
     * @return punt
     */
    public int TotPuntuacion(){
        int punt = 0;
        punt += (int) (rpm * puntos_rpm);
        punt += (int) (acceso * puntos_rpm);
        punt += (int) (capacidad * puntos_rpm);

        return punt;
    }

    /**
     * Metodo que se encarga de mostrar los datos ingresados por el ususario
     */
    public void mostrarDatos(){
        System.out.println("Marca = " +marca);
        System.out.println("Velocidad = " +rpm +" (rpm)");
        System.out.println("Tiempo de acceso = " +acceso+" (ms)");
        System.out.println("Capacidad = " +capacidad+" (Gb)");
        System.out.println("Puntuacion = " +TotPuntuacion());
    }

    /*
//Clase HD
    public void HardDisk()throws IOException{

        //Constante
        final int MAX_HD= 5;

        //variables
        int totalPuntuacion = 0;
        int puntajeMedio = 0;

        //Objetos
        ControllerWind3 peor, mejor;

        //Array de objetos
        ControllerWind3 hd[] = new ControllerWind3[MAX_HD];

        //Crea los Hard Disk y los lee
        for(int i=0; i<hd.length; i++){

            hd[i] = new ControllerWind3();

            try {
                marca = txt_marca.getText();
            }
            catch (Exception e) {
                System.err.println("El valor no es aceptado.");
                e.printStackTrace();
            }
            try {
                rpm = Integer.parseInt(txt_rpm.getText());
            }
            catch (NumberFormatException e) {
                System.err.println("No se puede convertir a numero");
                e.printStackTrace();
            }
            try {
                acceso = Double.parseDouble(txt_tacceso.getText());
            }
            catch (Exception e) {
                System.err.println("El valor no es aceptado.");
                e.printStackTrace();
            }
            try {
                capacidad = Double.parseDouble(txt_capacidad.getText());
            }
            catch (Exception e) {
                System.err.println("El valor no es aceptado.");
                e.printStackTrace();
            }
        }

        peor = hd[0];
        mejor = hd[0];

        //Calcular el mejor y el peor
        for(int i=0; i<hd.length; i++){
            totalPuntuacion += hd[i].TotPuntuacion();

            if(hd[i].TotPuntuacion() < peor.TotPuntuacion()){
                peor = hd[i];
            }else if(hd[i].TotPuntuacion() > mejor.TotPuntuacion()){
                mejor = hd[i];
            }
        }
        puntajeMedio = totalPuntuacion/MAX_HD;

    }*/



}