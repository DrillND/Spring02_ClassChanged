package com.mh.org3;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * 1. 자바 버전 맞추기
 * 	build path
 * 	project facets
 * 2. web.xml j소문자를 J대문자로...
 * 3. Pojo방식을 사용하기 위한
 * 	cglib.jar 파일 maven으로부터 가져오기
 * 	context:annotationconfig 태그 설정
 */
/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		// logger.info("Welcome home! The client locale is {}.", locale);
		return "home";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(Model model) {
		return "insert";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(Model model) {
		return "delete";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(Model model) {
		return "update";
	}
	
	@RequestMapping(value = "/cc", method = RequestMethod.GET)
	@ResponseBody //cc를 요청하면 리턴하는 문자가 날아간다. 
	public String cc(Model model) {
		return "{ a:'aa', b:'bb'}";
	}

}
