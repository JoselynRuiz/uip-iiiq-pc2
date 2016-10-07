import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        Double centavos, dolar, euro;


        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Introduzca cantidad de centavos:");
        centavos = Double.parseDouble(teclado.readLine());

        System.out.println("la cantidad de centavos es:" + centavos);

        dolar = centavos/100;
        euro = dolar*0.89;

        System.out.println("la cantidad en Dolares es " + dolar + "dolares");
        System.out.println("la cantidad de Euros es: " + euro + "euros");

        }
    }

