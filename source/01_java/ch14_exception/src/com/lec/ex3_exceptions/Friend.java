package com.lec.ex3_exceptions;
import java.text.SimpleDateFormat;
//데이터 : 이름, 전화번호, 생년월일(Date) 
//Friend f = new Friend("홍길동", "010-4570-8382", new Datr(94, 8, 10))
//sysout(f) => [이름]홍길* [전화] ***-****-8382 [생일] 9월 10일 ♬ 생일축하 ♬
import java.util.Date;
public class Friend {
	private String name;
	private String tel;
	private Date birthday;
	public Friend(String name) {
		this.name = name;
	}
	public Friend(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}
	public Friend(String name, String tel, Date birthday) {
		super();
		this.name = name;
		this.tel = tel;
		this.birthday = birthday;
	}
	public String toString() { //[이름]홍길* [전화] ***-****-8382 [생일] 9월 10일 ♬ 생일축하 ♬
		String result = "";
		String nameOut = name.substring(0, name.length()-1) + "*";
		result += "[이름]" + nameOut;
		if(tel!=null) {
			String telOut = tel.substring(tel.lastIndexOf("-")+1);
			result += "[전화]***-****-" + telOut;
		}
		if(birthday!=null) {
		SimpleDateFormat sdf = new SimpleDateFormat("M월d일");
		String birthOut = sdf.format(birthday);
		result += "[생일]" + birthOut;
		String today = sdf.format(new Date());
		if(today.equals(birthOut)) {
			result += " ♬ 생일축하 ♬ ";
		}
		}
		return result;
	}
}
