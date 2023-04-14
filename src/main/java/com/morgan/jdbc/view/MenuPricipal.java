package com.morgan.jdbc.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MenuPricipal extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPricipal frame = new MenuPricipal();
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
	public MenuPricipal() {
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
		
		JLabel lblNewLabel = new JLabel("Bienvenid@ ");
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 22));
		lblNewLabel.setBounds(10, 11, 428, 31);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 447, 305, 53);
		panel.add(panel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(758, 64, 210, 31);
		panel.add(comboBox);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"12123131", null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"No. Cuenta", "Tipo de Cuenta", "Saldo"
			}
		));
		table.setBackground(new Color(0, 255, 0));
		table.setBounds(435, 118, 533, 222);
		panel.add(table);
		
		
	}
}
