package com.lec.ex1_parentChild;
// pStr, 
public class ParentClass {
	String pStr = "부모클래스";
	public ParentClass() {
		System.out.println("부모클래스(parent 클래스 = super클래스) 생성자");
	}
	public void getPapaName() {
		System.out.println("아빠 이름 : 김지환");
	}
	public void getMamiName() {
		System.out.println("엄마 이름 : 지대한");
	}
}