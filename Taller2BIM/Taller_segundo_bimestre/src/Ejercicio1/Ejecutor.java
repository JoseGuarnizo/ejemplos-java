package Ejercicio1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SALAS
 */
public class Ejecutor {
   public static void main( String args[] )
   {
      Paises p1 = new Paises();

      p1.abrirArchivo();
      p1.leer_informacion();
      p1.cerrarArchivo();
   } // fin de main
}
