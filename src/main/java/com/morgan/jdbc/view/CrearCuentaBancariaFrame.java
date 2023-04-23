package com.morgan.jdbc.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.morgan.dao.ClienteDAO;
import com.morgan.jdbc.controller.CuentaController;
import com.morgan.jdbc.controller.TipoCuentaController;
import com.morgan.modelos.Cuenta;

import javax.swing.border.LineBorder;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CrearCuentaBancariaFrame extends JFrame {
	public int cuenta;
	private JPanel contentPane;
	private JTextField txtNombreCuenta;
	private TipoCuentaController tipoCuentaController;
	private CuentaController cuentaController;
	private ClienteDAO clienteDAO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearCuentaBancariaFrame frame = new CrearCuentaBancariaFrame();
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
	public CrearCuentaBancariaFrame() {
		this.tipoCuentaController = new TipoCuentaController();
		this.cuentaController = new CuentaController();
		this.clienteDAO = new ClienteDAO();
		
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 405, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 396, 430);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 255));
		panel_1.setBounds(0, 51, 580, 50);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CREAR CUENTA BANCARIA");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 26));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(0, 0, 409, 50);
		panel_1.add(lblNewLabel);
		
		JComboBox comboTipo = new JComboBox();
		comboTipo.setBackground(new Color(0, 128, 255));
		comboTipo.setFont(new Font("Roboto", Font.PLAIN, 20));
		comboTipo.setName("Elige un tipo de Cuenta");
		comboTipo.setBounds(21, 115, 351, 37);
		panel.add(comboTipo);
		comboTipo.addItem("Seleccione el tipo de Cuenta");
		var tiposCuenta = this.tipoCuentaController.listar();
        tiposCuenta.forEach(tipo -> comboTipo.addItem(tipo));
		
		txtNombreCuenta = new JTextField();
		txtNombreCuenta.setBounds(21, 209, 351, 37);
		panel.add(txtNombreCuenta);
		txtNombreCuenta.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre de la Cuenta (Opcional)\r\n");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 18));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(21, 180, 351, 29);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("MorganBank");
		lblNewLabel_4.setForeground(new Color(0, 128, 64));
		lblNewLabel_4.setFont(new Font("Rockwell", Font.BOLD, 30));
		lblNewLabel_4.setBounds(99, 11, 210, 38);
		panel.add(lblNewLabel_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 128, 64));
		panel_2.setBounds(21, 283, 148, 37);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Crear Cuenta");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cuenta cuenta;
				int id_tipo_cuenta = comboTipo.getSelectedIndex();
				
				
				String nombre_cuenta = txtNombreCuenta.getText();
				cuenta = new Cuenta(clienteDAO.getCliente(),id_tipo_cuenta,nombre_cuenta);
				
				cuentaController.CrearCuenta(cuenta);
				
				
			}
		});
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Roboto", Font.BOLD, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 0, 148, 37);
		panel_2.add(lblNewLabel_2);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_2_1.setBackground(new Color(0, 128, 64));
		panel_2_1.setBounds(224, 283, 148, 37);
		panel.add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("Regresar");
		lblNewLabel_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CrearCuentaBancariaFrame.this.dispose();
				MenuPrincipalFrame menu = new MenuPrincipalFrame();
				menu.setVisible(true);
			}
		});
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Roboto", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(0, 0, 148, 37);
		panel_2_1.add(lblNewLabel_2_1);
	}
}
