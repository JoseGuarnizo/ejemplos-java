/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio4;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author Elvis Ayala
 */
public class CreaFactura {

    private Formatter salida; // objeto usado para enviar texto al archivo

    // permite al usuario abrir el archivo
    public void abrir_archivo() {
        try {
            salida = new Formatter("Factura.txt");
        } // fin de try
        catch (SecurityException securityException) {
            System.err.println(
                    "No tiene acceso de escritura a este archivo.");
            System.exit(1);
        } // fin de catch
        catch (FileNotFoundException filesNotFoundException) {
            System.err.println("Error al crear el archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del método abrir_archivo

    // agrega registros al archivo
    public void agregar_informacion() {
        // Este metodo recibe los valores qeu se envia de la clase  lectura Archivo
        try // envía valores al archivo
        {
            Scanner entrada = new Scanner(System.in);
            boolean bandera = true;
            System.out.println("Ingrese el nombre del cliente");
            String nombre = entrada.nextLine();
            System.out.println("Ingrese la ciudad");
            String ciudad = entrada.next();

            int op = 0, op2 = 0, cant = 0;
            double precio = 0, sub = 0, iva, total;
            String producto = "";

            salida.format("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\n"
                    + "\tComercial Ventas y Reventas\nNombre: %s\nCiudad: %s\n"
                    + "_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\n"
                    + "Producto\t\tCant\t\tPrecio\n", nombre, ciudad);

            while (bandera) {

                System.out.printf("  _-_-_-_- Menú_-_-_-_-_-\n"
                        + "[1].- Arroz -- costo del kilo $2.50\n"
                        + "[2].- Azúcar -- costo del kilo $1.50\n"
                        + "[3].- Aceite -- costo $ 1.30 por unidad\n"
                        + "[4].- Tallarines -- costo $ 1.50 por unidad\n"
                        + "[5].- Sal -- costo del kilo $1.00\n");

                System.out.println("Ingrese el producto QUE desee comparar");
                op = entrada.nextInt();
                System.out.println("Ingrese la cantidad");
                cant = entrada.nextInt();
                switch (op) {
                    case 1:
                        precio = 2.50 * cant;
                        producto = "Arroz     ";
                        break;
                    case 2:
                        precio = 1.50 * cant;
                        producto = "Azúcar    ";
                        break;
                    case 3:
                        precio = 1.30 * cant;
                        producto = "Aceite    ";
                        break;
                    case 4:
                        precio = 1.50 * cant;
                        producto = "Tallarines";
                        break;
                    case 5:
                        precio = 1.0 * cant;
                        producto = "Sal       ";
                        break;
                }
                salida.format("%s\t\t%d\t\t%.2f\n", producto, cant, precio);
                sub = sub + precio;
                System.out.println("Desea ingresar más productos\n Si(1) No(2)");
                op2 = entrada.nextInt();
                if (op2 != 1) {
                    bandera = false;
                }

            }
            iva = sub * 0.14;
            total = sub + iva;

            salida.format("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\n"
                    + "\t\t\tSubtotal: %.2f\n"
                    + "\t\t\tIVA: %.2f\n"
                    + "\t\t\tTOTAL: %.2f\n", sub, iva, total);

            // escribe el nuevo registro (escribe en el archivo
        } // fin de try
        catch (FormatterClosedException formatterClosedException) {
            System.err.println("Error al escribir en el archivo.");
            return;
        } // fin de catch
        catch (NoSuchElementException elementException) {
            System.err.println("Entrada invalida. Intente de nuevo.");
            // descarta la entrada para que el usuario intente de nuevo
        } // fin de catch
    } // fin del método agregarRegistros

    // cierra el arrchivo
    public void cerrar_archivo() {
        if (salida != null) {
            salida.close();
        }
    } // fin del método cerrarArchivo
} // fin de la clase ArchivoTexto
