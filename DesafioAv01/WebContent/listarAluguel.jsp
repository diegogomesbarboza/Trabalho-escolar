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

		<div class="row d-flex justify-content-center">
			<div class="col-md-8">
				<h3>Carros Disponíveis</h3>
				<div class="col-md-12">
					<table class="table">
						<thead>
							<tr>
								<th>Id</th>
								<th>Fabricante</th>
								<th>Modelo</th>
								<th>Preço Aluguel (R$)</th>
								<th>&nbsp;</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${lista}" var="carro">
								<tr>
									<td>${carro.idCarro}</td>
									<td>${carro.fabricante}</td>
									<td>${carro.modelo}</td>
									<td>${carro.precoAluguel}</td>
									<td><a
										href="/DesafioAv01/CarroServlet?acao=alugar&id_carro=${carro.idCarro}">ALUGAR</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
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