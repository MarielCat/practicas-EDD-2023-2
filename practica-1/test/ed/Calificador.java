/**
 * Código utilizado para el curso de Estructuras de Datos.
 *
 * Se permite consultarlo para fines didácticos de forma personal, pero no está
 * permitido transferirlo tal cual a estudiantes actuales o potenciales pues se
 * afectará su realización de los ejercicios.
 */
package ed;

import java.util.Iterator;
import java.util.Random;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;

/**
 * Clase base que se encarga en crear la aplicación para el manejo y uso de
 * pruebas unitarias.
 *
 * Las pruebas se definen en clases hijas de esta clase, y deben sobrescribir el
 * método init. Para empezar cada prueba se debe utilizar los métodos startTest
 * y deben finalizar con el método passed, mientras que el aumento de aciertos
 * por prueba unitaria se hace con el método addUp.
 *
 * @author mindahrelfen
 */
public abstract class Calificador {

	/**
	 * Rango para pruebas de longitud cortas.
	 */
	public static final int SMALL_RANGE = 4;

	/**
	 * Rango para pruebas de longitud media.
	 */
	public static final int MEDIUM_RANGE = 16;

	/**
	 * Rango para pruebas de longitud larga.
	 */
	public static final int LARGE_RANGE = 256;

	/**
	 * Longitud de las cadenas de resumen antes del retorno de carro.
	 */
	public static final int LENGTH = 75;

	/**
	 * Puntos acumulados en la prueba actual.
	 */
	protected static double points;

	/**
	 * Puntos totales en la prueba actual.
	 */
	protected static double numberOfPoints;

	/**
	 * Genera números enteros aleatorios en forma de String a través de su
	 * iterador.
	 */
	protected static RandomStringGenerator rsg;

	/**
	 * Iterador de rsg.
	 */
	protected static Iterator<String> rsgIt;

	/**
	 * Cantidad de elementos que rsg tendrá.
	 */
	protected static int range;

	/**
	 * Generador de números aleatorios.
	 */
	protected static Random rdm;

	/**
	 * Indica si ya se imprimió el reporte de la ultima prueba ejecutada.
	 */
	protected static boolean isPrinted;

	/**
	 * Define el nombre de la categoría de la prueba en ejecución.
	 */
	protected static String categoryName;

	/**
	 * Definición de las categorías a calificar.
	 */
	protected static Category[] categories;

	/**
	 * Constructor por defecto. Define la cantidad de números posibles igual a
	 * {@value #MEDIUM_RANGE}. Con una sola categoría a calificar con 1.0 de 1.0
	 * aciertos. Permite referencias nulas.
	 */
	public Calificador() {
		init();
		setCategories();
		rdm = new Random();
	}

	/**
	 * Define que al inicio de cada prueba se guarde el nombre de dicha prueba.
	 */
	@Rule
	public TestName testName = new TestName();

	/**
	 * Método que se implementa para mantener correcta la creación de las clases
	 * que definen a las pruebas unitarias.
	 *
	 * Se espera que las clases hijas sobrescriban este método, pues funge como
	 * constructor para todas las clases en la jerarquía de herencia de esta
	 * clase.
	 */
	protected void init() {
	}

	/**
	 * Define las categorías a calificar.
	 *
	 * Se espera que las clases hijas sobrescriban este método.
	 *
	 * Por defecto solo se tiene una categoría a calificar sin nombre y con 1.0
	 * de 1.0 aciertos.
	 */
	protected void setCategories() {
		defineCategories(new String[]{
			""
		}, new double[]{
			1.0
		});
	}

	/**
	 * Define el rango de valores con el cual el generador de números aleatorios
	 * enteros en forma de String va a trabajar.
	 *
	 * @param r int Recibe un número entero mayor a cero.
	 *
	 * @throws IndexOutOfBoundsException Si el parámetro es menor o igual a
	 * cero.
	 */
	protected void set(int r) {
		if (r < 1) {
			throw new IllegalArgumentException("Solo se permiten números positivos");
		}
		range = r;
		rsg = new RandomStringGenerator(range);
	}

