package project1.consola;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Aplicacion {
	//Atributos
	//Constructor
	//Req funcionales
	public static void main(String[] argumentos) 
	{
		//Interacci�n Menu - usuario 
		System.out.println("Bienvenido a Thuesday.com\n");
		
		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				int opcion_seleccionada = 2;//Integer.parseInt(System.out.println("Por favor seleccione una opci�n�n"));
				if (opcion_seleccionada == 1) 
				{
					System.out.println("Opci�n 1");
					try {
						cargarDatos();
					} catch (FileNotFoundException e) 
					{
						e.printStackTrace();
					} catch (IOException e) 
					{
						e.printStackTrace();
					}
				}
				else if (opcion_seleccionada == 2) 
				{
					System.out.println("Opci�n 2");
				}	
				else if (opcion_seleccionada == 3) 
				{
					System.out.println("Opci�n 3");
				}
				else if (opcion_seleccionada == 4) 
				{
					System.out.println("Opci�n 4");
				}
				else if (opcion_seleccionada ==5)
				{
					System.out.println("Saliendo de la aplicaci�n ...");
					continuar = false;
				}
				else
				{
					System.out.println("Por favor seleccione una opci�n v�lida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los n�meros de las opciones.");
			}
		}
	}
	
	public static void mostrarMenu() 
	{
		System.out.println("\nOpciones de la aplicaci�n\n");
		System.out.println("1. Cargar un archivos");
		System.out.println("2. Mostrar actividades");
	}
	private static void cargarDatos() throws FileNotFoundException, IOException 
	{
		System.out.println("\n" + "Cargar un archivo de actividades" + "\n");

		String archivo = input("Por favor ingrese el nombre del archivo CSV con las actividades");
		cargarArchivos(archivo);
		System.out.println("Se carg� el archivo " + archivo + " con información de los Juegos Olímpicos.");
	}
	public static void cargarArchivos(String ruta) 
	{
		//Se define en qu� forma se guarda la informaci�n
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(ruta));
			String linea = br.readLine();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public static String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
}
