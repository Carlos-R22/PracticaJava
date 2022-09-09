package AA14;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

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