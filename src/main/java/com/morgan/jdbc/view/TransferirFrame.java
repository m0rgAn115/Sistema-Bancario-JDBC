package com.morgan.jdbc.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.morgan.jdbc.controller.CuentaController;
import com.morgan.jdbc.controller.CuentasGuardadasController;
import com.morgan.jdbc.controller.RegistroMovimientosController;
import com.morgan.modelos.Cuenta;
import com.morgan.modelos.CuentasGuardadas;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import java.awt.Font;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.List;
import java.awt.Panel;
import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TransferirFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtMonto;
	private JTextField txtNumeroCuenta;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextField txtSaldo;
	private CuentaController cuentaController;
	private List<Cuenta> cuentas;
	private CuentasGuardadasController cuentasGuardadasController;
	private List<CuentasGuardadas> cuentasGuard;
	private JComboBox comboCuentasReg;
	private RegistroMovimientosController regMovController;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransferirFrame frame = new TransferirFrame();
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
	public TransferirFrame() {
		this.cuentaController = new CuentaController();
		cuentas = this.cuentaController.listar();
		cuentasGuardadasController = new CuentasGuardadasController();
		regMovController = new RegistroMovimientosController();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 629, 387);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JComboBox comboCuentas = new JComboBox();
		comboCuentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				var cuentas = cuentaController.listar();
				if(comboCuentas.getSelectedIndex()>0) {
				    txtSaldo.setText(cuentas.get(comboCuentas.getSelectedIndex()-1).getSaldo().toString());
				}
				
			}
		});
		comboCuentas.setBounds(29, 74, 310, 32);
		panel.add(comboCuentas);
		comboCuentas.addItem("Cuenta que Transferira");
		
		cuentas.forEach(cuenta -> comboCuentas.addItem(cuenta.getNoCuenta()+" - "+cuenta.getNombreCuenta()));
		
		
		
		
		
		
		
		txtMonto = new JTextField();
		txtMonto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtMonto.setText("");
			}
		});
		txtMonto.setFont(new Font("Rockwell Condensed", Font.BOLD, 20));
		txtMonto.setText("0.00");
		txtMonto.setBounds(322, 245, 286, 32);
		panel.add(txtMonto);
		txtMonto.setColumns(10);
		
		txtNumeroCuenta = new JTextField();
		txtNumeroCuenta.setFont(new Font("Roboto", Font.BOLD, 20));
		txtNumeroCuenta.setBounds(29, 245, 283, 32);
		panel.add(txtNumeroCuenta);
		txtNumeroCuenta.setColumns(10);
		
		JRadioButton rdbtCuentasPropias = new JRadioButton("Cuentas Propias");
		rdbtCuentasPropias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboCuentasReg.removeAllItems();
				comboCuentasReg.addItem("Cuentas Propias");
				cuentas.forEach(cuenta -> comboCuentasReg.addItem(cuenta.getNoCuenta()+" - "+cuenta.getNombreCuenta()));
				comboCuentasReg.setEnabled(true);
			}
		});
		rdbtCuentasPropias.setBackground(new Color(255, 255, 255));
		rdbtCuentasPropias.setFont(new Font("Roboto", Font.BOLD, 18));
		buttonGroup.add(rdbtCuentasPropias);
		rdbtCuentasPropias.setBounds(325, 127, 283, 25);
		panel.add(rdbtCuentasPropias);
		
		JRadioButton rdbnCuentasGuardadas = new JRadioButton("Cuentas Guardadas");
		rdbnCuentasGuardadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboCuentasReg.removeAllItems();
				cargarComboReg();
				comboCuentasReg.setEnabled(true);
			}
		});
		rdbnCuentasGuardadas.setBackground(new Color(255, 255, 255));
		rdbnCuentasGuardadas.setFont(new Font("Roboto", Font.BOLD, 18));
		buttonGroup.add(rdbnCuentasGuardadas);
		rdbnCuentasGuardadas.setBounds(26, 127, 283, 25);
		panel.add(rdbnCuentasGuardadas);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 204, 0));
		panel_2.setBounds(29, 331, 219, 32);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Realizar Transferencia");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(comboCuentas.getSelectedIndex()>0 && !txtNumeroCuenta.getText().isBlank()) {
					int cuentaOrigen=cuentas.get(comboCuentas.getSelectedIndex()-1).getNoCuenta();
					int cuentaDestino= Integer.parseInt(txtNumeroCuenta.getText());
					
					BigDecimal saldoCuentaOrigen = cuentaController.getSaldo(cuentas.get(comboCuentas.getSelectedIndex()-1).getNoCuenta());
					BigDecimal saldoCuentaDestino = cuentaController.getSaldo(Integer.parseInt(txtNumeroCuenta.getText()));
					BigDecimal monto = new BigDecimal(txtMonto.getText());
					
					Cuenta cuenta = new Cuenta();
					cuenta.setSaldo(saldoCuentaOrigen);
					
					
					if(cuenta.validarSaldoSuficiente(monto)) {
						TransferirFrame.this.dispose();
						BigDecimal nuevoSaldoCuentaOrigen = saldoCuentaOrigen.subtract(monto);
						BigDecimal nuevoSaldoCuentaDestino = saldoCuentaDestino.add(monto);
						cuentaController.transferir(cuentaOrigen, cuentaDestino,nuevoSaldoCuentaOrigen, nuevoSaldoCuentaDestino);
						
						TransferirFrame tf = new TransferirFrame();
						tf.setVisible(true);
						
						regMovController.registrar(cuentaOrigen,cuentaDestino,monto);
					}					
				}else JOptionPane.showMessageDialog(null, "Seleccione cuenta Origen y Cuenta Destino!");
				
			}
		});
		lblNewLabel_1.setBounds(0, 0, 219, 32);
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setBackground(new Color(255, 204, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 18));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 0, 51));
		panel_1.setBounds(411, 331, 197, 32);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Regresar");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TransferirFrame.this.dispose();
			}
		});
		lblNewLabel_1_1.setBounds(0, 0, 197, 32);
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel_1_1.setBackground(new Color(255, 204, 0));
		panel_1.add(lblNewLabel_1_1);
		
		txtSaldo = new JTextField();
		txtSaldo.setEditable(false);
		txtSaldo.setText("0.00");
		txtSaldo.setFont(new Font("Rockwell Condensed", Font.BOLD, 20));
		txtSaldo.setColumns(10);
		txtSaldo.setBounds(349, 74, 270, 32);
		panel.add(txtSaldo);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(new Color(128, 255, 0));
		panel_2_1.setBounds(29, 288, 186, 32);
		panel.add(panel_2_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Guardar Cuenta");
		lblNewLabel_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombreCuenta = JOptionPane.showInputDialog("Ingrese un Alias para la cuenta "+txtNumeroCuenta.getText()+": (OPCIONAL)");
				cuentasGuardadasController.guardar(nombreCuenta, Integer.parseInt(txtNumeroCuenta.getText()));
				cargarComboReg();
				
			}
		});
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Roboto", Font.BOLD, 18));
		lblNewLabel_1_2.setBackground(new Color(255, 204, 0));
		lblNewLabel_1_2.setBounds(0, 0, 190, 32);
		panel_2_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel = new JLabel("Cuenta Destino");
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblNewLabel.setBounds(29, 213, 270, 33);
		panel.add(lblNewLabel);
		
		JLabel lblMontoATransferir = new JLabel("Monto a Transferir");
		lblMontoATransferir.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblMontoATransferir.setBounds(322, 213, 270, 33);
		panel.add(lblMontoATransferir);
		
		
		
comboCuentasReg = new JComboBox();
		
		comboCuentasReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboCuentasReg.getSelectedIndex()>0 ) {
					if(rdbnCuentasGuardadas.isSelected()) {
						txtNumeroCuenta.setText(String.valueOf(cuentasGuard.get(comboCuentasReg.getSelectedIndex()-1).getNoCuenta()));
					}else {
						txtNumeroCuenta.setText(String.valueOf(cuentas.get(comboCuentasReg.getSelectedIndex()-1).getNoCuenta()));
					}
				    
				}
			}
		});
		comboCuentasReg.setEnabled(false);
		comboCuentasReg.setBounds(36, 159, 572, 43);
		panel.add(comboCuentasReg);
		comboCuentasReg.addItem("Cuentas a Transferir Guardadas");
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	void cargarComboReg() {
		cuentasGuard = cuentasGuardadasController.listar();
		comboCuentasReg.removeAllItems();
		comboCuentasReg.addItem("Cuentas a Transferir Guardadas");
		cuentasGuard.forEach(cuenta -> comboCuentasReg.addItem(cuenta.getNoCuenta() + " - "+ cuenta.getNombreCuenta()));
		
	}
}

