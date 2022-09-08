package AA10;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/* GENERAR UN PROYECTO MAVEN QUE MUESTRE POR CONSOLA LA INFORMACION DEL CLIMA ACTUAL,
*  ADEMAS DE MOSTRAR UN MENSAJE DE BIENVENIDA AL USUARIO, UNA VEZ INSERTADO
SU NOMBRE.
INTEGRAR EL NUEVO PROYECTO EN GITHUB BAJO EL NOMBRE DE EJERCICIO AA10
ENTREGABLE:
Codigo del proyecto
link del repositorio */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Indique su nombre por favor");
		String nombre = sc.nextLine();
		System.out.println("Bienvenido "+nombre);
		
		try {
			URL url = new URL(
					"https://www.el-tiempo.net/api/json/v2/provincias/28");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.connect();

			int tiempoRespuesta = conn.getResponseCode(); // Para manejo de
			// Situaciones

			if (tiempoRespuesta != 200) {
				throw new RuntimeException("HttpResponse" + tiempoRespuesta);
			} else {
				StringBuilder informacionString = new StringBuilder();
				Scanner sd = new Scanner(url.openStream());
				while (sd.hasNext()) {
					informacionString.append(sd.nextLine());
				}
				sc.close();
				System.out.println(informacionString);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
