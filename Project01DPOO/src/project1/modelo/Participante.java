package project1.modelo;

import java.util.ArrayList;

public class Participante{
		//Atributos
		private String nombre;
		private String correo;
		private ArrayList<Registro> historial; 
		//Constructor
		public Participante(String nombre,String correo) 
		{
			this.nombre=nombre;
			this.correo=correo;
			historial= new ArrayList<Registro>();
		}
		//Req funcionales
		public void addRegistro(Registro nuevoRegistro) 
		{
			historial.add(nuevoRegistro);
		}
		//Req no funcionales
		public void mostrarRegistro() 
		{
			for(int i=0;i<historial.size();i++) 
			{
				System.out.println(i+"."+historial.get(i));
			}
		}
		public String getNombre() 
		{
			return this.nombre;
		}
		public String getCorreo() 
		{
			return this.correo;
		}
}
