package AA9;

public class Videojuegos implements Ganancias{

	private String nombre;
	private int venta;
	private double precio;
	private double gananciasT;
	
	public Videojuegos() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param nombre
	 * @param venta
	 * @param precio
	 */
	public Videojuegos(String nombre, int venta, double precio, double gananciasT) {
		super();
		this.nombre = nombre;
		this.venta = venta;
		this.precio = precio;
		this.gananciasT = gananciasT;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVenta() {
		return venta;
	}

	public void setVenta(int venta) {
		this.venta = venta;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	

	public double getGananciasT() {
		gananciasT = precio*venta;
		return gananciasT;
	}

	public void setGananciasT(double gananciasT) {
		this.gananciasT = gananciasT;
	}

	@Override
	public String toString() {
		return "Videojuegos " + nombre + ", numero de ventas= " + venta + ", con precio= " + precio + " ganancias totales: "+ gananciasT;
	}

	public double gananciasT(){
		Double ganancias = getVenta()*getPrecio(); 
		return ganancias;
	}
	
}
