package com.morgan.Test;

import com.morgan.modelos.Funcionario;
import com.morgan.modelos.Gerente;

public class TestFuncionario {
	public static void main(String[] args) {
		Funcionario f1 = new Gerente("21312314142","Angel Mondragon",1);
		
		f1.setSueldo(2000);
		
		System.out.println("Su nombre es: "+f1.getNombre());
	}
}
