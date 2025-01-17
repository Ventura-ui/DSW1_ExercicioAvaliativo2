package br.edu.ifsp.dsw1.model.dao;

import br.edu.ifsp.dsw1.model.entity.Usuario;

public interface UsuarioDao {
	
	boolean insert(Usuario usuario);
	
	Usuario findByLogin(String login);

}
