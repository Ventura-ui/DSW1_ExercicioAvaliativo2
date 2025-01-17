package br.edu.ifsp.dsw1.controller.filtro;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

// filtro para fazer a verificação da sessão. Se o usuário não estiver logado
// não poderá acessar as páginas que estão na pasta loggedin

@WebFilter(urlPatterns = {"/loggedin/*","/logged.do"})
public class FiltroDeSessao implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession sessao = httpRequest.getSession(false);
		
		if(sessao != null && sessao.getAttribute("user") != null) {
			chain.doFilter(httpRequest, response);
		}else {
			request.setAttribute("message", "Não é possível acessar essa página sem estar logado!");
			
			var dispatcher = request.getRequestDispatcher("front.do?action=pageLogin");
			dispatcher.forward(request, response);
		}
	}

}
