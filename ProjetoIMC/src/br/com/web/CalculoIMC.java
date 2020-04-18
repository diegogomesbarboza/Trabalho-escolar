package br.com.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculoIMC
 */
@WebServlet("/calculo")
public class CalculoIMC extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		double altura = Double.parseDouble(request.getParameter("altura"));
		double peso = Double.parseDouble(request.getParameter("peso"));

		double imc = peso / (altura * altura);

		String resultado = "";

		if (imc < 18.5) {
			resultado = "Abaixo do peso";
		} else if (imc >= 18.5 && imc < 25) {
			resultado = "Peso normal";
		} else if (imc >= 25 && imc < 30) {
			resultado = "Sobrepeso";
		} else {
			resultado = "Obesidade";
		}
		
		request.setAttribute("resultado", resultado);
		request.setAttribute("imc", imc);

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
