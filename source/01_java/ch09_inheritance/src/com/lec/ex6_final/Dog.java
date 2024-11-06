package com.lec.ex6_final;

public class Dog extends Animal {
	public void running() {
		speed += 10;
		System.out.println("강아지가 뛰면서 꼬리를 흔들면서 달리는 속도 : " + speed);
	}
	
}
