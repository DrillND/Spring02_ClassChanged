package com.mh.mocom.controller;

import java.util.Locale;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	

	@Autowired
	SqlSession sqlsession;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, String text) {
		sqlsession.selectOne("member.loginchk");
		System.out.println("text = " + text);
		if (text != null && text.equals("loginfail")) {
			model.addAttribute("text", text);
		}
		return "index";
	}

}
