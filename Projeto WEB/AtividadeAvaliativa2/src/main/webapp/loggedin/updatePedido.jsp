<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar pedido</title>
</head>
<body>
	<h1>Editar pedido</h1>
	<br><br>
	<hr>
	<br><br>
	
	<%
		String message = (String) request.getAttribute("message");
		if(message != null){
			%> <h3><%=message%></h3>
			<%
		}
	%>
	
	<%
		int idPedido = (Integer) request.getAttribute("idPedido");
	%>
	
	<br><br>
	
	<form action="logged.do?action=updatePedido&idPedido=<%=idPedido%>" method="post">	
		<label for="nomeCliente">Nome do cliente</label>
		<input type="text" id="nomeCliente" name="nomeCliente" required="required" placeholder="Digite o nome do cliente"><br><br>
		
		<label for="endereco">Endereço</label>
		<input type="text" id="endereco" name="endereco" required="required" placeholder="Digite o endereço do pedido"><br><br>
		
		<label for="valor">Valor</label>
		<input type="number" id="valor" name="valor" required="required" placeholder="Digite o valor do pedido"><br><br>
		
		<label for="descricao">Descrição</label>
		<input type="text" id="descricao" name="descricao" required="required" placeholder="Digite a descrição do pedido"><br><br>
		
		<button type="submit">Enviar</button>
	</form>
	
	<br><br>
	<hr>
	<br><br>
	<p><a href="logged.do?action=listarPedidos">Voltar</a></p>
</body>
</html>