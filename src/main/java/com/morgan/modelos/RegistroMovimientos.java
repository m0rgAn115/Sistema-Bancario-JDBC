package com.morgan.modelos;

import java.util.Date;

public class RegistroMovimientos {
	private int id;
	private int NoCliente;
	private int noCuenta;
	private String fecha;
	private String descripcion;
	
	public RegistroMovimientos(int id, int noCliente, int noCuenta, String fecha, String descripcion) {
		this.id = id;
		this.NoCliente = noCliente;
		this.noCuenta = noCuenta;
		this.fecha = fecha;
		this.descripcion = descripcion;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNoCuenta() {
		return noCuenta;
	}
	public void setNoCuenta(int noCuenta) {
		this.noCuenta = noCuenta;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getNoCliente() {
		return NoCliente;
	}
	public void setNoCliente(int noCliente) {
		NoCliente = noCliente;
	}
	
	
	
	
	
}
