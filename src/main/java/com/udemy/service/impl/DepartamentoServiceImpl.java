package com.udemy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.udemy.dao.DepartamentoDAO;
import com.udemy.domain.Departamento;
import com.udemy.service.DepartamentoService;

@Service
@Transactional(readOnly = false)
public class DepartamentoServiceImpl implements DepartamentoService{

	@Autowired
	private DepartamentoDAO departamentoDAO;
	
	@Override
	public void salvar(Departamento departamento) {
		this.departamentoDAO.save(departamento);
	}

	@Override
	public void editar(Departamento departamento) {
		this.departamentoDAO.update(departamento);
	}

	@Override
	public void excluir(Integer id) {
		this.departamentoDAO.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Departamento buscarPorId(Integer id) {
		return this.departamentoDAO.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Departamento> listarTodos() {
		return this.departamentoDAO.findAll();
	}

}
