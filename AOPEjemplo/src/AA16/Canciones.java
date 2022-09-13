package AA16;

public class Canciones extends Artistas{
	
	private String cancion;
	private int visualizaciones;
	/**
	 * @param artista
	 * @param nombre
	 * @param visualizaciones
	 */
	
	/**
	 * 
	 */
	public Canciones() {
		super();
	}



	/**
	 * @param nombre
	 * @param artista
	 * @param cancion
	 * @param visualizaciones
	 */
	public Canciones(String nombre, String artista, String cancion, int visualizaciones ) {
		super(nombre, artista);
		this.cancion = cancion;
		this.visualizaciones = visualizaciones;
	}



	public String getNombre() {
		return cancion;
	}
	public void setNombre(String nombre) {
		this.cancion = nombre;
	}
	public int getVisualizaciones() {
		return visualizaciones;
	}
	public void setVisualizaciones(int visualizaciones) {
		this.visualizaciones = visualizaciones;
	}

	@Override
	public String toString() {
		return "Cancion: "+  cancion + ", visualizaciones: " + visualizaciones + ", Cantante/s: " + getArtista();
	}
	


}
