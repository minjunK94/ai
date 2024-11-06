package com.lec.ex6_final;
/** final class : 상속금지
 * 	final을 변수 앞에 붙히면 변수 수정 불가
 *  final을 메소드 앞에 붙히면 override 불가
 *  final을 class 앞에 붙히면 상속 불가
 */
public final class Rabbit extends Animal {
	@Override
	public void running() {
		speed += 30;
		System.out.println("토끼가 미친듯이 뛰는중 속도 : " + speed);
	}
}
