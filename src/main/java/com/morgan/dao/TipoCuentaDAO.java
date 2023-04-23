package com.morgan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.morgan.jdbc.factory.ConnectionFactory;
import com.morgan.modelos.TipoDeCuenta;

public class TipoCuentaDAO {

	public List<TipoDeCuenta> listar() {
		List<TipoDeCuenta> resultado = new ArrayList<>();
		final Connection con = new ConnectionFactory().recuperaConexion();
		try(con){
			final PreparedStatement statement = con.prepareStatement("SELECT NOMBRE,ID_TIPO_CUENTA FROM TIPO_DE_CUENTA");
			try(statement){
				final ResultSet resultSet = statement.executeQuery();
				try(resultSet){
					while(resultSet.next()) {
						TipoDeCuenta tipoDeCuenta = new TipoDeCuenta(resultSet.getInt("ID_TIPO_CUENTA"),resultSet.getString("NOMBRE"));
						resultado.add(tipoDeCuenta);
					}
				}
			}
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return resultado;
	
	}

	public List<TipoDeCuenta> cargar() {
		List<TipoDeCuenta> resultado = new ArrayList<>();
		final Connection con = new ConnectionFactory().recuperaConexion();
		try(con) {
			final PreparedStatement statement = con.prepareStatement("Select * FROM TIPO_DE_CUENTA");
			try(statement){
				final ResultSet resultSet = statement.executeQuery();
				try(resultSet){
					while(resultSet.next()) {
						TipoDeCuenta tipo = new TipoDeCuenta(resultSet.getInt("ID_TIPO_CUENTA"),
								resultSet.getString("NOMBRE"));
						
						resultado.add(tipo);
					}
				}
			}
			return resultado;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
}
