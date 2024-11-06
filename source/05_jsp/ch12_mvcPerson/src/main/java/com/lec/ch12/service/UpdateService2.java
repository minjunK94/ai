package com.lec.ch12.service;

import java.sql.Date;

import com.lec.ch12.dao.PersonRepository;
import com.lec.ch12.dto.Person;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateService2 implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// id, name, tel, address, birth, memo 중 빈스트링이 아닌 값만 수정
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
		// id로 person정보 가져옴 => 빈스트링 파라미터가 아닌 값만 person에 setter로 값을 수정 후  -> update
		PersonRepository dao = PersonRepository.getInstance();
		Person person = dao.getPerson(id); // 수정전 person 정보
		if(!name.equals("")) { // 수정할 이름을 받았을 경우 실행 
			person.setName(name);
		}
		if(!tel.equals("")) { // 수정할 전화번호를 받았을 경우 
			person.setTel(tel);
		}
		if(!address.equals("")) { // 수정할 주소 입력 받았을경우
			person.setAddress(address);
		}
		person.setBirth(birth); // 수정 안할꺼면 빈스트링으로 냅둠
		if(!memo.equals("")) { // 수정할 메모 입력 받았을경우
			person.setMemo(memo);
		}
		// if문 후에는 person에 수정할 정보가 담겨있다
		dao.updatePerson(person); // 끝
	}

}
