package com.morgan.modelos;

public class CuentasGuardadas extends Cuenta{
	
	private int id;
	private int NoCliente;
	private String NombreCuenta;
	private int NoCuenta;
	
	public CuentasGuardadas(int id,int NoCliente,String NombreCuenta,int NoCuenta) {
		this.id=id;
		this.NoCliente=NoCliente;
		this.NombreCuenta=NombreCuenta;
		this.NoCuenta=NoCuenta;
		
	}
//System.out.println(String.format("Se ha guardado la cuenta: {id=%d,NoCliente=%d, NombreCuenta=%s, NoCuenta=%d}",id,NoCliente,NombreCuenta,NoCuenta));
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNoCliente() {
		return NoCliente;
	}

	public void setNoCliente(int noCliente) {
		NoCliente = noCliente;
	}

	public String getNombreCuenta() {
		return NombreCuenta;
	}

	public void setNombreCuenta(String nombreCuenta) {
		NombreCuenta = nombreCuenta;
	}

	public int getNoCuenta() {
		return NoCuenta;
	}

	public void setNoCuenta(int noCuenta) {
		NoCuenta = noCuenta;
	}
	
	
	
	
}
