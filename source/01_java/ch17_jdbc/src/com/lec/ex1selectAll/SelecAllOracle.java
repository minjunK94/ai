package com.lec.ex1selectAll;

import java.sql.*;

public class SelecAllOracle {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String ur1 = "jdbc:oracle:thin:@localhost:1521:xe";
		String sql = "SELECT * FROM EMP";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; // select 결과를 받을 변수객채
		try {
			Class.forName(driver); // 1단계
			conn = DriverManager.getConnection(ur1, "scott", "tiger"); // 2단계
			stmt = conn.createStatement(); // 3단계 sql전송 객체
			rs = stmt.executeQuery(sql); // 4단계 5단계 SQL전송 + SQL결과 받기
			// 6단계 원하는 로직 수행
			if(rs.next()) { // select 결과가 1행 이상
				System.out.println("사번\t이름\t직책\t상사사번\t입사일\t급여\t상여\t부서번호");
				do {
					int empno = rs.getInt(1); //첫번째 필드를 출력하라
					String ename = rs.getString("ename"); // sql 결과의 title 에 ename인 값
					String job = rs.getString("job");
					String mgr = rs.getString("mgr");// String 으로 가져오면 null문자로 출력됨
//					String hiredate = rs.getString("hiredate");
					Date hiredate = rs.getDate("hiredate"); // 날짜만 받기( 시간은 0시 0분으로 출력)
//					Timestamp hiredate1 = rs.getTimestamp("hiredate"); // 날짜와 시간을 다 받음
					int sal = rs.getInt("sal");
					int comm = rs.getInt("comm");
					int deptno = rs.getInt("deptno");
					if(job.length() < 6) {
						System.out.printf("%d\t %s\t %s\t\t %s\t %TF\t %d\t %d\t %d\n",
								empno, ename, job, mgr, hiredate, sal, comm, deptno);
					}else {
					System.out.printf("%d\t %s\t %s\t %s\t %TF\t %d\t %d\t %d\n",
								empno, ename, job, mgr, hiredate, sal, comm, deptno);
					}
				}while(rs.next());
			}else {
				System.out.println("등록된 사원 정보가 없습니다");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}// finally
	}//main
}
