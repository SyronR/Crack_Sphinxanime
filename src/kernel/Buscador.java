package kernel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import gui.GestorArchivos;

public class Buscador {

	//////////////////////////////////////////
	// ATRIBUTOS /////////////////////////////
	//////////////////////////////////////////

	private static boolean finalizar;
	private Arrancador arrancador;
	private GestorArchivos gestorArchivos;
	private FileNameExtensionFilter filtroTxt;

	//////////////////////////////////////////
	// CONSTRUCTOR ///////////////////////////
	//////////////////////////////////////////

	public Buscador(Arrancador arrancador) {
		this.arrancador = arrancador;
		this.gestorArchivos = arrancador.getGestor().getGestorArchivos();
		this.filtroTxt = new FileNameExtensionFilter("Fichero de texto plano", "txt");
		
		gestorArchivos.setFileFilter(filtroTxt);
	}

	//////////////////////////////////////////
	// METODOS ///////////////////////////////
	//////////////////////////////////////////

	public void crakearSphinxanime(String palabrasClaves) {
		new Hilo(arrancador, palabrasClaves, gestorArchivos).start();
	}

	//////////////////////////////////////////
	// GET/SET ///////////////////////////////
	//////////////////////////////////////////

	public Arrancador getArrancador() {
		return arrancador;
	}

	public void setArrancador(Arrancador arrancador) {
		this.arrancador = arrancador;
	}

	public static boolean getFinalizar() {
		return finalizar;
	}

	public static void setFinalizar(boolean finalizar) {
		Buscador.finalizar = finalizar;
	}
}

class Hilo extends Thread {

	private Arrancador arrancador;
	private String palabrasClaves;
	private GestorArchivos gestorArchivos;

	public Hilo(Arrancador arrancador, String palabrasClaves, GestorArchivos gestorArchivos) {
		this.arrancador = arrancador;
		this.palabrasClaves = palabrasClaves;
		this.gestorArchivos = gestorArchivos;
		Buscador.setFinalizar(false);
	}

	@Override
	public void run() {

		// VARIABLES /////////////////////////////////////////////////////////

		short contador = 1;

		Document paginaWeb;
		Elements h3PaginaWeb;
		String frasePaginaWeb;
		String frase;
		String resultados = "";
		
		File archivo;
		Integer valor;

		// CODIGO ////////////////////////////////////////////////////////////

		/* Aqui se realiza la busqueda en segundo plano */
		try {

			/* Si esta vacio, implica que el modo de busqueda sea completo */
			if (palabrasClaves.isEmpty()) {

				arrancador.getGestor().getVentanaRegistro().escribirEnRegistro("\nIniciando Busqueda Completa... \n\n");
				
				/* Mientras que finalizar sea false, seguiremos recorriendo */
				while (Buscador.getFinalizar() == false) {

					paginaWeb = Jsoup.connect("https://box.sphinxanime.net/?v=" + contador).get();
					h3PaginaWeb = paginaWeb.select(".content h3");

					/* Si la frase de la pagina web no esta vacia, se lee y se guarda */
					if (!h3PaginaWeb.toString().equals("")) {

						frasePaginaWeb = h3PaginaWeb.toString().substring(4, h3PaginaWeb.toString().length() - 5);
						frase = "URL: " + contador + " // " + frasePaginaWeb + "\n";

						arrancador.getGestor().getVentanaRegistro().escribirEnRegistro(frase);
						resultados += frase;

					} else {

						/* Si le damos a Si, paramos la busqueda */
						if (JOptionPane.showConfirmDialog(null, "¿La página con número '" + contador
								+ "' está vacía, desea terminar la búsqueda?") == 0)
							Buscador.setFinalizar(true);
						else
							Buscador.setFinalizar(false);
					}

					contador++;
				}

			} else {
				
				/* Si no esta vacio, implica que el modo de busqueda sea concreto */
				arrancador.getGestor().getVentanaRegistro().escribirEnRegistro("\nIniciando Busqueda Concreta (" + palabrasClaves + ")... \n\n");
				
				/* Mientras que finalizar sea false, seguiremos recorriendo */
				while (Buscador.getFinalizar() == false) {

					paginaWeb = Jsoup.connect("https://box.sphinxanime.net/?v=" + contador).get();
					h3PaginaWeb = paginaWeb.select(".content h3");

					/* Si la frase de la pagina web no esta vacia, se lee y se guarda */
					if (!h3PaginaWeb.toString().equals("")) {

						frasePaginaWeb = h3PaginaWeb.toString().substring(4, h3PaginaWeb.toString().length() - 5);
						frase = "URL: " + contador + " // " + frasePaginaWeb + "\n";

						if (frasePaginaWeb.contains(palabrasClaves)) {

							arrancador.getGestor().getVentanaRegistro().escribirEnRegistro(frase);
							resultados += frase;

						}

					} else {

						/* Si le damos a Si, paramos la busqueda */
						if (JOptionPane.showConfirmDialog(null, "¿La página con número '" + contador
								+ "' está vacía, desea terminar la búsqueda?") == 0)
							Buscador.setFinalizar(true);
						else
							Buscador.setFinalizar(false);
					}

					contador++;
				}

			}

		} catch (IOException e) {
			arrancador.getGestor().error("EXCEPCION: Se ha producido una excepción al buscar en la pagina web");
		}
		
		arrancador.getGestor().getVentanaRegistro().escribirEnRegistro("\nBusqueda Finalizada");
		
		/* Guardar el resultado en un fichero */
		if (JOptionPane.showConfirmDialog(gestorArchivos, "¿Desea guardar el resultado en un archivo?") == 0) {
			valor = gestorArchivos.showSaveDialog(null);
			
			if (valor == JFileChooser.APPROVE_OPTION && gestorArchivos.getSelectedFile().getName().endsWith(".txt")) {
				archivo = gestorArchivos.getSelectedFile();
				
				try (BufferedWriter escritura = new BufferedWriter(new FileWriter(archivo, false))) {

					escritura.write(resultados);
					arrancador.getGestor().mensaje("Resultados exportados con exito");

				} catch (IOException e) {
					arrancador.getGestor().error("ERROR: Se ha producido un error inesperado al exportar los resultados");
				}
				
			} else {
				arrancador.getGestor().error("ERROR: El fichero tiene que terminar con la extensión .txt");
			}
		}

	}
}
