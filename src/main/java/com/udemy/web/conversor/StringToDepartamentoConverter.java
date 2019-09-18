package com.udemy.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.udemy.domain.Departamento;
import com.udemy.service.DepartamentoService;

@Component
public class StringToDepartamentoConverter implements Converter<String, Departamento>{

	@Autowired
	private DepartamentoService departamentoService;
	
	@Override
	public Departamento convert(String text) {
		if(text.isEmpty()) {
			return null;
		}
		Integer id = Integer.valueOf(text);
		return departamentoService.buscarPorId(id);
	}

}
