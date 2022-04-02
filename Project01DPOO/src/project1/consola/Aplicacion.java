package project1.consola;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import project1.implementacion.Proyecto;
import project1.modelo.*;

public class Aplicacion {
	//Atributos
	//Constructor
	//Req funcionales
	public static void main(String[] argumentos) throws ParseException 
	{
		//Interacción Menu - usuario 
		System.out.println("Bienvenido a Thuesday.com\n");
		
		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				int opcion_seleccionada =Integer.parseInt(input("Por favor seleccione una opción: "));
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
					registrarUsuario();
					System.out.println("Opción 2");
				}	
				else if (opcion_seleccionada == 3) 
				{
					crearRegistro();
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
	
	private static void crearRegistro() {
		// TODO Auto-generated method stub
		
	}

	private static void registrarUsuario() 
	{
		String userName=input("Ingrese su nombre: ");
		String userAdr=input("Ingrese su correo electrónico: ");
		int tieneActividad=Integer.parseInt(input("Ingrese 1 si tiene una actividad asignada, de lo contrario ingrese 0, es decir, tiene asignado el proyecto: "));
		
		if (tieneActividad==1) 
		{
			Participante participante = new Participante(userName,userAdr);
		}
		else 
		{
			ParticipanteInicial participantei = new ParticipanteInicial(userName,userAdr);
		}
	}

	public static void mostrarMenu() 
	{
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Cargar Actividades");
		System.out.println("2. Registrar Usuario");
		System.out.println("3. Crear Registro en una Actividad");
	}
	private static void cargarDatos() throws FileNotFoundException, IOException, ParseException 
	{
		System.out.println("\n" + "Cargar un archivo de actividades" + "\n");
		String archivo = input("Por favor ingrese el nombre del archivo CSV con las actividades: ");
		cargarArchivos(archivo);
		System.out.println("Se cargó el archivo " + archivo + " con información de actividades.");
	}
	public static void cargarArchivos(String ruta) throws ParseException 
	{
		//Se define en qué forma se guarda la información
		
		//crear proyecto
		Proyecto proyect = new Proyecto();
		//mapa de actividades filtradas por titulo
		Map<String, Actividad> listActividades=new HashMap<String, Actividad>();
		
		BufferedReader br;
		String fechaInicial="";
		try {
			br = new BufferedReader(new FileReader(ruta));
			String linea = br.readLine();
			while (linea != null) {
			      String[] substr = linea.split(";");
			      Actividad actividad= new Actividad(substr[0],substr[1],substr[2]);
			      fechaInicial=input("Ingrese la fecha en formato dd/HH/mm (dia/hora/min)");
			      actividad.setFechaInicial(fechaInicial);
			      //añadir obj al Map
			      listActividades.put(actividad.getTitle(), actividad);
			      //añadir obj a la lista de actividades que tiene un proyecto
			      proyect.addActividad(actividad);
			}
			System.out.println("Información cargada");
		} catch (IOException e) {e.printStackTrace();}
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
