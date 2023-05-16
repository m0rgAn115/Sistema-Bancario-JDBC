package com.morgan.jdbc.controller;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import com.morgan.dao.CuentaDAO;
import com.morgan.modelos.Cuenta;
import com.morgan.modelos.TipoDeCuenta;

public class CuentaController {
	private CuentaDAO cuentaDAO;
	
	public CuentaController() {
		this.cuentaDAO=new CuentaDAO();
	}
	
	public void CrearCuenta(Cuenta cuenta) {
		cuentaDAO.crearCuenta(cuenta);
	}
	
	public List<Cuenta> listar(){
		return cuentaDAO.listar();
	}

	public void eliminar(int NoCuenta) {
		cuentaDAO.eliminar(NoCuenta);
	}

	public void editarNombre(int id,String nombre) {
		cuentaDAO.editarNombre(id,nombre);
		
	}

	public List<Cuenta> filtrar(int i) {
		
		return cuentaDAO.filtrar(i);
	}

	public void transferir(int cuentaOrigen, int cuentaDestino, BigDecimal nuevoSaldoOrigen, BigDecimal nuevoSaldoDestino) {
		cuentaDAO.transferir(cuentaOrigen,cuentaDestino,nuevoSaldoOrigen,nuevoSaldoDestino);
		
	}

	public BigDecimal getSaldo(int NoCuenta) {
		
		return cuentaDAO.getSaldo(NoCuenta);
	}
	
	public boolean validarExistencia(int id) {
		return cuentaDAO.validarExistencia(id);
	}
	
	

	

	
}
