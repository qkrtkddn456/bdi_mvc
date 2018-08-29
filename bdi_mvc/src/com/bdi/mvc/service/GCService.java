package com.bdi.mvc.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.bdi.mvc.vo.GC;

public interface GCService {
	public List<GC> getGCList(GC gc)throws SQLException;
	public GC getGC(int gcNum)throws SQLException;
	public Map<String,Object> insertGC(GC gc)throws SQLException;
	public Map<String,Object> updateGC(GC gc)throws SQLException;
	public Map<String,Object> deleteGC(GC gc)throws SQLException;
}
