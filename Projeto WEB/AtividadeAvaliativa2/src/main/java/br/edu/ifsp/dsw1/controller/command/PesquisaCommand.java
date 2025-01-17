package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;
import java.util.List;

import br.edu.ifsp.dsw1.model.dao.PedidosFactory;
import br.edu.ifsp.dsw1.model.entity.Pedido;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PesquisaCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		var dao = new PedidosFactory().factory();
		String nomeCliente = request.getParameter("nomeCliente");
		
		List<Pedido> pedidos = dao.findByClientName(nomeCliente);
		
		if(pedidos.isEmpty()) {
			request.setAttribute("message", "Cliente não encontrado");
			pedidos = dao.retrieve();
		}
		
		request.setAttribute("pedidos", pedidos);
		return "logged.do?action=pageLista";
	}

}
