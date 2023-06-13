/*
 * Código utilizado para el curso de Estructuras de Datos.
 */
package ed.complejidad;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Interfaz que define los métodos para utilizar con las pruebas unitarias.
 *
 * @author veronica
 * @author mindahrelfen
 */
public interface IComplejidad {

	/**
	 * Devuelve el número de operaciones acumuladas desde la última vez que se
	 * reinició el contador.
	 *
	 * @return número de operaciones.
	 */
	public long leeContador();

	/**
	 * Método para guardar las operaciones cuando sólo se usa un parámetro.
	 *
	 * @param archivo nombre del archivo en el cual se agrega el reporte del
	 * número de operaciones que tardó en ejecutarse el método.
	 * @param par valor que se usó al llamar al último método ejecutado.
	 * @param ops número de operaciones realizadas.
	 * @throws java.io.FileNotFoundException
	 */
	public static void escribeOperaciones(String archivo, int par, long ops) throws FileNotFoundException {
		throw new UnsupportedOperationException("Agrega aquí tu código.");
	}

	/**
	 * Método para guardar las operaciones cuando se llamó una función con dos
	 * parámetros.
	 *
	 * @param archivo nombre del archivo en el cual se agrega el reporte del
	 * número de operaciones que tardó en ejecutarse el método.
	 * @param par1 primer valor que se usó al llamar al último método ejecutado.
	 * @param par2 segundo valor que se usó al llamar al último método
	 * ejecutado.
	 * @param ops número de operaciones realizadas.
	 */
	public static void escribeOperaciones(String archivo, int par1, int par2, long ops) throws FileNotFoundException {
		throw new UnsupportedOperationException("Agrega aquí tu código.");
	}

	/**
	 * Método para escribir una línea en blanco en un archivo. Se utilizará para
	 * las gráficas 3D.
	 *
	 * @param archivo Nombre del archivo.
	 * @throws FileNotFoundException
	 */
	public static void escribeLineaVacía(String archivo) throws FileNotFoundException {
		try ( PrintStream writer = new PrintStream(new FileOutputStream(archivo, true))) {
			writer.println();
		}
	}

	/**
	 * Método para calcular, de forma recursiva, el elemento en la fila
	 * <code>i</code>, en la columna <code>j</code> del triangulo de Pascal
	 *
	 * @param ren el numero de fila
	 * @param col el numero de columna Si es <code>null</code> no se realizará
	 * este cálculo.
	 * @return El elemento en la <code>i</code>-esima fila y la
	 * <code>j</code>-esima columna del triangulo de Pascal.
	 * @throws IndexOutOfBoundsException Si los indices <code>i</code> o
	 * <code>j</code> son inválidos
	 */
	public int tPascalRec(int ren, int col);

	/**
	 * Metodo para calcular, iterativamente, el elemento en la fila
	 * <code>i</code> y la columna <code>j</code> del triangulo de Pascal
	 *
	 * @param ren el numero de fila
	 * @param col el numero de columna
	 * @return El elemento en la i-esima fila y la j-esima columna del triangulo
	 * de Pascal.
	 * @throws IndexOutOfBoundsException Si los indices <code>i</code> o
	 * <code>j</code> son inválidos
	 */
	public int tPascalIt(int ren, int col);

	/**
	 * Devuelve el n-esimo elemento, calculado de forma recursiva, de la
	 * sucesion de Fibonacci.  Por conveción fibonacci(0) = 0, fibonacci(1) = 1.
	 *
	 * @param n el indice del elemento que se desea calcular
	 * @return el n-esimo elemento de la sucesion de Fibonacci
	 * @throws IndexOutOfBoundsException Si el valor de <code>n</code>es
	 * inválido
	 */
	public int fibonacciRec(int n);

	/**
	 * Devuelve el n-esimo elemento, calculado de forma iterativa, de la
	 * sucesion de Fibonacci.  Por conveción fibonacci(0) = 0, fibonacci(1) = 1.
	 *
	 * @param n el indice del elemento que se desea calcular
	 * @return el n-esimo elemento de la sucesiond de Fibonacci
	 * @throws IndexOutOfBoundsException Si el valor de <code>n</code>es
	 * inválido
	 */
	public int fibonacciIt(int n);

}
