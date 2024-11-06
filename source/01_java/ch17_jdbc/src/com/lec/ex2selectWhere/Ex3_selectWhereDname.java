package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

// 부서 이름을 입력받아 해당 부서 정보를 출력
public class Ex3_selectWhereDname {
	public static void main(String[] args) {
		String ur1 = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		System.out.println("원하는 부서명은 ?");
		String dname = scanner.next();
		String query = "SELECT * FROM DEPT WHERE DNAME = UPPER('" + dname + "')";
		try {
			conn = DriverManager.getConnection(ur1, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			if(rs.next()) {
				System.out.println("원하는 부서 이름은 : " + dname);
				System.out.println("원하는 부서 번호는 : " + rs.getString("deptno"));
				System.out.println("원하는 부서 위치는 : " + rs.getString("loc"));
			}else {
				System.out.println(dname + "는 없는 이름임돠");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try { //7 단계 연결해제
				if(rs!= null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}		
	}
}
}
