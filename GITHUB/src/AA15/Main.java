package AA15;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

/*
AA15
Este programa debe tener implementado lo siguiente:
- Composición
- Interfaces
- Herencia
- Manejo de Ficheros
- Implementación de un archivo JSON a traves de una API
- Mensaje por consola de Jenkins
- Implementación del proyecto en la rama de Desarrollo con merge en la rama principial (main o master segun aplique)
https://public.opendatasoft.com/explore/dataset/provincias-espanolas/table/?sort=-provincia


PROBLEMATICA: 
Nos contrataron desde el gobierno de España para diseñarles un programa que les informe las Provincias y sus respectivas capitales, el programa debe tener la capacidad de generar un archivo TXT de salida informando por cada provincia
su capital. El txt de salida debe tener la fecha de cuando corrio el proceso dentro del archivo. 

ESTRUCTURA DEL PROGRAMA: 
- Contar con al menos 3 clases, una de Provincia, una de Capital de provincia y otra a definir por el programador.
- Contar con un metodo implementado en una interfaz que conste de generar el archivo de salida.
- Utilizar la composición para implementar la información del usuario que lo implemente. Ejemplo: ID_USUARIO: 1 Nombre del usuario: Vargas,Gustavo Fecha Login 12/09/2022
(!) La información del usuario debe ir en el TXT implementada 
- Mostrar la información por consola de Jenkins. Generando un jenkinsfile que implemente la salida


ENTREGABLES:
- Codigo del proyecto
- Captura de consola de Jenkins 
- TXT de salida 
 */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce tu ID");
		int id = teclado.nextInt();
		System.out.println("Introduce tu nombre");
		String nombre = teclado.next();

		Usuario u1 = new Usuario(id, nombre, LocalDate.now());

		try {
			URL url = new URL(
					"https://public.opendatasoft.com/api/records/1.0/search/?dataset=provincias-espanolas&q=&rows=0&sort=-provincia&facet=ccaa&facet=provincia");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.connect();

			int tiempoRespuesta = conn.getResponseCode(); // Para manejo de
			// Situaciones

			if (tiempoRespuesta != 200) {
				throw new RuntimeException("HttpResponse" + tiempoRespuesta);
			} else {

				Scanner sc = new Scanner(url.openStream());
				String json = "";
				while (sc.hasNextLine()) {
					json = json + sc.nextLine();
				}
				sc.close();
				JSONObject objetoJSON = new JSONObject(json);
				JSONArray arrayJSON = (JSONArray) objetoJSON.get("facet_groups");
				objetoJSON = (JSONObject) arrayJSON.get(1);
				arrayJSON = (JSONArray) objetoJSON.get("facets");
				// System.out.println(arrayJSON);
				List<Provincia> listaProvincia = new ArrayList<>();
				for (Object iter : arrayJSON) {
					new Provincia(((JSONObject) iter).getString("name").toString());
					listaProvincia.add(
							new Capital(((JSONObject) iter).getString("path"), ((JSONObject) iter).getString("name")));
				}

				System.out.println(listaProvincia);

				File file = new File("APIcapitales.txt");
				try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
					writer.write(u1.toString());
					writer.write(listaProvincia.toString());

				}
				StringBuilder Jenkins = new StringBuilder();
				Jenkins.append("pipeline{\r\n");
			    Jenkins.append("agent any \r\n");
			    Jenkins.append("stages{ \r\n");
			    Jenkins.append("stage('Main'){ \r\n");
			    Jenkins.append("steps{ \r\n");
			    Jenkins.append("def data = readFile(file:  \"APIcapitales.txt\")\r\n");
			    Jenkins.append("println(data) \r\n");
			    Jenkins.append("} \r\n");
			    Jenkins.append("} \r\n");
			    Jenkins.append("} \r\n");
			    Jenkins.append("} \r\n");

		        //System.out.println(Jenkins.toString());
		        BufferedWriter bw2 = new BufferedWriter(new FileWriter("JenkinsfileAA15.txt"));
		        bw2.write(Jenkins.toString());
				bw2.close();
				
				System.out.println("\nArchivo Jenkins generado correctamente.");

			}
			teclado.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	interface salidaTXT {
		public void salidaTXT();
	}
}
