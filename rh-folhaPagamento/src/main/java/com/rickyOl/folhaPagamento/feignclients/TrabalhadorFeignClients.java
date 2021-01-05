package com.rickyOl.folhaPagamento.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rickyOl.folhaPagamento.entidades.Trabalhador;

@Component
@FeignClient(name="rh-trabalhador" , url = "localhost:8001", path = "/trabalhador")
public interface TrabalhadorFeignClients {

	@GetMapping(value="/{id}")
	ResponseEntity<Trabalhador> buscarPorId(@PathVariable Long id);
}
