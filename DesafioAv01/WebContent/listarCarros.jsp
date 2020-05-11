<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Locadora de Veículos</title>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description"
	content="Source code generated using layoutit.com">
<meta name="author" content="LayoutIt!">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>
<body>
	<div class="container-fluid" style="color: white;">
		<%@ include file="menu.jsp"%>

		<h3>Listagem Geral</h3>

		<div class="row">
			<div class="col-md-12">
				<table class="table">
					<thead>
						<tr>
							<th>Id</th>
							<th>Fabricante</th>
							<th>Modelo</th>
							<th>Preço Aluguel</th>
							<th>Disponibilidade</th>
							<th colspan="2">&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${lista}" var="carro">
							<tr>
								<td>${carro.idCarro}</td>
								<td>${carro.fabricante}</td>
								<td>${carro.modelo}</td>
								<td>${carro.precoAluguel}</td>
								<td>${carro.isDisponivel()}</td>
								<td><a
									href="/DesafioAv01/CarroServlet?acao=editar&id_carro=${carro.idCarro}">EDITAR</a></td>
								<td><a
									href="/DesafioAv01/CarroServlet?acao=excluir&id_carro=${carro.idCarro}">EXCLUIR</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

	<div class="col-md-12" style="height: 10rem;"></div>
		<%@ include file="rodape.jsp"%>
		<div class="col-md-12" style="height: 50rem;"></div>
	</div>

	<!--  rodapé do body -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/scripts.js"></script>
</body>
</html>