package ed.complejidad;

public class Complejidad implements IComplejidad{

    public long leeContador(){
        return 0;
    }

    /*El método escribeOperaciones y escribeLineaVacía al ser estaticos se implementan dentro de IComplejidad 
    por lo que no es necesario implementarlos aquí.*/

    /*Método auxiliar que calcula el numero resultante según una posición en el triangulo de Pascal
     * @return el elemento en la i-esima fila y la j-esima columna del triangulo
	 * de Pascal.*/

    public int tPascalRecAux(int ren, int col){
        if (ren == 0 || ren == col || col == 0) {
            return 1;
        }
        else{
            int resultado;
            resultado = tPascalRecAux(ren-1,col-1) + tPascalRecAux(ren-1 , col);
            return resultado;

        }
    }
    
    //Método principal que llama al auxiliar para calcular el resultado.
    public int tPascalRec(int ren, int col) throws IndexOutOfBoundsException{
        if (ren < 0 || col < 0 || col > ren){
            throw new IndexOutOfBoundsException ("Parametros Invalidos");
        }
        return tPascalRecAux(ren, col);
        
    }

    
    public int tPascalIt (int ren, int col){
        //Sumamos uno cada vez que pase por el método.
        if (ren < 0 || col <0 || col > ren){ 
            throw new IndexOutOfBoundsException("Argumento Inválido"); //Declaramos cuales son los argumentos inválidos.
        }
        else {
            int renTemp=ren+1; 
            int resultado = 0;
                
            int [] tempArray =new int [1]; 
        
            for(int i=1; i<=renTemp; i++){ 
                int [] array= new int [i]; 
        
                for(int j=0;j<i;j++){ 
                    if(j==0||j==(i-1)){ 
                        array[j]=1; 
                        if(renTemp==i && col==j){ 
                            resultado = array[j]; 
                            
                        }
                    }
                    else{
                        array[j]=tempArray[j]+tempArray[j-1];
                        if(renTemp==i&&col==j){ 
                            resultado=array[j];
                        }
                    }
                }
                    tempArray =array;
            }
            return resultado;
        }
    }


     /*Método que calcula el resultado de la sucesión Fibonacci en la posición n de manera recursiva. 
     *@return el n-esímo elemento de Fibonacci*/
    /*Este método es auxilar para ser posteriormente llamado y no se aglomere todo el código en un método. */

    public int fibonacciRecAux(int n1){
        switch (n1){ //Posibles casos base en los que pueden caer y los que se llaman recursivamente.
            case 0:
            return 0;
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
