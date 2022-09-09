package AA14;

public class Golosina {
	private String nombre;
	private int peso;
	/**
	 * 
	 */
	public Golosina() {
		super();
	}
	/**
	 * @param nombre
	 * @param peso
	 */
	public Golosina(String nombre, int peso) {
		super();
		this.nombre = nombre;
		this.peso = peso;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	@Override
	public String toString() {
		return "Golosina nombre=" + nombre + ", peso=" + peso;
	}
	
	
	
}
