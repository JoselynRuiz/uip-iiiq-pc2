/*Ejercicio:
-Leer un numero; -Leer de forma indefinida n velocidades mh. Guardad lista. -Convertirlas en Kmh. Guardad otra lista.
-Validar, si la velocidad (en km/h) es mayor que 80 entonces multa de $50, si es mayor que 120 entonces multa de 150 -Imprimir:
Reporte de Transito
Nombre: pinco pallino
Velocidad màxima:  km/h
Velocidad prmedio:  km/h
Multa total: $0.00 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.Double;
//import java.io.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String nombre="";
        int n=0, i, multa1=0, multa2=0;
        double maxm=0, maxk=0, promedio1=0, sumK=0, totmulta=0, sumM=0;

        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingresa tu nombre: ");

        do{
            try {
                nombre = teclado.readLine();
            }catch (Exception e){
                System.out.println("Error. Valor invalido.");
            }
        }while (nombre.matches(".*\\d+.*")); //ningun numero puede estar en la cadena.

        System.out.println("Ingrese la cantidad de elementos de la lista: ");
        try{
            n= Integer.parseInt(teclado.readLine());
        }catch (Exception e){
            System.out.println("E' stato commesso un errore");
        }
        double v1[]= new double[n];
        double v2[]= new double[n];

        for(i=0;i<n;i++)
        {
            System.out.println("Ingresa los valores de las millas en la posicion "+i+" de la lista: ");
            try{
                v1[i]= Double.parseDouble(teclado.readLine());
                if(v1[i]>maxm)
                {
                    maxm = v1[i]; //Mayor en millas
                    maxk = maxm * 1.609; //Mayor en km
                }

            }catch (Exception e){
                System.out.println("Error, valor incorrecto");
            }
        }

        System.out.println();
        for(i=0;i<n;i++)
        {
            v2[i]= v1[i] * 1.609;   // Tranforma la lista de millas a kilometros
            System.out.println("Millas por hora: "+ v1[i] +"; Kilometros por hora: " +v2[i]);
            if(v2[i] > 80 && v2[i] <= 120)
            {
                System.out.println("Velocidad: "+v2[i]+"km. Se aplica multa de $50");
                totmulta= 50;
            }else if (v2[i] > 120)
            {
                System.out.println("Velocidad: "+v2[i]+"km. Se aplica multa de $150");
                totmulta= 150;
            }

            System.out.println();
            sumK= sumK+v2[i];       //Suma de las velocidades en Kilometros
            promedio1 = (sumK/n);   //Promedio en kilometros

        }

        System.out.println("\n");
        System.out.println("REPORTE DE TRANSITO: ");
        System.out.println("Nombre: "+ nombre);
        System.out.println("Velocidad maxima (km): "+ maxk);
        System.out.println("La suma de las velocidades es (km): "+ sumK);
        System.out.println("Velocidad promedio (km): "+ promedio1);
        System.out.println("Multa total: "+ totmulta);

    }
}