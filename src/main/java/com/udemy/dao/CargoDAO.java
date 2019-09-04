package com.udemy.dao;

import java.util.List;

import com.udemy.domain.Cargo;

public interface CargoDAO {

	void save(Cargo cargo);
	void update(Cargo cargo);
	void delete(Integer id);
	Cargo findById(Integer id);
	List<Cargo> findAll();
}
