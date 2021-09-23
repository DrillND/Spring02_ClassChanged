package com.mh.org2;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mh.org2.cls.AA;
import com.mh.org2.cls.BB;
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

/**
 * Handles requests for the application home page.
 */
@Controller
//@Component 위랑 같은 역할
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	// import 자동완성 ctrl shift o
	@Autowired
	AA aa;

	@Autowired
	BB bb;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		System.out.println("aa.getAa() = " + aa.getAa());

		return "home";
	}

	@RequestMapping(value = "/bb", method = RequestMethod.GET)
	public String bb(Model model, HttpServletRequest req) {
		if( req.getParameter("bb") == null) {
			model.addAttribute("bb", bb);
			return "bb";
		}
		String number = (String) req.getParameter("bb");
		bb.setAa(Integer.parseInt(number));

		System.out.println("bb.getAa() = " + bb.getAa());
		
		return "bb";
	}

	/*
	 * null은 숫자형으로 변경시 Exception 발생
	 * Numberformatexception...
	 */
	
//	@RequestMapping(value = "/bb", method = RequestMethod.GET)
//	public String bb(Model model, int cc) {
//		System.out.println("cc = "+cc);
//		System.out.println("bb.getAa() = "+bb.getAa());
//		model.addAttribute("aoao", bb);
//		return "bb";
//	}
}
