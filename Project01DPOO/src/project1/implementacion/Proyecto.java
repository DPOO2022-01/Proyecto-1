package project1.implementacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import project1.modelo.*;

public class Proyecto {
	//Atributos
	private String nombre;
	private Date fechaInicio;
	private Date fechaFinal;
	private ParticipanteInicial fundador;
	private ArrayList<Actividad> actividades;
	private ArrayList<Participante> participantes;
	public final static SimpleDateFormat formato=new SimpleDateFormat("dd/HH/mm" );
	//Constructor
	public Proyecto() 
	{
		this.actividades=new ArrayList<Actividad>();
		this.participantes=new ArrayList<Participante>();
	}
	//Req funcionales
	//Req no funcionales
	public String getNombre()
	{
		return this.nombre;
	}
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	public Date setFechaInicial(String fechaI) throws ParseException 
	{
		this.fechaInicio=formato.parse(fechaI);
		return fechaInicio;
	}
	public Date setFechaFinal(String fechaF) throws ParseException 
	{
		this.fechaFinal=formato.parse(fechaF);
		return fechaFinal;
	}
	public ParticipanteInicial getFundador() 
	{
		return this.fundador;
	}
	public void setFundador(ParticipanteInicial fundador) 
	{
		this.fundador=fundador;
	}
	public void addActividad(Actividad actividad) 
	{
		this.actividades.add(actividad);
	}
	public void addParticipantes(Participante participante) 
	{
		this.participantes.add(participante);
	}
}