	/**
	 * Define el rango de valores con el cual el generador de números aleatorios
	 * enteros en forma de String va a trabajar.
	 *
	 * @param r int Recibe un número entero mayor a cero.
	 * @param allowNull If <code>null</code> elements will be allowed.
	 *
	 * @throws IndexOutOfBoundsException Si el parámetro es menor o igual a
	 * cero.
	 */
	protected void set(int r, boolean allowNull) {
		if (r < 1) {
			throw new IllegalArgumentException("Solo se permiten números positivos");
		}
		range = r;
		rsg = new RandomStringGenerator(range, allowNull);
	}

	/**
	 * Define las categorías a calificar, recibe dos arreglos de misma longitud,
	 * uno con los nombres de cada categoría y el otro con los porcentajes. La
	 * suma de dichos porcentajes debe ser iguala uno.
	 *
	 * @param categoryNames String[] Contiene los nombres de las categorías.
	 * @param percentages double[] Contiene la ponderación de las categorías.
	 */
	protected void defineCategories(String[] categoryNames, double[] percentages) {
		Category[] c;

		categoryName = "";
		c = new Category[categoryNames.length];
		for (int i = 0; i < c.length; i++) {
			c[i] = new Category(categoryNames[i], percentages[i]);
		}

		/**
		 * Aquí se revisa si las categorías ya se definieron con anterioridad,
		 * esto es porque JUnit "crea" de nuevo una instancia de Calificador
		 * cada que ejecuta una prueba.
		 */
		if (categories == null) {
			categories = c;
		} else if (c.length != categories.length) {
			categories = c;
		} else {
			for (int i = 0; i < c.length; i++) {
				if (!c[i].equals(categories[i])) {
					categories = c;
					break;
				}
			}
		}
	}

	/**
	 * Se ejecuta antes de iniciar la ejecución de todas las pruebas. Inicia los
	 * puntos obtenidos y a calificar en cero e inicia las banderas en su estado
	 * inicial.
	 */
	@BeforeClass
	public static void setUpClass() {
		points = numberOfPoints = 0.0;
		isPrinted = true;
	}

	/**
	 * Se ejecuta al finalizar la ejecución de todas las pruebas. Imprime el
	 * ultimo reporte y el puntaje total obtenido.
	 */
	@AfterClass
	public static void tearDownClass() {
		print(true, getScore());
	}

	/**
	 * Define el inicio de una prueba en particular. Los parámetro definidos se
	 * utilizan para categorizar cada tipo de prueba, así como los aciertos de
	 * la prueba.
	 *
	 * @param s String Es la descripción de la prueba en particular.
	 * @param p double Es el puntaje máximo que se obtiene por esta prueba.
	 */
	public final void startTest(String s, double p) {
		print(true, testName.getMethodName() + ":\n\t" + formattedString(s, LENGTH));
		numberOfPoints = p;
		points = 0.0;
		isPrinted = false;
		addMax(p, categoryName);
	}

	/**
	 * Define el inicio de una prueba en particular. Los parámetro definidos se
	 * utilizan para categorizar cada tipo de prueba, así como los aciertos de
	 * la prueba.
	 *
	 * @param s String Es la descripción de la prueba en particular.
	 * @param p double Es el puntaje máximo que se obtiene por esta prueba.
	 * @param c String Es el nombre de la categoría de la prueba.
	 */
	public final void startTest(String s, double p, String c) {
		categoryName = c;
		startTest(s, p);
	}

	/**
	 * Se invoca para aumentar el puntaje obtenido para la prueba, el puntaje se
	 * agrega a la categoría de la prueba.
	 *
	 * No revisa correctez.
	 *
	 * @param d double Es el aumento en el puntaje obtenido para la prueba.
	 */
	public final void addUp(double d) {
		points += d;
		addScore(d, categoryName);
	}

