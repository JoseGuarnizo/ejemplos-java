/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author SALAS
 */
public class LeerEstudiantes {

    private Scanner entrada;
    public String nombreListo;
    public String apellidoListo;
    public int edad1;
    // permite al usuario abrir el archivo
    public void abrirArchivo() {
        try {
            System.out.println("El archivo se a leido con exito");
            entrada = new Scanner(new File("estudiantes.txt"));
        } // fin de try
        catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error al abrir el archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del método abrirArchivo

    // lee registro del archivo
    public void leer_informacion() {
        try // lee registros del archivo, usando el objeto Scanner
        {
            NuevoArchivo a1 = new NuevoArchivo();
            a1.abrir_archivo();
            System.out.println("El archivo se creo con exito");
            while (entrada.hasNext()) {
                String linea = entrada.nextLine();
                ArrayList<String> linea_partes = new ArrayList<String>(Arrays.asList(linea.split("\\|")));
                String ape = linea_partes.get(0);
                String nom = linea_partes.get(1);
                String añonac = linea_partes.get(2);
                int año = Integer.parseInt(añonac);
                String [ ] apellido = ape.split("\\ ");
                String [ ] nombre = nom.split("\\ ");
                apellidoListo = apellido[0];
                nombreListo = nombre[0];
                edad1 = 2016 - año;
                a1.agregar_informacion(nombreListo, apellidoListo, edad1);
                                
            } // fin de while
            a1.cerrar_archivo();
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
    } // fin del metodo cerrarArchivo
} // fin de la clase LeerArchivoTexto