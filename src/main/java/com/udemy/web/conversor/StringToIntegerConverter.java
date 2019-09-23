package com.udemy.web.conversor;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToIntegerConverter implements Converter<String, Integer>{

	@Override
	public Integer convert(String text) {
		text = text.trim();
		//Se tiver string concatenado com integer, fazer isso.
		if(text.matches("[0-9]+")) {
			return Integer.valueOf(text);
		}
		
		return null;
	}

	
}
