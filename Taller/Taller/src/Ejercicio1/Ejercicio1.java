package Ejercicio1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Ejercicio1 {

    // objeto usado para enviar texto al archivo
    private Scanner entrada;

    // permite al usuario abrir el archivo
    public void abrir_archivo() {
        try {
            entrada = new Scanner(new File("paises.txt"));
        } // fin de try
        catch (FileNotFoundException filesNotFoundException) {
            System.err.println("Error al crear el archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del método abrir_archivo

    public void leer_informacion() {
        boolean verificar;
        boolean verificar1;
        try // lee registros del archivo, usando el objeto Scanner
        {
            while (entrada.hasNext()) {
                String linea = entrada.nextLine();

                ArrayList<String> linea_partes = new ArrayList<String>(Arrays.asList(linea.split(",")));

                verificar = linea_partes.get(0).contains("u");
                verificar1 = linea_partes.get(0).contains("U");
                if (verificar == true || verificar1 == true) {
                    System.out.println("Pais:" + linea_partes.get(0) + "\tPais en Ingles:"
                            + linea_partes.get(1) + "\n");

                }

            }
        } // fin de try
        catch (NoSuchElementException elementException) {
            System.err.println("El archivo no esta bien formado.");
            entrada.close();
            System.exit(1);
        } // fin de catch
        catch (IllegalStateException stateException) {
            System.err.println("Error al leer del archivo.");
            System.exit(1);
        } // fin de catch
    }

    // cierra el arrchivo
    public void cerrar_archivo() {
        if (entrada != null) {
            entrada.close();
        }
    }
}
