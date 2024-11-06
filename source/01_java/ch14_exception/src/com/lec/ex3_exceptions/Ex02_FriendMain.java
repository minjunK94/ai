package com.lec.ex3_exceptions;
import java.util.Date;
public class Ex02_FriendMain {
	public static void main(String[] args) {
		Friend friend1 = new Friend("홍길동","010-4570-8382",
				new Date(94, 8, 10));
		System.out.println(friend1);
		Friend friend2 = new Friend("홍길동","010-4570-8382",
				new Date(94, 4, 27));
		System.out.println(friend2);
		Friend friend3 = new Friend("김동길");
		System.out.println(friend3);
		Friend friend4 = new Friend("박동길", "010-1234-5678");
		System.out.println(friend4);
	}
}
