package AA16;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigurarSpring.class)) {
			Servicio servicio = ctx.getBean(Servicio.class);
			servicio.generarArchivo();
			servicio.exito();
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce tu nombre de usuario: ");
		String nombre = sc.next();

		System.out.println("Introduce tu ID: ");
		int id = sc.nextInt();

		System.out.println("Introduce tu email de usuario: ");
		String email = sc.next();

		Usuario u1 = new Usuario(nombre, id, email);

		lecturaCanciones("C:\\Users\\crome\\EXPERIS\\AOPEjemplo\\src\\AA16\\Canciones_2020.txt", u1);
		lecturaCanciones("C:\\Users\\crome\\EXPERIS\\AOPEjemplo\\src\\AA16\\Canciones_2021.txt", u1);
		lecturaArtistas("C:\\Users\\crome\\EXPERIS\\AOPEjemplo\\src\\AA16\\Artistas_2020.txt", u1);
		lecturaArtistas("C:\\Users\\crome\\EXPERIS\\AOPEjemplo\\src\\AA16\\Artistas_2021.txt", u1);
	}

	public static void lecturaCanciones(String file, Usuario u) {

		List<String> listOfStrings = new ArrayList<String>();
		List<Canciones> canciones = new ArrayList<Canciones>();

		try {
			BufferedReader bf = new BufferedReader(new FileReader(file));

			// read entire line as string
			String line = bf.readLine();

			// checking for end of file
			while (line != null) {
				String line1 = line.replace("	", " ");
				String line2 = line1.replace(".", "");
				listOfStrings.add(line2);

				String[] visualizaciones = line2.split("\\s+");
				int visual = visualizaciones.length;
				int visitas = Integer.parseInt(visualizaciones[visual - 1]);
				// System.out.println(visitas);

				int guion = line2.indexOf("-");
				// System.out.println(line2);
				// System.out.println(guion);
				int space = line2.lastIndexOf(" ");
				// System.out.println(space);

				int guion2 = line2.lastIndexOf("-");

				// System.out.println("Cantante: "+line2.substring(guion, space).toString());
				String cantante = line2.substring(guion, space).toString();
				// System.out.println("Cancion: "+line2.substring(0, guion2).toString());
				String cancion = line2.substring(0, guion2).toString();
				// System.out.println(cancion);
				// System.out.println(cantante);

				line = bf.readLine();

				// artistas.add(new Artistas(cantante, cantante));
				canciones.add(new Canciones(cantante, cantante, cancion, visitas));

				// System.out.println(artistas.toString());
				// System.out.println(canciones.toString());
				// closing bufferreader object

			}
			bf.close();
			escrituraFicheros(canciones, file, u);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void lecturaArtistas(String file, Usuario u) {

		List<Artistas> artistas = new ArrayList<Artistas>();

		try {
			BufferedReader bf = new BufferedReader(new FileReader(file));

			// read entire line as string
			String line = bf.readLine();

			// checking for end of file
			while (line != null) {
				System.out.println(line);
				artistas.add(new Artistas(line, line));
				line = bf.readLine();
			}

			escrituraFicheros(artistas, file, u);
			// System.out.println(artistas.toString());

			// closing bufferreader object
			bf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void escrituraFicheros(List lista, String file, Usuario u) {

		FileWriter fichero = null;
		try {

			fichero = new FileWriter("TOP_SPOTIFY.txt", true);
			int final1 = file.lastIndexOf("\\");
			int final2 = file.lastIndexOf(".");
			String file2 = file.substring(final1, final2);
			file2.replace("_", "");
			file2.replace("\\", "");
			fichero.write("ARCHIVO GENERADO POR " + u);
			fichero.write("\n");
			fichero.write("\n");
			fichero.write("TOP 10 " + file2);
			fichero.write("\n");
			fichero.write("\n");

			// Escribimos linea a linea en el fichero
			for (Object lis : lista) {
				fichero.write(lis + "\n");
				fichero.write("\n");
			}

			fichero.close();

		} catch (Exception ex) {
			System.out.println("Mensaje de la excepción: " + ex.getMessage());
		}

	}

	interface Recaudacion {
		public void recaudacion();
	}
}