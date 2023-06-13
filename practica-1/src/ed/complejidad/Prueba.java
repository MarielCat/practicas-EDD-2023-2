package ed.complejidad;

public class Prueba {

    public static int fibonacciIt(int n){
        int numAct = 0;
        int numSig = 1;
        int numTemp = 0;

        for (int i = 1; i <= n; i ++){
            numTemp = numAct; //El número temporal se convierte en el actual
            numAct = numSig; // Ahora el actual toma el valor de el siguiente (que se inicializa en 1)
            numSig = numSig + numTemp; // E
        }

        return numAct;
    }

    public static void main (String args[]){
        System.out.println(fibonacciIt(12));
    }
    
}
