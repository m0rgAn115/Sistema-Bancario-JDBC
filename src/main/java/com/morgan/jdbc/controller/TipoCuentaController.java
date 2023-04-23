package com.morgan.jdbc.controller;

import java.util.List;

import com.morgan.dao.TipoCuentaDAO;
import com.morgan.modelos.TipoDeCuenta;

public class TipoCuentaController {
	private TipoCuentaDAO tipoCuentaDAO;
	
	public TipoCuentaController() {
		this.tipoCuentaDAO = new TipoCuentaDAO();
	}

	public List<TipoDeCuenta> listar() {
		
		return tipoCuentaDAO.listar();
	}

	public List<TipoDeCuenta> cargar() {
		return tipoCuentaDAO.cargar();
		
	}
}