	/**
	 * Se invoca para avisar que la prueba fue pasada con éxito.
	 */
	public final void passed() {
		print(false, "\tPassed.");
	}

	public final String formattedString(String s, int length) {
		int index;

		if (s.length() > length - 4) {
			index = s.lastIndexOf(" ", length - 4); // se usa 4 por el \t
			return s.substring(0, index) + "\n\t" + formattedString(s.substring(index + 1), length);
		} else {
			return s;
		}

	}

	/**
	 * Imprime el resumen de la prueba si no se ha impreso ya, además imprime un
	 * mensaje en particular.
	 *
	 * @param p boolean Indica si el resumen se imprime con una vuelta de carro
	 * después de dicho resumen o no.
	 * @param msg String Mensaje que se imprime después del resumen.
	 */
	public static final void print(boolean p, String msg) {
		String s;

		if (!isPrinted) {
			s = "\t[" + points + "/" + numberOfPoints + "]";
			if (p) {
				System.out.println(s);
			} else {
				System.out.print(s);
			}
		}
		isPrinted = true;
		System.out.println(msg);
	}

	/**
	 * Agrega el puntaje dado al puntaje máximo de la categoría dada.
	 *
	 * @param score double Puntaje a agregar.
	 * @param categoryName String Nombre de la categoría a modificar.
	 */
	private void addMax(double score, String categoryName) {
		int i;

		i = getCategoryIndex(categoryName);
		categories[i].addMax(score);
	}

	/**
	 * Agrega el puntaje dado al puntaje obtenido de la categoría dada.
	 *
	 * @param score double Puntaje a agregar.
	 * @param categoryName String Nombre de la categoría a modificar.
	 */
	private void addScore(double score, String categoryName) {
		int i;

		i = getCategoryIndex(categoryName);
		categories[i].addScore(score);
	}

	/**
	 * Obtiene el índice dentro del arreglo de categorías de la categoría que
	 * tiene el nombre dado.
	 *
	 * @param msg String Nombre de la categoría a buscar.
	 *
	 * @return int Índice de la categoría a buscada.
	 *
	 * @throws IndexOutOfBoundsException Si el nombre no se encuentra en el
	 * arreglo de categorías.
	 */
	private int getCategoryIndex(String categoryName) {
		for (int i = 0; i < categories.length; i++) {
			if (categoryName.equals(categories[i].getName())) {
				return i;
			}
		}

		throw new IndexOutOfBoundsException("No existe el nombre " + categoryName + " en las categorías dadas.");
	}

	/**
	 * Método que se encarga de calcular y devolver en forma de cadena los
	 * puntajes parciales para cada categoría y el puntaje general de todas las
	 * categorías.
	 *
	 * @return String Cadena que representa el resumen del total.
	 */
	private static String getScore() {
		double d, n, score, maxScore, percentage;
		String name, str1, str2;
		Printer p;
		StringBuilder sb;

		p = new Printer(LENGTH);
		sb = new StringBuilder();
		d = 0.0;

		for (int i = 0; i < categories.length; i++) {
			score = categories[i].getScore();
			maxScore = categories[i].getMaxScore();
			percentage = categories[i].getPercentage();
			name = categories[i].getName();
			n = (score / maxScore * percentage);
			d = (Double.isNaN(n) ? d : d + n);
			sb.append(p.divisor('='));
			sb.append("\n");
			str1 = name + " (Aciertos: " + score + "/" + maxScore + ")";
			str2 = "Puntaje: " + (n * 100.0) + "/" + (percentage * 100.0);
			sb.append(p.line(str1, str2));
			sb.append("\n");
		}

		sb.append(p.divisor('='));
		sb.append("\n");
		str1 = "Puntaje Total:";
		str2 = (d * 100.0) + "/100.0";
		sb.append(p.line(str1, str2));
		sb.append("\n");
		sb.append(p.divisor('='));

		return sb.toString();
	}
}
