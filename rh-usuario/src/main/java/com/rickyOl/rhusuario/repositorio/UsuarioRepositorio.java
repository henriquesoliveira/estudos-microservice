package com.rickyOl.rhusuario.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rickyOl.rhusuario.entidades.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{

	Usuario findByEmail(String email);
}
