package AA16;

public class Usuario extends Persona{
	
	private int USER_ID;
	private String USER_EMAIL;
	/**
	 * @param nombre
	 * @param uSER_ID
	 * @param uSER_EMAIL
	 */
	public Usuario(String nombre, int uSER_ID, String uSER_EMAIL) {
		super(nombre);
		USER_ID = uSER_ID;
		USER_EMAIL = uSER_EMAIL;
	}
	/**
	 * 
	 */
	public Usuario() {
		super();
	}
	public int getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(int uSER_ID) {
		USER_ID = uSER_ID;
	}
	public String getUSER_EMAIL() {
		return USER_EMAIL;
	}
	public void setUSER_EMAIL(String uSER_EMAIL) {
		USER_EMAIL = uSER_EMAIL;
	}
	@Override
	public String toString() {
		return " USER= " + getNombre()+"USER_ID= " + USER_ID + ", USER_EMAIL= " + USER_EMAIL ;
	}

	
	
}
