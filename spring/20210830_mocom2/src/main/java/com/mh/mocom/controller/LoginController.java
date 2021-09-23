package com.mh.mocom.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mh.mocom.dao.MemberDao;
import com.mh.mocom.dto.MemberDto;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	/*
	 * 불필요한 import 나 변수 선언을 없애는 단축키도 있다.
	 * 
	 * 바로 ctrl + shift + O ! 한반에 다 없애준다.
	 */

	@Autowired
	MemberDao dao;

	@RequestMapping(value = "/loginchk", method = RequestMethod.POST)
	public String loginchk(MemberDto dto,HttpSession session) {
		/*
		 * login check mybatis sqllog
		 */

		dto = dao.chklogin(dto);

		if (dto != null) {
			//session에다가 저장해야 되고
			session.setAttribute("dto", dto);
			return "chart";
		} 
		
		else {
			//로그인에 실패 하였습니다. 아이디랑 비밀번호를 확인하세요.
			return "redirect:/?text=loginfail";
		}
	}

}
