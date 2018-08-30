package com.bdi.mvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bdi.mvc.common.DBCon;
import com.bdi.mvc.dao.GCDAO;
import com.bdi.mvc.vo.Depart;
import com.bdi.mvc.vo.GC;

public class GCDAOImpl implements GCDAO{
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	@Override
	public List<GC> selectGCList(GC gc) throws SQLException{
		List<GC> list = new ArrayList<GC>();
		String sql = "select gcNum, gcName, gcPrice, gcVendor, gcOrder, ";
		sql += " gcDesc, gcImg from game_chart";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				gc = new GC(rs.getInt("gcNum"),rs.getString("gcName"),rs.getInt("gcPrice"),
						rs.getString("gcVendor"),rs.getInt("gcOrder"),rs.getString("gcDesc"),
						rs.getString("gcImg"));
				list.add(gc);
			}
		}catch(SQLException e) {
			throw e;
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
		}
		return list;
	}

	@Override
	public GC selectGC(int gcNum) throws SQLException{
		String sql = "select * from game_chart where gcNum=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, gcNum);
			rs = ps.executeQuery();
			while(rs.next()) {
				GC gc = new GC(gcNum, rs.getString("gcName"), rs.getInt("gcPrice"),
						rs.getString("gcVendor"), rs.getInt("gcOrder"), rs.getString("gcDesc"),
						rs.getString("gcImg"));
				return (gc);
			}
		}catch(SQLException e) {
			throw e;
		}
		return null;
	}

	@Override
	public int insertGC(GC gc) throws SQLException{
		String sql = "insert into game_chart(gcName, gcPrice, gcVendor, gcOrder";
		sql += ", gcDesc, gcImg) values(?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, gc.getGcname());
			ps.setInt(2, gc.getGcprice());
			ps.setString(3, gc.getGcvendor());
			ps.setInt(4, gc.getGcorder());
			ps.setString(5, gc.getGcdesc());
			ps.setString(6, gc.getGcimg());
			return ps.executeUpdate();
		}catch(SQLException e) {
			throw e;
		}
	}

	@Override
	public int updateGC(GC gc) throws SQLException{
		String sql = "update game_chart set gcName=?, gcPrice=?, gcVendor=?, gcOrder=?, ";
		sql += " gcDesc=?, gcImg=? where gcNum=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, gc.getGcname());
			ps.setInt(2, gc.getGcprice());
			ps.setString(3, gc.getGcvendor());
			ps.setInt(4, gc.getGcorder());
			ps.setString(5, gc.getGcdesc());
			ps.setString(6, gc.getGcimg());
			ps.setInt(7, gc.getGcnum());
			return ps.executeUpdate();
		}catch(SQLException e) {
			throw e;
		}
	}

	@Override
	public int deleteGC(GC gc) throws SQLException{
		String sql = "delete from game_chart where gcNum=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, gc.getGcnum());
			return ps.executeUpdate();
		}catch(SQLException e) {
			throw e;
		}
	}

	@Override
	public void setConnection(Connection con) {
		// TODO Auto-generated method stub
		this.con = con;
	}

}
