package AA16;

import org.springframework.stereotype.Service;

@Service
public class Servicio {
	public void generarArchivo() {
		System.out.println("Se va a generar un archivo");
	}

	public void exito() {
		System.out.println("Se ha generado eL archivo TOP_SPOTIFY");
	}
}
