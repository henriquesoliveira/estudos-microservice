package com.rickyOl.folhaPagamento.entidades;

import java.io.Serializable;


public class Trabalhador implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long id;
	
	private String nome;
	
	private Double valorDiaria;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(Double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

}
