package br.edu.ifsp.dsw1.model.entity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Usuario {
	
	private String login;
	private String senha;
	
	public Usuario() {}

	public Usuario(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	// faz a autenticação do usuário, verificando se o email e a senha coincidem
	public static boolean autenticate(Usuario userFromSystem, String login, String senha) {
		if (userFromSystem != null) {
			return senha.equals(userFromSystem.getSenha()) && login.equals(userFromSystem.getLogin());
		}
		return false;
	}

}
