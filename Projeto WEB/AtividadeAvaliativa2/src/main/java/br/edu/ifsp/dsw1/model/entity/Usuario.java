package br.edu.ifsp.dsw1.model.entity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Usuario {
	
	private String login;
	private String senha;
	private List<Pedido> pedidos = new LinkedList<Pedido>();
	
	public Usuario() {}

	public Usuario(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
		pedidos = new LinkedList<Pedido>();
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

	public List<Pedido> getPedidos() {
		return new ArrayList<Pedido>(pedidos);
	}

	public void clearPedidos() {
		pedidos.clear();
	}
	
	public void addPedido(Pedido pedido) {
		pedidos.add(new Pedido(pedido.getId(), pedido.getNomeCliente(), pedido.getEnderecoEntrega(), pedido.getValor(), pedido.getDescricao()));
	}
	
	public static boolean autenticate(Usuario userFromSystem, String login, String senha) {
		if (userFromSystem != null) {
			return senha.equals(userFromSystem.getSenha()) && login.equals(userFromSystem.getLogin());
		}
		return false;
	}

}
