package com.morgan.modelos;

import java.math.BigDecimal;

public class Cuenta {
	private int noCuenta;
	private int noCliente;
	private int tipo_cuenta_id;
	private BigDecimal saldo;
	private String nombreCuenta;
	private Enum tipoDeCuenta;
	
	public Cuenta() {
		// TODO Auto-generated constructor stub
	}
	
	public Cuenta(Cliente cliente,int tipo_cuenta_id) {
		this.noCuenta= (int)(Math.random()*1000000+1);
		this.noCliente = cliente.getId();
		this.tipo_cuenta_id = tipo_cuenta_id;
		this.saldo= new BigDecimal(0);
	}

	public Cuenta(Cliente cliente, int tipo_cuenta_id, String nombre_cuenta) {
		this.noCuenta= (int)(Math.random()*1000000+1);
		this.noCliente = cliente.getId();
		this.tipo_cuenta_id = tipo_cuenta_id;
		this.saldo= new BigDecimal(0);
		this.nombreCuenta = nombre_cuenta;
	}

	public Cuenta(int no_cuenta, int no_cliente, int tipo_cuenta, BigDecimal saldo, String nombre_cuenta) {
		this.noCuenta=no_cuenta;
		this.noCliente = no_cliente;
		this.tipo_cuenta_id = tipo_cuenta;
		this.saldo= saldo;
		this.nombreCuenta = nombre_cuenta;
	}

	public int getNoCuenta() {
		return noCuenta;
	}

	public void setNoCuenta(int noCuenta) {
		this.noCuenta = noCuenta;
	}

	public int getNoCliente() {
		return noCliente;
	}

	public void setNoCliente(int noCliente) {
		this.noCliente = noCliente;
	}

	public int getTipo_cuenta_id() {
		return tipo_cuenta_id;
	}

	public void setTipo_cuenta_id(int tipo_cuenta_id) {
		this.tipo_cuenta_id = tipo_cuenta_id;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	
	public String imprimir(){
		return String.format("{No.Cuenta=%d, No.Cliente=%d, tipo_cuenta_id=%d, saldo=%s", noCuenta,noCliente,tipo_cuenta_id,saldo.toString());
	}

	public String getNombreCuenta() {
		return nombreCuenta;
	}

	public void setNombreCuenta(String nombreCuenta) {
		nombreCuenta = nombreCuenta;
	}
	
	public boolean validarSaldoSuficiente(BigDecimal monto) {
		if(this.saldo.compareTo(monto)==1 || this.saldo.compareTo(monto)==0) {
			return true;
		}else return false;
	}
	
	
}
