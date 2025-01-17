package br.edu.ifsp.dsw1.model.dao;

import java.util.List;

import br.edu.ifsp.dsw1.model.entity.Pedido;
import br.edu.ifsp.dsw1.model.entity.Usuario;

public interface PedidoDao {
	
	boolean create(Pedido pedido);
	
	Pedido retrieve(int id);
	
	List<Pedido> retrieve();
	
	List<Pedido> findByClientName(String nomeCliente);
	
	boolean update(Pedido updatedpedido, int oldId);
	
	boolean delete(Pedido pedido);

}
