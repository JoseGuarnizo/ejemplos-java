
package Ejercicio3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Ejercicio3 {
    private Scanner entrada;
    String nombre;
    String apellido;
    int edad;

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
        String a1 = null;
        int c;
        try // lee registros del archivo, usando el objeto Scanner
        {
            ArchivoNuevo nuevo = new ArchivoNuevo();
            nuevo.abrir_archivo();
            while (entrada.hasNext()) {
                String linea = entrada.nextLine();
                ArrayList<String> linea_partes = new ArrayList<String>(Arrays.asList(linea.split("\\|")));
                nombre=linea_partes.get(0);
                apellido=linea_partes.get(1);
                String anio=linea_partes.get(2);
                int an=Integer.parseInt(anio);
                edad=0;
                edad = (2016 - an);
                
                String [] nom= nombre.split("\\ ");
                String [] ape= apellido.split("\\ ");
                linea_partes.remove(2);
                String cu = Integer.toString(edad);
                linea_partes.add(2, cu);
                nuevo.agregar_informacion(linea_partes);
            }
            nuevo.cerrar_archivo();
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
