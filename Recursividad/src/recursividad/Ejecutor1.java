/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursividad;

/**
 *
 * @author TOSHIBA
 */
public class Ejecutor1 {

    public static void main(String args[]) {
        ClaseMisteriosa m = new ClaseMisteriosa();
        int arreglo[] = {3, 4, 6, 10, 5, 7};
        // int arreglo[] = { 2500, 2600, 3200, 4600, 5200, 6600, 7200, 8600, 9200, 10600 };
        int resultado = m.misterio(arreglo, arreglo.length);
        System.out.printf("El resultado es: %d\n", resultado);

    }
}
