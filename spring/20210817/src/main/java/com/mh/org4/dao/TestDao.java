package com.mh.org4.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import com.mh.org4.dto.TestDto;


@Component
public class TestDao {
	/*
	 * int a(){
	 * return 1;
	 * }
	 * 
	 * double b(){
	 * return 1.1;
	 * }
	 * 
	 * 
	 */
	
	@Autowired
	DriverManagerDataSource datasource;
	
	@Autowired
	SqlSession sqlSession;
	
	public void doInsert() {
		sqlSession.insert("test.insert");
	}
	
	//public ArrayList<String> doList() {
	public ArrayList<TestDto> doList() {
		//ArrayList<String> list = new ArrayList<String>();
		ArrayList<TestDto> list = new ArrayList<TestDto>();
		System.out.println("dolist");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String url = "jdbc:mysql://localhost:3306/mh";
		
		
		try {
			//jar 파일가져오는 것
			Class.forName("com.mysql.jdbc.Driver");
			
			//mysql db연결 id rood pw 1234
			conn = DriverManager.getConnection(url, "root", "1234");
			//select 작성
			pstmt = conn.prepareStatement("select * from test");
			//실행 반환되는 값을 rs 담는 것
			rs = pstmt.executeQuery();
			// rs next
			while(rs.next()) {
				TestDto dto = new TestDto();
				dto.setPara1(rs.getString(1));
				dto.setPara2(rs.getString(2));
				list.add(dto);
				
				//System.out.println("rs.getString(1) = "+rs.getString(1));
				//System.out.println("rs.getString(2) = "+rs.getString(2));
				//list.add(rs.getNString(1));
				//list.add(rs.getString(2));
			}
		} catch (Exception e) {
			
		}finally {
			
		}
		//list.add("a");
		//list.add("b");
		return list;
	}
	
	//public List<Connection> mydatasource;
	
	public void mylist() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = datasource.getConnection();
			pstmt = conn.prepareStatement("");
		} catch (Exception e) {
			
		}
	}
}
