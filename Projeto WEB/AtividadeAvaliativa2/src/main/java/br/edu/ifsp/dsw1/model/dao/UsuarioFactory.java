package br.edu.ifsp.dsw1.model.dao;

public class UsuarioFactory {

	public UsuarioDao factory() {
		return new UsuarioDatabase();
	}
	
}
