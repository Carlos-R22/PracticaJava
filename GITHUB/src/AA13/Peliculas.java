package AA13;

public class Peliculas {
	
	private String recaudacion;
	private String nombre;
	
	
	/**
	 * 
	 */
	public Peliculas() {
		super();
	}

	/**
	 * @param nombre
	 * @param recaudacion
	 */
	public Peliculas(String recaudacion, String nombre) {
		super();
		this.nombre = nombre;
		this.recaudacion = recaudacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRecaudacion() {
		return recaudacion;
	}

	public void setRecaudacion(String recaudacion) {
		this.recaudacion = recaudacion;
	}

	@Override
	public String toString() {
		return "Peliculas [nombre=" + nombre + ", recaudacion=" + recaudacion + "]";
	}
	
	
	
	
}
