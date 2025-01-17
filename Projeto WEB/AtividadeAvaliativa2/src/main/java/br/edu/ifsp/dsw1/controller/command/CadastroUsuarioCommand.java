package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.model.dao.UsuarioFactory;
import br.edu.ifsp.dsw1.model.entity.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CadastroUsuarioCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		var login = request.getParameter("login");
		var senha = request.getParameter("senha");
		
		Usuario usuario = new Usuario(login, senha);
		
		var dao = new UsuarioFactory().factory();
		
		boolean created = dao.insert(usuario);
		String mensagem;
		if(created) {
			mensagem = "Usuário cadastrado com sucesso!";
		}else {
			mensagem = "Não foi possivel cadsatrar o usuário!";
		}
		
		request.setAttribute("message", mensagem);
		return "logged.do?action=pageCadastroUsuario";
	}

}
