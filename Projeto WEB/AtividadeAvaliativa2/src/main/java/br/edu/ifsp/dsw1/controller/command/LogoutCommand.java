package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LogoutCommand implements Command{
	
	// efetua o logout, invalidando a sessão
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		var sessao = request.getSession(false);
		
		if(sessao != null) {
			sessao.invalidate();
		}
		
		return "front.do?action=pageLogin";
	}

}
