package br.com.bo;

import java.sql.SQLException;

import br.com.bean.PessoaBean;
import br.com.dao.PessoaDAO;

public class PessoaBo {

	public Boolean isLogado(String login, String password) throws SQLException {
		PessoaDAO dao = new PessoaDAO();
		PessoaBean pessoa = dao.getPessoa(login);
		
		System.out.println(pessoa);
		
		if(pessoa.getLogin() == null) {
			return false;
		}
		
		return (pessoa.getPassword().equalsIgnoreCase(password));
	}
}
