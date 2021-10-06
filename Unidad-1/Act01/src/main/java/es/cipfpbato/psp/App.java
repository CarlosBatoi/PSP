package es.cipfpbato.psp;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) throws IOException {
        if (args.length <= 0) {
            System.err.println("Ha ocurrido un error al ejecutar el proceso.\n Necesito un argumento o comando  para poder ejecutar el proceso");
            System.exit(-1);

        }
        ArrayList<String> arrayArgumentos = new ArrayList<>(Arrays.asList(args));
        try {
            Process hijo = new ProcessBuilder(arrayArgumentos).start();
            TimeUnit.SECONDS.sleep(2);
            InputStream is = hijo.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            System.out.println("Print de proceso hijo " + arrayArgumentos + ":");
            System.out.println("  ");
            String brLine = br.readLine();

            //Creamos un la ruta del archivo
            String ruta = "output.txt";

            //asingamos un a variable string a linea
            String contenido = brLine;
            //creamos el archivo
            File file = new File(ruta);

            //si el archivo no existe lo creamos
            if (!file.exists()) {
                file.createNewFile();
            }
            // le indicamos donde queremos escrbirir los datos
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            //mientras el archivo tenga lineas
            while ((brLine = br.readLine()) != null) {
                //imprimo las lineas
                System.out.println(brLine);
                // las escribo en el archivo
                bw.write("\n" + brLine);

            }
            // cuando finalice la esctriura, cerramos el archivo output.txt
            bw.close();

        } catch
        (IOException | InterruptedException ex) {
            System.err.println("IO exception!");
            System.exit(-1);
        }


    }
}