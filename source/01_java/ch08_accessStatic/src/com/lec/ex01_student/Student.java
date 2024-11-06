package com.lec.ex01_student;
// 데이터 : name(String), kor(int), eng, mat, tot, avg(double)
// 생성자 : new Student("이름", 90,90,90)
// 메소드 : infoPrint(), infoString()
public class Student {
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private double avg;
	// 생성자
	public Student() {} // {}< 디폴트 생성자
	public Student(String name, int kor, int eng, int mat) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		tot = kor + eng + mat;
		avg = tot/3.;
	}
	// 메소드
	public void inforPrint() {
		// \t(띄어쓰기)정우성
		System.out.printf("\t%s\t%3d\t%3d\t%3d\t%3d\t%.1f", name, kor, eng, mat, tot, avg);
	}
	public String infoString() {
		return String.format("\t%s\t%3d\t%3d\t%3d\t%3d\t%.1f", name, kor, eng, mat, tot, avg);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
}
