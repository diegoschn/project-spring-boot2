package com.udemy.service;

import java.util.List;

import com.udemy.domain.Departamento;

public interface DepartamentoService {

	void salvar(Departamento departamento);
	void editar(Departamento departamento);
	void excluir(Integer id);
	Departamento buscarPorId(Integer id);
	List<Departamento> listarTodos();
}
