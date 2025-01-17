<%@page import="br.edu.ifsp.dsw1.model.entity.Pedido"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tabela de pedidos</title>
</head>
<body>
	
	<h1>Tabela de pedidos</h1>
	<br><br>
	<hr><br><br>
	
	<!-- Resgatando uma lista de pedidos -->
	<%
		List<Pedido> pedidos = (List<Pedido>) request.getAttribute("pedidos");
	%>
	
	<%
		String message = (String) request.getAttribute("message");
		if(message != null){
			%> <h3><%=message%></h3>
			<%
		}
	%>
	
	<!-- mensagem caso algum pedido seja atualizado -->
	<%
		String messageUpdated = (String) request.getAttribute("messageUpdated");
		if(messageUpdated != null){
			%> <h3><%=messageUpdated%></h3>
			<%
		}
	%>
	
	<br><br>
	
	<!-- fazer a pesquisa de um pedido através do nome de seu cliente -->
	<form action="logged.do?action=pesquisa" method="post">
		<input type="text" name="nomeCliente" id="nomeCliente" placeholder="Pesquise pelo nome do cliente">
		<button type="submit">Pesquisar</button>
	</form>
	
	<br><br><br>
	
	<!-- tabela de pedidos com as suas informações os botões de editar e deletar um pedido -->
	<table border="1">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">ID</th>
				<th scope="col">Nome do cliente</th>
				<th scope="col">Endereço</th>
				<th scope="col">Valor (R$)</th>
				<th scope="col">Descrição</th>
				<th scope="col">Editar</th>
				<th scope="col">Deletar</th>
			</tr>
		</thead>
		<tbody>
			<%
				int i = 1;
				for(Pedido pedido : pedidos){
			%>
			
			<tr>
				<th scope="row"><%=i%></th>
				<td><%=pedido.getId()%></td>
				<td><%=pedido.getNomeCliente()%></td>
				<td><%=pedido.getEnderecoEntrega()%></td>
				<td><%=pedido.getValor()%></td>
				<td><%=pedido.getDescricao()%></td>
				<td><a href="logged.do?action=pageUpdate&idPedido=<%=pedido.getId()%>">Editar pedido</a></td>
				<td><a href="logged.do?action=delete&id=<%=pedido.getId()%>">Deletar pedido</a></td>
			</tr>
			
			<%i++;
			} %>
		</tbody>
	</table>
	
	<br><br>
	<hr>
	<br><br>
	<p><a href="logged.do?action=pageHome">Voltar</a></p>
	
</body>
</html>