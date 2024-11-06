package com.lec.ex1_car;

public class CarMain {
	public static void main(String[] args) {
		Car myCar = new Car();
		//myCar.color="핑크";
		myCar.setColor("핑크");
		//myCar.cc = 2400;
		myCar.setCc(2600);
		//myCar.speed = 332;
		myCar.setSpeed(124);
		System.out.println(myCar.getColor() + "색 차량 배기량 은 " + myCar.getCc() + "cc, 속도는 " + myCar.getSpeed());
		myCar.drive();
		myCar.park();
		myCar.race();
		System.out.println(myCar.getColor() + "색 차량 배기량 은 " + myCar.getCc() + "cc, 속도는 " + myCar.getSpeed());
		
		Car youCar = new Car();
		//youCar.color="민트";
		youCar.setColor("민트");
				
		youCar.drive();
		
		System.out.println(youCar.getColor() + "색");
	}
	
}
