package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestbookDAO;
import com.javaex.vo.GuestbookVO;


@Service //(컨트롤러에서 @Autowired를 쓰려면 서비스 클래스에서 이 어노테이션이 꼭 필요하다.)
public class GuestbookService { //비즈니스 로직 관리
	
	
	//필드
	@Autowired
	private GuestbookDAO guestbookDAO;
	
	//생성자
	
	//메소드gs
	
	//메소드일반
	
	//-전체 방명록 리스트 가져오기
	public List<GuestbookVO> exeGetGuestbookList() {
		
		System.out.println("GuestbookService.exeGetGuestbookList");
		
		//DAO를 통해서 일한다.
		//GuestbookDAO guestbookDAO = new GuestbookDAO();
		List<GuestbookVO> guestbookList = guestbookDAO.guestbookSelect();
		
		return guestbookList;
	}
	
	
	//-방명록 저장하기				//넘겨진 주소를 따라가면 GuestbookVO 가 있다.
	public int exeGuestbookAdd(GuestbookVO guestbookVO) {
		
		System.out.println("GuestbookService.exeGuestbookAdd");
		
		//GuestbookDAO guestbookDAO = new GuestbookDAO();
		int count = guestbookDAO.guestbookInsert(guestbookVO);
		
		return count;
	}

	
	//-방명록 삭제하기
	public int exeGetGuestbookRemove(GuestbookVO guestbookVO) {
		System.out.println("GuestbookService.exeGuestbookRemove");
		
		//GuestbookDAO guestbookDAO = new GuestbookDAO();
		int count = guestbookDAO.guestbookDelete(guestbookVO);
		
		return count;
		
	}
	
	

}
