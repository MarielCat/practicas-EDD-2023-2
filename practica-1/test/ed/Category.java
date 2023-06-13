/**
 * Código utilizado para el curso de Estructuras de Datos.
 */
package ed;

/**
 * Define la clase que guarda las categorías a calificar.
 *
 * Se utiliza una cadena String como identificador para diferenciar cada
 * categoría distinta. Cada categoría requiere de un porcentaje entre cero y
 * uno. El puntaje máximo y el puntaje obtenido se calcula en tiempo de
 * ejecución al pasar o fallar cada prueba correspondiente a esta categoría.
 *
 * @author mindahrelfen
 */
public class Category {

	/**
	 * Define el nombre de la esta categoría.
	 */
	private String name;

	/**
	 * Define el porcentaje que esta categoría vale con respecto al total.
	 */
	private double percentage;

	/**
	 * Define el número total de puntos en esta categoría.
	 */
	private double maxScore;

	/**
	 * Define el número de aciertos con respecto al total en esta categoría.
	 */
	private double score;

	/**
	 * Constructor.
	 *
	 * @param name String Nombre de esta categoría.
	 * @param percentage double Porcentaje que vale esta categoría.
	 */
	public Category(String name, double percentage) {
		this.name = name;
		this.percentage = percentage;
		this.maxScore = 0.0;
		this.score = 0.0;
	}

	/**
	 * Aumenta el puntaje máximo de esta categoría.
	 *
	 * @param maxScore double Puntaje a agregar.
	 */
	public void addMax(double maxScore) {
		this.maxScore += maxScore;
	}

	/**
	 * Aumenta el puntaje obtenido de esta categoría.
	 *
	 * @param score double Puntaje a agregar.
	 */
	public void addScore(double score) {
		this.score += score;
	}

	/**
	 * Método de acceso para el nombre de la categoría.
	 *
	 * @return String Nombre de esta categoría.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Método de acceso para el porcentaje de la categoría.
	 *
	 * @return double Porcentaje de esta categoría.
	 */
	public double getPercentage() {
		return percentage;
	}

	/**
	 * Método de acceso para el puntaje máximo de la categoría.
	 *
	 * @return double Puntaje máximo de esta categoría.
	 */
	public double getMaxScore() {
		return maxScore;
	}

	/**
	 * Método de acceso para el puntaje obtenido de la categoría.
	 *
	 * @return double Puntaje obtenido de esta categoría.
	 */
	public double getScore() {
		return score;
	}

	@Override
	public boolean equals(Object obj) {
		Category c, t;

		if (obj == null) {
			return false;
		} else if (obj == this) {
			return true;
		} else if (!(obj instanceof Category)) {
			return false;
		} else {
			c = (Category) obj;
			t = this;

			if (!t.name.equals(c.name)) {
				return false;
			}
			if (Math.abs(t.percentage - c.percentage) > 0.1) {
				return false;
			}

			return true;
		}
	}
}
