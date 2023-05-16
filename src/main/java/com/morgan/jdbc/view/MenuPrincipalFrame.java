package com.morgan.jdbc.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.morgan.dao.ClienteDAO;
import com.morgan.jdbc.controller.CuentaController;
import com.morgan.jdbc.controller.TipoCuentaController;
import com.morgan.modelos.NombreTipoCuenta;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Optional;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.ComboBoxEditor;
import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipalFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ClienteDAO clienteDAO;
	private CuentaController cuentaController;
	private DefaultTableModel modelo;
	private JTable tabla;
	private TipoCuentaController tipoCuentaController;
	private NombreTipoCuenta nombreTipoCuenta;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipalFrame frame = new MenuPrincipalFrame();
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
	public MenuPrincipalFrame() {
		clienteDAO = new ClienteDAO();
		cuentaController = new CuentaController();
		tipoCuentaController = new TipoCuentaController();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 992, 563);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 978, 526);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(MenuPrincipalFrame.class.getResource("/com/morgan/imagenes/Imagen3.png")));
		lblNewLabel_1_1.setAlignmentX(1.0f);
		lblNewLabel_1_1.setBounds(765, 11, 119, 127);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel = new JLabel("Bienvenid@ "+clienteDAO.getCliente().getNombre());
		lblNewLabel.setFont(new Font("Segoe UI Light", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setBounds(10, 11, 428, 31);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 153, 153));
		panel_1.setBounds(10, 447, 240, 53);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Crear Cuenta Bancaria");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuPrincipalFrame.this.dispose();
				CrearCuentaBancariaFrame c = new CrearCuentaBancariaFrame();
				c.setVisible(true);
			}
		});
		lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 238, 53);
		panel_1.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Mostrar Todos");
		var tipos = tipoCuentaController.cargar();
		tipos.forEach(tipo -> comboBox.addItem(tipo.getNombre()));
		
		
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(comboBox.getSelectedIndex()!=0) {
					
					String nombreTipo = comboBox.getSelectedItem().toString();
					for(int i=0;i<tipos.size();i++) {
						if(tipos.get(i).getNombre()==nombreTipo) {
							System.out.println(tipos.get(i).getId());
							Filtrar(tipos.get(i).getId());
						}
						
					}
				}else cargarTabla();
				
			}
		});
		comboBox.setBounds(10, 77, 267, 31);
		panel.add(comboBox);
		
		
		
		tabla = new JTable();
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabla.setSelectionForeground(new Color(255, 255, 255));
		tabla.setSelectionBackground(new Color(153, 204, 255));
		tabla.setGridColor(new Color(0, 0, 0));
		tabla.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		tabla.setRowMargin(15);
		tabla.setRowHeight(30);
		tabla.setForeground(new Color(255, 255, 255));
		tabla.setBackground(new Color(0, 128, 255));
		
	
		tabla.setFont(new Font("Roboto", Font.ITALIC, 18));
		tabla.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre Cuenta", "Numero Cuenta", "Saldo Cuenta", "Tipo Cuenta"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, true, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tabla.getColumnModel().getColumn(0).setPreferredWidth(80);
		tabla.getColumnModel().getColumn(1).setPreferredWidth(60);
		tabla.getColumnModel().getColumn(2).setResizable(false);

        modelo = (DefaultTableModel) tabla.getModel();
        
        cargarTabla();

        tabla.setBounds(10, 159, 634, 206);
        
        panel.add(tabla);
        
        JLabel lblNewLabel_2 = new JLabel("Nombre");
        lblNewLabel_2.setFont(new Font("Roboto", Font.ITALIC, 18));
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBounds(10, 135, 165, 22);
        panel.add(lblNewLabel_2);
        
        JLabel lblNewLabel_2_1 = new JLabel("Numero de Cuenta");
        lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1.setFont(new Font("Roboto", Font.ITALIC, 18));
        lblNewLabel_2_1.setBounds(176, 135, 148, 22);
        panel.add(lblNewLabel_2_1);
        
        JLabel lblNewLabel_2_1_1 = new JLabel("Saldo");
        lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1_1.setFont(new Font("Roboto", Font.ITALIC, 18));
        lblNewLabel_2_1_1.setBounds(327, 135, 148, 22);
        panel.add(lblNewLabel_2_1_1);
        
        JLabel lblNewLabel_2_1_1_1 = new JLabel("Tipo Cuenta");
        lblNewLabel_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1_1_1.setFont(new Font("Roboto", Font.ITALIC, 18));
        lblNewLabel_2_1_1_1.setBounds(484, 135, 160, 22);
        panel.add(lblNewLabel_2_1_1_1);
        
        JLabel lblNewLabel_4 = new JLabel("MorganBank");
        lblNewLabel_4.setHorizontalTextPosition(SwingConstants.CENTER);
        lblNewLabel_4.setForeground(new Color(0, 128, 64));
        lblNewLabel_4.setFont(new Font("Rockwell", Font.BOLD, 30));
        lblNewLabel_4.setBounds(403, 6, 304, 37);
        panel.add(lblNewLabel_4);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(0, 128, 0));
        panel_2.setBounds(680, 217, 267, 42);
        panel.add(panel_2);
        panel_2.setLayout(null);
        
        JLabel lblNewLabel_3_1 = new JLabel("Transferir");
        lblNewLabel_3_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		TransferirFrame tr = new TransferirFrame();
        		tr.setVisible(true);
        	}
        });
        lblNewLabel_3_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblNewLabel_3_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_3_1.setHorizontalTextPosition(SwingConstants.CENTER);
        lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3_1.setFont(new Font("Roboto", Font.BOLD, 25));
        lblNewLabel_3_1.setBounds(0, 0, 267, 42);
        panel_2.add(lblNewLabel_3_1);
        
        JPanel panel_2_1 = new JPanel();
        panel_2_1.setBackground(new Color(0, 102, 102));
        panel_2_1.setBounds(680, 369, 267, 42);
        panel.add(panel_2_1);
        panel_2_1.setLayout(null);
        
        JLabel btnEditarNombre = new JLabel("Editar Nombre");
        btnEditarNombre.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		if(tabla.getSelectedRow()!=-1) {
        			int id = Integer.parseInt(modelo.getValueAt(tabla.getSelectedRow(), 1).toString());
            		String nombre = JOptionPane.showInputDialog(null, "Ingresa el nuevo Nombre: ");
            		cuentaController.editarNombre(id,nombre);
            		JOptionPane.showMessageDialog(null, "Se ha cambiado el nombre con Exito!");
            		tabla.setValueAt(nombre, tabla.getSelectedRow(), 0);
        		}else JOptionPane.showMessageDialog(null, "Seleccione una cuenta de la tabla!");
        		
        		
        	}
        });
        btnEditarNombre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnEditarNombre.setForeground(new Color(255, 255, 255));
        btnEditarNombre.setHorizontalTextPosition(SwingConstants.CENTER);
        btnEditarNombre.setHorizontalAlignment(SwingConstants.CENTER);
        btnEditarNombre.setFont(new Font("Roboto", Font.BOLD, 25));
        btnEditarNombre.setBounds(0, 0, 267, 42);
        panel_2_1.add(btnEditarNombre);
        
        JPanel panel_2_2 = new JPanel();
        panel_2_2.setBackground(new Color(255, 0, 51));
        panel_2_2.setBounds(680, 422, 267, 42);
        panel.add(panel_2_2);
        panel_2_2.setLayout(null);
        
        JLabel btnEliminarCuenta = new JLabel("Eliminar Cuenta");
        btnEliminarCuenta.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		if(tabla.getSelectedRow()!=-1) {
        			int id = Integer.parseInt(modelo.getValueAt(tabla.getSelectedRow(), 1).toString());
            		if(JOptionPane.showConfirmDialog(null, "Seguro que quieres eliminar la cuenta "+id)==0) {
            			cuentaController.eliminar(id);
            			modelo.removeRow(tabla.getSelectedRow());
            			JOptionPane.showMessageDialog(null, "Cuenta Eliminada con Exito");
            			System.out.println(id);
            		}
        		}else JOptionPane.showMessageDialog(null, "Seleccione una cuenta de la tabla!");
        		
        		
        		
        		
        		
        	}
        });
        btnEliminarCuenta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnEliminarCuenta.setForeground(new Color(255, 255, 255));
        btnEliminarCuenta.setHorizontalTextPosition(SwingConstants.CENTER);
        btnEliminarCuenta.setHorizontalAlignment(SwingConstants.CENTER);
        btnEliminarCuenta.setFont(new Font("Roboto", Font.BOLD, 25));
        btnEliminarCuenta.setBounds(0, 0, 267, 42);
        panel_2_2.add(btnEliminarCuenta);
        
        JPanel panel_2_3 = new JPanel();
        panel_2_3.setBackground(new Color(0, 102, 102));
        panel_2_3.setBounds(680, 159, 267, 42);
        panel.add(panel_2_3);
        panel_2_3.setLayout(null);
        
        JLabel lblNewLabel_3 = new JLabel("Ver Movimientos");
        lblNewLabel_3.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		MovimientosFrame mov = new MovimientosFrame();
        		mov.setVisible(true);
        	}
        });
        lblNewLabel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblNewLabel_3.setForeground(new Color(255, 255, 255));
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setFont(new Font("Roboto", Font.BOLD, 25));
        lblNewLabel_3.setHorizontalTextPosition(SwingConstants.CENTER);
        lblNewLabel_3.setBounds(0, 0, 267, 42);
        panel_2_3.add(lblNewLabel_3);
        
        JPanel panel_3 = new JPanel();
        panel_3.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		TransferirFrame tr = new TransferirFrame();
        		tr.setVisible(true);
        	}
        });
        panel_3.setBounds(512, 435, 83, 65);
        panel.add(panel_3);
        
        JPanel btnSacarDinero = new JPanel();
        btnSacarDinero.setLayout(null);
        btnSacarDinero.setBackground(new Color(0, 0, 255));
        btnSacarDinero.setBounds(680, 277, 267, 42);
        panel.add(btnSacarDinero);
        
        JLabel lblNewLabel_3_2_1 = new JLabel("Sacar Dinero");
        lblNewLabel_3_2_1.setHorizontalTextPosition(SwingConstants.CENTER);
        lblNewLabel_3_2_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3_2_1.setForeground(Color.WHITE);
        lblNewLabel_3_2_1.setFont(new Font("Roboto", Font.BOLD, 25));
        lblNewLabel_3_2_1.setBounds(0, 0, 267, 42);
        btnSacarDinero.add(lblNewLabel_3_2_1);
	}
	
	private void cargarCombo(JComboBox combo) {
		
		
	}

	private void cargarTabla() {		
		
		modelo = crearTabla();
		var cuentas = this.cuentaController.listar();   
        cuentas.forEach(cuenta -> modelo.addRow(new Object[] { cuenta.getNombreCuenta(),
        cuenta.getNoCuenta(), "$" + cuenta.getSaldo(),nombreTipoCuenta.values()[cuenta.getTipo_cuenta_id()-1]}));
	}
	
	private void Filtrar(int id) {				

	    modelo =  crearTabla();
		
		var cuentas = this.cuentaController.filtrar(id);   

        cuentas.forEach(cuenta -> modelo.addRow(new Object[] { cuenta.getNombreCuenta(),
        cuenta.getNoCuenta(), cuenta.getSaldo(),nombreTipoCuenta.values()[cuenta.getTipo_cuenta_id()-1]}));
	}



private DefaultTableModel crearTabla() {
	tabla.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre Cuenta", "Numero Cuenta", "Saldo Cuenta", "Tipo Cuenta"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, true, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tabla.getColumnModel().getColumn(0).setPreferredWidth(80);
		tabla.getColumnModel().getColumn(1).setPreferredWidth(60);
		tabla.getColumnModel().getColumn(2).setResizable(false);
		
		return (DefaultTableModel) tabla.getModel();
}}
