package com.rickyOl.rhusuario.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "tb_papel")
public class Papel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomePapel;

	public Papel(Long id, String nomePapel) {
		super();
		this.id = id;
		this.nomePapel = nomePapel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomePapel() {
		return nomePapel;
	}

	public void setNomePapel(String nomePapel) {
		this.nomePapel = nomePapel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomePapel == null) ? 0 : nomePapel.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Papel other = (Papel) obj;
		if (nomePapel == null) {
			if (other.nomePapel != null)
				return false;
		} else if (!nomePapel.equals(other.nomePapel))
			return false;
		return true;
	}

}
