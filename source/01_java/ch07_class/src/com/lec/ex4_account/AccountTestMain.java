package com.lec.ex4_account;

public class AccountTestMain {
	public static void main(String[] args) {
		Account hong = new Account("010-1234-5678", "홍길동");
		hong.deposite(1);
		hong.withdraw(2);
		hong.infoPrint();
		System.out.println(hong.infoString());
		Account kim = new Account("010-8765-4321", "김동", 2421538721L);
		kim.withdraw(2000);
		System.out.println(kim.infoString());
	}
}
