package project1.modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Actividad {
	//Atributos
	public final static SimpleDateFormat formato=new SimpleDateFormat("dd/HH/mm" );
	private String titulo;
	private String descripcion;
	private String tipo;
	private Date horaInicio;
	private Date horaFin;
	private Participante creador;
	private Boolean tieneCreador;
	private ArrayList<Registro> registros;
	//Constructor
	public Actividad(String titulo, String descripcion, String tipo) 
	{
		this.titulo=titulo;
		this.descripcion=descripcion;
		this.tipo=tipo;
		this.creador=null;
		this.tieneCreador=false;
		this.registros=new ArrayList<Registro>();
	}
	//Req funcionales
	
	public ArrayList<Registro> getReporte()
	{
		return this.registros;
	}
	
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
	public Date setFechaInicial(String fechaI) throws ParseException 
	{
		this.horaInicio=formato.parse(fechaI);
		return horaInicio;
	}
	public Date setFechaFinal(String fechaF) throws ParseException 
	{
		this.horaFin=formato.parse(fechaF);
		return horaFin;
	}
	public String getTitle() 
	{
		return this.titulo;
	}
	public ArrayList<Registro> getRegistros()
	{
		return this.registros;
	}
	public String getTipo() 
	{
		return this.tipo;
	}
	public Boolean getTieneCreador() 
	{
		return this.tieneCreador;
	}
	public void setTieneCreador(Boolean f) 
	{
		this.tieneCreador=f;
	}
	@SuppressWarnings("deprecation") //manejo de error extraño
	public int calcularDemora(Date fecha1, Date fecha2) 
	{
		int calc=0, f1_d,f1_h,f1_m,f2_d,f2_h,f2_m;
		f1_d=fecha1.getDay()*1440; //1440 minutos en un día
		f1_h=fecha1.getHours()*60; //60 minutos en una hora
		f1_m=fecha1.getMinutes();
		f2_d=fecha2.getDay()*1440;
		f2_h=fecha2.getHours()*60;
		f2_m=fecha2.getMinutes();
		calc=f1_d+f1_h+f1_m+f2_d+f2_h+f2_m;
		return calc;
	}
}
