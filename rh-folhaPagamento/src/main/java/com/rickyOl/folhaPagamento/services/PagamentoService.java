package com.rickyOl.folhaPagamento.services;

import org.springframework.stereotype.Service;

import com.rickyOl.folhaPagamento.entidades.Pagamento;

@Service
public class PagamentoService {

	public Pagamento getPagamento(long trabalhadorId, int dias) {
	
		return new Pagamento("Teste",200.00	, dias);
	}
}
