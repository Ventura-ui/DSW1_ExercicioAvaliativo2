<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro usuario</title>
</head>
<body>
	
	<h1>Cadastrar usuario</h1>
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
	
	<br><br>
	
	<form action="logged.do?action=cadastroUsuario" method="post">
		<label for="login">Login</label>
		<input type="text" id="login" name="login" required="required" placeholder="digite o seu login"><br><br>
		
		<label for="senha">Senha</label>
		<input type="password" id="senha" name="senha" required="required" placeholder="digite a sua senha"><br><br>
		
		<button type="submit">Enviar</button>
	</form>
	
	<br><br>
	<hr>
	<br><br>
	<p><a href="logged.do?action=pageHome">Voltar</a></p>
	
</body>
</html>