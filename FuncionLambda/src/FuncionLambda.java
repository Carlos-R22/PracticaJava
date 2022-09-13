import java.util.Scanner;
/*
 * 	Crear un programa que implemente una funci�n lambda, una interfaz y una clase
 *  donde se pase por consola los resultados de una suma. Se deben pedir 2 valores
 *  por consola
 */


public class FuncionLambda 
{	
	public static void main (String [] args)
	{
		Suma suma_lambda = (t1, t2) -> t1 + t2;
		Scanner sc = new Scanner(System.in);
		int n1, n2;
		System.out.println("Introduce dos numeros para ser sumados \n");
		n1= sc.nextInt();
		System.out.println("n2: ");
		n2 = sc.nextInt();
		sumar(n1, n2, suma_lambda);
		sc.close();
	}
	
	public static void sumar (int n1, int n2, Suma formato)
	{
		int resultado = formato.ejecutar(n1,  n2);
		System.out.println("La suma es: " + resultado);
	}
	
interface Suma 
{
		int ejecutar (int n1, int n2);
}
	
}