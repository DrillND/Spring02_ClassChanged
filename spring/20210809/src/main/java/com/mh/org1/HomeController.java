package com.mh.org1;

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

import com.mh.org1.cls.AA;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	/*
	 * web.xml내용에
	 * servlet-context.xml 내용을 읽는게 연결되어져있고
	 * 
	 * InternalResourceViewResolver
	 * Web-INF/views/
	 * 
	 * jsp로 연결되어져있어서..
	 * 
	 * HomeController에서 requestMapping 설정하고
	 * jsp 파일생성
	 */
	
	@Autowired
	AA aa;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(Locale locale, Model model) {
		
		//Connection conn가능
		
		model.addAttribute("index1", "aaa" );
		model.addAttribute("index2", "bbb" );
		System.out.println(aa.getAaa());
		
		return "index";
	}
}
