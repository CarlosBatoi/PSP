package es.cipfpbatoi.psp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
         try {
        int numero = (int) (Math.random() * 10 + 1);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Si no introduces la palabra stop,genero un numero aletaotrio de 0 a 10 : ");
        String cadena = br.readLine();

        while (!cadena.equals("stop")) {

            System.out.println(numero);
            System.out.print("Si no introduces la palabra stop,genero un numero aletaotrio de 0 a 10 : ");
            cadena = br.readLine();

        }

        if (cadena.equals("stop")) {

            br.close();
        }


    } catch (Exception e) {
    }



    }
    }

