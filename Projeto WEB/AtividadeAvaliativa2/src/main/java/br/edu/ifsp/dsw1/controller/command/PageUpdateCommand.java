package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PageUpdateCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int idPedido = Integer.parseInt(request.getParameter("idPedido"));
		
		
		request.setAttribute("idPedido", idPedido);
		return "/loggedin/updatePedido.jsp";
	}

}
