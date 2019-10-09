package com.naver.controller;

import java.util.Scanner;

import com.naver.point.PointDAO;
import com.naver.point.PointDTO;
import com.naver.view.PointView;

public class PointController {
	private Scanner sc;
	private PointDAO pointDAO;
	private PointView pointView;

	public PointController() {
		sc = new Scanner(System.in);
		pointDAO = new PointDAO();
		pointView = new PointView();
	}

	public void start() {
		int result =0;
		boolean check = true;
		String id = null;
		int term =0;

		while(check) {
			System.out.println("관리자모드");
			System.out.println("1. 성적조회");
			System.out.println("2. 성적입력");
			System.out.println("3. 성적수정");
			System.out.println("4. 성적삭제");
			System.out.println("5. 종료");
			int num = sc.nextInt();

			switch(num) {
			case 1:
				System.out.println("id");
				id = sc.next();
				System.out.println("term");
				term = sc.nextInt();
				
				PointDTO pointDTO = pointDAO.getone(id, term);
				if(pointDTO!=null) {			
						pointView.view(pointDTO);					
				} else {
					System.out.println("데이터가 없습니다.");
				}
				break;

			case 2:
				PointDTO pointDTO2 = new PointDTO();
				System.out.println("id");
				pointDTO2.setId(sc.next());
				System.out.println("term");
				pointDTO2.setTerm(sc.nextInt());
				System.out.println("국어");
				pointDTO2.setKor(sc.nextInt());
				System.out.println("영어");
				pointDTO2.setEng(sc.nextInt());
				System.out.println("수학");
				pointDTO2.setMath(sc.nextInt());
				System.out.println("bid");
				pointDTO2.setBid(sc.next());

				pointDTO2.setTotal(pointDTO2.getKor()+pointDTO2.getEng()+pointDTO2.getMath());
				pointDTO2.setAvg(pointDTO2.getTotal()/3);

				result = pointDAO.insert(pointDTO2);
				if(result>0) {
					System.out.println("추가 성공");
					pointView.view(pointDTO2);
				} else {
					System.out.println("추가 실패");
				}
				break;

			case 3:
				PointDTO pointDTO3 = new PointDTO();
				System.out.println("id");
				pointDTO3.setId(sc.next());
				
				//수정할 정보 묻기
				System.out.println("term");
				pointDTO3.setTerm(sc.nextInt());
				System.out.println("국어");
				pointDTO3.setKor(sc.nextInt());
				System.out.println("영어");
				pointDTO3.setEng(sc.nextInt());
				System.out.println("수학");
				pointDTO3.setMath(sc.nextInt());
				System.out.println("bid");
				pointDTO3.setBid(sc.next());

				pointDTO3.setTotal(pointDTO3.getKor()+pointDTO3.getEng()+pointDTO3.getMath());
				pointDTO3.setAvg(pointDTO3.getTotal()/3);

				result = pointDAO.update(pointDTO3);
				if(result>0) {
					System.out.println("수정 성공");
					pointView.view(pointDTO3);
				} else {
					System.out.println("수정 실패");
				}
				break;

			case 4:
				System.out.println("삭제할 id");
				id = sc.next();
				System.out.println("term");
				term = sc.nextInt();

				result = pointDAO.delete(id, term);
				if(result>0) {
					System.out.println("삭제 성공");
				} else {
					System.out.println("삭제 실패");
				}
				break;

			default:
				check=!check;
			}

		}
	} //start

}
