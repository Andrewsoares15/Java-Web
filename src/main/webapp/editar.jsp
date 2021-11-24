<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Agenda de contatos</title>
<link rel="icon" href="imagens/tel1.png">
<link rel="stylesheet" href="style.css">
</head>
	<h1>Editar contato</h1>
	<form name="frmcontato" action="update" class="form">
		<table>
			<tr>
				<td>Idcon:<input type="text" name="idcon"  id="caixa4" readonly="readonly" value ="<% out.print(request.getAttribute("idcon")); %>">  </td>
			</tr>
			<tr>
				<td>Nome:<input type="text" name="nome"  class="caixa1" value ="<% out.print(request.getAttribute("nome")); %>"> </td>
			</tr>
			<tr>
				<td>Fone:<input  type="text" name="fone"  class="caixa2" value ="<% out.print(request.getAttribute("fone")); %>"> </td> 
			</tr>
			<tr>
				<td>Email:<input type="text" name="email"  class="caixa3" value ="<% out.print(request.getAttribute("email")); %>"> </td> 
			</tr>
		</table>
		<input type="button" value="Salvar" class="botao2" onclick="validar()">
	</form>
	<script src="scripts/validador.js"></script>
</body>
</html>