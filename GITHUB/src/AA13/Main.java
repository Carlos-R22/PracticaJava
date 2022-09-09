package AA13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/*
 AA13
ACTIVIDAD INTEGRADORA DE JAVA - Github - Jenkins

Nos contrataron de una empresa que desea implementar la metodologia de Integración Continua. Para esto, nos piden que desarrollemos un programa en Java que implemente un jenkinsfile
Ademas de eso, quieren que contabilicemos el TOP 20 de peliculas con mayor recaudación de LA HISTORIA. Para esto, nos dejaron un archivo con las 10 peliculas siguientes al top 10 con mayor recaudación
en la historia. 
PELICULA A 1
PELICULA B 2
PELICULA C 3
PELICULA D 4
PELICULA E 5
PELICULA F 6
PELICULA G 7
PELICULA H 8
PELICULA I 9
PELICULA J 10
PELICULA A 11
PELICULA B 12
PELICULA C 13
PELICULA D 14
PELICULA E 15
PELICULA F 16
PELICULA G 17
PELICULA H 18
PELICULA I 19
PELICULA J 20
El archivo debe estar ordenado por recaudación (de mayor recaudación a menor recaudación) 

En GitHub:
Subir todo el proyecto de Java, una vez generados los TXTS. 

En Jenkins:
(SOBRE LA RAMA PRINCIPAL) 
El jenkinsfile debe ser tomado del repositorio en Github. El contenido del mismo debe mostrar por consola (Consola de Jenkins) el siguiente mensaje:
"Hola Mundo! EL día de hoy es elDia (variable que almacene la fecha).
 Este curso me hizo programar mas de lo que me hubiese gustado" 

¿COMO FUNCIONA ESTO? 
1) Crear un nuevo proyecto en Eclipse "AA13 - Java integrado a Jenkins y Github"
2) Desarrollar la estructura del programa. 
3) Desarrollar el jenkinsfile. 
4) Actualizar el repo desde Eclipse a Github
5) Una vez actualizado el repo, configurar en jenkins la busqueda del jenkinsfile generado por el proyecto. 

ENTREGABLES: 
- Codigo del proyecto de Java. 
- Captura de la pantalla de Java mostrando las 20 mejores peliculas
- Captura de la pantalla de Jenkins
- TXT de Salida de peliculas (Llamarlo "top20_mejores_peliculas.txt")

¿COMO GENERAR EL JENKINSFILE? 
Un jenkinsfile es un simple TXT. GENERAMOS UN TXT Y LE INSERTAMOS EL CODIGO QUE ESPERA JENKINS.  
 */

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		List<Peliculas> pelis = new ArrayList<>();

		List<String> listOfStrings = new ArrayList<String>();

		// load data from file
		BufferedReader bf = new BufferedReader(
				new FileReader("C:\\Users\\crome\\git\\PracticaJava\\GITHUB\\src\\AA13\\Peliculas_11_20.txt"));

		// read entire line as string
		String line = bf.readLine();

		// checking for end of file
		while (line != null) {
			String line1 = line.replace("$", "");
			String line2 = line1.replace(",", "");
			listOfStrings.add(line2.replace(" ", "_"));
			line = bf.readLine();
		}

		// closing bufferreader object
		bf.close();

		BufferedReader bf2 = new BufferedReader(
				new FileReader("C:\\Users\\crome\\git\\PracticaJava\\GITHUB\\src\\AA13\\top10.txt"));

		// read entire line as string
		String line4 = bf2.readLine();

		// checking for end of file
		while (line4 != null) {
			String line5 = line4.replace("$", "");
			String line6 = line5.replace(",", "");
			listOfStrings.add(line6.replace(" ", "_"));
			line4 = bf2.readLine();
		}

		// closing bufferreader object
		bf2.close();

		// storing the data in arraylist to array
		String[] array = listOfStrings.toArray(new String[0]);

		// printing each line of file
		// which is stored in array
		for (String str : array) {
			//System.out.println(str);
			String[] clase = str.split(" ");
			int pos = clase[0].length();
			//System.err.println(pos);
			int pos2 = clase[0].lastIndexOf("_")+1;
			//System.out.println(pos2);
			String parte = clase[0].substring(pos2, pos);
			//System.out.println(parte);
			pelis.add(new Peliculas(parte, clase[0].replace("_", " ").substring(0, pos2)));
		}
		
		
		Collections.sort(pelis, new Comparator<Peliculas>() {
			@Override
			public int compare(Peliculas p1, Peliculas p2) {
				return p2.getRecaudacion().compareTo(p1.getRecaudacion());
			}
		});
		
		System.out.println(pelis);
		
		FileWriter writer = new FileWriter("top20_mejores_peliculas.txt"); 
		for(Peliculas str: pelis) {
		  writer.write(str + System.lineSeparator());
		}
		writer.close();
		
		StringBuilder Jenkins = new StringBuilder();
        Jenkins.append("import java.time.LocalDate\r\n");
        Jenkins.append("pipeline{\r\n");
        Jenkins.append("agent any \r\n");
        Jenkins.append("stages{ \r\n");
        Jenkins.append("stage('Main'){ \r\n");
        Jenkins.append("steps{ \r\n");
        Jenkins.append("script{ \r\n");
        Jenkins.append("def fecha = LocalDate.now() \r\n");
        Jenkins.append("def texto = 'Hola Mundo! EL día de hoy es elDia' + fecha.getDayOfWeek() \r\n");
        Jenkins.append("def texto2 = 'Este curso me hizo programar mas de lo que me hubiese gustado.' \r\n");
        Jenkins.append("println texto \r\n");
        Jenkins.append("println texto2 \r\n");
        Jenkins.append("} \r\n");
        Jenkins.append("} \r\n");
        Jenkins.append("} \r\n");
        Jenkins.append("} \r\n");
        Jenkins.append("} \r\n");

        //System.out.println(Jenkins.toString());
        BufferedWriter bw2 = new BufferedWriter(new FileWriter("JenkinsfileAA13.txt"));
        bw2.write(Jenkins.toString());
		bw2.close();
	}
	
	
}
