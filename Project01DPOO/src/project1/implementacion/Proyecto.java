package project1.implementacion;

import project1.modelo.ParticipanteInicial;

public class Proyecto {
	//Atributos
	private String nombre;
	private String fechaInicio;
	private String fechaFinal;
	private String descripcion;
	private ParticipanteInicial fundador;
	//Constructor
	public Proyecto(String nombre, String fechaI,String fechaF,String descripcion) 
	{
		this.nombre=nombre;
		fechaInicio=fechaI;
		fechaFinal=fechaF;
		this.descripcion=descripcion;
	}
	//Req funcionales
	//Req no funcionales
	public ParticipanteInicial getFundador() 
	{
		return this.fundador;
	}
	public void setFundador(ParticipanteInicial fundador) 
	{
		this.fundador=fundador;
	}
	public String getDescripcion() 
	{
		return this.descripcion;
	}
}
