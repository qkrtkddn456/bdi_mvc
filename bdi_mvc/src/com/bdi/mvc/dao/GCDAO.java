package com.bdi.mvc.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.bdi.mvc.vo.GC;

public interface GCDAO {
	public void setConnection(Connection con);
	public List<GC> selectGCList(GC gc)throws SQLException;
	public GC selectGC(int gcNum)throws SQLException;
	public int insertGC(GC gc)throws SQLException;
	public int updateGC(GC gc)throws SQLException;
	public int deleteGC(GC gc)throws SQLException;
	
}
