package com.mh.mocom.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mh.mocom.dto.MemberDto;



@Controller
public class ChartController {
	
	@Autowired
	SqlSession sqlsession;
	
	@RequestMapping(value = "/selectmember", method = RequestMethod.GET)
	@ResponseBody //이건 뭐야? jsp 파일이 아니라 문자열이 그대로 감
	public String selectmember() {
		
		List<MemberDto> list = sqlsession.selectList("member.select");
		return new Gson().toJson(list);
		
	}
	
	@RequestMapping(value = "/testjson", method = RequestMethod.GET)
	@ResponseBody //이건 뭐야? jsp 파일이 아니라 문자열이 그대로 감
	public String testjson() {
		int[] myages= {5,40,30,25,15,3};
		return "[\r\n"
				+ "  {\"name\": \"Tom\", \"age\": "+myages[0]+" },\r\n"
				+ "  {\"name\": \"Franz\", \"age\": "+myages[1]+" },\r\n"
				+ "  {\"name\": \"Chris Calip\", \"age\": "+myages[2]+" },\r\n"
				+ "  {\"name\": \"Maria\", \"age\": 30 },\r\n"
				+ "  {\"name\": \"Fred\", \"age\": 50 },\r\n"
				+ "  {\"name\": \"R Stallman\", \"age\": 60 }\r\n"
				+ "]";
	}
	
/*
 * json 문자열을 직접 만들어서 보내고 있는데
 * java class를 이용해서 json 문자열을 만들자
 * 
 * class Member{
 * String name;
 * int age;
 * }
 * 
 * gson.json(new Member());
 * 
 */
	
	@RequestMapping(value = "/gsonlib", method = RequestMethod.GET)
	@ResponseBody //이건 뭐야? jsp 파일이 아니라 문자열이 그대로 감
	public String gsonjson() {
		Gson gson = new Gson();
		JsonObject jobj = new JsonObject();
		jobj.addProperty("name", 10);
		jobj.addProperty("age", 10);
		
		String test = gson.toJson(jobj);
		return test;
	}
	//직접 주소 끝에 gsonlib 쳐서 페이지 이동
	
	@RequestMapping(value = "/gsonlib1", method = RequestMethod.GET)
	@ResponseBody //이건 뭐야? jsp 파일이 아니라 문자열이 그대로 감
	public String gsonjson1() {
		
		Gson gson = new Gson();
		
		MemberDto dto = new MemberDto();
		dto.setAge(10);
		dto.setId("aa");
		dto.setPw("pw");
		
		
		String test = gson.toJson(dto);
		return test;
	}
	// 목표가 데이터베이스에서 읽어서 json 형태의 객체를 뿌려주는 것
	
	@RequestMapping(value = "/gsonlib2", method = RequestMethod.GET)
	@ResponseBody //이건 뭐야? jsp 파일이 아니라 문자열이 그대로 감
	public String gsonjson2() {
		
		Gson gson = new Gson();
		
		MemberDto dto = new MemberDto();
		dto.setAge(10);
		dto.setId("aa");
		dto.setPw("pw");
		
		
		String test = gson.toJson(dto);
		MemberDto jsontodto = gson.fromJson(test, MemberDto.class);
		System.out.println(jsontodto);
		return test;
	}
	
	@RequestMapping(value = "/gsonlib3", method = RequestMethod.GET)
	@ResponseBody //이건 뭐야? jsp 파일이 아니라 문자열이 그대로 감
	public String gsonjson3() {
		Gson gson = new Gson();
		
		List<MemberDto> list = new ArrayList<MemberDto>();
		
		MemberDto dto1 = new MemberDto();
		dto1.setAge(10);
		dto1.setId("aa");
		dto1.setPw("pw");
		
		list.add(dto1);
		
		MemberDto dto2 = new MemberDto();
		dto2.setAge(30);
		dto2.setId("aa");
		dto2.setPw("pw");
		
		list.add(dto2);
		
		MemberDto dto3 = new MemberDto();
		dto3.setAge(40);
		dto3.setId("aa");
		dto3.setPw("pw");
		
		list.add(dto3);
		
		String test = gson.toJson(list);
		
		return test;
	}
}
