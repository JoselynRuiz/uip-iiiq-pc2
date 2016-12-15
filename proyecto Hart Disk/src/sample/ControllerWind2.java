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
    @FXML
    private Button btn_regresar;
    @FXML
    private Label lbl_hd;
    @FXML
    private TextField txt_marca;
    @FXML
    private TextField txt_rpm;
    @FXML
    private TextField txt_tacceso;
    @FXML
    private TextField txt_capacidad;
    @FXML
    private Button btn_confirmar;
    @FXML
    private Button btn_resultado;

    //atributos
    private String marca;
    public int rpm; //Rotaciones por minuto.
    public double acceso;
    public double capacidad;
    public int puntaje=0;

    //Constantes
    private int puntos_rpm = 1;
    private int puntos_acceso = +200;
    private int puntos_capacidad = 500;

    final int MAX_HD = 5;

    //Variables
//    int totalPuntuacion = 0;
    int puntajeMedio = 0;

    Double mejor, peor;

    //Array de objetos
    Double hd[] = new Double[MAX_HD];

    int i = 0;

    /**
     * Metodo que se encarga de enviar la informacion introducida por el usuario a otra pantalla
     * @param actionEvent Parametro generado por el metodo enviar
     * @throws Exception Excepcion en caso de que el usuario introduzca un valor erroneo
     */
    public void enviar(ActionEvent actionEvent)throws Exception{

        for( i = 0;i<hd.length; i++) {

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

/*            //Calcular el mejor y el peor
            for(int i=0; i<hd.length; i++){

            puntaje += i.puntaje;

            if(hd[i].TotPuntuacion() < peor.TotPuntuacion()){
                peor = hd[i];
            }else if(hd[i].TotPuntuacion() > mejor.TotPuntuacion()){
                mejor = hd[i];
             }
            }
*/
            rpm += (int) (rpm * puntos_rpm);
            acceso += (int) (acceso * puntos_acceso);
            capacidad += (int) (capacidad * puntos_capacidad);
            puntaje = (int) (rpm + acceso + capacidad);


            puntajeMedio = puntaje/MAX_HD;


            Stage stage = (Stage) btn_confirmar.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("window3.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            ControllerWind3 contoller = fxmlLoader.<ControllerWind3>getController();
//        contoller.setResultado("\nPuntaje medio = " + puntajeMedio);
//        contoller.setResultado("\n*** Hard Disk mejor ***");
            contoller.setResultado("Hard disk marca: " + marca + ".\nRotaciones por minuto: " + rpm + ".\nTiempo de acceso: " + acceso + ".\nCapacidad: " + capacidad + ".\nPuntuacion final: " + puntaje);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }

            public void mostraLabel()
            {
                    lbl_hd.setText(String.valueOf(i+1));
            }

    /**
     * Metodo que se encarga de calcular el promedio
     */
    public void promedio_mejor_peor(){
                for( i = 0;i<hd.length; i++)
                {

                }
            }


            //Crea los Hard Disk y los lee


            public void leerDatos(int i) throws IOException{

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

    /**
     * Metodo que se encarga de limpiar los datos introducidos por el usuario
     */
    public void limpiar(){

        txt_marca.setText("");
        txt_rpm.setText("");
        txt_tacceso.setText("");
        txt_capacidad.setText("");

    }

    /**
     * Metodo que se encarga de salir del programa
     * @param actionEvent Parametro generado por el metodo salir
     */
    public void salir(ActionEvent actionEvent) {

        Platform.exit();
    }

    /**
     * Meotodo que se encarga de cambiar de una pantalla a otra
     * @param actionEvent Parametro generado por el metodo cambiar_pantalla
     * @throws IOException Excepcion en caso de que se produzca un error
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
     * Metodo que se encarga de guardar la informacion en in File(archivo)
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
            bw.write("Marca: " + marca + ";\r\n Rotaciones por minuto: "+ rpm + ";\r\n Tiempo de acceso: "+ acceso +";\r\n Capacidad: " + capacidad +";\r\n Puntuacion final: "+ puntaje);
            bw.write("\n");
            bw.close();
        } catch (IOException e){
            System.out.println("Problema con el escritor...");
        }
    }

    public int TotPuntuacion(){
        int punt = 0;
        punt += (int) (rpm * puntos_rpm);
        punt += (int) (acceso * puntos_rpm);
        punt += (int) (capacidad * puntos_rpm);

        return punt;
    }

/*    public void mostrarDatos(){
        System.out.println("Marca = " +marca);
        System.out.println("Velocidad = " +rpm +" (rpm)");
        System.out.println("Tiempo de acceso = " +acceso+" (ms)");
        System.out.println("Capacidad = " +capacidad+" (Gb)");
        System.out.println("Puntuacion = " +TotPuntuacion());
    }
*/

/*
//Clase
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

        mejor.mostrarDatos();
        peor.mostrarDatos();

    }*/

}