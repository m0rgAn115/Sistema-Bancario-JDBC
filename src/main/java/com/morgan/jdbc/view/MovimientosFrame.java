package com.morgan.jdbc.view;

import com.morgan.modelos.RegistroMovimientos;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Dimension;
import javax.swing.border.CompoundBorder;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import com.morgan.jdbc.controller.*;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
public class MovimientosFrame extends JFrame {

	private JPanel contentPane;
	private JTable tbMovimientos_1;
	private CuentaController cuentaController = new CuentaController();
	private DefaultTableModel modelo;
	private RegistroMovimientosController registroMovimientosController = new RegistroMovimientosController();
	private JTextField txtId;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovimientosFrame frame = new MovimientosFrame();
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
	public MovimientosFrame() {
		
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 781, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 767, 410);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 153, 255));
		panel_1.setBounds(0, 40, 734, 40);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mis Movimientos");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 25));
		lblNewLabel.setBounds(0, 0, 700, 40);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 153, 255));
		panel_2.setBounds(696, 0, 75, 396);
		panel.add(panel_2);
		
		tbMovimientos_1 = new JTable();
		tbMovimientos_1.setRowSelectionAllowed(false);
		tbMovimientos_1.setRequestFocusEnabled(false);
		crearTabla();
		tbMovimientos_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbMovimientos_1.setSelectionForeground(Color.WHITE);
		tbMovimientos_1.setSelectionBackground(new Color(153, 204, 255));
		tbMovimientos_1.setRowMargin(15);
		tbMovimientos_1.setRowHeight(30);
		tbMovimientos_1.setGridColor(Color.BLACK);
		tbMovimientos_1.setForeground(new Color(0, 0, 0));
		tbMovimientos_1.setFont(new Font("Rockwell", Font.ITALIC, 16));
		tbMovimientos_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		tbMovimientos_1.setBackground(new Color(186, 230, 250));
		tbMovimientos_1.setBounds(10, 179, 676, 173);
		panel.add(tbMovimientos_1);
		
		JComboBox comboCuentas = new JComboBox();
		comboCuentas.setBackground(new Color(255, 255, 255));
		comboCuentas.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		comboCuentas.setFont(new Font("Roboto Light", Font.BOLD, 16));
		comboCuentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboCuentas.getSelectedIndex()==0) {
					cargarTabla();
				}else {
					var cuentas = cuentaController.listar();
					int noCuenta = cuentas.get(comboCuentas.getSelectedIndex()-1).getNoCuenta();
					cargarTablaFiltro(noCuenta);
				}
				
				
			}
		});
		
		
		
		comboCuentas.addItem("Todas mis cuentas");
		var cuentas = cuentaController.listar();
		
		cuentas.forEach(cuenta -> comboCuentas.addItem(cuenta.getNoCuenta() +" - "+ cuenta.getNombreCuenta()));
		
		
		comboCuentas.setBounds(10, 103, 271, 31);
		panel.add(comboCuentas);
		
		
		
		
		
		JPanel btnRegresar = new JPanel();
		btnRegresar.setForeground(new Color(198, 19, 50));
		btnRegresar.setBackground(new Color(255, 0, 0));
		btnRegresar.setBounds(20, 363, 164, 36);
		panel.add(btnRegresar);
		btnRegresar.setLayout(null);
		
		JLabel lblRegresar = new JLabel("Regresar");
		lblRegresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblRegresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MovimientosFrame.this.dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRegresar.setBackground(new Color(198, 19, 50));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnRegresar.setBackground(new Color(255,0,0));
			}
		});
		lblRegresar.setBounds(0, 0, 164, 34);
		btnRegresar.add(lblRegresar);
		lblRegresar.setBackground(new Color(255, 0, 0));
		lblRegresar.setForeground(new Color(255, 255, 255));
		lblRegresar.setFont(new Font("Roboto", Font.BOLD, 18));
		lblRegresar.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtId = new JTextField();
		txtId.setBackground(new Color(255, 255, 255));
		txtId.setEditable(false);
		txtId.setBorder(null);
		txtId.setFont(new Font("Roboto", Font.BOLD, 18));
		txtId.setText(" No.Cuenta                         Descripcion                                  Fecha");
		txtId.setBounds(10, 155, 676, 20);
		panel.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("MorganBank");
		lblNewLabel_4.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(new Color(0, 128, 64));
		lblNewLabel_4.setFont(new Font("Rockwell", Font.BOLD, 30));
		lblNewLabel_4.setBounds(250, 0, 304, 37);
		panel.add(lblNewLabel_4);
	}
	
	private DefaultTableModel crearTabla() {
		tbMovimientos_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"No.Cuenta", "Descripcion", "Fecha"
			}
		));
		tbMovimientos_1.getColumnModel().getColumn(0).setPreferredWidth(26);
		tbMovimientos_1.getColumnModel().getColumn(1).setPreferredWidth(166);
		tbMovimientos_1.getColumnModel().getColumn(2).setPreferredWidth(64);
				
			return (DefaultTableModel) tbMovimientos_1.getModel();
	}
	
	
	
	private void cargarTabla() {
		modelo = crearTabla();
		var movimientos = registroMovimientosController.listar();  
		
        
        movimientos.forEach(movimiento -> modelo.addRow(new Object[] { 
        	movimiento.getNoCuenta(),movimiento.getDescripcion(),movimiento.getFecha()})); 
	}
	
	private void cargarTablaFiltro(int noCuenta) {
		modelo = crearTabla();
		List<RegistroMovimientos> movimientos = registroMovimientosController.filtrar(noCuenta);
		
		movimientos.forEach(movimiento -> modelo.addRow(new Object[] {
	        	movimiento.getNoCuenta(),movimiento.getDescripcion(),movimiento.getFecha()})); 
	}
}

