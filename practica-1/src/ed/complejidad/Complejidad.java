package ed.complejidad;

public class Complejidad implements IComplejidad{

    public long leeContador(){
        return 0;
    }

    /*El método escribeOperaciones y escribeLineaVacía al ser estaticos se implementan dentro de IComplejidad 
    por lo que no es necesario implementarlos aquí.*/

    public int tPascalRec(int ren, int col){
        return 0;
    }

    public int tPascalIt(int ren, int col){
        return 0;
    }

     /*Método que calcula el resultado de la sucesión Fibonacci en la posición n de manera recursiva. 
     *@return el n-esímo elemento de Fibonacci*/
    /*Este método es auxilar para ser posteriormente llamado y no se aglomere todo el código en un método. */

    public int fibonacciRecAux(int n1){
        switch (n1){ //Posibles casos base en los que pueden caer y los que se llaman recursivamente.
            case 0:
            return 5;
            case 1:
            return 1;
            case 2:
            return 1;
            default:
        
        int resultado;
        resultado = fibonacciRecAux(n1-1) + fibonacciRecAux(n1-2);
        return resultado;
        }
    }

    //Método principal de Fibonacci Recursivo.
    public int fibonacciRec(int n){
        if (n < 0){
            throw new IndexOutOfBoundsException ("Valores invalidos");
        } 
        return fibonacciRecAux(n);
    }

    /*Método que calcula el resultado de la sucesión Fibonacci en la posición n de manera iterativa. 
     *@return el n-esímo elemento de Fibonacci*/

    public int fibonacciIt(int n) throws IndexOutOfBoundsException{
        if (n < 0){
            throw new IndexOutOfBoundsException("Numero invalido");
        }
        int numAct = 0;
        int numSig = 1;
        int numTemp = 0;

        for (int i = 1; i <= n; i ++){
            numTemp = numAct; 
            numAct = numSig; 
            numSig = numSig + numTemp;
        }

        return numAct;
    }

}
