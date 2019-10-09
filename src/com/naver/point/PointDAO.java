package com.naver.point;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.naver.util.DBConnector;

public class PointDAO {

	public PointDTO getone(String id, int term) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		PointDTO pointDTO = null;
		
		try {
			con = DBConnector.getConnect();
			String sql = "select * from point where id=? and term=?";
			st = con.prepareStatement(sql);
			st.setString(1, id);
			st.setInt(2, term);
			rs = st.executeQuery();
			
			if(rs.next()) {
				pointDTO = new PointDTO();
				pointDTO.setNum(rs.getInt(1));
				pointDTO.setId(rs.getString(2));
				pointDTO.setKor(rs.getInt(3));
				pointDTO.setEng(rs.getInt(4));
				pointDTO.setMath(rs.getInt(5));
				pointDTO.setTotal(rs.getInt(6));
				pointDTO.setAvg(rs.getDouble(7));
				pointDTO.setTerm(rs.getInt(8));
				pointDTO.setBid(rs.getString(9));
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
		
		return pointDTO;
	}//getone
	
	public int insert(PointDTO pointDTO) {
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;
		
		try {
			con = DBConnector.getConnect();
			String sql = "insert into point values (point_seq.nextval,?,?,?,?,?,?,?,?)";
			st = con.prepareStatement(sql);
			st.setString(1, pointDTO.getId());
			st.setInt(2, pointDTO.getKor());
			st.setInt(3, pointDTO.getEng());
			st.setInt(4, pointDTO.getMath());
			st.setInt(5, pointDTO.getTotal());
			st.setDouble(6, pointDTO.getAvg());
			st.setInt(7, pointDTO.getTerm());
			st.setString(8, pointDTO.getBid());
			
			result = st.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
		return result;
	}//insert
	
	public int update(PointDTO pointDTO) {
		Connection con = null;
		PreparedStatement st =null;
		int result = 0;
		
		try {
			con = DBConnector.getConnect();
			String sql = "update point set kor=?, eng=?, math=?, total=?, avg=? where id=? and term=?";
			st = con.prepareStatement(sql);
			st.setInt(1, pointDTO.getKor());
			st.setInt(2, pointDTO.getEng());
			st.setInt(3, pointDTO.getMath());
			st.setInt(4, pointDTO.getTotal());
			st.setDouble(5, pointDTO.getAvg());
			st.setString(6, pointDTO.getId());
			st.setInt(7, pointDTO.getTerm());
			
			result = st.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}//update
	
	public int delete(String id, int term) {
		Connection con = null;
		PreparedStatement st = null;
		int result =0;
		
		try {
			con = DBConnector.getConnect();
			String sql = "delete point where id=? and term=?";
			st = con.prepareStatement(sql);
			st.setString(1, id);
			st.setInt(2, term);
			result = st.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}//delete

}
