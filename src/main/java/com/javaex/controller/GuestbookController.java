package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestbookDAO;
import com.javaex.vo.GuestbookVO;

@Controller  //주소 조사하러 갈 때 @컨트롤러(어노테이션)가 있는 애들만 한다.
public class GuestbookController {
	
	
	//필드
	
	//생성자
	
	//메소드gs
	
	//메소드일반
	//방명록 리스트 가져오기
	@RequestMapping(value="/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) { //리턴문자열이 스트링이라 자료형이 Stirng이다.
		System.out.println("guestbookController/list()");
		
		GuestbookDAO guestbookDAO = new GuestbookDAO();
		List<GuestbookVO> guestbookList = guestbookDAO.guestbookSelect();
		System.out.println(guestbookList);
		
		
		//*Model개념
		//D.S(dispatcher servlet) 한테!!!! request의 attribute영역에 
		//"gList" 이름으로 0x333(guestbookList)을 넣어줘
		model.addAttribute("gList", guestbookList);
		
		//*View개념
		
		//D.S(dispatcher servlet)야!!!!
		//"/WEB-INF/views/addlist.jsp"에 포워드해
		//(뷰에 담은 걸 리턴해서 보여줘!)
		return "addlist";
	}
	

	@RequestMapping(value="/add", method=  {RequestMethod.GET , RequestMethod.POST})
	public String add(@ModelAttribute GuestbookVO guestbookVO) {
	    		//add를 실행하는 건 D.S            
					//D.S(dispatcher servlet)야!!!! request의 파라미터 값을 꺼내서
		            //GuestbookVO로 묶어줘!

		/*D.S(dispatcher servlet)가 하는 일
		 1)파라미터의 값을 꺼낸다
		 name=aaa    setName()
		 
		 
		 
		 2)GuestbookVO 메모리에 올린다. (기본생성자사용!!!!)
		  GuestbookVO guestbookVO = new GuestbookVO();
		  
		  3)Setter로 값을 넣는다.
		  name=aaa  --->  setName(aaa)
		  
		 4) D.S 는 add(guestbookVO)실행한다.
		 
		 *url 파라미터 이름과 VO의 필드 이름을 같게 만든다.
		  
		 */

		System.out.println(guestbookVO);
		GuestbookDAO guestbookDAO = new GuestbookDAO();
		int count = guestbookDAO.guestbookInsert(guestbookVO);
		System.out.println(count);
		
		
		//리다이렉트 하는 법 "redirect:" 앞쪽에 써준다
		//http://localhost:8888/guestbook4/list
		return "redirect:/list";
		//redirect: 이게 붙어있으면 리다이렉트 시킬테고,
		//아무것도 없으면 jsp파일을 찾는다.
	}


	/*
	//방명록 글 저장
	@RequestMapping(value="/add", method=  {RequestMethod.GET , RequestMethod.POST})
	public String add(@RequestParam(value="name") String name,
					  @RequestParam(value="password") String password,
					  @RequestParam(value="content") String content) {
	
		//D.S(dispatcher servlet)야!!!!
		//파라미처 영역의 name인 값을 꺼내줘
		System.out.println("guestbookController/add");
		
		GuestbookVO guestbookVO = new GuestbookVO();
		guestbookVO.setName(name);
		guestbookVO.setPassword(password);
		guestbookVO.setContent(content);
		
		System.out.println(guestbookVO);
		
		
		
		System.out.println(name);
		System.out.println(password);
		System.out.println(content);
		return "";
	}
	*/
	//@RequestParam(value="no") int no, Model model

	//삭제폼(삭제랑 헷갈리지말자) 폼만 보여주면 됨
	@RequestMapping(value="/rform", method= {RequestMethod.GET , RequestMethod.POST})
	public String removeform() {

		System.out.println("GuestbookControlle/rform");
		
		return "removeform";
	}
	
	
	//삭제
	@RequestMapping(value="/remove", method= {RequestMethod.GET, RequestMethod.POST})
	public String remove(@ModelAttribute GuestbookVO guestbookVO) {
		System.out.println("GuestbookXontroller.remove()");

		GuestbookDAO guestbookDAO = new GuestbookDAO();
		int count = guestbookDAO.guestbookDelete(guestbookVO);
		
		
		
		return "redirect:/list";
	}

	
}
