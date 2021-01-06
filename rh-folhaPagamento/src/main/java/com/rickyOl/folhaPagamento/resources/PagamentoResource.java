package com.rickyOl.folhaPagamento.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.rickyOl.folhaPagamento.entidades.Pagamento;
import com.rickyOl.folhaPagamento.services.PagamentoService;

@RestController
@RequestMapping(value="/pagamento")
public class PagamentoResource {

	@Autowired
	private PagamentoService service;
	
	@HystrixCommand(fallbackMethod = "buscarPagamentoAlternativo")	
	@GetMapping(value ="/{idTrabalhador}/dias/{dias}")
	public ResponseEntity<Pagamento> buscarPagamento(@PathVariable Long idTrabalhador, @PathVariable Integer dias ){
		
		Pagamento pag = service.getPagamento(idTrabalhador, dias);
		return ResponseEntity.ok(pag);
	} 
	/**
	 * Método alternativo caso haja falha em alguma requisiçao do MS-Trabalhador
	 * MétodoMockado
	 */
	public ResponseEntity<Pagamento> buscarPagamentoAlternativo( Long idTrabalhador,  Integer dias ){
		Pagamento pag = new Pagamento("Teste", 400.0, dias);
		return ResponseEntity.ok(pag);
	}
	
}
