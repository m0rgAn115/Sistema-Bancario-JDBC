package com.morgan.jdbc.controller;

import java.math.BigDecimal;
import java.util.List;

import com.morgan.dao.RegistroMovimientosDAO;
import com.morgan.modelos.RegistroMovimientos;

public class RegistroMovimientosController {
	
	private RegistroMovimientosDAO registroMovimientosDAO;
	
	public RegistroMovimientosController() {
		this.registroMovimientosDAO = new RegistroMovimientosDAO();
	}
	
	public List<RegistroMovimientos> listar(){
		return registroMovimientosDAO.listar();
	}

	public void registrar(int cuentaOrigen, int cuentaDestino, BigDecimal monto) {
		this.registroMovimientosDAO.registrar(cuentaOrigen,cuentaDestino,monto);
		
	}

	public List<RegistroMovimientos> filtrar(int noCuenta) {
		return this.registroMovimientosDAO.filtrar(noCuenta);
	}
}
