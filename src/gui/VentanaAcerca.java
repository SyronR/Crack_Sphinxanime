package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class VentanaAcerca extends JDialog {

	//////////////////////////////////////////
	// ATRIBUTOS /////////////////////////////
	//////////////////////////////////////////
	
	private static final long serialVersionUID = 1L;
	private GestorVentanas gestor;
	private JLabel lblNewLabel_0;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	
	//////////////////////////////////////////
	// CONSTRUCTOR ///////////////////////////
	//////////////////////////////////////////
	
	public VentanaAcerca(GestorVentanas gestor) {
		this.gestor = gestor;
		
		setResizable(false);
		setSize(new Dimension(350, 300));
		setTitle("Acerca de: " + gestor.getVentanaPrincipal().getTitle());
		setMinimumSize(new Dimension(300, 200));
		getContentPane().setSize(new Dimension(300, 200));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		
		this.lblNewLabel_0 = new JLabel("Desarrollador:");
		this.lblNewLabel_0.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		this.lblNewLabel_1 = new JLabel("Versi\u00F3n:");
		this.lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		this.lblNewLabel_2 = new JLabel("Correo Electronico:");
		this.lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		this.lblNewLabel_3 = new JLabel("Notas del Parche:");
		this.lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		this.lblNewLabel_4 = new JLabel("Enlace:");
		this.lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		JLabel labelDesarrollador = new JLabel("New label");
		labelDesarrollador.setText(gestor.getArrancador().getAcerca().getDesarrollador());
		
		JLabel labelVersion = new JLabel("New label");
		labelVersion.setText(gestor.getArrancador().getAcerca().getVersion());
		
		JLabel labelCorreo = new JLabel("New label");
		labelCorreo.setText(gestor.getArrancador().getAcerca().getCorreo());
		
		JLabel labelCambios = new JLabel("New label");
		labelCambios.setText(gestor.getArrancador().getAcerca().getCambios());
		
		JLabel labelEnlace = new JLabel("New label");
		labelEnlace.setText(gestor.getArrancador().getAcerca().getUso());
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_0)
									.addPreferredGap(ComponentPlacement.RELATED, 81, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(labelDesarrollador, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
									.addGap(32))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 110, GroupLayout.PREFERRED_SIZE))
								.addComponent(labelVersion, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.RELATED, 56, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(labelCorreo, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
									.addGap(32))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_3)
									.addPreferredGap(ComponentPlacement.RELATED, 64, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(labelCambios, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
									.addGap(32)))
							.addGap(171))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(235, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(labelEnlace, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
							.addGap(203))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(18)
					.addComponent(lblNewLabel_0)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(labelDesarrollador)
					.addGap(18)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(labelVersion)
					.addGap(18)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(labelCorreo)
					.addGap(18)
					.addComponent(lblNewLabel_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(labelCambios)
					.addGap(18)
					.addComponent(lblNewLabel_4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(labelEnlace)
					.addContainerGap(63, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
	}
	
	//////////////////////////////////////////
	// METODOS ///////////////////////////////
	//////////////////////////////////////////
	
	//////////////////////////////////////////
	// GET/SET ///////////////////////////////
	//////////////////////////////////////////
	
	public GestorVentanas getGestor() {
		return gestor;
	}
}
