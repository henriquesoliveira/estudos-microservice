package com.rickyOl.rhoauth.services;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rickyOl.rhoauth.entidades.Usuario;
import com.rickyOl.rhoauth.feignclients.UsuarioFeignClient;

@Service
public class UsuarioService {

	private static Logger logger = LoggerFactory.getLogger(UsuarioService.class);
	
	@Autowired
	private UsuarioFeignClient usuarioFeignClient;

	public Usuario findByEmail(String email) {
		Usuario user = usuarioFeignClient.buscarPorEmail(email).getBody();

		if (Objects.isNull(user)) {
			logger.error("Email não encontrado:" + email);
			throw new IllegalArgumentException("Email não encontrado");
		}
		logger.info("Email encontrado:" + email);
		return user;
	}
}
