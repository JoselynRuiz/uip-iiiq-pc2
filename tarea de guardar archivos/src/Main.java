import java.io.*;

public class Main {

    public static void main(String[] args) {

        String nombre="",archivo1 = "velocidades.txt", archivo2 = "Nombreymulta.txt";;
        int n=0, i;
        double maxm=0, promedio1=0, sumK=0, totmulta=0;

        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingresa tu nombre: ");
        try {
            nombre = teclado.readLine();
        }catch (Exception e){
            System.out.println("Error. Valor invalido.");
        }

        System.out.println("Introduzca la cantidad de velocidades: ");

        try {
            n= Integer.parseInt(teclado.readLine());
            File f1 = new File(archivo1);
            f1.createNewFile();
        } catch (IOException e) {
            System.out.println("Error");
        }

        double v1[]= new double[n];
        double v2[]= new double[n];

        for(i=0;i<n;i++)
        {
            System.out.println("Ingresa la velocidad "+i+": ");
            try{
                v1[i]= Double.parseDouble(teclado.readLine());
                if(v1[i]>maxm)
                {
                   maxm = v1[i];

                }

                FileWriter fw = new FileWriter(archivo1, true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(Double.toString(v1[i]));
                bw.newLine();
                bw.flush();
            } catch (IOException e) {
                System.out.println("Error");
            }
     }

        System.out.println();
        for(i=0;i<n;i++)
       {
           v2[i]= v1[i];

            if(v2[i] >= 120 && v2[i] < 160)
            {
                totmulta= totmulta+50;

            }else if (v2[i] >= 160)
            {
                totmulta= totmulta+150;
            }

            System.out.println();
            sumK= sumK+v2[i];
            promedio1 = (sumK/n);

        }
        try {
            File f = new File(archivo2);
            f.createNewFile();
            FileWriter fw = new FileWriter(archivo2, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(nombre + "," + Double.toString(totmulta));
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            System.out.println("Error");
        }

        System.out.println("\n");
        System.out.println("REPORTE DE TRANSITO: ");
        System.out.println("Nombre: "+ nombre);
        System.out.println("La suma de las velocidades es: "+ sumK);
        System.out.println("Velocidad promedio: "+ promedio1);
        System.out.println("Multa total: "+ totmulta);

    }
}