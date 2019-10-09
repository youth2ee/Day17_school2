package com.naver.view;

import com.naver.member.MemberDTO;

public class MemberView {
	public void view(MemberDTO memberDTO) {
		System.out.println(memberDTO.getKind());
		System.out.println(memberDTO.getId());
		System.out.println(memberDTO.getPw());
		System.out.println(memberDTO.getName());
		System.out.println(memberDTO.getEmail());
		System.out.println(memberDTO.getPhone());
		System.out.println(memberDTO.getBid());
	}

}
