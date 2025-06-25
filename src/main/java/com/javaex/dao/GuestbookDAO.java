package com.javaex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVO;

@Repository //(DAO 클래스에서 @Autowired를 쓰려면 이 저장소라는 의미의 어노테이션이 꼭 필요하다.)
public class GuestbookDAO {//마이바티스 사용한 버전

		// 필드
		@Autowired
		private SqlSession sqlSession; 

		
		//전체데이터 가져오기
		public List<GuestbookVO> guestbookSelect() {
			System.out.println("guestbookDAO.selectList");		 //게스트북xml의 (방)이름. 진짜이름 -->쿼리문의 위치 
			List<GuestbookVO> guestbookList = sqlSession.selectList("guestbook.selectList");
		
			
			return guestbookList;
		}

		
	
		//저장하기
		public int guestbookInsert(GuestbookVO guestbookVO) {
											
			System.out.println("guestbookDAO.Insert");
			
											//"인서트" 쓸때 주소인 VO에서 꺼내 써라
			int count = sqlSession.insert("guestbook.insert", guestbookVO);
			
			return count;
			
		}

		
		//삭제하기
		public int guestbookDelete(GuestbookVO guestbookVO) {
			System.out.println("guestbookDAO.Delete()");
			
			int count = sqlSession.delete("guestbook.delete", guestbookVO);
			
			return count;
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

