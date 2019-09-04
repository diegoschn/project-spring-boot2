package com.udemy.service;

import java.util.List;

import com.udemy.domain.Cargo;

public interface CargoService {

	void salvar(Cargo cargo);
	void editar(Cargo cargo);
	void excluir(Integer id);
	Cargo buscarPorId(Integer id);
	List<Cargo> listarTodos();
}
