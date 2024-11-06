package com.lec.ex4update;

import java.sql.*;
import java.util.*;

// 수정할 부서번호, 부서명, 부서위치를 받아서 update 한다
public class UpdateDept {
	public static void main(String[] args) {
		String ur1 = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		System.out.println("수정할 부서번호는 >");
		int deptno = scanner.nextInt();
		// 부서번호 존재 여부 confirm 으아아아아아아아아아
		System.out.println("수정할 부서이름은 >");
		String dname = scanner.next();
		System.out.println("수정할 부서근무지는 >");
		String loc = scanner.next();
		String sql = String.format("UPDATE DEPT"
				+ "    SET DNAME=UPPER('%s'),"
				+ "        LOC = UPPER('%s')"
				+ "    WHERE DEPTNO=%d", dname, loc, deptno);
		try {
			conn = DriverManager.getConnection(ur1, "scott", "tiger");
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			System.out.println(result>0? "수정성공":"수정실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try { //7 단계 연결해제
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}		
		}// try - catch - finally
		
	}// main
}
