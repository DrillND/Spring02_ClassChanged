package com.mh.org4.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mh.org4.dao.TestDao;
import com.mh.org4.dto.TestDto;

@Controller
public class TestController {
	
	@Autowired
	TestDao dao;
	/*
	 *  controller(requestMapping -> TestDao -> TestDto -> b.xml (개발패턴) 
	 * 
	 */
//	@Autowired
//	DriverManagerDataSource dataSource;
	
	@RequestMapping(value = "list")
	public String list(Model model) {
		
		//List<String> rvalue = dao.doList();
		List<TestDto> rvalue = dao.doList();
		model.addAttribute("a",rvalue);
		
		
		return "list";
	}
	/*
	 *  model 사용방법
	 *  값을 가지고 jsp로 이동하기 위한 것
	 *  
	 *  <---------------------->
	 *  spring에서 해보기 (백앤드 개발자)
	 *  mybatis 설정
	 *  게시판 만들기 
	 *  회원가입
	 *  
	 *  view (프론트 개발자) 
	 *  html,css,javasiprt,jqery,d3js(데이터 시각화)
	 */
	@RequestMapping(value = "insert")
	public String insert(Model model, HttpServletRequest request, @RequestParam String para1, String para2) {
		String va1 = request.getParameter("para1");
		System.out.println(va1);
		System.out.println("para1 = "+ para1);
		System.out.println("para2 = "+ para2);
		dao.doInsert(para1,para2);
		return "insert";
	}
	
	@RequestMapping(value="insertform")
	public String insertform() {
		return "insertform";
	}
}
