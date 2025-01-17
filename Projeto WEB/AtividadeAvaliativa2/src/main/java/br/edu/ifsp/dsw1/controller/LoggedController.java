package br.edu.ifsp.dsw1.controller;

import java.io.IOException;

import br.edu.ifsp.dsw1.controller.command.CadastroPedidoCommand;
import br.edu.ifsp.dsw1.controller.command.CadastroUsuarioCommand;
import br.edu.ifsp.dsw1.controller.command.Command;
import br.edu.ifsp.dsw1.controller.command.DeleteCommand;
import br.edu.ifsp.dsw1.controller.command.ErrorCommand;
import br.edu.ifsp.dsw1.controller.command.ListCommand;
import br.edu.ifsp.dsw1.controller.command.LogoutCommand;
import br.edu.ifsp.dsw1.controller.command.PageCadastroPedidoCommand;
import br.edu.ifsp.dsw1.controller.command.PageCadastroUsuarioCommand;
import br.edu.ifsp.dsw1.controller.command.PageHomeCommand;
import br.edu.ifsp.dsw1.controller.command.PageListCommand;
import br.edu.ifsp.dsw1.controller.command.PageUpdateCommand;
import br.edu.ifsp.dsw1.controller.command.PesquisaCommand;
import br.edu.ifsp.dsw1.controller.command.UpdateCommand;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/logged.do")
public class LoggedController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Command command = null;
		String action = request.getParameter("action");
		
		if(action.equals("pageHome")) {
			command = new PageHomeCommand();
		}else if(action.equals("logout")) {
			command = new LogoutCommand();
		}else if(action.equals("pageCadastroUsuario")) {
			command = new PageCadastroUsuarioCommand();
		}else if(action.equals("cadastroUsuario")) {
			command = new CadastroUsuarioCommand();
		}else if(action.equals("pageCadastroPedido")) {
			command = new PageCadastroPedidoCommand();
		}else if(action.equals("cadastroPedido")) {
			command = new CadastroPedidoCommand();
		}else if(action.equals("listarPedidos")) {
			command = new ListCommand();
		}else if(action.equals("pageLista")) {
			command = new PageListCommand();
		}else if(action.equals("delete")) {
			command = new DeleteCommand();
		}else if(action.equals("pesquisa")) {
			command = new PesquisaCommand();
		}else if(action.equals("pageUpdate")) {
			command = new PageUpdateCommand();
		}else if(action.equals("updatePedido")) {
			command = new UpdateCommand();
		}else {
			command = new ErrorCommand();
		}
		
		String view = command.execute(request, response);
		var dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

}
