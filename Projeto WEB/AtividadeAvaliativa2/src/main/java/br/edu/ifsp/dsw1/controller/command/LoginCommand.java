package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.model.dao.UsuarioFactory;
import br.edu.ifsp.dsw1.model.entity.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginCommand implements Command{
	
	// pega o login e a senha, faz a autenticação, e se der certo manda para  a página home
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		var login = request.getParameter("login");
		var senha = request.getParameter("senha");
		
		var dao = new UsuarioFactory().factory();
		var user = dao.findByLogin(login);
		
		boolean correto = Usuario.autenticate(user, login, senha);
		
		String message;
		
		if(correto) {
			var sessao = request.getSession(true);
			sessao.setAttribute("user", user);
			sessao.setMaxInactiveInterval(24 * 60 * 60);
			return "logged.do?action=pageHome";
		}else {
			message = "Login incorreto!";
			request.setAttribute("message", message);
		}
		
		return "front.do?action=pageLogin";
	}

}
