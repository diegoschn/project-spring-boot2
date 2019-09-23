package com.udemy.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.udemy.dao.FuncionarioDAO;
import com.udemy.domain.Funcionario;
import com.udemy.service.FuncionarioService;

@Service
@Transactional(readOnly = false)
public class FuncionarioServiceImpl implements FuncionarioService{

	@Autowired
	private FuncionarioDAO funcionarioDAO;
	
	@Override
	public void salvar(Funcionario funcionario) {
		this.funcionarioDAO.save(funcionario);
	}

	@Override
	public void editar(Funcionario funcionario) {
		this.funcionarioDAO.update(funcionario);
	}

	@Override
	public void excluir(Integer id) {
		this.funcionarioDAO.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Funcionario buscarPorId(Integer id) {
		return this.funcionarioDAO.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Funcionario> listarTodos() {
		return this.funcionarioDAO.findAll();
	}

	@Override
	public List<Funcionario> buscarPorNome(String nome) {
		return funcionarioDAO.findByNome(nome);
	}
	
	@Transactional(readOnly = true)
	public List<Funcionario> buscarPorCargo(Integer id){
		return funcionarioDAO.findByCargo(id);
	}

	@Override
	public List<Funcionario> buscarPorDatas(LocalDate entrada, LocalDate saida) {
		if(entrada!=null && saida!=null) {
			return funcionarioDAO.findByEntradaDataSaida(entrada, saida);
		}else if(entrada!=null) {
			return funcionarioDAO.findByDataEntrada(entrada);
		}else if(saida!=null) {
			return funcionarioDAO.findByDataSaida(saida);
		}else {
			return new ArrayList<>();
		}
	}

	
}
