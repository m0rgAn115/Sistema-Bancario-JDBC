package com.morgan.Test;

import java.math.BigDecimal;

import com.morgan.dao.CuentaDAO;
import com.morgan.jdbc.controller.CuentaController;
import com.morgan.modelos.Cliente;
import com.morgan.modelos.Cuenta;

public class TestCuenta {
	public static void main(String[] args) {
		CuentaController cuentaController = new CuentaController();
		Cliente cliente = new Cliente();
		CuentaDAO cuentaDAO = new CuentaDAO();
				
		cliente.setId(12);
		
		Cuenta cuenta = new Cuenta();
		cuenta.setSaldo(new BigDecimal(1000));
		
		
		

		
		System.out.println(cuentaDAO.validarExistencia(255385));
		System.out.println(cuentaController.getSaldo(255385));
		
		
	}
}
