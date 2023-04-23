package com.morgan.jdbc.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.morgan.jdbc.controller.ClienteController;
import com.morgan.jdbc.controller.CuentaController;
import com.morgan.modelos.Cliente;
import com.morgan.modelos.Cuenta;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Component;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import java.awt.Cursor;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtNoCliente;
	private JPasswordField passContraseña;
	private Cuenta cuenta;
	private ClienteController clienteController;
	private Cliente cliente;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			
			
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		clienteController = new ClienteController();
		cliente = new Cliente();
		
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 769, 403);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 153, 255));
		panel_1.setBounds(572, 0, 198, 399);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("MorganBank");
		lblNewLabel_2.setFont(new Font("Roboto", Font.BOLD, 25));
		lblNewLabel_2.setBounds(39, 220, 149, 31);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblNewLabel_1.setIcon(new ImageIcon(MainFrame.class.getResource("/com/morgan/imagenes/Imagen3.png")));
		lblNewLabel_1.setBounds(45, 90, 130, 130);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainFrame.class.getResource("/com/morgan/imagenes/Imagen1.jpg")));
		lblNewLabel.setBounds(10, 0, 188, 398);
		panel_1.add(lblNewLabel);
		
		final JLabel lblNoCliente = new JLabel("Numero de Cliente");
		lblNoCliente.setHorizontalAlignment(SwingConstants.LEFT);
		lblNoCliente.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNoCliente.setBounds(29, 136, 240, 38);
		panel.add(lblNoCliente);
		
		txtNoCliente = new JTextField();
		txtNoCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				txtNoCliente.setText("");
				txtNoCliente.setForeground(Color.black);
				lblNoCliente.setForeground(Color.red);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNoCliente.setForeground(Color.black);
			}
		});
		txtNoCliente.setForeground(new Color(192, 192, 192));
		txtNoCliente.setFont(new Font("Roboto", Font.BOLD, 18));
		txtNoCliente.setText("Digite su numero de cliente");
		txtNoCliente.setBorder(null);
		txtNoCliente.setBounds(29, 177, 513, 38);
		panel.add(txtNoCliente);
		txtNoCliente.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(29, 215, 513, 25);
		panel.add(separator);
		
		JLabel lblNewLabel_4 = new JLabel("MorganBank");
		lblNewLabel_4.setForeground(new Color(0, 128, 64));
		lblNewLabel_4.setFont(new Font("Rockwell", Font.BOLD, 30));
		lblNewLabel_4.setBounds(204, 11, 210, 38);
		panel.add(lblNewLabel_4);
		
		final JLabel lblContraseña = new JLabel("Contraseña");
		lblContraseña.setHorizontalAlignment(SwingConstants.LEFT);
		lblContraseña.setFont(new Font("Roboto", Font.BOLD, 20));
		lblContraseña.setBounds(29, 226, 240, 38);
		panel.add(lblContraseña);
		
		passContraseña = new JPasswordField();
		passContraseña.setForeground(new Color(192, 192, 192));
		passContraseña.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				passContraseña.setText("");
				passContraseña.setForeground(Color.black);
				lblContraseña.setForeground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblContraseña.setForeground(Color.black);
			}
		});
		passContraseña.setText("jkodsadsadadsad");
		passContraseña.setFont(new Font("Roboto", Font.BOLD, 18));
		passContraseña.setBorder(null);
		passContraseña.setBounds(29, 265, 513, 25);
		panel.add(passContraseña);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(29, 297, 513, 25);
		panel.add(separator_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 153, 255));
		panel_2.setBounds(0, 56, 580, 48);
		panel.add(panel_2);
		
		JLabel lblNewLabel_3 = new JLabel("INICIAR SESION");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		panel_2.add(lblNewLabel_3);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setFont(new Font("Roboto", Font.BOLD, 32));
		
		final JPanel btnIniciarSesion = new JPanel();
		btnIniciarSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null,"Inicio Sesion");
			}
		});
		btnIniciarSesion.setBackground(new Color(34, 130, 108));
		btnIniciarSesion.setForeground(new Color(34, 130, 108));
		btnIniciarSesion.setBounds(29, 333, 128, 38);
		panel.add(btnIniciarSesion);
		btnIniciarSesion.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Iniciar Sesion");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIniciarSesion.setBackground(new Color(34,180,120));//34 130 108
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnIniciarSesion.setBackground(new Color(34,130,108));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				int id = Integer.parseInt(txtNoCliente.getText());
				String contraseña = passContraseña.getText();				
				if(clienteController.iniciarSesion(id,contraseña)) {
					MainFrame.this.dispose();
					MenuPrincipalFrame menu = new MenuPrincipalFrame();
					menu.setVisible(true);
				}
				
			}
		});
		lblNewLabel_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Roboto", Font.BOLD, 16));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(0, 0, 128, 38);
		btnIniciarSesion.add(lblNewLabel_5);
		
		JPanel btnRegistrarte = new JPanel();
		btnRegistrarte.setLayout(null);
		btnRegistrarte.setForeground(new Color(34, 130, 108));
		btnRegistrarte.setBackground(new Color(34, 130, 108));
		btnRegistrarte.setBounds(414, 333, 128, 38);
		panel.add(btnRegistrarte);
		
		JLabel lblNewLabel_5_1 = new JLabel("Registrate");
		lblNewLabel_5_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainFrame.this.dispose();
				try {
					RegistrarseFrame frame = new RegistrarseFrame();
					frame.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			public void mouseEntered(MouseEvent e) {
				btnRegistrarte.setBackground(new Color(34,180,120));//34 130 108
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnRegistrarte.setBackground(new Color(34,130,108));
			}
		});
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setForeground(Color.WHITE);
		lblNewLabel_5_1.setFont(new Font("Roboto", Font.BOLD, 16));
		lblNewLabel_5_1.setBounds(0, 0, 128, 38);
		btnRegistrarte.add(lblNewLabel_5_1);
	}
	
	public Cuenta getCuenta(){
		return this.cuenta;
	}
}
