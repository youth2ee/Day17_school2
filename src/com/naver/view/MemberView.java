package com.naver.view;

import com.naver.member.MemberDTO;

public class MemberView {
	public void view(MemberDTO memberDTO) {
		System.out.println("kind : "+memberDTO.getKind());
		System.out.println("id : "+memberDTO.getId());
		System.out.println("pw : "+memberDTO.getPw());
		System.out.println("name : "+memberDTO.getName());
		System.out.println("email : "+memberDTO.getEmail());
		System.out.println("phone : "+memberDTO.getPhone());
		System.out.println("bid : "+memberDTO.getBid());
	}

}
