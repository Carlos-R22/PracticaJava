package AA16;

public class Artistas extends Persona{
	
private String artista;

/**
 * @param artista
 */
public Artistas(String nombre, String artista) {
	super(nombre);
	this.artista = artista;
}

public Artistas( ) {
	super();

}

public String getArtista() {
	return artista;
}

public void setArtista(String artista) {
	this.artista = artista;
}

@Override
public String toString() {
	return "Artistas: " + artista;
}



}
