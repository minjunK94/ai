package com.lec.ex6_final;

public class Animal {
	protected int speed;
	public void rnning() {
		speed += 5;
		System.out.println("동물이 뛰고 있는데 현재 속도 : " + speed);
	}
	public final void stop() { // override 금지 메소드 (final 을 사용해서 )
		speed = 0;
		System.out.println("멈춤");
	}
	public void running() {
		// TODO Auto-generated method stub
		
	}
}
