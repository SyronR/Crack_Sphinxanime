package kernel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

public class ListaNegra {

	//////////////////////////////////////////
	// ATRIBUTOS /////////////////////////////
	//////////////////////////////////////////

	private File fichero;
	private File carpeta;
	private HashSet<Short> listaNegra;
	private Arrancador arrancador;

	//////////////////////////////////////////
	// CONSTRUCTOR ///////////////////////////
	//////////////////////////////////////////

	public ListaNegra(Arrancador arrancador) {
		this.carpeta = new File("config");
		this.fichero = new File("config/listaNegra.conf");
		this.listaNegra = new HashSet<>();
		this.arrancador = arrancador;

		inicializador();
	}

	//////////////////////////////////////////
	// METODOS ///////////////////////////////
	//////////////////////////////////////////

	private void inicializador() {

		/** Este metodo comprobara si el archivo de configuracion esta presente o no **/

		// Comprobar carpeta
		
		if (!carpeta.exists()) {
			carpeta.mkdir();
		}
				
		
		// Comprobar fichero
		
		try {
			fichero.createNewFile();

		} catch (IOException e1) {
			arrancador.getGestor().error("ERROR: No se ha podido crear la lista negra. Error de permisos");
			arrancador.getGestor().getVentanaRegistro().escribirEnRegistro("ERROR: No se ha podido crear la lista negra. Error de permisos");

		}
		
		
		String linea;
		try (BufferedReader lectura = new BufferedReader(new FileReader(fichero))) {

			while ((linea = lectura.readLine()) != null) {
				listaNegra.add(Short.parseShort(linea));
			}

		} catch (FileNotFoundException e) {
			arrancador.getGestor().getVentanaRegistro().escribirEnRegistro( e.getMessage() );
			
		} catch (IOException e) {
			arrancador.getGestor().getVentanaRegistro().escribirEnRegistro( e.getMessage() );
		}

	}
	
	private void actualizarListaNegra() {
		
		try (BufferedWriter escritura = new BufferedWriter(new FileWriter(fichero, false))) {
			
			for (Short url: listaNegra) {
				escritura.write(url + "");
				escritura.newLine();
			}
			
		} catch (IOException e) {
			arrancador.getGestor().getVentanaRegistro().escribirEnRegistro( e.getMessage() );
		}
		
	}
	
	public void insertarURL(Short url) {
		if (listaNegra.add(url)) 
			arrancador.getGestor().mensaje("Añadido correctamente");
		else 
			arrancador.getGestor().error("Ya existe esa URL");
		
		actualizarListaNegra();
	}
	
	public void eliminarURL(Short url) {
		if (listaNegra.remove(url)) 
			arrancador.getGestor().mensaje("Eliminado correctamente");
		else
			arrancador.getGestor().error("No existe esa URL");

		actualizarListaNegra();
	}

	//////////////////////////////////////////
	// GET/SET ///////////////////////////////
	//////////////////////////////////////////
	
	public HashSet<Short> getListaNegra() {
		return listaNegra;
	}

}
