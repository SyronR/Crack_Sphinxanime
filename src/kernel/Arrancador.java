package kernel;

import addons.Acerca;
import gui.GestorVentanas;

public class Arrancador {

	//////////////////////////////////////////
	// ATRIBUTOS /////////////////////////////
	//////////////////////////////////////////
		
	private GestorVentanas gestor;
	private Buscador buscador;
	private Acerca acerca;
	
	//////////////////////////////////////////
	// CONSTRUCTOR ///////////////////////////
	//////////////////////////////////////////
	
	public Arrancador() {
		acerca = new Acerca(this);
		gestor = new GestorVentanas(this);
		buscador = new Buscador(this);
	}
	
	//////////////////////////////////////////
	// METODOS ///////////////////////////////
	//////////////////////////////////////////
	
	public static void main(String[] args) {
		new Arrancador();
	}
	
	//////////////////////////////////////////
	// GET/SET ///////////////////////////////
	//////////////////////////////////////////
	
	public GestorVentanas getGestor() {
		return gestor;
	}

	public void setGestor(GestorVentanas gestor) {
		this.gestor = gestor;
	}

	public Buscador getBuscador() {
		return buscador;
	}

	public void setBuscador(Buscador buscador) {
		this.buscador = buscador;
	}

	public Acerca getAcerca() {
		return acerca;
	}

	public void setAcerca(Acerca acerca) {
		this.acerca = acerca;
	}
}
