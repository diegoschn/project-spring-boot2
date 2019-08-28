package com.udemy.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cargos")
public class Cargo extends AbstractEntity<Integer>{

	private String nome;
	private Departamento departamento;
	
	@Column(name = "nome", nullable = false, unique = true, length = 60)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@ManyToOne
	@JoinColumn(name = "id_departamento_fk")
	public Departamento getDepartamento() {
		return departamento;
	}
	
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	
}
