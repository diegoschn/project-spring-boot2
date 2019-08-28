package com.udemy.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "departamentos")
public class Departamento extends AbstractEntity<Integer>{

	private String nome;
	private List<Cargo> cargos;
	
	@Column(name = "nome", nullable = false, unique = true, length = 60)
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@OneToMany(mappedBy = "departamento")
	public List<Cargo> getCargos() {
		return cargos;
	}
	
	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}
}
