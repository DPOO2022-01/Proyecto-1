package project1.modelo;

public class Registro {
	//Atributos
	private String horaInicio;
	private String horaFin;
	private Actividad actividad;
	//Constructor
	public Registro(String horaInicio, String horaFin, Actividad actividad) 
	{
		this.horaInicio=horaInicio;
		this.horaFin=horaFin;
		this.actividad=actividad;
	}
	//Req funcionales
	public String actualizarRegistro() 
	{
		return "";
	}
	//Req no funcionales
	public String mostrarRegistro() 
	{
		return this.actividad+" hecha desde: "+this.horaInicio+" hasta "+this.horaFin;
	}
}

