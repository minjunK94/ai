package com.lec.ex4_product;
// new Product("S22")
public class Product {
	private String modelNo; // 모델명 "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
	private int serialNo; // 고유번호
	static int count = 10; //
	public Product(String modelNo) {
		this.modelNo = modelNo;
		serialNo = ++count;
	}
	public void infoPrint() {
		System.out.println("모델명 : " + modelNo + "시리얼번호 : " + serialNo);
	}
}
