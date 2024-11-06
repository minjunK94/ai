package com.lec.ex5delete;
import java.sql.*;
import java.util.Scanner;
public class DeleteDept {
	public static void main(String[] args) {
		String ur1 = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		System.out.print("삭제하실 부서번호는 >");
		int deptno = scanner.nextInt();
		String confirmSql = "DELETE "
				+ "    FROM DEPT"
				+ "    WHERE DEPTNO = %ㅇ" + deptno;
		try {
			conn = DriverManager.getConnection(ur1, "scott", "tiger");
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(confirmSql);
			if (result>0) {
				System.out.println(deptno + "삭제 성공");
			}else {
				System.out.println(deptno + "해당 부서는 없습니다.");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try { //7 단계 연결해제
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}		
		}
				
	}
}

