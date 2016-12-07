package Ejercicio2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Ejercicio2 {

    private Scanner entrada;

    // permite al usuario abrir el archivo
    public void abrir_archivo() {
        try {
            entrada = new Scanner(new File("estudiantes.txt"));
        } // fin de try
        catch (FileNotFoundException filesNotFoundException) {
            System.err.println("Error al crear el archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del método abrir_archivo

    public void leer_informacion() {
        String a;
        boolean a1 = false, a2 = false, a3 = false, a4 = false, a5;
        try // lee registros del archivo, usando el objeto Scanner
        {
            while (entrada.hasNext()) {
                String linea = entrada.nextLine();

                ArrayList<String> linea_partes = new ArrayList<String>(Arrays.asList(linea.split("\\|")));
                for (int i = 0; i < linea_partes.size(); i++) {
                    a = linea_partes.get(i).substring(0, 1);
                    a1 = a.contains("A");
                    a2 = a.contains("B");
                    a3 = a.contains("C");
                    a4 = a.contains("E");
                    a5 = a.contains("U");
                    if (a1 == true || a2 == true || a3 == true || a4 == true || a5 == true) {
                        System.out.println(linea_partes.get(i));
                    }

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
