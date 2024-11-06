package com.lec.ex2_access;

public class AccessTestMain {
	public static void main(String[] args) {
		AccessTest obj = new AccessTest();
//		System.out.println(obj.privateMember);
		System.out.println(obj.defaultMember);
		System.out.println(obj.protectddMember);
		System.out.println(obj.publicMember);
//		obj.privateMethod();
		obj.defaultMethod();
		obj.protectedMathod();
		obj.publicMethod();
		
	}
}
