package recursividad;

public class ClaseMisteriosa {

    public int misterio(int arreglo2[], int tamanio) {
        if (tamanio == 1) {
            return arreglo2[0];
        } else {
            return arreglo2[tamanio - 1] + misterio(arreglo2, tamanio - 1);
        }

    } // fin del método misterio
} // fin de la clase ClaseMisteriosa

