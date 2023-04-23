package com.morgan.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.morgan.jdbc.factory.ConnectionFactory;
import com.morgan.modelos.RegistroMovimientos;

public class RegistroMovimientosDAO {
	
	private ClienteDAO clienteDAO;
	
	public RegistroMovimientosDAO() {
		clienteDAO = new ClienteDAO();
	}

	public List<RegistroMovimientos> listar() {
		List<RegistroMovimientos> resultados = new ArrayList<>();
		final Connection con = new ConnectionFactory().recuperaConexion();
		try(con){
			PreparedStatement statement = con.prepareStatement("SELECT * FROM REGISTROMOVIMIENTOS WHERE NOCLIENTE=?");
			try(statement){
				statement.setInt(1, clienteDAO.getCliente().getId());
				ResultSet resultSet = statement.executeQuery();
				try(resultSet){
					while(resultSet.next()) {
						int id = resultSet.getInt("ID");
						int noCliente = resultSet.getInt("NOCLIENTE");
						int noCuenta = resultSet.getInt("NOCUENTA");
						String fecha = resultSet.getString("FECHA");
						String descripcion = resultSet.getString("DESCRIPCION");
						RegistroMovimientos mov = new RegistroMovimientos(id,noCliente,noCuenta,fecha,descripcion);
						resultados.add(mov);
					}
				}
			}
			return resultados;
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		
	}

	public void registrar(int cuentaOrigen, int cuentaDestino, BigDecimal monto) {
		final Connection con = new ConnectionFactory().recuperaConexion();
		try(con) {
			PreparedStatement statement = con.prepareStatement("INSERT INTO REGISTROMOVIMIENTOS(NOCLIENTE,NOCUENTA,DESCRIPCION) VALUES(?,?,?)");
			try(statement){
				statement.setInt(1, this.clienteDAO.getCliente().getId());
				statement.setInt(2, cuentaOrigen);
				statement.setString(3, "Transferencia de $"+monto+" a "+cuentaDestino);
				statement.execute();
				System.out.println("{Movimiento registrado con exito}");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public List<RegistroMovimientos> filtrar(int noCuentaR) {
		List<RegistroMovimientos> resultados = new ArrayList<>();
		
		final Connection con = new ConnectionFactory().recuperaConexion();
		try(con){
			PreparedStatement statement = con.prepareStatement("SELECT * FROM REGISTROMOVIMIENTOS WHERE NOCUENTA=?");
			try(statement){
				statement.setInt(1, noCuentaR);
				ResultSet resultSet = statement.executeQuery();
				try(resultSet){
					while(resultSet.next()) {
						int id = resultSet.getInt("ID");
						int noCliente = resultSet.getInt("NOCLIENTE");
						int noCuenta = resultSet.getInt("NOCUENTA");
						String fecha = resultSet.getString("FECHA");
						String descripcion = resultSet.getString("DESCRIPCION");
						RegistroMovimientos mov = new RegistroMovimientos(id,noCliente,noCuenta,fecha,descripcion);
						resultados.add(mov);
					}
				}
			}
			return resultados;
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
