
package Archivos2;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public class Archivos2 {
    private Scanner entrada;

    // permite al usuario abrir el archivo
    public void abrirArchivo() {
        try {
            entrada = new Scanner(new File("Calificaciones.txt"));
        } // fin de try
        catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error al abrir el archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del método abrirArchivo

    // lee registro del archivo
    public void leer_informacion() {
        
        double suma=0;
        double suma1=0;
        double suma2=0;
        double promedio[]= new double[4];
        double pf=0;
        int a=0;
        double al=0;
        
        try // lee registros del archivo, usando el objeto Scanner
        {
            while (entrada.hasNext()) {
                String linea = entrada.nextLine();
                
                ArrayList<String> linea_partes = new ArrayList<String>(Arrays.asList(linea.split(";")));
                System.out.println(linea_partes);
                
                for (int i = 2; i <linea_partes.size()-1; i++) {
                    a=0;
                    promedio[a]=0;
                    promedio[a]=(Double.parseDouble(linea_partes.get(i))+Double.parseDouble(linea_partes.get(i+1)))/2;
                    System.out.printf("promedio es %f\n",promedio[a]);
                    
                    if (al<promedio[a]) {
                        al=promedio[a];
                    }
                    a=a+1;
                }

            }
            System.out.println("Promedio mas alto:"+al);// fin de while
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
    } // fin del metodo leerRegistros
    // cierra el archivo y termina la aplicación

    public void cerrarArchivo() {
        if (entrada != null) {
            entrada.close(); // cierra el archivo
        }
    }
}
