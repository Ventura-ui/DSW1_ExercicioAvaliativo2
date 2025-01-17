package br.edu.ifsp.dsw1.model.dao;

public class PedidosFactory {
	
	public PedidoDao factory() {
		return new PedidoDatabase();
	}

}
