package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import kernel.Buscador;

public class VentanaPrincipal extends JFrame {

	//////////////////////////////////////////
	// ATRIBUTOS /////////////////////////////
	//////////////////////////////////////////
	
	private static final long serialVersionUID = 1L;
	
	private boolean busquedaCompleta;
	
	private GestorVentanas gestor;
	private JTextField campoBusqueda;
	
	//////////////////////////////////////////
	// CONSTRUCTOR ///////////////////////////
	//////////////////////////////////////////
	
	public VentanaPrincipal(GestorVentanas gestor) {
		this.gestor = gestor;
		busquedaCompleta = true;
		
		/* Centrado de pantalla */
		centrarPantalla();
		
		/* Cierre en Cascada */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/* Look & Feel */
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e1) {
			gestor.error("ERROR: No se ha podido establecer el Look & Feel (Ventana Principal)");
		}
		
		setSize(new Dimension(320, 260));
		setTitle("Crakeador Sphinxanime");
		setResizable(false);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.EAST);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Tipo de busqueda", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Botones", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JButton botonRegistro = new JButton("Mostrar Registro");
		botonRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarRegistro();
			}
		});
		
		JButton botonBuscar = new JButton("Iniciar Busqueda");
		botonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				realizarBusqueda();
			}
		});
		
		JButton botonDetener = new JButton("Detener Busqueda");
		botonDetener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				detenerBusqueda();
			}
		});
		
		JButton botonAcerca = new JButton("Mostrar Acerca");
		botonAcerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarAcerca();
			}
		});
		GroupLayout gl_panel_1_1 = new GroupLayout(panel_1_1);
		gl_panel_1_1.setHorizontalGroup(
			gl_panel_1_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1_1.createParallelGroup(Alignment.LEADING)
						.addComponent(botonBuscar, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
						.addComponent(botonDetener, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1_1.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(botonAcerca, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(botonRegistro, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_1_1.setVerticalGroup(
			gl_panel_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1_1.createSequentialGroup()
					.addGroup(gl_panel_1_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(botonBuscar)
						.addComponent(botonRegistro))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(botonDetener)
						.addComponent(botonAcerca))
					.addContainerGap(13, Short.MAX_VALUE))
		);
		panel_1_1.setLayout(gl_panel_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Lista negra de URLs", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton botonInsertarURL = new JButton("Añadir URL");
		botonInsertarURL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarURL();
			}
		});
		
		JButton botonEliminarURL = new JButton("Eliminar URL");
		botonEliminarURL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarURL();
			}
		});
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 289, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(botonInsertarURL, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(botonEliminarURL, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 48, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(botonInsertarURL)
						.addComponent(botonEliminarURL))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1_1, GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(9)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1_1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JButton botonCompleto = new JButton("Completa");
		botonCompleto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setearBusquedaCompletaTrue();
			}
		});
		
		JButton botonConcreta = new JButton("Concreta");
		botonConcreta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setearBusquedaCompletaFalse();
			}
		});
		
		campoBusqueda = new JTextField();
		campoBusqueda.setEnabled(false);
		
				campoBusqueda.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(campoBusqueda, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
							.addComponent(botonCompleto, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(botonConcreta, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)))
					.addGap(10))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(botonConcreta)
						.addComponent(botonCompleto))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(campoBusqueda, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(18, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
		
	}
	
	//////////////////////////////////////////
	// METODOS ///////////////////////////////
	//////////////////////////////////////////
	
	private void centrarPantalla() {
		
        // Obtener el tamaño de la pantalla
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Obtener el tamaño de la ventana
        Dimension windowSize = getSize();

        // Calcular la posición centrada
        int posX = (screenSize.width - windowSize.width) / 3;
        int posY = (screenSize.height - windowSize.height) / 3;

        // Establecer la posición centrada
        setLocation(posX, posY);
	}
	
	private void setearBusquedaCompletaTrue() {
		busquedaCompleta = true;
		campoBusqueda.setEnabled(false);
	}
	
	private void setearBusquedaCompletaFalse() {
		busquedaCompleta = false;
		campoBusqueda.setEnabled(true);
	}
	
	private void mostrarRegistro() {
		gestor.mostrarRegistro();
	}
	
	private void mostrarAcerca() {
		gestor.mostrarAcerca();
	}
	
	private void detenerBusqueda() {
		Buscador.setFinalizar(true);
	}
	
	private void realizarBusqueda() {
		
		/* Comprobar si la busqueda es completa o concreta */
		if (busquedaCompleta == true) {
			
			mostrarRegistro();
			gestor.getArrancador().getBuscador().crakearSphinxanime( "" );
			
		} else {
			
			/* Comprobar si el patron de busqueda esta vacio */
			if (!campoBusqueda.getText().isEmpty()) {
				
				mostrarRegistro();
				gestor.getArrancador().getBuscador().crakearSphinxanime( campoBusqueda.getText() );
				
			} else {
				gestor.advertencia("El patrón de busqueda no puede estar vacio");
			}
		}
	}
	
	private void insertarURL() {
		try {
			Short url = Short.parseShort( JOptionPane.showInputDialog("Inserte la URL que desea restringir") );
			
			gestor.getArrancador().getListaNegra().insertarURL(url);
			
		} catch (NumberFormatException e) {
			
		}
	}
	
	private void eliminarURL() {
		try {
			Short url = Short.parseShort( JOptionPane.showInputDialog("Inserte la URL que desea eliminar") );
			
			gestor.getArrancador().getListaNegra().eliminarURL(url);
			
		} catch (NumberFormatException e) {
			
		}
	}
}
