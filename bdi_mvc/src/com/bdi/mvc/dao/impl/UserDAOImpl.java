package com.bdi.mvc.dao.impl;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bdi.mvc.common.DBCon;
import com.bdi.mvc.dao.UserDAO;
import com.bdi.mvc.vo.User;

public class UserDAOImpl implements UserDAO {

	@Override
	public List<User> userSelectList(User us) {
		List<User> list = new ArrayList<User>();
		Connection con = DBCon.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select uiNo, uiName, uiId, uiDesc, uiAge, diNo from user_info";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				us = new User(rs.getInt("uiNo"),
						rs.getString("uiName"),
						rs.getString("uiId"),
						null,
						rs.getString("uiDesc"),
						rs.getInt("uiAge"),
						rs.getInt("diNo"));
				list.add(us);
			}
		}catch(SQLException	e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(ps!=null) {
					ps.close();
				}
			}catch(SQLException e) {
				
			}
			DBCon.close();
		}
		return list;
	}

	@Override
	public User userSelect(int uiNo) {
		Connection con = DBCon.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select uiNo, uiName, uiId, uiDesc, uiAge, diNo from user_info";
		sql += " where uiNo=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, uiNo);
			rs = ps.executeQuery();
			if(rs.next()) {
				User us = new User(rs.getInt("uiNo"),
						rs.getString("uiName"),
						rs.getString("uiId"),
						null,
						rs.getString("uiDesc"),
						rs.getInt("uiAge"),
						rs.getInt("diNo"));
				return us;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(ps!=null) {
					ps.close();
				}
			}catch(SQLException e) {
				
			}
			DBCon.close();
		}
		return null;
	}

	@Override
	public int userInsert(User us) {
		Connection con = DBCon.getCon();
		PreparedStatement ps = null;
		String sql = "insert into user_info(";
		sql += "uiName, uiId, uiPwd, uiDesc, uiAge, diNo)";
		sql += "values(?,?,?,?,?,?)";
		int cnt = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, us.getUiname());
			ps.setString(2, us.getUiid());
			ps.setString(3, us.getUipwd());
			ps.setString(4, us.getUidesc());
			ps.setInt(5, us.getUiage());
			ps.setInt(6, us.getDino());
			cnt += ps.executeUpdate();
		}catch(SQLException e ) {
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null) {
					ps.close();
				}
			}catch(SQLException e) {
				
			}
			DBCon.close();
		}
		return cnt;
	}

	@Override
	public int userUpdate(User us) {
		Connection con = DBCon.getCon();
		PreparedStatement ps = null;
		String sql = "update user_info";
		sql += " set uiName=?,";
		sql += " uiId=?,";
		sql += " uiPwd=?,";
		sql += " uiDesc=?,";
		sql += " uiAge=?,";
		sql += " diNo=?";
		sql += " where uiNo = ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, us.getUiname());
			ps.setString(2, us.getUiid());
			ps.setString(3, us.getUipwd());
			ps.setString(4, us.getUidesc());
			ps.setInt(5, us.getUiage());
			ps.setInt(6, us.getDino());
			ps.setInt(7, us.getUino());
			return ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBCon.close();
		}
		return 0;
	}

	@Override
	public int userDelete(int us) {
		Connection con = DBCon.getCon();
		String sql = "delete from user_info ";
		sql += " where uiNo = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, us);
			return ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBCon.close();
		}
		return 0;
	}

}
