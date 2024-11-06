package cm.lec.quiz;

import java.util.Scanner;

// 사용자로부터 구구단 수를 입력받아 gugudanOut(입력받은 수) 호출 -> 호출 한 메소드에서 해당 구구단 출력
public class Quiz_gugudan {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("출력 하고자 하는 구구단 수는 > ");
		int dansu = scanner.nextInt();
		System.out.println("입력 하신 구구단 수는 " + dansu + "단 ");
		gugudanOut(dansu);
	}

	private static void gugudanOut(int dansu) {
		for(int i=1 ; i<=9 ; i++) {
			//System.out.println(dansu + " * " + i + " = " + dansu*i);
			System.out.printf("%d X %d = %d\n", dansu, i, dansu*i);
		}
		// TODO Auto-generated method stub
		
	}

}
