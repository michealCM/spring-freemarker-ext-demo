package com.freemarker.demo.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.spring.freemarker.ext.validation.Validator;
import org.spring.freemarker.web.response.ResponseResult;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.freemarker.demo.service.TestService;

/**
 * 
 * @author Administrator
 * @date 2018-11-28 17:03:55
 */
@Controller
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@RequestMapping("index")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("name", 400);
		return modelAndView;
	}
	
	@RequestMapping("index-1")
	public String index2(HttpServletRequest request,Map map) {
		map.put("name", 400);
		return "index";
	}
	
	@RequestMapping("index-p")
	@Validator
	public ModelAndView indSubmit(FormVo formVo,BindingResult bindingResult) {
//		this.globalSetting.getPageCache();
		if(bindingResult.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("index");
			modelAndView.addObject("name", formVo.getName());
			return modelAndView;
		}else {
			ModelAndView modelAndView = new ModelAndView("home");
			modelAndView.addObject("name", formVo.getName());
			return modelAndView;
		}
	}
	
	@RequestMapping(value="response")
    @ResponseBody
    @Validator
	public ResponseResult<String> responseTest(FormVo formVo,BindingResult bindingResult,HttpServletRequest httpServletRequest){
		
//		httpServletRequest.getServletContext().getMimeType("")
		
		ResponseResult<String> responseResult = new ResponseResult<String>(true);
		responseResult.setMessage("测试数据");
		return responseResult;
	}
	
	@RequestMapping("home")
	private ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("template","common");
		modelAndView.addObject("name", 300);
		return modelAndView;
	}

}
