package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller  //어노테이션 //임포트 해줘야함     //주소 조사하러 갈 때 @컨트롤러(어노테이션)가 있는 애들만 한다.
@RequestMapping(value="/user")
public class HelloController {
	
	//필드
	
	//생성자
	
	//메소드gs
	
	//메소드일반			
	@RequestMapping(value="/hello", method={RequestMethod.GET, RequestMethod.POST}) //대괄호는 두개일때만이고 하나일 땐 괄호 사용x
	public String select() {
		System.out.println("hello");
		
		return "hello";
	}
	
	@RequestMapping(value="/remove", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete() {
		System.out.println("guestbook4/remove");
		
		return "";
		
		
	}
	
	
	
	
}
