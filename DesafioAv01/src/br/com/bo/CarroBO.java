package br.com.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.bean.CarroBean;
import br.com.dao.CarroDAO;

public class CarroBO {
	
	CarroDAO dao = new CarroDAO();
	
	public List<CarroBean> getListaCarros() throws SQLException{
		return dao.getListaCarros();
	}
	
	public List<CarroBean> getListaCarrosDisponiveis(boolean alugado) throws SQLException{
		return dao.listarDisponibilidade(alugado);
	}
	
	public CarroBean getCarroPorId(String id) throws SQLException {
		int idCarro = Integer.parseInt(id);
		
		return dao.getCarroPorId(idCarro);
	}

	public void salvarCarro(CarroBean carro) throws SQLException {
		if(carro.getIdCarro()!= null) {
			dao.update(carro);
		}else {
			dao.insert(carro);
		}
	}

	public void excluirCarroPorId(String idCarro) throws SQLException {
		dao.delete(Integer.parseInt(idCarro));
	}

	public void registrarAluguel(String id, boolean alugado) throws SQLException {
		CarroBean carro = dao.getCarroPorId(Integer.parseInt(id));
		carro.setAlugado(alugado);
		this.salvarCarro(carro);
	}	
}
