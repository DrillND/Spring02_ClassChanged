package com.mh.org4;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/*
 * spring 객체 생성
 * 
 * spring IOC 복습
 * Commponent scan
 * 
 * mybatis 연결
 * spring 객체설정
 */


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private DBM dbm;
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		dbm.doA();
		return "home";
	}
	/*
	 * requestMapping 으로 등록된 주소로만
	 * 브라우저 요청이 가능하다
	 * 등록된 메서드 안에서 작업을 수행한다.
	 * home.jsp a.jsp b.jsp
	 * 
	 */
}
