package com.udemy.service;

import java.util.List;

import com.udemy.domain.Funcionario;

public interface FuncionarioService {

	void salvar(Funcionario funcionario);
	void editar(Funcionario funcionario);
	void excluir(Integer id);
	Funcionario buscarPorId(Integer id);
	List<Funcionario> listarTodos();
}
