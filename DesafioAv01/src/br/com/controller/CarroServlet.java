package br.com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bean.CarroBean;
import br.com.bo.CarroBO;
import br.com.bo.PessoaBo;
import br.com.bo.exception.BusinessException;
import br.com.bo.utils.TextUtils;

@WebServlet("/CarroServlet")
public class CarroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CarroBO bo = new CarroBO();
	
	public CarroServlet() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		String acao = (String) req.getParameter("acao");

		if (acao == null) {
			req.getRequestDispatcher("index.jsp").forward(req, resp);

		} else if (acao.equalsIgnoreCase("logar")) {
			logar(req, resp);

		}else if (acao.equalsIgnoreCase("listar")) {
			listarCarros(req, resp);

		} else if (acao.equalsIgnoreCase("listarAlugar")) {
			listarAlugarCarros(req, resp);

		} else if (acao.equalsIgnoreCase("listarDevolver")) {
			listarDevolver(req, resp);

		} else if (acao.equalsIgnoreCase("cadastrar")) {
			editarCarro(req, resp, null);

		} else if (acao.equalsIgnoreCase("editar")) {
			String idCarro = (String) req.getParameter("id_carro");
			editarCarro(req, resp, idCarro);

		} else if (acao.equalsIgnoreCase("devolver")) {
			String idCarro = (String) req.getParameter("id_carro");
			devolverCarro(req, resp, idCarro);

		} else if (acao.equalsIgnoreCase("excluir")) {
			String idCarro = (String) req.getParameter("id_carro");
			excluirCarro(req, resp, idCarro);

		} else if (acao.equalsIgnoreCase("confirmarAluguel")) {
			confirmarAluguel(req, resp);

		} else if (acao.equalsIgnoreCase("alugar")) {
			String idCarro = (String) req.getParameter("id_carro");
			alugarCarro(req, resp, idCarro);

		} else if (acao.equalsIgnoreCase("salvar")) {
			salvarCarro(req, resp);

		} else if (acao.equalsIgnoreCase("cancelar")) {
			listarCarros(req, resp);

		} else {
			System.out.println("chegou");
			req.getRequestDispatcher("erro404.html").forward(req, resp);
		}

	}
	
	private void logar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String login = (String) req.getParameter("login");
		String password = (String) req.getParameter("password");
		
		PessoaBo bo = new PessoaBo();
		
		try {
			if(bo.isLogado(login, password)) {
				req.getRequestDispatcher("home.jsp").forward(req, resp);
			}else {
				req.setAttribute("mensagem", "Usuário ou senha incorreta.");
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}
		
	private void salvarCarro(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String idCarro = (String) req.getParameter("id_carro");
		String fabricante = (String) req.getParameter("fabricante");
		String modelo = (String) req.getParameter("modelo");
		String preco = (String) req.getParameter("preco");

		CarroBean carro = new CarroBean();

		if (!TextUtils.isBlank(idCarro)) {
			carro.setIdCarro(Integer.parseInt(idCarro));
		}

		carro.setFabricante(fabricante);
		carro.setModelo(modelo);
		try {
			if (TextUtils.isBlank(fabricante) || TextUtils.isBlank(modelo)) {
				throw new BusinessException("Os dados não podem está vazios.");
			}

			carro.setPrecoAluguel(Double.parseDouble(preco));
			bo.salvarCarro(carro);

		} catch (BusinessException e) {
			req.setAttribute("mensagem", e.getMessage());
			req.setAttribute("carro", carro);
			req.getRequestDispatcher("editarCarro.jsp").forward(req, resp);

		} catch (Exception e) {
			req.setAttribute("mensagem", "Valor incorreto!");
			req.setAttribute("carro", carro);
			req.getRequestDispatcher("editarCarro.jsp").forward(req, resp);
		}

		listarCarros(req, resp);
	}

	private void listarCarros(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<CarroBean> lista;

		try {
			lista = bo.getListaCarros();

		} catch (Exception e) {
			throw new ServletException(e);
		}

		req.setAttribute("lista", lista);
		req.getRequestDispatcher("listarCarros.jsp").forward(req, resp);
	}

	private void listarAlugarCarros(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<CarroBean> lista;

		try {
			lista = bo.getListaCarrosDisponiveis(false);

		} catch (Exception e) {
			throw new ServletException(e);
		}

		req.setAttribute("lista", lista);
		req.getRequestDispatcher("listarAluguel.jsp").forward(req, resp);
	}

	private void listarDevolver(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<CarroBean> lista;

		try {
			lista = bo.getListaCarrosDisponiveis(true);

		} catch (Exception e) {
			throw new ServletException(e);
		}

		req.setAttribute("lista", lista);
		req.getRequestDispatcher("listarDevolver.jsp").forward(req, resp);
	}

	private void editarCarro(HttpServletRequest req, HttpServletResponse resp, String idCarro)
			throws ServletException, IOException {
		CarroBean carro = new CarroBean();

		try {
			if (idCarro != null) {
				carro = bo.getCarroPorId(idCarro);
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}

		req.setAttribute("carro", carro);
		req.getRequestDispatcher("editarCarro.jsp").forward(req, resp);
	}

	private void alugarCarro(HttpServletRequest req, HttpServletResponse resp, String idCarro)
			throws ServletException, IOException {
		CarroBean carro = new CarroBean();

		try {
			if (idCarro != null) {
				carro = bo.getCarroPorId(idCarro);
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}

		req.setAttribute("carro", carro);
		req.getRequestDispatcher("confirmarAluguel.jsp").forward(req, resp);
	}

	private void excluirCarro(HttpServletRequest req, HttpServletResponse resp, String idCarro)
			throws ServletException, IOException {
		try {
			if (idCarro != null) {
				bo.excluirCarroPorId(idCarro);
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}

		listarCarros(req, resp);
	}

	private void confirmarAluguel(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String idCarro = (String) req.getParameter("id_carro");

		try {
			bo.registrarAluguel(idCarro, true);
		} catch (SQLException e) {
			throw new ServletException(e);
		}
		listarAlugarCarros(req, resp);
	}

	private void devolverCarro(HttpServletRequest req, HttpServletResponse resp, String idCarro)
			throws ServletException, IOException {
		try {
			if (idCarro != null) {
				bo.registrarAluguel(idCarro, false);
			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}
		listarDevolver(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
