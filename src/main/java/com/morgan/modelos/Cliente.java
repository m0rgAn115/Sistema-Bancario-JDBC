package com.morgan.modelos;

public class Cliente {
	private int id;
	private String contraseña;
	private String nombre;
	private String direccion;
	private String telefono;
	
	public Cliente(String contraseña,String nombre, String direccion,String telefono) {
		this.contraseña = contraseña;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono= telefono;
	}
	
	public Cliente() {
		
	}
	
	
	
	public Cliente(int id, String contraseña, String nombre, String direccion, String telefono) {
		this.id = id;
		this.contraseña =contraseña;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	@Override
	public String toString() {
		return String.format("{id=%d, contraseña=%s, nombre=%s, direccion=%s,telefono=%s}",
				this.id,this.contraseña,this.nombre,this.direccion,this.telefono);
	}
	
	
	
}
