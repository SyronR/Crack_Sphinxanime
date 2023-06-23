package gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import kernel.Arrancador;

public class GestorVentanas extends JFrame {

	//////////////////////////////////////////
	// ATRIBUTOS /////////////////////////////
	//////////////////////////////////////////
		
	private static final long serialVersionUID = 1L;
	private Arrancador arrancador;
	private VentanaPrincipal ventanaPrincipal;
	private VentanaRegistro ventanaRegistro;
	private VentanaAcerca ventanaAcerca;
	private GestorArchivos gestorArchivos;
	
	//////////////////////////////////////////
	// CONSTRUCTOR ///////////////////////////
	//////////////////////////////////////////
	
	public GestorVentanas(Arrancador arrancador) {
		this.arrancador = arrancador;
		
		gestorArchivos = new GestorArchivos(this);
		ventanaPrincipal = new VentanaPrincipal(this);
		ventanaRegistro = new VentanaRegistro(this);
		ventanaAcerca = new VentanaAcerca(this);
		
		ventanaPrincipal.setVisible(true);
	}
	
	//////////////////////////////////////////
	// METODOS ///////////////////////////////
	//////////////////////////////////////////
	
	public void mensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
	}

	public void advertencia(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Advertencia", JOptionPane.WARNING_MESSAGE);
	}

	public void error(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	protected void mostrarRegistro() {
		ventanaRegistro.setVisible(true);
	}
	
	protected void mostrarAcerca() {
		ventanaAcerca.setVisible(true);
	}

	//////////////////////////////////////////
	// GET/SET ///////////////////////////////
	//////////////////////////////////////////
	
	public Arrancador getArrancador() {
		return arrancador;
	}

	public VentanaRegistro getVentanaRegistro() {
		return ventanaRegistro;
	}

	public void setVentanaRegistro(VentanaRegistro ventanaRegistro) {
		this.ventanaRegistro = ventanaRegistro;
	}

	public void setArrancador(Arrancador arrancador) {
		this.arrancador = arrancador;
	}

	public VentanaPrincipal getVentanaPrincipal() {
		return ventanaPrincipal;
	}

	public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}

	public VentanaAcerca getVentanaAcerca() {
		return ventanaAcerca;
	}

	public void setVentanaAcerca(VentanaAcerca ventanaAcerca) {
		this.ventanaAcerca = ventanaAcerca;
	}

	public GestorArchivos getGestorArchivos() {
		return gestorArchivos;
	}

	public void setGestorArchivos(GestorArchivos gestorArchivos) {
		this.gestorArchivos = gestorArchivos;
	}
	
	
	
}
