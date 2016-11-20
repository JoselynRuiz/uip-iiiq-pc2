/*Tarea3.
Hacer un programa que maneje mascotas. Usted puede elegir si tiene un perro o un gato.
Todas las mascotas tienen nombre, puntos de vida y ejecutan acciones, especificamente
de esta manera:
- El perro tiene 50 puntos de vida y puede ladrar (-2), comer(+10) y correr (-15).
- El gato tiene 30 puntos de vida y puede dormir(+2), comer(+5) y caminar.
Cuando elija su mascota ud elije las acciones que realizar. Puede salir del programa
cuando muera la mascota o cuando lo desee el usario. Independiente mente del caso se
deben guardar el nombre de la mascota y los pts de vida en un archivo.
 */
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.*;


public class Mascotas {

    public static void main(String[] args) throws IOException {
        // write your code here

        String nombrep = "", nombreg = "";
        String archivo1 = "nombre y pts.txt";
        int ptvidap = 50, ptvidag = 30;
        int mascota = 0;
        int eligeaccionperro = 0, eligeacciongato = 0;
        int pregunta = 1;
        BufferedReader t1 = new BufferedReader(new InputStreamReader(System.in));

        Perro mascota1 = new Perro(nombrep,ptvidap,eligeaccionperro);
        Gato mascota2 = new Gato(nombreg,ptvidag,eligeacciongato);

        while (pregunta == 1)
        {
            try {
                System.out.println("Elige tu mascota: ");
                System.out.println("1)Perro.");
                System.out.println("2)Gato.");
                mascota = Integer.parseInt(t1.readLine());
            } catch (Exception e) {
                System.out.print("Error. Valor invalido");
            }

//MENU 1 PARA ELEGIR EL NOMBRE DEL ANIMAL

            switch (mascota) {

                case 1:
                    try {
                        System.out.println("Felicidades. Has elegido un perro!!");
                        System.out.println("Como deseas llamar a tu perro? ");
                        nombrep = t1.readLine();
                        mascota1.setNombre(nombrep);
                    } catch (Exception e) {
                        System.out.print("Error. Valor invalido.");
                    }
                    System.out.println("Tu perro se llama: " + mascota1.getNombre());
                    System.out.println("Tu perro tiene "+ mascota1.getPvida() +" pts. de vida ");
                    //MENU INTERNO PARA ELEGIR LA ACCION DEL PERRO
                    do {
                        System.out.println();
                        System.out.println("Elige una accion para tu perro "+mascota1.getNombre()+" :");
                        System.out.println("1)Ladrar.");
                        System.out.println("2)Comer.");
                        System.out.println("3)Correr.");
                        System.out.println("4)Salir.");
                        eligeaccionperro = Integer.parseInt(t1.readLine());
                        switch (eligeaccionperro) {

                            case 1:
                                mascota1.Ladrar(2);
                                System.out.println("La vida de tu perro " + mascota1.getNombre() + " es: " + mascota1.getPvida());
                                break;

                            case 2:
                                System.out.println("La vida de tu perro " + mascota1.getNombre() + " es: " + mascota1.Comer());
                                break;

                            case 3:
                                System.out.println("La vida de tu perro " + mascota1.getNombre() + " es: " + mascota1.Correr());
                                break;

                            case 4:
                                System.out.println("Saliendo del juego.");
                                break;

                            default:
                                System.out.println("Error. Vuelve a elegir la accion del perro por favor.");
                                break;

                        }
                    } while (eligeaccionperro != 4 && mascota1.getPvida() > 0);
                    try {
                        File f = new File(archivo1);
                        f.createNewFile();
                        FileWriter fw = new FileWriter(archivo1, true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write(mascota1.getNombre() + " , " + mascota1.getPvida());
                        bw.newLine();
                        bw.flush();
                    } catch (IOException e) {
                        System.out.println("Problema de lectura-escritura");
                    }
                    System.out.println("Lo sentimos. " + mascota1.getNombre() + " ha muerto.");
                    System.out.println("Vuelve a jugar!");
                    break;

                case 2:
                    try {
                        System.out.println("Felicidades. Has elegido un gato!!");
                        System.out.println("Como deseas llamar a tu gato? ");
                        nombreg = t1.readLine();
                        mascota2.setNombre(nombreg);
                    } catch (Exception e) {
                        System.out.print("Error. Valor invalido");
                    }
                    System.out.println("Tu gato se llama: "+mascota2.getNombre());          //Aqui se usa el metodo constructor para mostrar la info del gato
                    System.out.println("Tu gato tiene "+ mascota2.getPvida() +" pts. de vida ");
                    //MENU INTERNO PARA ELEGIR LA ACCION DEL GATO
                    do {
                        System.out.println();
                        System.out.println("Elige una accion para tu gato "+mascota2.getNombre()+":");
                        System.out.println("1)Dormir.");
                        System.out.println("2)Comer.");
                        System.out.println("3)Caminar.");
                        System.out.println("4)Salir.");
                        eligeacciongato = Integer.parseInt(t1.readLine());
                        switch (eligeacciongato) {
                            case 1:
                                System.out.println("La vida de tu gato " + mascota2.getNombre() + " es: " + mascota2.Dormir());
                                break;

                            case 2:
                                System.out.println("La vida de tu gato " + mascota2.getNombre() + " es: " + mascota2.Comer());
                                break;

                            case 3:
                                System.out.println("La vida de tu gato " + mascota2.getNombre() + " es: " + mascota2.Caminar());
                                break;

                            case 4:
                                System.out.println("Saliendo del juego.");
                                break;

                            default:
                                System.out.println("Intenta de nuevo. ");
                                break;
                        }

                    } while (eligeacciongato != 4 && mascota2.getPvida()>0);

                    try {
                        File f = new File(archivo1);
                        f.createNewFile();
                        FileWriter fw = new FileWriter(archivo1, true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write(mascota2.getNombre() + " , " + mascota2.getPvida());
                        bw.newLine();
                        bw.flush();
                    } catch (IOException e) {
                        System.out.println("Problema de lectura-escritura");
                    }
                    System.out.println("Lo sentimos. " + mascota2.getNombre() + " ha muerto.");
                    System.out.println("Vuelve a jugar!");
                    break;

                default:
                    System.out.println("Error. Vuelve a elegir una mascota.");
                    break;
            }
            System.out.println();
            System.out.println("Quieres tener una nueva mascota? 1)Si. 0)No.");
            pregunta = Integer.parseInt(t1.readLine());
        }

        System.out.println("Arrivederci e buona serata!.");
    }
}
