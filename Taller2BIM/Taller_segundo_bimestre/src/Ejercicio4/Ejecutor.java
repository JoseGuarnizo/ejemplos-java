/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio4;

/**
 *
 * @author Usuario
 */
public class Ejecutor {
     public static void main(String args[]) {
     CreaFactura ap = new CreaFactura();

      ap.abrir_archivo();
      ap.agregar_informacion();
      ap.cerrar_archivo();
    } // fin de main
} // fin de la clase PruebaCre
