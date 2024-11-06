package com.lec.ex;

import java.util.Scanner;

import com.lec.dao.DeptRepository;
import com.lec.dto.Dept;

//부서번호를 입력 받아 부서정보출력
public interface Ex2_selectWhereDeptno {
	public static void main(String[] args) {
		DeptRepository repository = DeptRepository.getInstance();
		Scanner scanner = new Scanner(System.in);
		System.out.println("원하는 부서 번호는 > ");
		int deptno = scanner.nextInt();
		Dept dept = repository.getDept(deptno);
		if(dept!=null) {
			System.out.println(deptno + "번 부서 정보는 다음과 같습니다.");
			System.out.println("부서명 :" + dept.getDname());
			System.out.println("부서위치 : " + dept.getLoc());
		}else {
			System.out.println("해당 부서 번호는 존재 하지 않습니다");
		}
	}
}
