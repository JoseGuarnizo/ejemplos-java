package recursividad;

public class CalculoFactorial {

    public double factorial(double numero) {
        if (numero <= 1) {
            return 1;

        } else {
            return numero * factorial(numero - 1);
        }

    }

    public void mostrarfactorial() {
        for (int contador = 0; contador <= 4; contador++) {
            System.out.printf("%d! = %.0f\n", contador, factorial(contador));
            
        }
    }
}
