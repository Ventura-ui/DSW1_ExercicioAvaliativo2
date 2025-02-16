package br.edu.ifsp.dsw1.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import br.edu.ifsp.dsw1.model.dao.connection.UserConnection;
import br.edu.ifsp.dsw1.model.entity.Pedido;
import br.edu.ifsp.dsw1.model.entity.Usuario;

public class PedidoDatabase implements PedidoDao{
	
	private static final String INSERT = "INSERT INTO pedidos (nomeCliente, enderecoEntrega, valor, descricao) VALUES (?, ?, ?, ?)";
	private static final String SELECT_BY_ID = "SELECT * FROM pedidos WHERE idpedidos = ?";
	private static final String SELECT_BY_CLIENT_NAME = "SELECT * FROM pedidos WHERE nomeCliente LIKE ? ORDER BY nomeCliente";
	private static final String SELECT_ALL = "SELECT * FROM pedidos ORDER BY idpedidos";
	private static final String UPDATE = "UPDATE pedidos SET nomeCliente = ?, enderecoEntrega = ?, valor = ?, descricao = ? WHERE idpedidos = ?";
	private static final String DELETE = "DELETE FROM pedidos WHERE idpedidos = ?";
	
	// Insert de um pedido na tabela pedidos
	@Override
	public boolean create(Pedido pedido) {
		if (pedido != null) {
			int rows = -1;
			try ( var connection = UserConnection.getConnection();
				  var preparedStatement = connection.prepareStatement(INSERT)) {

				preparedStatement.setString(1, pedido.getNomeCliente());
				preparedStatement.setString(2, pedido.getEnderecoEntrega());
				preparedStatement.setDouble(3, pedido.getValor());
				preparedStatement.setString(4, pedido.getDescricao());
				rows = preparedStatement.executeUpdate();
				

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return rows > 0;
		}
		return false;
	}
	
	// busca por um pedido através de seu ID único
	@Override
	public Pedido retrieve(int id) {
		Pedido pedido = null;
		if (id > 0) {
			try (var connection = UserConnection.getConnection();
				 var preparedStatement = connection.prepareStatement(SELECT_BY_ID)){
				
				preparedStatement.setInt(1, id);

				ResultSet result = preparedStatement.executeQuery();
				if (result.next()) {
					pedido = new Pedido();
					pedido.setId(result.getInt("idpedidos"));
					pedido.setNomeCliente(result.getString("nomeCliente"));
					pedido.setEnderecoEntrega(result.getString("enderecoEntrega"));
					pedido.setValor(result.getDouble("valor"));
					pedido.setDescricao(result.getString("descricao"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return pedido;
	}
	
	// busca por todos os pedidos cadastrados
	@Override
	public List<Pedido> retrieve() {
		List<Pedido> pedidos = new LinkedList<Pedido>();
			try (var connection = UserConnection.getConnection();
				 var preparedStatement = connection.prepareStatement(SELECT_ALL)){

				var result = preparedStatement.executeQuery();
				while (result.next()) {
					Pedido pedido = new Pedido();
					pedido.setId(result.getInt("idpedidos"));
					pedido.setNomeCliente(result.getString("nomeCliente"));
					pedido.setEnderecoEntrega(result.getString("enderecoEntrega"));
					pedido.setValor(result.getDouble("valor"));
					pedido.setDescricao(result.getString("descricao"));
					pedidos.add(pedido);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return pedidos;
	}
	
	// busca por todos os pedidos que tiverem a String nomeCliente no nome de seu cliente
	@Override
	public List<Pedido> findByClientName(String nomeCliente) {
		List<Pedido> pedidos = new LinkedList<Pedido>();
		try (var connection = UserConnection.getConnection();
			 var preparedStatement = connection.prepareStatement(SELECT_BY_CLIENT_NAME)){
			
			nomeCliente = "%" + nomeCliente + "%";
			preparedStatement.setString(1, nomeCliente);

			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				Pedido pedido = new Pedido();
				pedido.setId(result.getInt("idpedidos"));
				pedido.setNomeCliente(result.getString("nomeCliente"));
				pedido.setEnderecoEntrega(result.getString("enderecoEntrega"));
				pedido.setValor(result.getDouble("valor"));
				pedido.setDescricao(result.getString("descricao"));
				pedidos.add(pedido);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pedidos;
	}
	
	// modificar os atributos de um pedido, menos o seu id
	@Override
	public boolean update(Pedido updatedpedido, int oldId) {
		if(updatedpedido != null && oldId > 0) {
			int rows = -1;
			try(var connection = UserConnection.getConnection();
					var stat = connection.prepareStatement(UPDATE)) {
				
				stat.setString(1, updatedpedido.getNomeCliente());
				stat.setString(2, updatedpedido.getEnderecoEntrega());
				stat.setDouble(3, updatedpedido.getValor());
				stat.setString(4, updatedpedido.getDescricao());
				stat.setInt(5, oldId);
				
				rows = stat.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return rows > 0;
		}
		return false;
	}
	
	// deletar um pedido do banco de dados
	@Override
	public boolean delete(Pedido pedido) {
		if (pedido != null) {
			int rows = -1;
			try ( var connection = UserConnection.getConnection();
				  var preparedStatement = connection.prepareStatement(DELETE)) {

				preparedStatement.setInt(1, pedido.getId());
				rows = preparedStatement.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return rows > 0;
		}
		return false;
	}

	

}
