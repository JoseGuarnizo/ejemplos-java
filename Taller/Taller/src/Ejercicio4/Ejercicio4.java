package Ejercicio4;

import Ejercicio3.Ejercicio3;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Ejercicio4 {

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
        // el archivo permite el ingreso
        // de edad, nombre, apellido de una persona

        Scanner entrada = new Scanner(System.in);
        String nombre = null;
        String ciudad = null;
        String n = "";
        double subt = 0;
        double precio = 0;
        int cant = 0;
        boolean bandera = true;
        double total = 0;
        double iva = 0;

        System.out.println("Ingrese el nombre:");
        nombre = entrada.next();
        System.out.println("Ingrese la ciudad:");
        ciudad = entrada.next();

        while (bandera) {
            System.out.println("-----------MENU------------");
            System.out.println("1. Arroz; costo del kilo 2.50$");
            System.out.println("2. Azucar; costo del kilo 1.50$");
            System.out.println("3. Aceite; costo 1.30$");
            System.out.println("4. Tallarines; costo 1.50$ por unidad");
            System.out.println("5. Sal; costo del kilo 1.00$");
            System.out.println("Cual menu escoge");
            int menu = entrada.nextInt();
            switch (menu) {
                case 1:
                    n = "Arroz";
                    System.out.println("Ingrese Cantidad:");
                    cant = entrada.nextInt();
                    precio = cant * 2.50;
                    break;
                case 2:
                    n = "Azucar";
                    System.out.println("Ingrese cantidad:");
                    cant = entrada.nextInt();
                    precio = cant * 1.50;
                    break;
                case 3:
                    n = "Aceite";
                    System.out.println("ingrese cantidad");
                    cant = entrada.nextInt();
                    precio = cant * 1.30;
                    break;
                case 4:
                    n = "Tallarines";
                    System.out.println("Ingrese cantidad");
                    cant = entrada.nextInt();
                    precio = cant * 1.50;
                    break;
                case 5:
                    n = "Sal";
                    System.out.println("Ingrese cantidad");
                    cant = entrada.nextInt();
                    precio = cant * 1;
                    break;
                default:
                    System.out.println("no hay mas");
                    break;
            }
            subt = subt + precio;
            System.out.println("Va ingresar mas datos si(1), no(2)");
            int valor = entrada.nextInt();
            if (valor == 2) {
                bandera = false;
            }

        }// fin de while
        iva = subt * 0.14;
        total = subt + iva;

        try {
            salida.format("Comercial Ventas y Reventas\n"
                    + "Nombre:%s\nCiudad:%s\n------------------------------------\n"
                    + "%-15s%-15s%-15s\n------------------------------------\n"
                    + "%-15s%-15d%-15f\n------------------------------------\n"
                    + "%-25s%-10f\n"
                    + "%-25s%-10f\n"
                    + "%-25s%-10f\n\n\n"
                    + "", nombre, ciudad, "Producto", "Cantidad", "Precio", n, cant, precio, "Subtotal: ", subt, "IVA: ", iva, "Total: ", total);
        } // fin de try
        catch (FormatterClosedException formatterClosedException) {
            System.err.println("Error al escribir en el archivo.");
            return;
        } // fin de catch
        catch (NoSuchElementException elementException) {
            System.err.println("Entrada invalida. Intente de nuevo.");
            entrada.nextLine(); // descarta la entrada para que el usuario intente de nuevo
        } // fin de catch

    } // fin del método agregarRegistros

// cierra el arrchivo
    public void cerrar_archivo() {
        if (salida != null) {
            salida.close();
        }
    }
}
