package com.lec.ex1_trycatch;
import java.util.InputMismatchException;
import java.util.Scanner;
//첫번째 정수를 제대로 입력할 때까지 입력받음, 
//두번째 정수를 제대로 입력하지 않으면 1로 처리 하여 할당 받고 곱셉, 덧셈, 뺄셈 을 출력
public class Ex02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int i=0, j=1; // InputMismatchException
		do {	
			try {
				System.out.println("첫번째 정수는 ");
				i = scanner.nextInt();
				break;
			}catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				scanner.nextLine();
			}
		}while(true);
		
		System.out.println("두번재 정수는 ");
		try {
			j = scanner.nextInt();
			System.out.println("i/j = " + (i/j));
		}catch (ArithmeticException e){
			System.out.println(" 0으로 나눌 수 없지요 " + e.getMessage());
		}catch (InputMismatchException e) {
			System.out.println("두번째 정수를 잘못 입력 해서 1로 처리 함다 ");
		}
		
//		System.out.println(" i/j = " + (i/j));//ArithmeticException : 예외처리
		System.out.println(" i/j = " + (i*j));
		System.out.println(" i/j = " + (i+j));
		System.out.println(" i/j = " + (i-j));
		scanner.close();
	}
}
