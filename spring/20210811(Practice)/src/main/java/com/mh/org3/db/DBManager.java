package com.mh.org3.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component // 싱글톤 패턴으로 디비담는 통에 들어간다. DBManager객체가
//@Service
//@Repository 라고 적어도 노상관
public class DBManager {
	public void inserttest(String para1, String para2) {
		/*
		 * para1 para2 가져와서 mysql 연결해가지고 db저장 maven mysql jar 구글에 쳐서 web.xml
		 * <dependencies>안에
		 */
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			// 이 클래스 파일 없으면... catch 구문으로 진행
			// 이 클래스 파일 있으면... 다음줄 진행...
			// port 윈도우에서 0~65000? port
			// ip라는 것은 전화번호
			// port 내선번호
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mh?useUnicode=true&characterEncoding=UTF-8",
					"root", "1234");
			pstmt = conn.prepareStatement("insert into test value (?,?)");
			pstmt.setString(1, para1);
			pstmt.setString(2, para2);
			pstmt.executeUpdate(); // 실행

		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 아무 문제 없으면 파이널리로 와서 디비 연결들 다 끊어 줌
			try {
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	public void deletetest(String dpara1) {
		/*
		 * para1 para2 가져와서 mysql 연결해가지고 db저장 maven mysql jar 구글에 쳐서 web.xml
		 * <dependencies>안에
		 */
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			// 이 클래스 파일 없으면... catch 구문으로 진행
			// 이 클래스 파일 있으면... 다음줄 진행...
			// port 윈도우에서 0~65000? port
			// ip라는 것은 전화번호
			// port 내선번호
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mh", "root", "1234");
			pstmt = conn.prepareStatement("delete from test where para1 = (?)");
			pstmt.setString(1, dpara1);

			pstmt.executeUpdate(); // 실행

		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 아무 문제 없으면 파이널리로 와서 디비 연결들 다 끊어 줌
			try {
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	public void updatetest(String upara1, String upara2) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mh", "root", "1234");
			pstmt = conn.prepareStatement("UPDATE test SET para2 = (?) WHERE para1 = (?);");
			pstmt.setString(1, upara2);
			pstmt.setString(2, upara1);

			pstmt.executeUpdate(); // 실행

		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 아무 문제 없으면 파이널리로 와서 디비 연결들 다 끊어 줌
			try {
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

}
