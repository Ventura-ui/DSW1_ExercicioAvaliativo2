package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.model.dao.PedidosFactory;
import br.edu.ifsp.dsw1.model.entity.Pedido;
import br.edu.ifsp.dsw1.model.entity.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CadastroPedidoCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nomeCliente = request.getParameter("nomeCliente");
		String endereco = request.getParameter("endereco");
		double valor = Double.parseDouble(request.getParameter("valor"));
		String descricao = request.getParameter("descricao");
		
		var sessao = request.getSession(false);
		
		var user = (Usuario) sessao.getAttribute("user");
		
		Pedido pedido = new Pedido(nomeCliente, endereco, valor, descricao);
		
		var dao = new PedidosFactory().factory();
		
		boolean created = dao.create(pedido);
		
		String message;
		if(created) {
			message = "Pedido cadastrado com sucesso pelo usuário: " + user.getLogin() + "!";
		}else {
			message = "Não foi possivel cadastrar o produto!";
		}
		
		request.setAttribute("message", message);
		return "logged.do?action=pageCadastroPedido";
	}

}
