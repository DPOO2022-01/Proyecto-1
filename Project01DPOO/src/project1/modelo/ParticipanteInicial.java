package project1.modelo;

import project1.implementacion.Proyecto;

public class ParticipanteInicial extends Participante{
	//atributos + los heredados
	private Proyecto proyecto;
	//Constructor
	public ParticipanteInicial(String nombre, String correo) {
		super(nombre, correo);
	}
	//Req funcionales
	//Req no funcionales
	public Proyecto getProyecto() {
		return proyecto;
	}
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	
}
