package com.lec.ex5.person;

public class PersonInfoTestMain {
	public static void main(String[] args) {
		PersonInfo p1 = new PersonInfo("홍길동", 33, 'm', "1994-05-27");
		PersonInfo p2 = new PersonInfo("길동", 29, 'f');
		PersonInfo[] person = {p1,p2};
		for(int idx=0 ; idx <person.length ; idx++) {
//			person[idx].print();
			System.out.println(person[idx].infoString());
		}
	}
}
