package br.edu.ifsp.dsw1.model.dao;

import java.sql.SQLException;

import br.edu.ifsp.dsw1.model.dao.connection.UserConnection;
import br.edu.ifsp.dsw1.model.entity.Usuario;

public class UsuarioDatabase implements UsuarioDao{
	
	private static final String INSERT = "INSERT INTO usuario (login, senha) VALUES (?, ?)";
	private static final String SELECT_BY_LOGIN = "SELECT * FROM usuario WHERE login = ?";

	@Override
	public boolean insert(Usuario usuario) {
		if (usuario != null) {
			int rows = -1;
			try( var connection = UserConnection.getConnection();
				 var statement = connection.prepareStatement(INSERT)){
				
				statement.setString(1, usuario.getLogin());
				statement.setString(2, usuario.getSenha());
				
				rows = statement.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return rows > 0;
		}
		return false;
	}

	@Override
	public Usuario findByLogin(String login) {
		Usuario usuario = null;
		try( var connection = UserConnection.getConnection();
				 var statement = connection.prepareStatement(SELECT_BY_LOGIN)) {
			
			statement.setString(1, login);
			var resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				usuario = new Usuario();
				usuario.setLogin(resultSet.getString("login"));
				usuario.setSenha(resultSet.getString("senha"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			usuario = null;
		}
		return usuario;
	}

}
