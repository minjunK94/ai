package com.lec.ex2_map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.lec.ex1_list.Friend;

public class Ex02_FriendhashMap {
	public static void main(String[] args) {
		Friend[] farr = new Friend[5];
		ArrayList<Friend> fs = new ArrayList<Friend>();
		HashMap<String, Friend> friends = new HashMap<String, Friend>();
		Friend newFriend = new Friend("길동이", "010-1111-1111");
		friends.put(newFriend.getTel(), newFriend);
		friends.put("010-1234-5678", new Friend("지대한", "010-1234-5678"));
		friends.put("010-2222-3333", new Friend("곽병래", "010-2222-3333"));
		Iterator<String> iterator = friends.keySet().iterator(); // 반복자
		while(iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(friends.get(key).getName() + "\t" +friends.get(key).getTel());
		}
//		iterator = friends.keySet().iterator();
//		while(iterator.hasNext()) {
//			String key = iterator.next();
//			System.out.println(friends.get(key).getName() + "\t" +friends.get(key).getTel());
//		}
	}
}
