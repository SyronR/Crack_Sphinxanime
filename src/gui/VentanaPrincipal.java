package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
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
		
		/* Cierre en Cascada */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/* Look & Feel */
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e1) {
			gestor.error("ERROR: No se ha podido establecer el Look & Feel (Ventana Principal)");
		}
		
		setSize(new Dimension(320, 210));
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
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(9)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1_1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(31, Short.MAX_VALUE))
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
}
