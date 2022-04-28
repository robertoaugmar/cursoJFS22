package br.com.bob.teste;

import javax.persistence.Persistence;

public class TesteJPA {
	
	public static void main(String[] args) {
		
		Persistence.createEntityManagerFactory("cursoJSF22");
	}

}
