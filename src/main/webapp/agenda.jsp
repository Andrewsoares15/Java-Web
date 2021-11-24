<%@page import="br.com.model.JavaBeans"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Agenda de contatos</title>
<link rel="icon" href="imagens/tel1.png">
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="novo.css">
</head>
<body>
	<h1>Agenda de contatos</h1>
	<a href="novo.html" class="botao1">Novo contato</a>
	<table class="tabelinha">
		<thead >
			<th>ID </th>
			<th>Nome </th>
			<th>Fone </th>
			<th>Email </th>
			<th>Editar </th>
			<th>Excluir </th>
		</thead>
		<tbody>
			<c:forEach items="${contatos}" var="itens">
			<tr>
				<td>${itens.idcon}</td>
				<td>${itens.nome}</td>
				<td>${itens.fone}</td>
				<td>${itens.email}</td>
				<td><a href="select?idcon=${itens.idcon}" class="editar">Editar</a></td>
				<td><a href="javascript: confirmar(${itens.idcon}) ">Excluir</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<script src="scripts/confirmador.js"></script>
</body>
</html>