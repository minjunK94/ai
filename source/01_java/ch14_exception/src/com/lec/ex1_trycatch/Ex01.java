package com.lec.ex1_trycatch;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("첫번째 정수는 ");
		int i = scanner.nextInt();
		System.out.println("두번재 정수는 ");
		int j = scanner.nextInt();
		System.out.println(" i/j = " + (i/j));//ArithmeticException : 예외처리
		System.out.println(" i/j = " + (i*j));
		System.out.println(" i/j = " + (i+j));
		System.out.println(" i/j = " + (i-j));
		scanner.close();
	}
}
