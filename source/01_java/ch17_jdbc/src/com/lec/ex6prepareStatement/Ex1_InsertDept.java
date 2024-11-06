package com.lec.ex6prepareStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex1_InsertDept {
	public static void main(String[] args) {
		String ur1 = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
//		Statement stmt = null;
		String sql = "INSERT INTO DEPT "
				+ "    VALUES (?, UPPER(?), UPPER(?))";
		System.out.print("입력 하실 부서번호는 >");
		int deptno = scanner.nextInt();
		System.out.print("입력 하실 부서명은 >");
		String dname = scanner.next();
		System.out.print("입력 하실 부서위치는 >");
		String loc = scanner.next();
		try {
			conn = DriverManager.getConnection(ur1, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno); // 첫번째 물음표는 int값 deptno로 채움
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);
			int result = pstmt.executeUpdate();
			System.out.println(result>0? "입력성공":"입력실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try { //7 단계 연결해제
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}		
		}
		
	}
}
