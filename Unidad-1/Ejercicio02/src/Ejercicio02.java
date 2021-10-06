import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Ejercicio02 {
    public static void main(String[] args) throws IOException {

        String comando = ("java -jar /home/carlos/Escritorio/Dam-Segundo-Año/PSP/Repositorios/Unidad-1/Random-10/target/Random10-1.0-SNAPSHOT.jar");
        List<String> argList = new ArrayList<>(Arrays.asList(comando));
        ProcessBuilder pb = new ProcessBuilder(comando.split(" "));

        Process random10 = pb.start();
        Scanner random10Scanner = new Scanner(random10.getInputStream());

        //envio de palabras al proceso
        OutputStream os = random10.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);

        Scanner sc = new Scanner(System.in);

        String linea = sc.nextLine();

        while (!linea.equals("stop")){
            // el buffer lee la linea
            bw.write(linea);
            // bw.newLine es para que salte de linea
            bw.newLine();
            //le decimos al bufer que escriba
            bw.flush();
            //aqui falta algo
            System.out.println(random10Scanner.nextLine());
        }

    }
}

