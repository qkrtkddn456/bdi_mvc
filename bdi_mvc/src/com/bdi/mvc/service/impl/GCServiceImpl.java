package com.bdi.mvc.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bdi.mvc.common.DBCon;
import com.bdi.mvc.dao.GCDAO;
import com.bdi.mvc.dao.impl.GCDAOImpl;
import com.bdi.mvc.service.GCService;
import com.bdi.mvc.vo.GC;

public class GCServiceImpl implements GCService {
	private GCDAO gdao = new GCDAOImpl();
	@Override
	public List<GC> getGCList(GC gc) throws SQLException{
		gdao.setConnection(DBCon.getCon());
		try {
			return gdao.selectGCList(gc);
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

	@Override
	public GC getGC(int gcNum) throws SQLException{
		gdao.setConnection(DBCon.getCon());
		try {
			return gdao.selectGC(gcNum);
		}catch (SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

	@Override
	public Map<String, Object> insertGC(GC gc) throws SQLException{
		gdao.setConnection(DBCon.getCon());
		try {
			int cnt = gdao.insertGC(gc);
			Map<String,Object> rMap = new HashMap<String,Object>();
			rMap.put("cnt", cnt);
			rMap.put("msg", "저장 실패");
			if(cnt==1) {
				rMap.put("msg", "저장 성공");
			}
			return rMap;
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

	@Override
	public Map<String, Object> updateGC(GC gc)throws SQLException {
		gdao.setConnection(DBCon.getCon());
		try {
			int cnt = gdao.updateGC(gc);
			Map<String,Object> rMap = new HashMap<String,Object>();
			rMap.put("cnt", cnt);
			rMap.put("msg", "수정 실패");
			if(cnt==1) {
				rMap.put("msg", "수정 성공");
			}
			return rMap;
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

	@Override
	public Map<String, Object> deleteGC(GC gc) throws SQLException{
		gdao.setConnection(DBCon.getCon());
		try {
			int cnt = gdao.deleteGC(gc);
			Map<String,Object> rMap = new HashMap<String,Object>();
			rMap.put("cnt", cnt);
			rMap.put("msg", "삭제 실패");
			if(cnt==1) {
				rMap.put("msg", "삭제 성공");
			}
			return rMap;
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

}
