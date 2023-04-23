package com.morgan.jdbc.controller;

import java.util.List;

import com.morgan.dao.CuentasGuardadasDAO;
import com.morgan.modelos.CuentasGuardadas;

public class CuentasGuardadasController {
	private CuentasGuardadasDAO cuentasGuardadasDAO;
	
	public CuentasGuardadasController() {
		this.cuentasGuardadasDAO=new CuentasGuardadasDAO();
	}
	
	public void guardar(String nombre, int noCuenta) {
		cuentasGuardadasDAO.guardar(nombre,noCuenta);
	}
	
	public List<CuentasGuardadas> listar(){
		return cuentasGuardadasDAO.listar();
	}
}
