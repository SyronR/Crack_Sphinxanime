package addons;

import kernel.Arrancador;

public class Acerca {

	//////////////////////////////////////////
	// ATRIBUTOS /////////////////////////////
	//////////////////////////////////////////

	private String desarrollador;
	private String version;
	private String correo;
	private String cambios;
	private String enlace;

	private Arrancador main;

	//////////////////////////////////////////
	// CONSTRUCTOR ///////////////////////////
	//////////////////////////////////////////

	public Acerca(Arrancador main) {
		desarrollador = "Alberto Gálvez / Syron Power";
		version = "1.0 (Semillas)";
		correo = "galvezssr@gmail.com / syronpower@gmail.com";
		cambios = "Compilado en Java 8";
		enlace = "https://box.sphinxanime.net/?v=";

		this.main = main;
	}

	//////////////////////////////////////////
	// METODOS ///////////////////////////////
	//////////////////////////////////////////
	
	//////////////////////////////////////////
	// GET/SET ///////////////////////////////
	//////////////////////////////////////////

	public String getDesarrollador() {
		return desarrollador;
	}

	public String getVersion() {
		return version;
	}

	public String getCorreo() {
		return correo;
	}

	public String getCambios() {
		return cambios;
	}

	public Arrancador getArrancador() {
		return main;
	}

	public String getUso() {
		return enlace;
	}
	
}
