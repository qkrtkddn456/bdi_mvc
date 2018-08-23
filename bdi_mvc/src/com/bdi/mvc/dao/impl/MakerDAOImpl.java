package com.bdi.mvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bdi.mvc.common.DBCon;
import com.bdi.mvc.dao.MakerDAO;
import com.bdi.mvc.vo.Maker;

public class MakerDAOImpl implements MakerDAO {

	@Override
	public List<Maker> selectMakerList(Maker mk) {
		List<Maker> list = new ArrayList<Maker>();
		Connection con = DBCon.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select mNum, mName, mPrice, mCnt, mTotal, mDesc from maker";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				mk = new Maker(rs.getInt("mNum"),
						rs.getString("mName"),
						rs.getInt("mPrice"),
						rs.getInt("mCnt"),
						rs.getInt("mTotal"),
						rs.getString("mDesc"));
				list.add(mk);
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
		return list;
	}

	@Override
	public Maker selectMaker(int mNum) {
		try {
			Connection con = DBCon.getCon();
			String sql = "select * from maker where mNum=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, mNum);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Maker maker = new Maker(rs.getInt("mNum")
						, rs.getString("mName")
						, rs.getInt("mPrice")
						, rs.getInt("mCnt")
						, rs.getInt("mTotal")
						, rs.getString("mDesc"));
				return maker;
			}
			return null;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBCon.close();
		}
		return null;
	}

	@Override
	public Map<String, Object> insertMaker(Maker mk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> updateMaker(Maker mk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> deleteMaker(Maker mk) {
		// TODO Auto-generated method stub
		return null;
	}

}
