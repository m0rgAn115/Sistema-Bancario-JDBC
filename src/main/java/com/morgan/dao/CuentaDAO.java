package com.morgan.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.morgan.jdbc.factory.ConnectionFactory;
import com.morgan.modelos.Cuenta;

public class CuentaDAO {
	
	private ClienteDAO clienteDAO;
	
	public CuentaDAO() {
		clienteDAO = new ClienteDAO();
	}

	public void crearCuenta(Cuenta cuenta) {
		final Connection con = new ConnectionFactory().recuperaConexion();
		try(con){
			final PreparedStatement statement = con.prepareStatement("INSERT INTO CUENTA(NOCUENTA,NOCLIENTE,TIPO_CUENTA_ID,SALDO,NOMBRE_CUENTA)"
					+ " VALUES (?,?,?,?,?)");
			try(statement){
				ejecutarRegistro(cuenta, statement);
				JOptionPane.showMessageDialog(null, "Se ha creado una cuenta con exito!");
			}
			}catch(SQLException e) {
				throw new RuntimeException(e);
		}
		
		
	}
	
	public void ejecutarRegistro(Cuenta cuenta,PreparedStatement statement) throws SQLException {
		statement.setInt(1, cuenta.getNoCuenta());
		statement.setInt(2, cuenta.getNoCliente());
		statement.setInt(3, cuenta.getTipo_cuenta_id());
		statement.setBigDecimal(4, cuenta.getSaldo());
		statement.setString(5, cuenta.getNombreCuenta());
		
		statement.execute();
		
		cuenta.imprimir();
			
		
	}

	public List<Cuenta> listar() {
		List<Cuenta> resultado = new ArrayList<>();
		Connection con = new ConnectionFactory().recuperaConexion();
		try(con){
			PreparedStatement statement = con.prepareStatement("SELECT * FROM CUENTA WHERE NOCLIENTE=?");
			try(statement){
				statement.setInt(1, clienteDAO.getCliente().getId());
				ResultSet resultSet = statement.executeQuery();
				try(resultSet){
					while(resultSet.next()) {
						int no_cuenta=resultSet.getInt("NOCUENTA");
						int no_cliente = resultSet.getInt("NOCLIENTE");
						int tipo_cuenta_id = resultSet.getInt("TIPO_CUENTA_ID");
						BigDecimal saldo = resultSet.getBigDecimal("SALDO");
						String nombre_cuenta = resultSet.getString("NOMBRE_CUENTA");
						Cuenta cuenta = new Cuenta(no_cuenta,no_cliente,tipo_cuenta_id,saldo,nombre_cuenta);
						resultado.add(cuenta);
					}
				}
			}
			return resultado;
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void eliminar(int noCuenta) {
		final Connection con = new ConnectionFactory().recuperaConexion();
		try(con){
			final PreparedStatement statement = con.prepareStatement("DELETE FROM CUENTA WHERE NOCUENTA=?");
			try(statement){
				statement.setInt(1, noCuenta);
				statement.execute();
				System.out.println("{Se elimino la cuenta="+noCuenta+"}");
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public void editarNombre(int noCuenta,String nombre) {
		final Connection con = new ConnectionFactory().recuperaConexion();
		try(con) {
			final PreparedStatement statement = con.prepareStatement("UPDATE CUENTA SET NOMBRE_CUENTA=? WHERE NOCUENTA=?");
			try(statement){
				statement.setString(1, nombre);
				statement.setInt(2, noCuenta);
				statement.execute();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public List<Cuenta> filtrar(int id) {
		List<Cuenta> resultado = new ArrayList<>();
		Connection con = new ConnectionFactory().recuperaConexion();
		try(con){
			PreparedStatement statement = con.prepareStatement("SELECT * FROM CUENTA WHERE NOCLIENTE=? AND TIPO_CUENTA_ID=?");
			try(statement){
				statement.setInt(1, clienteDAO.getCliente().getId());
				statement.setInt(2, id);
				ResultSet resultSet = statement.executeQuery();
				try(resultSet){
					while(resultSet.next()) {
						int no_cuenta=resultSet.getInt("NOCUENTA");
						int no_cliente = resultSet.getInt("NOCLIENTE");
						int tipo_cuenta_id = resultSet.getInt("TIPO_CUENTA_ID");
						BigDecimal saldo = resultSet.getBigDecimal("SALDO");
						String nombre_cuenta = resultSet.getString("NOMBRE_CUENTA");
						Cuenta cuenta = new Cuenta(no_cuenta,no_cliente,tipo_cuenta_id,saldo,nombre_cuenta);
						resultado.add(cuenta);
					}
				}
			}
			return resultado;
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void transferir(int cuentaOrigen,int cuentaDestino, BigDecimal nuevoSaldoOrigen, BigDecimal nuevoSaldoDestino) {
		final Connection con = new ConnectionFactory().recuperaConexion();
		try(con) {
			if(validarExistencia(cuentaDestino)) {
				final PreparedStatement statement = con.prepareStatement("UPDATE CUENTA SET SALDO=? WHERE NOCUENTA=?");
				final PreparedStatement statement2 = con.prepareStatement("UPDATE CUENTA SET SALDO=? WHERE NOCUENTA=?");
				try(statement){
					try (statement2){
						statement.setBigDecimal(1, nuevoSaldoOrigen);
						statement.setInt(2, cuentaOrigen);
						statement2.setBigDecimal(1, nuevoSaldoDestino);
						statement2.setInt(2, cuentaDestino);
						statement.execute();
						statement2.execute();
						
						JOptionPane.showMessageDialog(null, "Transferencia Exitosa");
					}
					
				}
				
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public boolean validarExistencia(int NoCuenta) {
		final Connection con = new ConnectionFactory().recuperaConexion();
		try(con) {
			final PreparedStatement statement = con.prepareStatement("SELECT NOCUENTA FROM CUENTA WHERE NOCUENTA=?");
			try(statement){
				statement.setInt(1, NoCuenta);
				final ResultSet resultSet = statement.executeQuery();
				try(resultSet){
					resultSet.next();
					return resultSet.getInt("NOCUENTA") == NoCuenta;
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "La cuenta ingresada No existe");
			throw new RuntimeException(e);
			
		}
	}

	public BigDecimal getSaldo(int noCuenta) {
		final Connection con = new ConnectionFactory().recuperaConexion();
		try(con){
			final PreparedStatement statement = con.prepareStatement("SELECT SALDO FROM CUENTA WHERE NOCUENTA=?");
			try(statement){
				statement.setInt(1, noCuenta);
				final ResultSet resultSet = statement.executeQuery();
				try(resultSet){
					resultSet.next();
					return new BigDecimal(resultSet.getInt("SALDO"));
					}
				}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}
