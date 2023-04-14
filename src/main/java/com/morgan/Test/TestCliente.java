package com.morgan.Test;

import com.morgan.jdbc.controller.ClienteController;
import com.morgan.modelos.Cliente;

public class TestCliente {
	public static void main(String[] args) {
		
		ClienteController clienteController = new ClienteController();
		Cliente cliente = new Cliente("admin", "Angel", "cdmx", "5542345654");
		
		clienteController.registrarCliente(cliente);
		
	
	}
}
