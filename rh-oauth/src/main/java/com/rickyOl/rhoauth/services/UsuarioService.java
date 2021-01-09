package com.rickyOl.rhoauth.services;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rickyOl.rhoauth.entidades.Usuario;
import com.rickyOl.rhoauth.feignclients.UsuarioFeignClient;

@Service
public class UsuarioService implements UserDetailsService{

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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = usuarioFeignClient.buscarPorEmail(username).getBody();

		if (Objects.isNull(user)) {
			logger.error("Email não encontrado:" + username);
			throw new UsernameNotFoundException("Email não encontrado");
		}
		logger.info("Email encontrado:" + username);
		return user;
	}
}
