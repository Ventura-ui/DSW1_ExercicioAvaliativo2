package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.model.dao.PedidosFactory;
import br.edu.ifsp.dsw1.model.entity.Pedido;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		var idPedido = Integer.parseInt(request.getParameter("idPedido"));
		String nomeCliente = request.getParameter("nomeCliente");
		String endereco = request.getParameter("endereco");
		double valor = Double.parseDouble(request.getParameter("valor"));
		String descricao = request.getParameter("descricao");
		
		var dao = new PedidosFactory().factory();
		
		Pedido pedidoAntigo = dao.retrieve(idPedido);
		
		Pedido pedido = new Pedido(nomeCliente, endereco, valor, descricao);
		
		boolean updated = dao.update(pedido, idPedido);
		
		
		if(updated) {
			request.setAttribute("messageUpdated", "Pedido " + pedidoAntigo.getId() + " foi atualizado com sucesso!");
		}else {
			request.setAttribute("message", "Não foi possível atualizar o pedido: " + pedidoAntigo.getId() + "!");
			return "logged.do?action=pageUpdate";
		}
		
		return "logged.do?action=listarPedidos";
	}

}
