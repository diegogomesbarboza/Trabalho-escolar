package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.bean.PessoaBean;

public class PessoaDAO {
	
	public PessoaBean getPessoa(String login) throws SQLException {
		
		PessoaBean pessoa = new PessoaBean();
		
		Connection connection = new ConnectionFactory().getConection();
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM Pessoa WHERE login=?");
		ps.setString(1, login);

		ResultSet rs = ps.executeQuery();

		if (rs.first()) {
			pessoa.setLogin(rs.getString("login"));
			pessoa.setPassword(rs.getString("password"));
		}

		return pessoa;

	}
}
