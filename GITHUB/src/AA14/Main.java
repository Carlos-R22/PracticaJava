package AA14;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;


/*
 *(!) AA14 (!)
ESTRUCTURA DEL PROGRAMA:
- Proyecto Maven (Lo van a necesitar para el JSON)
- Herencia entre clases
- Implementación de una interfaz
- Conectividad con Github
- JSON / API
- Implementar un jenkinsfile

PROBLEMATICA:
Nos contrataron desde la empresa Charlie y la fabrica de chocolate situados en Sevilla para ayudarlos a mejorar su sistema de generación de chocolates. Para esto, el cliente nos dio algunas
especificaciones. Al ser una fabrica de chocolates, tienen en consideración las condiciones climaticas, ya que si la temperatura actual es mayor a 40° no se fabrican
chocolates ese día dado que existe un riesgo de que el mismo se derrita. Si las condiciones climaticas son favorables la producción se hace habitualmente.
Para informar al cliente de como esta yendo el proceso, nos pidio que se lo informemos a traves de un archivo plano. Informandole por producto las cantidades generadas
diariamente. 

ESPECIFICACIONES TECNICAS:
- El programa debe conectar con Github y dejar el codigo en la rama de Desarrollo
- Obtener la información del clima a traves de la API del sitio https://www.el-tiempo.net/
- La interfaz debe implementar el metodo produccionActiva() que es la que indica si ese día se produce chocolate o no.
- Clase Chocolate que herede de la clase Golosina con sus respectivos atributos.
- El jenkinsfile debe mostrar la información por consola de los chocolates generados. 

ENTREGABLES:
- Codigo del proyecto
- Captura de consola de jenkins
- Captura de consola de Java. La consola de Java debe informar si se puede producir chocolate o no, y en el caso de poderse, informar que fue lo que se produjo
el día de hoy. 

SET DE DATOS:
Nombre					CANTIDAD PRODUCIDA
- Chocolate Blanco			1000
- Choclate Negro			1500
- Chocolate con almendras		1200
- Chocolate con castañas de caju	1300
- Chocolate en rama			100
- Chocolate con 70% de cacao		1500


https://www.el-tiempo.net/api/json/v2/provincias/41/municipios/41001
 */


public class Main implements ProduccionActiva {
	public boolean produccionActiva(int temperatura) {
		boolean hayProduccion = false;
		if (temperatura < 40) {
			hayProduccion = true;
		}

		return hayProduccion;
	}

	public static void main(String[] args) {
		Main m = new Main();

		Chocolate blanco = new Chocolate("Chocolate Blanco", 1000);
		Chocolate negro = new Chocolate("Chocolate Negro", 1500);
		Chocolate alm = new Chocolate("Chocolate con almendras", 1200);
		Chocolate rama = new Chocolate("Chocolate en rama", 100);

		ArrayList<Chocolate> chocolates = new ArrayList();
		chocolates.add(blanco);
		chocolates.add(negro);
		chocolates.add(alm);
		chocolates.add(rama);

		try {

			// Sacamos la temperatura
			String temperatura = "";
			URL url = new URL("https://www.el-tiempo.net/api/json/v2/provincias/41");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.connect();

			int tiempoRespuesta = conn.getResponseCode();

			if (tiempoRespuesta != 200) {
				throw new RuntimeException("HttpResponse" + tiempoRespuesta);
			} else {
				Scanner sc1 = new Scanner(url.openStream());
				while (sc1.hasNext()) {
					temperatura = sc1.nextLine();
					temperatura = temperatura.substring(temperatura.indexOf("\"temperatures\""),
							temperatura.indexOf("\"temperatures\"") + 26);
					temperatura = temperatura.replace("{", "");
					temperatura = temperatura.replaceAll("\"", "");
					temperatura = temperatura.substring(temperatura.length() - 2);
					// System.out.println(temperatura);
				}
				sc1.close();

			}

			// Sacamos por pantalla y txt
			if (m.produccionActiva(Integer.parseInt(temperatura)) == true) {
				System.out.println("Hoy si se producirá chocolate.");
				File doc = new File("salida_0909.txt");
				doc.createNewFile();
				FileWriter fw = new FileWriter(doc);
				BufferedWriter bw = new BufferedWriter(fw);

				for (int i = 0; i < chocolates.size(); i++) {
					System.out.println(chocolates.get(i).toString());
					bw.write(chocolates.get(i).toString() + "\n");
				}

				System.out.println("\nArchivo de texto creado correctamente.");
				bw.close();
			} else {
				System.out.println("Hoy no habrá producción de chocolate, ya que la temperatura es de " + temperatura);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// Generación del Jenkins

		try {

			StringBuilder Jenkins = new StringBuilder();
			Jenkins.append("pipeline{\r\n");
		    Jenkins.append("agent any \r\n");
		    Jenkins.append("stages{ \r\n");
		    Jenkins.append("stage('Main'){ \r\n");
		    Jenkins.append("steps{ \r\n");
		    Jenkins.append("echo 'Chocolate [tipo=Blanco, cantidad producida=1000] Chocolate [tipo=Negro, cantidad producida=1500] Chocolate [tipo=Negro, cantidad producida=1500] Chocolate [tipo=Negro, cantidad producida=1500] Chocolate [tipo=Negro, cantidad producida=1500] Chocolate [tipo=Negro, cantidad producida=1500]' \r\n");
		    Jenkins.append("} \r\n");
		    Jenkins.append("} \r\n");
		    Jenkins.append("} \r\n");
		    Jenkins.append("} \r\n");

	        //System.out.println(Jenkins.toString());
	        BufferedWriter bw2 = new BufferedWriter(new FileWriter("JenkinsfileAA14.txt"));
	        bw2.write(Jenkins.toString());
			bw2.close();
			
			System.out.println("\nArchivo Jenkins generado correctamente.");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

interface ProduccionActiva {
	public boolean produccionActiva(int temperatura);
}