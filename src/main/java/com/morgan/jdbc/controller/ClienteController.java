package com.morgan.jdbc.controller;

import com.morgan.dao.ClienteDAO;
import com.morgan.modelos.Cliente;

public class ClienteController {
	private ClienteDAO clienteDAO;
	
	public ClienteController() {
		this.clienteDAO = new ClienteDAO();
	}
	
	public void registrarCliente(Cliente cliente) {
		clienteDAO.registrar(cliente);
	}

	public boolean iniciarSesion(int id,String contraseña) {
		return clienteDAO.iniciarSesion(id,contraseña);
		
	}
	
	
}
