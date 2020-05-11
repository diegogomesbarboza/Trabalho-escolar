package br.com.bean;

public class CarroBean {

	private Integer idCarro;

	private String fabricante;

	private String modelo;

	private Double precoAluguel;

	private Boolean alugado;

	public CarroBean() {
	}

	public Integer getIdCarro() {
		return idCarro;
	}

	public void setIdCarro(Integer idCarro) {
		this.idCarro = idCarro;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Double getPrecoAluguel() {
		return precoAluguel;
	}

	public void setPrecoAluguel(Double precoAluguel) {
		this.precoAluguel = precoAluguel;
	}

	public Boolean isAlugado() {
		return (alugado == null) ? false : alugado;

	}

	public void setAlugado(Boolean alugado) {
		this.alugado = alugado;
	}

	public String isDisponivel() {
		return (isAlugado()) ? "Indisponivel" : "Disponivel";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCarro == null) ? 0 : idCarro.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarroBean other = (CarroBean) obj;
		if (idCarro == null) {
			if (other.idCarro != null)
				return false;
		} else if (!idCarro.equals(other.idCarro))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CarroBean [idCarro=" + idCarro + ", fabricante=" + fabricante + ", modelo=" + modelo + ", precoAluguel="
				+ precoAluguel + ", alugado=" + isDisponivel() + "]";
	}

}
