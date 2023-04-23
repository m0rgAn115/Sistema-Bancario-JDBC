package com.morgan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.morgan.jdbc.factory.ConnectionFactory;
import com.morgan.modelos.Cliente;

public class ClienteDAO {
	private static Cliente cliente;

	public void registrar(Cliente cliente) {
		Connection con = new ConnectionFactory().recuperaConexion();
		try(con){
			final PreparedStatement statement = con.prepareStatement(
					"INSERT INTO CLIENTE(CONTRASEÑA_CLIENTE,NOMBRE_CLIENTE,DIRECCION_CLIENTE,TELEFONO_CLIENTE) "
					+ "VALUES (?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
		try(statement){
			ejecutaRegistro(cliente,statement);
			JOptionPane.showMessageDialog(null, "Se ha registrado con Exito!");
		}
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		}

	
	
	private void ejecutaRegistro(Cliente cliente,PreparedStatement statement) throws SQLException {
				
				statement.setString(1, cliente.getContraseña());
				statement.setString(2, cliente.getNombre());
				statement.setString(3, cliente.getDireccion());
				statement.setString(4, cliente.getTelefono());
			
				
				statement.execute();
				
				ResultSet resultSet = statement.getGeneratedKeys();//Obtenemos el valor de ID del producto
				
				try(resultSet) {
					while(resultSet.next()) {
						cliente.setId(resultSet.getInt(1));
						System.out.println(String.format("Fue registrado el cliente %s",cliente));
						
					}
				
				}
	}



	public boolean iniciarSesion(int id,String contraseña) {
		final Connection con = new ConnectionFactory().recuperaConexion();
		boolean Validacion = false;
		
		try(con){
			final PreparedStatement statement = con.prepareStatement("Select * FROM CLIENTE WHERE ID_CLIENTE=? AND CONTRASEÑA_CLIENTE=?");
			try(statement){
				statement.setInt(1, id);
				statement.setString(2, contraseña);
				
				ResultSet resultSet = statement.executeQuery();
				resultSet.next();
				if(resultSet.getInt("ID_CLIENTE")==id) {
					
					String nombre=resultSet.getString("NOMBRE_CLIENTE");
					String direccion=resultSet.getString("DIRECCION_CLIENTE");
					String telefono=resultSet.getString("TELEFONO_CLIENTE");
					
					setCliente(id, contraseña, nombre, direccion, telefono);
					
					JOptionPane.showMessageDialog(null, "Inicio de Sesion Exitoso!");
					System.out.println("Inicio de Sesion Exitoso!");
					Validacion = true;
					
			}			
			}
			
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Credenciales Incorrectas!");
			throw new RuntimeException(e);
		}
		return Validacion;
		
	}
	
	public void setCliente(int id,String contraseña,String nombre,String direccion,String telefono) {
		ClienteDAO.cliente = new Cliente(id,contraseña,nombre,direccion,telefono);
	}
	public Cliente getCliente() {
		return ClienteDAO.cliente;
	}

}
