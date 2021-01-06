package com.rickyOl.rhtrabalhador.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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
	
	private static Logger logger = LoggerFactory.getLogger(TrabalhadorResource.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	private TrabalhadorRepositorio repositorio;
	
	@GetMapping
	public ResponseEntity<List<Trabalhador>> buscarTodos(){
	
		List<Trabalhador> lista =  repositorio.findAll();
		return ResponseEntity.ok(lista);
	} 
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Trabalhador> buscarPorId(@PathVariable Long id){
	
		/*
		 * Teste para Hystrix
		 * try { Thread.sleep(3000L); } catch (Exception e) { // TODO: handle exception
		 * }
		 */
		
		logger.info("port="+env.getProperty("local.server.port"));
		
		Trabalhador trab =  repositorio.findById(id).get();
		return ResponseEntity.ok(trab);
	} 

}
