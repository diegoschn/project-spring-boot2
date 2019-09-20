package com.udemy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.udemy.dao.CargoDAO;
import com.udemy.domain.Cargo;
import com.udemy.service.CargoService;

@Transactional
@Service
public class CargoServiceImpl implements CargoService{

	@Autowired
	private CargoDAO cargoDAO;
	
	@Override
	public void salvar(Cargo cargo) {
		this.cargoDAO.save(cargo);
	}

	@Override
	public void editar(Cargo cargo) {
		this.cargoDAO.update(cargo);
	}

	@Override
	public void excluir(Integer id) {
		this.cargoDAO.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Cargo buscarPorId(Integer id) {
		return this.cargoDAO.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cargo> listarTodos() {
		return this.cargoDAO.findAll();
	}

	@Override
	public boolean cargoTemFuncionarios(Integer id) {
		if(buscarPorId(id).getFuncionarios().isEmpty()) {
			return false;
		}
		return true;
	}

}
