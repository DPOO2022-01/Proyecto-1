package project1.modelo;

public class Actividad {
	//Atributos
	private String titulo;
	private String descripcion;
	private String tipo;
	private String horaInicio;
	private String horaFin;
	private Participante creador;
	//Constructor
	public Actividad(String titulo, String descripcion, String tipo, String horaI, String horaF) 
	{
		this.titulo=titulo;
		this.descripcion=descripcion;
		this.tipo=tipo;
		horaInicio=horaI;
		horaFin=horaF;
	}
	//Req funcionales
	
	//Req no funcionales
	public Participante getCreador() 
	{
		return this.creador;
	}
	public void setCreador(Participante creador)
	{
		this.creador=creador;
	}
	public String getDescripcion() 
	{
		return this.descripcion;
	}
}
