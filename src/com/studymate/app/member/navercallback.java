package com.studymate.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.studymate.app.Execute;
import com.studymate.app.member.dao.MemberDAO;
import com.studymate.app.member.dto.MemberDTO;

public class navercallback implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub


	    HttpSession session = req.getSession();
	    
	    String email = req.getParameter("Nemail");
	    String nickname = req.getParameter("Nnickname");
	    String Id=req.getParameter("NId");
	    System.out.println("값이 저장될까 ?");
	    System.out.println("Nemail: " + email);
	    
	    System.out.println("Nnickname: " + nickname);

	    System.out.println("NId:  "+Id);
	    
  MemberDTO memberDTO = new MemberDTO();
        
        // 받아온 정보를 MemberDTO 객체의 멤버 변수에 저장
        memberDTO.setMemberPassword(Id);
        memberDTO.setMemberEmail(email);
        memberDTO.setMemberNickname(nickname);
        
        System.out.println(memberDTO);
        
        // MemberDAO 객체 생성
        MemberDAO memberDAO = new MemberDAO();
        
        // MemberDAO의 join 메서드 호출하여 MemberDTO 객체를 전달하여 회원 가입 처리
        memberDAO.join(memberDTO);
		  session.setAttribute("memberNickname", memberDTO.getMemberNickname()); 

        resp.sendRedirect("http://localhost:8085/app/member/mainLogin.jsp");	    
	}
	    }

		
