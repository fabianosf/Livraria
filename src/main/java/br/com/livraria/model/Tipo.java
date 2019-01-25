package br.com.livraria.model;

public enum Tipo {
	
	CELULAR("Celular"),
	COMERCIAL("Comercial"),
	CASA("Casa");
	
	private String descricao;
	
	Tipo(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

}
