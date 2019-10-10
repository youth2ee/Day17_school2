package com.naver.view;

import com.naver.point.PointDTO;

public class PointView {
	public void view(PointDTO pointDTO) {
		System.out.println("num : "+pointDTO.getNum());
		System.out.println("id : "+pointDTO.getId());
		System.out.println("kor : "+pointDTO.getKor());
		System.out.println("eng : "+pointDTO.getEng());
		System.out.println("math : "+pointDTO.getMath());
		System.out.println("total : "+pointDTO.getTotal());
		System.out.println("avg : "+pointDTO.getAvg());
		System.out.println("term : "+pointDTO.getTerm());
		System.out.println("bid : "+pointDTO.getBid());
	}

}
