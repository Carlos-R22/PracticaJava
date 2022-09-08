package AA9;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/*
 AA9
RELEVAMIENTO:
Nos contratan de una empresa de videojuegos para poder ayudarlos a desarrollar una APP
que almacene la información de los titulos mas importantes que tienen hoy en día
Para esto, debemos desarrollar un programa que informe a los empleados los titulos de videojuegos 
y sus respectivas ventas con el monto total que viene acumulando dichas ventas. 

ESTRUCTURA DEL PROGRAMA:
- Contar con una interfaz que calcule el monto total de los videojuegos y su recaudación
- TXT de salida que informe titulos, cantidades de unidades vendidas y monto total.
- Contar con una clase llamada videojuego que tenga atributos pertinentes a los videojuegos.

ENTREGABLES: 
- El proyecto debe estar publicado en Github
- Enviar el link del repo
- Enviar el codigo
- Enviar el TXT de salida.  


VIDEOJUEGOS:			CANTIDAD DE REGISTROS		PRECIO UNITARIO
DARK SOULS 3 				10000					5
THE LAST OF US 				50000					10
FIFA 2022					60000					15
MARIO BROSS					45000					1
DOOM 2						100000					1
HORIZON						50000					5

 */


public class Main {

	public static void main(String[]args) throws IOException {
		// TODO Auto-generated constructor stub
		
		List<String> lista = new ArrayList();
		Videojuegos a1 = new Videojuegos("DARK SOULS 3", 10000, 5, 0);
		Videojuegos a2 = new Videojuegos("MY LITTLE PONNY 5", 250000, 10,0);
		Videojuegos a3 = new Videojuegos("THE LAST OF US", 50000, 15,0);
		Videojuegos a4 = new Videojuegos("FIFA 1999", 100000, 7.5,0);
		Videojuegos a5 = new Videojuegos("PRINCES PEACH", 125564, 1,0);
		Videojuegos a6 = new Videojuegos("DOOM 21455", 10, 52,0);
		Videojuegos a7 = new Videojuegos("COOKING MAMA", 10000, 5,0);
		
		a1.setGananciasT((double)a1.getPrecio()*a1.getVenta());
		a2.setGananciasT((double)a2.getPrecio()*a2.getVenta());
		a3.setGananciasT((double)a3.getPrecio()*a3.getVenta());
		a4.setGananciasT((double)a4.getPrecio()*a4.getVenta());
		a5.setGananciasT((double)a5.getPrecio()*a5.getVenta());
		a6.setGananciasT((double)a6.getPrecio()*a6.getVenta());
		a7.setGananciasT((double)a7.getPrecio()*a7.getVenta());
		
		lista.add(a1.toString());
		lista.add(a2.toString());
		lista.add(a3.toString());
		lista.add(a4.toString());
		lista.add(a5.toString());
		lista.add(a6.toString());
		lista.add(a7.toString());
		
		
		try {
		Path path = Paths.get("videojuegos.txt");
		//FileWriter file = new FileWriter (path);
		//PrintWriter pw = new PrintWriter(file);

		Files.write(path, lista);
         for (Object l: lista)
        	 System.out.println(l);
             //pw.println(lista);

		}catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
          
           } catch (Exception e2) {
              e2.printStackTrace();
           }}
		
		
		
	}


	
}
