package com.lec.method;
// sum(5, 50), sum(10): 함수 오버로딩 / evenOdd(10) / abs(-9)
public class Arithmetic {
	public static int abs(int value) { // abs : value의 절대값을 return
		int result = (value>=0)? value : -value;
		return result;
	}
	public int sum(int a, int b) { // a부터 b 까지 누적합 return: 
		int sum = 0; // 누적변수
		for(int i=a ; i<=b ; i++) {
			sum += i; // sum = sum+i;
		}
		return sum;
	}
	public int sum(int to) { // 1부터 to 까지 누적합 return
		int result = 0;
		for(int i=1 ; i<=to ; i++) {
			result += i;
		}
		return result;
	}
	public String evenOdd(int value) {// value가 짝수인지 홀수인지 return
		String result = value%2==0 ? "짝수입니다" : "홀수입니다";
		return result;
		//		return "짝수입니다";
		// if (value%2==0) {
			// return "짝수입니다";
		// else {
			// return "홀수입니다";
	}
}
