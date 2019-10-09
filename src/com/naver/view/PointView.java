package com.naver.view;

import com.naver.point.PointDTO;

public class PointView {
	public void view(PointDTO pointDTO) {
		System.out.println(pointDTO.getNum());
		System.out.println(pointDTO.getId());
		System.out.println(pointDTO.getKor());
		System.out.println(pointDTO.getEng());
		System.out.println(pointDTO.getMath());
		System.out.println(pointDTO.getTotal());
		System.out.println(pointDTO.getAvg());
		System.out.println(pointDTO.getTerm());
		System.out.println(pointDTO.getBid());
	}

}
