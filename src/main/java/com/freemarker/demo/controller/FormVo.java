package com.freemarker.demo.controller;

import org.spring.freemarker.ext.validation.model.ValidationModel;

public class FormVo extends ValidationModel {
	
	private static final long serialVersionUID = 1L;
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
