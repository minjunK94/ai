package com.lec.ex4_account;
// 데이터(인스턴스변수) : accountNo(string : 진행을 해야 맨앞 0이 안없어짐)
// ownerName(String), balance(long)
// 생성자 new Account("010-1234-5678", "홍길동")
// 생성자 new Account("010-1234-5678", "홍길동", 00)
// 기능(메소드) :deposit(int), withdraw(int),inforPrint(정보출력), infoString(정보문자열)
// getBalance()(잔액조회)
public class Account {
	private String accountNo; 
	private String ownerName;
	private long balance;
	
	public Account(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		
	}
	public Account(String accountNo, String ownerName, long balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	public void deposite(long money) { // 온니 예금
		balance += money;
		System.out.println(money + "원 예금하여 잔액 : " + balance + "원");
	}
	public void withdraw(long money) throws Exception { // 잔액이 있으면 인출
		if(balance >= money) {
			balance -= money;
			System.out.println(money + "원 인출하여 잔액 : " + balance + "원");
		}else {// 강제 예외 발생 시킬예정
//			System.out.println("잔액 부족");
			throw new Exception("예외메세지 : " +money + "원 출금 진행 잔액("+balance+")원 부족하여 출금 불가합니다");
		}
	}
	public void infoPrint() {
		// 010-1234-5678 "홍길동"님 잔액 : xxx
//		System.out.println(accountNo + " \"" + ownerName + "\"님 잔액 : " + balance);
		System.out.printf("%s \"%s\"님 잔액 : %d\n", accountNo, ownerName, balance);
	}
	public String infoString() {
		// 010-1234-5678 "홍길동"님 잔액 : xxx 을 reurn
//		return accountNo + " \"" + ownerName + "\"님 잔액 : " + balance;
		return String.format("%s \"%s\"님 잔액 : %d", accountNo, ownerName, balance);
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
}
