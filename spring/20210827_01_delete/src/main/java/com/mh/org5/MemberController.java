package com.mh.org5;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	/*
	 * MemeberController -> MemberService -> MemberDao -> MemberDto -> member.xml
	 * 
	 * mybatis 설정
	 * pom.xml 에서 6가지 jar 가져오기
	 * maven 
	 * 1.mybatis, 2.mybatis-spring, 3.spring-jdbc, 4.dbcp, 5.mysql-conner, 6.cglib
	 * 
	 * 2.servlet-context.xml
	 * 3가지 bean 객체 설정
	 * 1.dbcp 2.sqlsessionfactory(xml파일을 읽어서 sql 설정) 3.sqlsseion(sql구문실행)
	 * 
	 * controller requestmapping
	 * memberlist -> resultType
	 * meberinsert -> parameterType 매개변수 설정하는 방식 만들어 봄 
	 * 
	 * 
	 * 20210826
	 * select
	 * insertform -> insert
	 * updateform -> update
	 * delete ->
	 * 
	 * 
	 * 프로젝트 새로 생성... 
	 * d3js..차트 그리는 것 바차트, 파이차트.
	 * 게시판 만들기 mybatis sqllog 설정 잡는 것!!
	 * 
	 * 그 후 응용!
	 * 
	 * 
	 * 
	 */
	
	@Autowired
	SqlSession sqlsession;
	//객체 생성 serlet-context안에 생성하고 selectList는 SqlSession안에 이미 생성된 객체 거기서 ("")불러옴
	
	@RequestMapping(value="memberlist")
	public String memberlist(Model model) {
		List<MemberDto> list = sqlsession.selectList("member.select");
		for(MemberDto dto : list) {
			System.out.println("dto = "+ dto.toString());
		}
		
		/*
		 *  for in in range(4):
		 *  print(i)
		 */
		model.addAttribute("aa","bb");
		model.addAttribute("alist",list);
		return "member/list";
	}
	/*
	 * request getParameter("id")
	 * String id, String pw
	 * 
	*/
//	@RequestMapping(value="memberinsert")
//	public String memberinsert(String id, String pw, String age, String gender, MemberDto dto) {
//		System.out.println("id = "+id);
//		System.out.println("pw = "+pw);
//		System.out.println("age = "+age);
//		System.out.println("gender = "+gender);
//		System.out.println("dto ="+ dto);
//		sqlsession.insert("member.insert");
//		return "member/insert";
//	}
	
	@RequestMapping(value="memberinsert")
	public String memberinsert(MemberDto dto) {
		System.out.println("dto ="+ dto);
		sqlsession.insert("member.insert",dto);
		return "member/insert";
	}
	
	@RequestMapping(value="memberinsertform")
	public String memberinsertform() {
		
		return "member/insertform";
	}
	
	@RequestMapping(value="memberupdateform")
	public String memberupdateform(int idx,Model model) {
		System.out.println(idx);
		MemberDto dto = sqlsession.selectOne("member.selectone",idx);
		System.out.println(dto);
		model.addAttribute("member",dto);
		return "member/updateform";
	}
	
	@RequestMapping(value="memberupdate")
	public String memberupdate(MemberDto dto,Model model) {
		System.out.println("update ===========\n"+dto);
		sqlsession.update("member.update",dto);
		return "redirect:memberlist";
	}
	
	@RequestMapping(value="memberdelete")
	public String memberdelete(int idx) {
		System.out.println("delete ===========\n"+idx);
		sqlsession.delete("member.delete",idx);
		return "redirect:memberlist";
	}
}
