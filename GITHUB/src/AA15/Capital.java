package AA15;

public class Capital extends Provincia{
	
	private String capital;

	/**
	 * @param ccaa
	 * @param provincia
	 * @param capital
	 */
	public Capital(String provincia, String capital) {
		super(provincia);
		this.capital = capital;
	}

	/**
	 * @param capital
	 */
	public Capital() {
		super();
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	@Override
	public String toString() {
		return "Capital: " + capital + ", Provincia: " + getProvincia().toString();
	}
	
	
	

}
