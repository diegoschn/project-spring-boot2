package com.udemy.dao;

import java.time.LocalDate;
import java.util.List;

import com.udemy.domain.Funcionario;

public interface FuncionarioDAO {

	void save(Funcionario funcionario);
	void update(Funcionario funcionario);
	void delete(Integer id);
	Funcionario findById(Integer id);
	List<Funcionario> findAll();
	List<Funcionario> findByNome(String nome);
	List<Funcionario> findByCargo(Integer id);
	List<Funcionario> findByEntradaDataSaida(LocalDate entrada, LocalDate saida);
	List<Funcionario> findByDataEntrada(LocalDate entrada);
	List<Funcionario> findByDataSaida(LocalDate saida);
}
