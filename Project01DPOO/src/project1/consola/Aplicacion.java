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
		//Interacción Menu - usuario 
		System.out.println("Bienvenido a Thuesday.com\n");
		
		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				int opcion_seleccionada = 2;//Integer.parseInt(System.out.println("Por favor seleccione una opción³n"));
				if (opcion_seleccionada == 1) 
				{
					System.out.println("Opción 1");
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
					System.out.println("Opción 2");
				}	
				else if (opcion_seleccionada == 3) 
				{
					System.out.println("Opción 3");
				}
				else if (opcion_seleccionada == 4) 
				{
					System.out.println("Opción 4");
				}
				else if (opcion_seleccionada ==5)
				{
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}
				else
				{
					System.out.println("Por favor seleccione una opción válida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
	}
	
	public static void mostrarMenu() 
	{
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Cargar un archivos");
		System.out.println("2. Mostrar actividades");
	}
	private static void cargarDatos() throws FileNotFoundException, IOException 
	{
		System.out.println("\n" + "Cargar un archivo de actividades" + "\n");

		String archivo = input("Por favor ingrese el nombre del archivo CSV con las actividades");
		cargarArchivos(archivo);
		System.out.println("Se cargó el archivo " + archivo + " con informaciÃ³n de los Juegos OlÃ­mpicos.");
	}
	public static void cargarArchivos(String ruta) 
	{
		//Se define en qué forma se guarda la información
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
