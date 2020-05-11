<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Cadastro de carro</title>
<meta charset="ISO-8859-1">
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
	<div class="container-fluid">
		<%@ include file="menu.jsp"%>

		<div class="row d-flex justify-content-center">
			<div class="col-md-6">
				<h3>Incluir/Alterar Carro</h3>
				<div class="jumbotron" style="opacity: 0.7">
					<div class="col-md-12">
						<c:if test="${not empty mensagem}">
							<div class="alert alert-danger" role="alert">
								<p>${mensagem}</p>
							</div>
						</c:if>
						<form role="form" action="CarroServlet">
							<input name="acao" type="hidden" value="Salvar">
							<div class="form-group col-md-6">
								<label for="id_carro"> Id Carro </label> <input id="id_carro"
									name="id_carro" class="form-control" readonly="readonly"
									value="${carro.idCarro}">
							</div>
							<div class="form-group col-md-12">
								<label for="fabricante">Fabricante</label> <input
									id="fabricante" name="fabricante" class="form-control"
									type="text" value="${carro.fabricante}">
							</div>
							<div class="form-group col-md-12">
								<label for="modelo">Modelo</label> <input id="modelo"
									name="modelo" class="form-control" value="${carro.modelo}">
							</div>
							<div class="form-group col-md-6">
								<label for="preco">Preço aluguel</label> <input id="preco"
									name="preco" type="number" step="0.01" class="form-control"
									value="${carro.precoAluguel}" pattern="(d{3})([,])(d{2})">
							</div>

							<div class="form-group col-md-6">
								<button type="button" class="btn btn-default"
									onclick="window.location.href='/DesafioAv01/CarroServlet?acao=listar'">
									Cancelar</button>
								<button type="submit" class="btn btn-primary">Salvar</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>

		<div class="col-md-12" style="height: 5rem;"></div>
		<%@ include file="rodape.jsp"%>

	</div>

	<!--  rodapé do body -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/scripts.js"></script>
</body>
</html>