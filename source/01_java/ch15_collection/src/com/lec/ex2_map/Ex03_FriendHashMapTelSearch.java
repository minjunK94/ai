package com.lec.ex2_map;

import java.util.HashMap;
import java.util.Scanner;

import com.lec.ex1_list.Friend;

public class Ex03_FriendHashMapTelSearch {
	public static void main(String[] args) {
		HashMap<String, Friend> friends = new HashMap<String, Friend>();
		friends.put("010-6666-6666", new Friend("지대한", "010-6666-6666"));
		friends.put("010-9999-9999", new Friend("곽병래", "010-9999-9999"));
		friends.put("010-7777-7777", new Friend("입벌구", "010-9999-9999"));
		friends.put("010-9994-1231", new Friend("김지환", "010-9999-9999"));
		friends.put("010-9991-1892", new Friend("뀨", "010-9999-9999"));
//		System.out.println(friends);
		Scanner scanner = new Scanner(System.in);
//		String searchTel = null;
		while(true) {
			System.out.println("검색하고자 하는 전화번호는 (단 종료는 x)? : ");
			String searchTel = scanner.next();
			if(searchTel.equals("x")) break;
			Friend searchFriend = friends.get(searchTel);
			if(searchFriend == null) {
				System.out.println("검색되지 않는 전화번호 입니다");
			}else {
				System.out.println("검색한 정보는" + searchFriend);
			}//if
		}//while
	}//main
}//class
