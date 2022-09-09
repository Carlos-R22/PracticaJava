package AA14;

public class Chocolate extends Golosina{

	private String nombre;
	private int cantidad;
	/**
	 * 
	 */
	public Chocolate() {
		super();
	}
	/**
	 * @param nombre
	 * @param peso
	 */
	public Chocolate(String nombre, int peso) {
		super(nombre, peso);
		this.nombre = nombre;
		this.cantidad = cantidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "Chocolate nombre=" + nombre + ", cantidad=" + cantidad;
	}
	
	
	
}
