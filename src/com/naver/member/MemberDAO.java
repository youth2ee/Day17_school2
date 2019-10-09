package com.naver.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.naver.point.PointDTO;
import com.naver.util.DBConnector;

public class MemberDAO {
	
	public int findKind(String id, String pw) {
		Connection con =null;
		PreparedStatement st =null;
		ResultSet rs =null;
		MemberDTO memberDTO =null;	
		int result =0;
		
		try {
			con = DBConnector.getConnect();
			String sql = "select kind from member where id=? and pw=?";
			st = con.prepareStatement(sql);
			st.setString(1, id);
			st.setString(2, pw);
			rs = st.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}//findKind
	
	public MemberDTO getone(String id) {
		Connection con =null;
		PreparedStatement st =null;
		ResultSet rs =null;
		MemberDTO memberDTO = null;		
		
		try {
			con = DBConnector.getConnect();
			String sql = "select * from member where id=?";
			st = con.prepareStatement(sql);
			st.setString(1, id);
			rs = st.executeQuery();
			
			if(rs.next()) {
				memberDTO = new MemberDTO();
				memberDTO.setKind(rs.getInt(1));
				memberDTO.setId(rs.getString(2));
				memberDTO.setPw(rs.getString(3));
				memberDTO.setName(rs.getString(4));
				memberDTO.setEmail(rs.getString(5));
				memberDTO.setPhone(rs.getString(6));
				memberDTO.setBid(rs.getString(7));
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return memberDTO;
		
	}//getone
	

}
