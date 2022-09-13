package AA17;

import java.util.Scanner;

/*
  AA17
Generar un programa que funcione como un juego de adivinanzas, donde el usuario
tenga que adivinar un numero entre 1 y 1.000.000
Donde si adivina le damos un mensaje de "Adivinaste, campeon" y sino adivino que siga iterando hasta adivinar
teniendo el usuario hasta 5 intentos para adivinar, si excede este numero se le indica que perdio el juego. 
ESTRUCTURA DEL PROGRAMA:
Clase de usuario, clase principal, interfaz que implemente alguna variable y/o metodo
que el programa utilice utilizando lambda.

ENTREGABLES:
- Codigo del proyecto
- Captura de pantalla
- Subirlo al repositorio de Github
 */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce tu nombre: ");
		String nombre = sc.next();

		Usuario u1 = new Usuario(nombre);
		Jugar adivina = (jugador) -> {
			int numAleatorio = (int) (Math.random() * 1000000 + 1);
			int cont = 1;
			int num;
			boolean acertado = false;
			System.out.println(jugador.getNombre() + " Vamos a jugar a adivinar un numero entre 1 y 1000000");
			while (cont < 6) {
				

				System.out.println("Introduce el numero que crees que es");
				num = sc.nextInt();

				if (num == numAleatorio) {
					System.out.println("Enhorabuena lo adivinaste");
					acertado = true;
					cont = 6;
				} else if(numAleatorio > num) {
					System.out.println("El número secreto es MAYOR que " + num);
					System.out.println("Te quedan " + (5 - cont) + " intentos");

				}
				else if (numAleatorio < num) {
					System.out.println("El número secreto es MENOR que " + num);
					System.out.println("Te quedan " + (5 - cont) + " intentos");
				}
				
				cont++;
			}
			if (!acertado) {
				System.out.println("jaja k pringao la cagaste, era "+numAleatorio);
			}
			sc.close();

			return 0;
		};
		
		 adivina.jugar(u1);
		};
	}


