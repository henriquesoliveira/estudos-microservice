package com.rickyOl.folhaPagamento.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rickyOl.folhaPagamento.entidades.Pagamento;
import com.rickyOl.folhaPagamento.services.PagamentoService;

@RestController
@RequestMapping(value="/pagamento")
public class PagamentoResource {

	@Autowired
	private PagamentoService service;
	
	@GetMapping(value ="/{idTrabalhador}/dias/{dias}")
	public ResponseEntity<Pagamento> buscarPagamento(@PathVariable Long idTrabalhador, @PathVariable Integer dias ){
		
		Pagamento pag = service.getPagamento(idTrabalhador, dias);
		return ResponseEntity.ok(pag);
	} 
}
