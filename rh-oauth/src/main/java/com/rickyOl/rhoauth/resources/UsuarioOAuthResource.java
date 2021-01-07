package com.rickyOl.rhoauth.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rickyOl.rhoauth.entidades.Usuario;
import com.rickyOl.rhoauth.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioOAuthResource {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping(value = "/search")
	public ResponseEntity<Usuario> buscarPorEmail(@RequestParam String email) {

		try {
			Usuario user = usuarioService.findByEmail(email);
			return ResponseEntity.ok(user);

		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
