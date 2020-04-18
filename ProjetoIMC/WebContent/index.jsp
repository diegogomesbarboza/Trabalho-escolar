<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Calcular IMC</title>
		<link rel="stylesheet" href="estilos.css" >
	</head>
	<body>
		<div class="corpo">
			<h1 class="titulo">Cálculo IMC</h1>
			<form action="calculo" method="get">
				<div class="imc"><label for="altura">Altura</label></div>
				<input type= "number" step="0.01" id="altura" name= "altura"><br><br>
				<div class="imc"><label for="peso">Peso</label></div>
				<input type="number" step="0.01" id="peso" name="peso"><br><br>
			
			 	<input type="submit" class="submit" value="Enviar dados">
			 </form>	
			 <p class="resultado">IMC: ${imc}</p>
			 <p class="resultado">Avaliação: ${resultado}</p>
	 	</div>
	</body>
</html>