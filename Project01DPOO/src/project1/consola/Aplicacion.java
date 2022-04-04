package project1.consola;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import project1.implementacion.Proyecto;
import project1.modelo.*;

public class Aplicacion {
	private static Map<String, Actividad> listActividades = null; //atributo de la clase, no obj
	private static Map<String, Actividad> userActividad = null;
	static ArrayList<Proyecto> listaProyectos = new ArrayList<Proyecto>(); 
	//Constructor
	//Req funcionales
	
	public static void main(String[] argumentos) throws ParseException 
	{
		//Interacción Menu - usuario 
		System.out.println("Bienvenido a Thuesday.com\n");
		Map<String, Actividad> listActividades=getActividades();
		Map<String, Actividad> userActividad = getUserActividades();
		boolean continuar = true;
		String proyectoSeleccionado = "No ha seleccionado ningun proyecto.";
		while (continuar)
		{
			try
			{
				mostrarMenu(proyectoSeleccionado);
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción: "));
				if (opcion_seleccionada == 1)
				{
					System.out.println("\n");
					System.out.println("1. Crear un nuevo proyecto.");
					System.out.println("2. Seleccionar un proyecto existente.\n");
					int opcion_proyecto = Integer.parseInt(input("Por favor seleccione una opción: "));
					if (opcion_proyecto == 1)
					{
						System.out.println("Ingrese el nombre del proyecto: ");
						String nombreProyecto = input(" ");
						Proyecto proyectoActual = new Proyecto();
						proyectoActual.setNombre(nombreProyecto);
						proyectoSeleccionado = proyectoActual.getNombre();
						listaProyectos.add(proyectoActual);
					}
					else if (opcion_proyecto == 2)
					{
						for(int i=0;i<listaProyectos.size();i++) 
						{
							System.out.println((i+1)+". "+(listaProyectos.get(i)).getNombre());
							
						}
						int proyecto1 = Integer.parseInt(input("Por favor seleccione un proyecto: "));
						proyectoSeleccionado = (listaProyectos.get(proyecto1-1)).getNombre();
					}
				}
				else if (opcion_seleccionada == 2) 
				{
					System.out.println("Opción 2");
					try {
						cargarDatos(listActividades);
					} catch (FileNotFoundException e) 
					{
						e.printStackTrace();
					} catch (IOException e) 
					{
						e.printStackTrace();
					}
				}
				else if (opcion_seleccionada == 3) 
				{
					registrarUsuario(userActividad);
					System.out.println("Opción 3");
				}	
				else if (opcion_seleccionada == 4) 
				{
					crearRegistro(userActividad);
					System.out.println("Opción 4");
				}
				else if (opcion_seleccionada == 5) 
				{
					actividadesParticipante(userActividad);
					System.out.println("Opción 5");
				}
				else if (opcion_seleccionada == 6) 
				{
					historialUsuario(userActividad);
					System.out.println("Opción 6");
				}
				else if (opcion_seleccionada == 7) 
				{
					mostrarActividades(listActividades);
					System.out.println("Opción 7");
				}
				else if (opcion_seleccionada == 8)
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
	public static void mostrarMenu(String proyectoSleccionado) 
	{
		System.out.println("\nPROYECTO ACTUAL: "+proyectoSleccionado);
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Seleccionar/Crear proyecto");
		System.out.println("2. Cargar Actividades");
		System.out.println("3. Registrar Usuario");
		System.out.println("4. Crear Registro en una Actividad");
		System.out.println("5. Consultar actividades de un participante");
		System.out.println("6. Consultar historial de un usuario");
		System.out.println("7. Mostrar actividades del proyecto");
		//System.out.println("8. Mostrar tiempo empleado en una actividad");
		//System.out.println("9. Mostrar promedio de tiempo empleado en el proyecto");
		System.out.println("8. Salir de la aplicación");
	}
	private static void crearRegistro(Map<String, Actividad> userActividad) throws ParseException {
		String userName=input("Ingrese su nombre: ");
		String fechaInicio=input("Ingrese la fecha de inicio en el formato dd/hh/mm: ");
		String fechaFin=input("Ingrese la fecha actual en el formato dd/hh/mm: ");
		Actividad userAct = userActividad.get(userName);
		userAct.setFechaFinal(fechaFin);
		userAct.setFechaInicial(fechaInicio);
		Participante paticipanteAct = userAct.getCreador();
		Registro registroNuevo= new Registro(fechaInicio, fechaFin,userAct);
		paticipanteAct.addRegistro(registroNuevo);
		System.out.println("Registro creado");
		
	}
	private static void registrarUsuario(Map<String, Actividad> userActividad) 
	{
		String userName=input("Ingrese su nombre: ");
		String userAdr=input("Ingrese su correo electrónico: ");
		int tieneActividad=Integer.parseInt(input("Ingrese 1 si tiene una actividad asignada, de lo contrario ingrese 0 para escoger una actividad: "));
		
		if (tieneActividad==1) 
		{
			if(userActividad.containsKey(userName)) 
			{
				Actividad actividadAsignada=userActividad.get(userName);
				System.out.println(userName+" tiene asignada la actividad "+actividadAsignada.getTitle());
			}
			else 
			{
				System.out.println("\nUsted no tienen una actividad asignada aún, a continuación se le asignará una.");
				ArrayList<Actividad> listActividades= new ArrayList<Actividad>(userActividad.values());
				String text="";
				for (Actividad cadaAct: listActividades) 
				{
					if (!cadaAct.getTieneCreador()) 
					{
						Participante participanteNuevo = new Participante(userName, userAdr);
						cadaAct.setCreador(participanteNuevo);
						cadaAct.setTieneCreador(true);
						text="Se le asignó la actividad "+cadaAct.getTitle();
						break;
					}
				}
				System.out.println("Se le asignó la actividad "+text);	
			}
		}
		else 
		{
			System.out.println("\nUsted no tienen una actividad asignada aún, a continuación se le asignará una");
			ArrayList<Actividad> listActividades= new ArrayList<Actividad>(userActividad.values());
			String text="";
			for (Actividad cadaAct: listActividades) 
			{
				if (!cadaAct.getTieneCreador()) 
				{
					Participante participanteNuevo = new Participante(userName, userAdr);
					cadaAct.setCreador(participanteNuevo);
					cadaAct.setTieneCreador(true);
					text="Se le asignó la actividad "+cadaAct.getTitle();
					break;
				}
			}
			System.out.println("Se le asignó la actividad "+text);
		}
	}
	private static void cargarDatos(Map<String, Actividad> listActividades) throws FileNotFoundException, IOException, ParseException 
	{
		
		System.out.println("\n" + "Cargar un archivo de actividades" + "\n");
		String archivo = input("Por favor ingrese el nombre del archivo CSV con las actividades: ");
		cargarArchivos(archivo,listActividades);
		System.out.println("Se cargó el archivo " + archivo + " con información de actividades.");
	}
	public static void cargarArchivos(String ruta,Map<String, Actividad> listActividades) throws ParseException 
	{
		//Se define en qué forma se guarda la información
		
		//crear proyecto
		Proyecto proyect = new Proyecto();
		//crear Participante inicial, pues este es quien inicializa el proyecto por default
		String userName=input("Ingrese su nombre: ");
		String userAdr=input("Ingrese su correo electrónico: ");
		ParticipanteInicial participanteI= new ParticipanteInicial(userName,userAdr);
		participanteI.setProyecto(proyect);
		proyect.setFundador(participanteI);
		//mapa de actividades filtradas por titulo por entrada

		BufferedReader br;
		//String fechaInicial="";
		try {
			br = new BufferedReader(new FileReader(ruta));
			String linea = br.readLine();
			while (linea != null) {
			      String[] substr = linea.split(";");
			      Actividad actividad= new Actividad(substr[0],substr[1],substr[2]);
			      //fechaInicial=input("Ingrese la fecha en formato dd/HH/mm (dia/hora/min)");
			      //actividad.setFechaInicial(fechaInicial);
			      //actividad.setFechaFinal("00/00/00"); //fecha default para la primer vez que se crea una actividad
			      //añadir obj al Map
			      listActividades.put(actividad.getTitle(), actividad);
			      //añadir obj a la lista de actividades que tiene un proyecto
			      proyect.addActividad(actividad);
			      System.out.println(actividad.getTitle());
			      //siguiente linea
			      linea = br.readLine();
			}
			System.out.println("Información cargada correctamente");
		} catch (IOException e) {e.printStackTrace();}
	}
	public static void actividadesParticipante(Map<String, Actividad> userActividad) 
	{
		String userName=input("Ingrese su nombre: ");
		Actividad act=userActividad.get(userName);
		System.out.println("\nEl usuario "+userName+" tiene asignada la actividad "+act.getTitle());
		System.out.println("\n"+act.getTipo());
		System.out.println("\n"+act.getCreador().getNombre());
	}
	public static void historialUsuario(Map<String, Actividad> userActividad) 
	{
		String userName=input("Ingrese su nombre: ");
		Actividad act=userActividad.get(userName);
		act.getCreador().mostrarRegistro();
	}
	public static void mostrarActividades(Map<String, Actividad> listActividades) 
	{
		int i=1;
		ArrayList<Actividad> listaActividades= new ArrayList<Actividad>(userActividad.values());
		for (Actividad cadaAct: listaActividades) 
		{
			System.out.println("\nLa actividad #"+i+" es "+cadaAct.getTitle());
			System.out.println("\nCaracterizada por ser de tipo "+cadaAct.getTipo());
			System.out.println("\nSu creador es"+cadaAct.getCreador().getNombre());
			i++;
		}
	}
	public static Map<String, Actividad> getActividades() 
	{
		listActividades=new HashMap<String, Actividad>();
		return listActividades;
	}
	public static Map<String, Actividad> getUserActividades() 
	{
		userActividad=new HashMap<String, Actividad>();
		return userActividad;
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
