package com.lex.ex4_override;

public class Parent {
	public Parent() {// overloading = 함수 중복 정의
		System.out.println("매개변수 없는 Parnet 생성자");
	}
	public Parent(int i) {
		System.out.println("매개변수 있는 Parnet 생성자");
	}
	public void method1() {
		System.out.println("Parnet의 method1");
	}
	public void method2() {
		System.out.println("Parnet의 method2");
	}

}
