package com.freemarker.demo.service;

import org.spring.freemarker.ext.validation.Validator;
import org.springframework.stereotype.Service;

import com.freemarker.demo.controller.FormVo;

/**
 * 
 * @author Administrator
 * @date 2018-12-19 20:49:20 
 */
@Service
public class TestService {
	
	@Validator
	public FormVo getFormBVo() {
		return new FormVo();
	}

}
