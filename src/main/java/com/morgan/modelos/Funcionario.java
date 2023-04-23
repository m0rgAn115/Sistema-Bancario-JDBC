package com.morgan.modelos;

public abstract class Funcionario {
	private double sueldo;
	private double bonificacion;
	private String sucursal;
	private String nombre;
	private String numeroCliente;
	
	Funcionario(String numeroCliente,String nombre,String sucursal){
		this.numeroCliente=numeroCliente;
		this.nombre=nombre;
		this.sucursal=sucursal;
	}
	
	
	public double getSueldo() {
		return sueldo;
	}
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	public double getBonificacion() {
		return bonificacion;
	}
	public void setBonificacion(double bonificacion) {
		this.bonificacion = bonificacion;
	}
	public String getSucursal() {
		return sucursal;
	}
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
