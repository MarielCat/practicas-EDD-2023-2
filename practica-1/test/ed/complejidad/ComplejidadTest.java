/**
 * Código utilizado para el curso de Estructuras de Datos.
 */
package ed.complejidad;

import org.junit.Test;
import static org.junit.Assert.*;
import ed.Calificador;

/**
 * Pruebas unitarias para los ejercicios de cálculo de complejidad.
 *
 * @author blackzafiro
 */
public class ComplejidadTest extends Calificador {

	protected IComplejidad c;

	@Override
	public void init() {
		c = new Complejidad();
	}

	/**
	 * Test of tPascalRec method, of class Complejidad.
	 */
	@Test
	public void testTPascalRec() {
		startTest("tPascalRec", 2.0);
		assertEquals(10, c.tPascalRec(5, 2));
		addUp(1.0);
		assertEquals(3, c.tPascalRec(3, 2));
		addUp(1.0);
		passed();
	}

	/**
	 * Test of tPascalIt method, of class Complejidad.
	 */
	@Test
	public void testTPascalIt() {
		startTest("tPascalIt", 2.0);
		assertEquals(10, c.tPascalIt(5, 2));
		addUp(1.0);
		assertEquals(3, c.tPascalIt(3, 2));
		addUp(1.0);
		passed();
	}

	/**
	 * Test of fibonacciRec method, of class Complejidad.
	 */
	@Test
	public void testFibonacciRec() {
		startTest("fibonacciRec", 2.0);
		assertEquals(8, c.fibonacciRec(6));
		addUp(1.0);
		assertEquals(21, c.fibonacciRec(8));
		addUp(1.0);
		passed();
	}

	/**
	 * Test of fibonacciIt method, of class Complejidad.
	 */
	@Test
	public void testFibonacciIt() {
		startTest("fibonacciIt", 2.0);
		assertEquals(21, c.fibonacciIt(8));
		addUp(1.0);
		assertEquals(144, c.fibonacciIt(12));
		addUp(1.0);
		passed();
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testFibItInválido() {
		startTest("Cálculo Fibonacci valor inválido iterativo", 0.2);
		try {
			c.fibonacciIt(-5);
		} catch (IndexOutOfBoundsException e) {
			addUp(0.2);
			passed();
			throw e;
		}
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testFibRecInválido() {
		startTest("Cálculo Fibonacci valor inválido recursivo", 0.2);
		try {
			c.fibonacciRec(-10);
		} catch (IndexOutOfBoundsException e) {
			addUp(0.2);
			passed();
			throw e;
		}
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testPascalInválido() {
		startTest("Cálculo Pascal valor inválido iterativo", 0.2);
		try {
			c.tPascalIt(-5, 1);
		} catch (IndexOutOfBoundsException e) {
			addUp(0.2);
			passed();
			throw e;
		}
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testPascalInválido2() {
		startTest("Cálculo Pascal valor inválido iterativo 2", 0.2);
		try {
			c.tPascalIt(5, -1);
		} catch (IndexOutOfBoundsException e) {
			addUp(0.2);
			passed();
			throw e;
		}
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testPascalInválido3() {
		startTest("Cálculo Pascal valor inválido iterativo 3", 0.2);
		try {
			c.tPascalIt(3, 5);
		} catch (IndexOutOfBoundsException e) {
			addUp(0.2);
			passed();
			throw e;
		}
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testPascalRecInválido() {
		startTest("Cálculo pascal valor inválido recursivo", 0.2);
		try {
			c.tPascalRec(-5, 1);
		} catch (IndexOutOfBoundsException e) {
			addUp(0.2);
			passed();
			throw e;
		}
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testPascalRecInválido2() {
		startTest("Cálculo Pascal valor inválido recursivo 2", 0.2);
		try {
			c.tPascalRec(5, -1);
		} catch (IndexOutOfBoundsException e) {
			addUp(0.2);
			passed();
			throw e;
		}
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testPascalRecInválido3() {
		startTest("Cálculo Pascal valor inválido recursivo 3", 0.2);
		try {
			c.tPascalRec(3, 5);
		} catch (IndexOutOfBoundsException e) {
			addUp(0.2);
			passed();
			throw e;
		}
	}
}
