package com.lec.ex6prepareStatement;
import java.sql.*;
import java.util.*;
// com.lec.ex2selectWhere.Ex2 + Ex3_selectWhereDnaem 같은 기능
// 부서명을 입력 받아 해당 부서 정보를 출력하고, 사원(사번, 이름, 급여. 급여순) 을 출력
public class Ex3_selectWhereDname {
	public static void main(String[] args) {
		String ur1 = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String deptSql = "SELECT *"
				+ "    FROM DEPT"
				+ "    WHERE DNAME = UPPER(?)";
		String empSql = "SELECT EMPNO, ENAME, SAL"
				+ "    FROM EMP E, DEPT D"
				+ "    WHERE E.DEPTNO = D.DEPTNO"
				+ "    AND DNAME = UPPER(?)"
				+ "    ORDER BY SAL";
		try {
			conn = DriverManager.getConnection(ur1, "scott", "tiger");
			pstmt = conn.prepareStatement(deptSql);
			System.out.print("검색 하실 부서 이름은 :");
			String dname = scanner.next();
			pstmt.setString(1, dname);
			rs = pstmt.executeQuery();
			 if (rs.next()) { 
					 System.out.println("원하는 부서 번호는 : " + rs.getInt("deptno"));
					 System.out.println("원하는 부서 이름은 : " + rs.getString("dname"));
					 System.out.println("원하는 부서 위치는 : " + rs.getString("loc"));
				 	rs.close();
	                pstmt.close();  
	                pstmt = conn.prepareStatement(empSql);
	                pstmt.setString(1, dname); 
	                rs = pstmt.executeQuery();
	                if (rs.next()) {
	                	System.out.println("사번\t이름\t급여");
	                	do {
							int empno = rs.getInt("empno");
							String ename = rs.getString("ename");
							int sal = rs.getInt("sal");
							System.out.println(empno + "\t" + ename + "\t" + sal);
	                	}while (rs.next());
	                }	                
	            } else {
	                System.out.println("해당 부서는 없습니다.");
	            }
			}catch (SQLException e) {
	            System.out.println(e.getMessage());
	        } finally {
	            try {
	                if (rs != null) rs.close();
	                if (pstmt != null) pstmt.close();
	                if (conn != null) conn.close();
	            } catch (Exception e) {
	                System.out.println(e.getMessage());
	            }
	        }
		}
	}
