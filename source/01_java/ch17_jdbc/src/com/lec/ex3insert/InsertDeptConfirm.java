package com.lec.ex3insert;

import java.sql.*;
import java.util.*;

// 입력 받은 부서번호 중복체크후 : 부서명, 근무지를 입력받아 insert 진행
public class InsertDeptConfirm {
	public static void main(String[] args) {
		String ur1 = "jdbc:oracle:thin:@localhost:1521:xe"; // 주소
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		System.out.print("입력 하실 부서번호는 >");
		int deptno = scanner.nextInt();
		// deptno 중복체크 
		String confirmSql = "SELECT COUNT(*) CNT FROM DEPT"
				+ "    WHERE DEPTNO = " + deptno ;
		try {
			conn = DriverManager.getConnection(ur1, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(confirmSql);
			rs.next();
			int cnt = rs.getInt(1); // 1번째 열을 가져옴!!
			if(cnt==0) {
				// ifsert 수행
				System.out.print("입력 하실 부서명은 >");
				String dname = scanner.next();
				System.out.print("입력 하실 부서위치는 >");
				String loc = scanner.next();
				String insertSql = String.format("INSERT INTO DEPT "
						+ "    VALUES (%d, UPPER('%s'), UPPER('%s'))", deptno, dname, loc);
				int result = stmt.executeUpdate(insertSql);
				if (result>0) {
					System.out.println("입력 성공");
				}
			}else {
				System.out.println("해당 부서번호는 중복 되었습니다");
			}
		} catch (SQLException e) {
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
