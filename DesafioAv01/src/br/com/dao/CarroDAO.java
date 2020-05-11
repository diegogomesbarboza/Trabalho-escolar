package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bean.CarroBean;

public class CarroDAO {
	
	public CarroBean getCarroPorId(int idCarro) throws SQLException {

		CarroBean carro = new CarroBean();

		Connection connection = new ConnectionFactory().getConection();
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM Carro WHERE id_carro=?");
		ps.setInt(1, idCarro);

		ResultSet rs = ps.executeQuery();

		if (rs.first()) {
			carro.setIdCarro(rs.getInt("id_carro"));
			carro.setFabricante(rs.getString("fabricante"));
			carro.setModelo(rs.getString("modelo"));
			carro.setPrecoAluguel(rs.getDouble("preco_aluguel"));
			carro.setAlugado(rs.getBoolean("alugado"));
		}

		return carro;

	}

	public List<CarroBean> getListaCarros() throws SQLException {

		List<CarroBean> lista = new ArrayList<CarroBean>();

		Connection connection = new ConnectionFactory().getConection();
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM Carro");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			CarroBean carro = new CarroBean();
			carro.setIdCarro(rs.getInt("id_carro"));
			carro.setFabricante(rs.getString("fabricante"));
			carro.setModelo(rs.getString("modelo"));
			carro.setPrecoAluguel(rs.getDouble("preco_aluguel"));
			carro.setAlugado(rs.getBoolean("alugado"));
			lista.add(carro);
			
			System.out.println(carro);
			
		}
		return lista;
	}

	public List<CarroBean> listarDisponibilidade(boolean alugado) throws SQLException {

		List<CarroBean> lista = new ArrayList<CarroBean>();

		Connection connection = new ConnectionFactory().getConection();
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM Carro WHERE alugado=?");
		ps.setBoolean(1, alugado);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			CarroBean c = new CarroBean();
			c.setIdCarro(rs.getInt("id_carro"));
			c.setFabricante(rs.getString("fabricante"));
			c.setModelo(rs.getString("modelo"));
			c.setPrecoAluguel(rs.getDouble("preco_aluguel"));
			c.setAlugado(rs.getBoolean("alugado"));
			lista.add(c);
		}

		return lista;

	}

	public void insert(CarroBean carro) throws SQLException {

		Connection connection = new ConnectionFactory().getConection();
		PreparedStatement ps = connection
				.prepareStatement("INSERT INTO Carro SET fabricante=?, modelo=?, preco_aluguel=?;");
		ps.setString(1, carro.getFabricante());
		ps.setString(2, carro.getModelo());
		ps.setDouble(3, carro.getPrecoAluguel());

		ps.execute();
	}

	public void update(CarroBean carro) throws SQLException {

		Connection connection = new ConnectionFactory().getConection();
		PreparedStatement ps = connection.prepareStatement(
				"UPDATE Carro SET id_carro=?, fabricante=?, modelo=?, preco_aluguel=?, alugado=? WHERE id_carro=?;");
		ps.setInt(1, carro.getIdCarro());
		ps.setString(2, carro.getFabricante());
		ps.setString(3, carro.getModelo());
		ps.setDouble(4, carro.getPrecoAluguel());
		ps.setBoolean(5, carro.isAlugado());
		ps.setInt(6, carro.getIdCarro());

		ps.executeUpdate();
	}

	public void delete(int id) throws SQLException {
		Connection connection = new ConnectionFactory().getConection();
		PreparedStatement ps = connection.prepareStatement("DELETE FROM Carro WHERE id_carro=?;");
		ps.setInt(1, id);

		ps.execute();

	}
}
