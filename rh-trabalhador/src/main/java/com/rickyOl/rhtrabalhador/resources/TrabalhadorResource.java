package com.rickyOl.rhtrabalhador.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rickyOl.rhtrabalhador.entidade.Trabalhador;
import com.rickyOl.rhtrabalhador.repositorio.TrabalhadorRepositorio;

@RestController
@RequestMapping(value = "/trabalhador")
public class TrabalhadorResource {
	
	@Autowired
	private TrabalhadorRepositorio repositorio;
	
	@GetMapping
	public ResponseEntity<List<Trabalhador>> buscarTodos(){
	
		List<Trabalhador> lista =  repositorio.findAll();
		return ResponseEntity.ok(lista);
	} 
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Trabalhador> buscarPorId(@PathVariable Long id){
	
		Trabalhador trab =  repositorio.findById(id).get();
		return ResponseEntity.ok(trab);
	} 

}
