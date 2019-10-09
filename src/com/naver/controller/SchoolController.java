package com.naver.controller;

import java.util.Scanner;

import com.naver.member.MemberDAO;
import com.naver.member.MemberDTO;
import com.naver.point.PointDAO;
import com.naver.point.PointDTO;
import com.naver.view.MemberView;
import com.naver.view.PointView;

public class SchoolController {
	private Scanner sc;
	private MemberDAO memberDAO;
	private MemberView memberView;
	private MemberController memberController;
	private PointDAO pointDAO;
	private PointView pointView;
	private PointController pointController;

	public SchoolController() {
		sc = new Scanner(System.in);
		memberDAO = new MemberDAO();
		memberView = new MemberView();
		memberController = new MemberController();
		pointDAO = new PointDAO();
		pointView = new PointView();
		pointController = new PointController();
	}

	public void start() {
		boolean check = true;
		int result = 0;

		System.out.println("*로그인*");
		System.out.println("id");
		String id = sc.next();
		System.out.println("pw");
		String pw = sc.next();
		
		while(check) {
			//로그인하기
			int num = memberDAO.findKind(id, pw);
			if(num==1 || num==2) {
				System.out.println("로그인 성공");
			} else {
				System.out.println("로그인 실패");
				check=!check;
			}

			//권한에 따라 관리자와 학생 나누기
			switch (num) {
			case 1: //관리자
				System.out.println("1. 회원정보");
				System.out.println("2. 성적관리");
				result = sc.nextInt();

				switch(result) {
				case 1: //관리자 회원정보
					MemberDTO memberDTO = memberDAO.getone(id);
					memberView.view(memberDTO);
					break;
				case 2: //관리자 성적관리
					pointController.start();
					break;
				default:
					check=!check;
				}
				break;

			case 2: //학생 
				System.out.println("1. 회원정보");
				System.out.println("2. 성적관리");
				result = sc.nextInt();
				
				switch(result) {
				case 1: //학생 회원정보
					MemberDTO memberDTO = memberDAO.getone(id);
					memberView.view(memberDTO);
					break;
				case 2: //학생 성적관리
					System.out.println("term");
					int term = sc.nextInt();
					PointDTO pointDTO = pointDAO.getone(id,term);
					pointView.view(pointDTO);
					break;
				default:
					check=!check;
				}
				break;

			default:
				System.out.println("권한이 없습니다.");
				check=!check;
			}//switch
		}//while

	}//start

}
