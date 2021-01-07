package com.rickyOl.rhusuario.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rickyOl.rhusuario.entidades.Usuario;
import com.rickyOl.rhusuario.repositorio.UsuarioRepositorio;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioRepositorio repositorio;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {

		Usuario user = repositorio.findById(id).get();
		return ResponseEntity.ok(user);
	}

	@GetMapping(value = "/search")
	public ResponseEntity<Usuario> buscarPorEmail(@RequestParam String email) {

		Usuario user = repositorio.findByEmail(email);
		return ResponseEntity.ok(user);
	}
}