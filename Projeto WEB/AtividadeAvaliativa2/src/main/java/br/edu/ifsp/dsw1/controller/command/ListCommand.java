package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;
import java.util.List;

import br.edu.ifsp.dsw1.model.dao.PedidosFactory;
import br.edu.ifsp.dsw1.model.entity.Pedido;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListCommand implements Command{
	
	// faz uma listagem dos pedidos
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		var dao = new PedidosFactory().factory();
		
		String messageUpdated = (String) request.getAttribute("messageUpdated");
		
		List<Pedido> pedidos = dao.retrieve();
		
		if(pedidos.isEmpty()) {
			request.setAttribute("message", "Lista de pedidos vazia!");
		}
		
		if(messageUpdated != null && !messageUpdated.isEmpty()) {
			request.setAttribute("messageUpdated", messageUpdated);
		}
		
		request.setAttribute("pedidos", pedidos);
		
		return "logged.do?action=pageLista";
	}

}
