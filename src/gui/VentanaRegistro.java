package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VentanaRegistro extends JFrame {

	//////////////////////////////////////////
	// ATRIBUTOS /////////////////////////////
	//////////////////////////////////////////

	private static final long serialVersionUID = 1L;
	private DateTimeFormatter hora;
	private GestorVentanas gestor;
	private JTextArea registro;
	
	//////////////////////////////////////////
	// CONSTRUCTOR ///////////////////////////
	//////////////////////////////////////////
	
	public VentanaRegistro(GestorVentanas gestor) {
		this.gestor = gestor;
		
		setMinimumSize(new Dimension(450, 300));
		setSize(new Dimension(900, 600));
		setTitle("Registro");
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		registro = new JTextArea();
		registro.setEnabled(false);
		scrollPane.setViewportView(registro);
		
		JMenuBar menuBar = new JMenuBar();
		scrollPane.setColumnHeaderView(menuBar);
		
		JMenu mnNewMenu = new JMenu("Opciones");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Limpiar Registro");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarRegistro();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
        hora = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
		registro.setText( hora.format(LocalDateTime.now()) + " | Registro Inicializado:" );
	}
	
	//////////////////////////////////////////
	// METODOS ///////////////////////////////
	//////////////////////////////////////////
	
	public void escribirEnRegistro(String frase) {
		String texto = registro.getText();
		registro.setText(texto + frase);
	}
	
	public void limpiarRegistro() {
		registro.setText( "" );
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

	public JTextArea getRegistro() {
		return registro;
	}

	public void setRegistro(JTextArea textArea) {
		this.registro = textArea;
	}
}
