package com.morgan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.morgan.jdbc.factory.ConnectionFactory;
import com.morgan.modelos.CuentasGuardadas;

public class CuentasGuardadasDAO {
	private ClienteDAO clienteDAO;
	
	public CuentasGuardadasDAO() {
		this.clienteDAO=new ClienteDAO();
	}

	public List<CuentasGuardadas> listar() {
		List<CuentasGuardadas> resultados = new ArrayList<>();
		final Connection con = new ConnectionFactory().recuperaConexion();
		
		try(con) {
			final PreparedStatement statement = con.prepareStatement("SELECT * FROM CUENTASGUARDADAS WHERE NOCLIENTE = ?");
			try(statement){
				statement.setInt(1, clienteDAO.getCliente().getId());
				ResultSet resultSet= statement.executeQuery();
				try(resultSet){
					while(resultSet.next()) {
						int id= resultSet.getInt("ID");
						int NoCliente = resultSet.getInt("NOCLIENTE");
						String Nombre = resultSet.getString("NOMBRECUENTA");
						int NoCuenta = resultSet.getInt("NOCUENTA");
						CuentasGuardadas cuentas = new CuentasGuardadas(id, NoCliente, Nombre, NoCuenta);
						resultados.add(cuentas);
					}
					return resultados;				
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void guardar(String nombreCuenta,int noCuenta) {
		final Connection con = new ConnectionFactory().recuperaConexion();	
		try(con) {
			final PreparedStatement statement = con.prepareStatement("INSERT INTO CUENTASGUARDADAS(NOCLIENTE,NOMBRECUENTA,NOCUENTA) "
					+ "VALUES (?,?,?)");
			try(statement){
				statement.setInt(1, clienteDAO.getCliente().getId());
				statement.setString(2, nombreCuenta);
				statement.setInt(3, noCuenta);
				statement.execute();
				System.out.println(String.format("Se ha guardado la cuenta: {NoCliente=%d, NombreCuenta=%s, NoCuenta=%d}",
						clienteDAO.getCliente().getId(),nombreCuenta,noCuenta));
				JOptionPane.showMessageDialog(null, "Cuenta Guardada con Exito!");
				}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	

}
