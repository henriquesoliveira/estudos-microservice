package com.rickyOl.folhaPagamento.entidades;

import java.io.Serializable;

public class Pagamento implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private Double valorDiaria;
	private Integer dias;

	public Pagamento() {

	}

	public Pagamento(String nome, Double valorDiaria, Integer dias) {
		super();
		this.nome = nome;
		this.valorDiaria = valorDiaria;
		this.dias = dias;
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

	public Integer getDias() {
		return dias;
	}

	public void setDias(Integer dias) {
		this.dias = dias;
	}

	public Double getTotal() {
		return dias * valorDiaria;
	}
}
