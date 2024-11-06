package com.lec.ch12.service;

import java.sql.Date;

import com.lec.ch12.dao.PersonRepository;
import com.lec.ch12.dto.Person;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// id, name, tel, address, birth, memo
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		String birthStr = request.getParameter("birth");
		Date birth = null;
		if(!birthStr.equals("")) {
			birth = Date.valueOf(birthStr);
		}
		String memo = request.getParameter("memo");
		PersonRepository dao = PersonRepository.getInstance();
		Person person = new Person(id, name, tel, address, birth, memo, null);
		int updateResult = dao.updatePerson(person); // DB수정
		System.out.println(updateResult==PersonRepository.SUCCESS? "수정성공":"수정실패");
	}

}
