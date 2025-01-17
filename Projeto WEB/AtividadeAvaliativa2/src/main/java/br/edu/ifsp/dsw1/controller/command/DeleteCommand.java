package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.model.dao.PedidosFactory;
import br.edu.ifsp.dsw1.model.entity.Pedido;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		var sessao = request.getSession(false);
		var dao = new PedidosFactory().factory();
		int id = Integer.parseInt(request.getParameter("id"));
		
		Pedido pedido = dao.retrieve(id);
		
		boolean deleted = dao.delete(pedido);
		
		String message;
		if(deleted) {
			message = "Pedido " + pedido.getDescricao() + " deletado com sucesso!";
		}else {
			message = "Não foi possível deletar o produto: " + pedido.getDescricao() + "!";
		}
		
		request.setAttribute("message", message);
		return "logged.do?action=listarPedidos";
	}

}
