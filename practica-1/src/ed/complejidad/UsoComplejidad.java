package ed.complejidad;

public class UsoComplejidad {
    //Clase donde mandaremos llamar a todos los métodos previamente programados.

    public static void main (String [] args){       
        Complejidad complejidad = new Complejidad();

        System.out.println("Pascal Recursivo: " + complejidad.tPascalRec(4,3));
        System.out.println("Pascal Iterativo: " + complejidad.tPascalIt(4, 3));
        System.out.println("Fibonacci Recursivo: " + complejidad.fibonacciRec(5));
        System.out.println("Fibonacci Iterativo: " + complejidad.fibonacciIt(5));

    }
    
}
