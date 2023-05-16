package com.morgan.jdbc.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;

import com.morgan.jdbc.controller.ClienteController;
import com.morgan.modelos.Cliente;

import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegistrarseFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtCiudad;
	private JTextField txtTelefono;
	private JPasswordField txtContraseña;
	private JPasswordField txtContraseña2;
	private ClienteController clienteController = new ClienteController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarseFrame frame = new RegistrarseFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistrarseFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 891, 465);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 153, 255));
		panel_1.setBounds(693, 0, 188, 395);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_3 = new JLabel("");
		lblNewLabel_1_3.setIcon(new ImageIcon(RegistrarseFrame.class.getResource("/com/morgan/imagenes/Imagen3.png")));
		lblNewLabel_1_3.setAlignmentX(1.0f);
		lblNewLabel_1_3.setBounds(43, 79, 120, 119);
		panel_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_2 = new JLabel("MorganBank");
		lblNewLabel_2.setFont(new Font("Roboto", Font.BOLD, 25));
		lblNewLabel_2.setBounds(29, 209, 149, 31);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(RegistrarseFrame.class.getResource("/com/morgan/imagenes/Imagen1.jpg")));
		lblNewLabel.setBounds(10, 0, 178, 391);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("MorganBank");
		lblNewLabel_4.setForeground(new Color(0, 128, 64));
		lblNewLabel_4.setFont(new Font("Rockwell", Font.BOLD, 30));
		lblNewLabel_4.setBounds(245, 11, 210, 38);
		panel.add(lblNewLabel_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 153, 255));
		panel_2.setBounds(0, 55, 703, 48);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("REGISTRARSE");
		lblNewLabel_3.setBounds(231, 0, 233, 48);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Roboto", Font.BOLD, 32));
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 18));
		lblNewLabel_1.setBounds(32, 222, 272, 34);
		panel.add(lblNewLabel_1);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Roboto", Font.PLAIN, 14));
		txtNombre.setColumns(10);
		txtNombre.setBounds(32, 157, 265, 34);
		panel.add(txtNombre);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Roboto", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(32, 124, 265, 34);
		panel.add(lblNewLabel_1_1);
		
		txtCiudad = new JTextField();
		txtCiudad.setFont(new Font("Roboto", Font.PLAIN, 14));
		txtCiudad.setColumns(10);
		txtCiudad.setBounds(335, 157, 141, 34);
		panel.add(txtCiudad);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Ciudad");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Roboto", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(325, 124, 141, 34);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Telefono");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setFont(new Font("Roboto", Font.BOLD, 18));
		lblNewLabel_1_1_1_1.setBounds(516, 124, 141, 34);
		panel.add(lblNewLabel_1_1_1_1);
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Roboto", Font.PLAIN, 14));
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(516, 157, 141, 34);
		panel.add(txtTelefono);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setFont(new Font("Roboto", Font.PLAIN, 18));
		txtContraseña.setBounds(32, 255, 272, 34);
		panel.add(txtContraseña);
		
		txtContraseña2 = new JPasswordField();
		txtContraseña2.setFont(new Font("Roboto", Font.PLAIN, 18));
		txtContraseña2.setBounds(358, 255, 299, 34);
		panel.add(txtContraseña2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Repite tu Contraseña:");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Roboto", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(358, 222, 299, 34);
		panel.add(lblNewLabel_1_2);
		
		JPanel btnIniciarSesion = new JPanel();
		btnIniciarSesion.setLayout(null);
		btnIniciarSesion.setForeground(new Color(34, 130, 108));
		btnIniciarSesion.setBackground(new Color(34, 130, 108));
		btnIniciarSesion.setBounds(32, 328, 128, 38);
		panel.add(btnIniciarSesion);
		
		JLabel lblNewLabel_5 = new JLabel("Registrate");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				registrarCliente();
			}
		});
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Roboto", Font.BOLD, 16));
		lblNewLabel_5.setBounds(0, 0, 128, 38);
		btnIniciarSesion.add(lblNewLabel_5);
		
		JPanel btnIniciarSesion_1 = new JPanel();
		btnIniciarSesion_1.setLayout(null);
		btnIniciarSesion_1.setForeground(new Color(34, 130, 108));
		btnIniciarSesion_1.setBackground(new Color(34, 130, 108));
		btnIniciarSesion_1.setBounds(529, 328, 128, 38);
		panel.add(btnIniciarSesion_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("Iniciar Sesion");
		lblNewLabel_5_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegistrarseFrame.this.dispose();
				try {
					IniciarSesionFrame frame = new IniciarSesionFrame();
					frame.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setForeground(Color.WHITE);
		lblNewLabel_5_1.setFont(new Font("Roboto", Font.BOLD, 16));
		lblNewLabel_5_1.setBounds(0, 0, 128, 38);
		btnIniciarSesion_1.add(lblNewLabel_5_1);
	}
	
	
	private void registrarCliente() {
		System.out.println(txtContraseña.getText());
		System.out.println(txtContraseña.getText().equals(txtContraseña2.getText()));
		String c2=txtContraseña2.getPassword().toString();
		String c1=txtContraseña.getPassword().toString();
		if(txtContraseña.getText().equals(txtContraseña2.getText())) {
			Cliente cliente = new Cliente(
					txtContraseña.getText(), txtNombre.getText(), txtCiudad.getText(), txtTelefono.getText());
					this.clienteController.registrarCliente(cliente);
		}else {
			JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden!");
		}
		
	}
}
