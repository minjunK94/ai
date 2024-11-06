package com.lec.ex4_product;

public class ProductTestMain {
	public static void main(String[] args) {
		Product p1 = new Product("A23");
		p1.infoPrint();
		Product p2 = new Product("A23");
		Product p3 = new Product("S23");
		p2.infoPrint();
		p3.infoPrint();
	}

}
