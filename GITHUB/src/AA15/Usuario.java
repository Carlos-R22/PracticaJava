package AA15;

import java.time.LocalDate;


public class Usuario {

	public int ID;
	public String nombre;
	public LocalDate fecha;
	/**
	 * @param iD
	 * @param nombre
	 * @param fecha
	 */
	public Usuario(int iD, String nombre, LocalDate fecha) {
		super();
		ID = iD;
		this.nombre = nombre;
		this.fecha = fecha;
	}
	/**
	 * 
	 */
	public Usuario() {
		super();
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Usuario ID=" + ID + ", nombre=" + nombre + ", fecha=" + fecha;
	}

	
	
	
}
