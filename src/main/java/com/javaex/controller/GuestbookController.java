package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller  //주소 조사하러 갈 때 @컨트롤러(어노테이션)가 있는 애들만 한다.
public class GuestbookController {
	
	
	//필드
	
	//생성자
	
	//메소드gs
	
	//메소드일반
	@RequestMapping(value="/addlist", method= {RequestMethod.GET, RequestMethod.POST})
	public String select() {
		System.out.println("guestbookController/addlist");
		
		
		return "";
	}
	
	


}
