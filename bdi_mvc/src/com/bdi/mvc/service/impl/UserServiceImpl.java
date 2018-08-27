package com.bdi.mvc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bdi.mvc.dao.UserDAO;
import com.bdi.mvc.dao.impl.UserDAOImpl;
import com.bdi.mvc.service.UserService;
import com.bdi.mvc.vo.User;

public class UserServiceImpl implements UserService {
	private UserDAO udao = new UserDAOImpl();
	@Override
	public List<User> getUserList(User us) {
		return udao.userSelectList(us);
	}

	@Override
	public User getUser(int uiNo) {
		return udao.userSelect(uiNo);
	}

	@Override
	public Map<String, Object> userInsert(User us) {
		Map<String, Object> rMap = new HashMap<String,Object>();
		rMap.put("msg", "유저 등록 오류!");
		rMap.put("success", "false");
		if(udao.userInsert(us)==1) {
			rMap.put("msg", "정상적으로 등록 되었습니다.");
			rMap.put("success", "true");
		}
		return rMap;
	}

	@Override
	public Map<String, Object> userUpdate(User us) {
		Map<String,Object> rMap = new HashMap<String,Object>();
		rMap.put("msg", "수정 실패");
		rMap.put("success", "false");
		int cnt = udao.userUpdate(us);
		if(cnt==1) {
			rMap.put("msg", "수정 성공");
			rMap.put("success", "true");
		}
		return rMap;
	}

	@Override
	public Map<String, Object> userDelete(int us) {
		Map<String,Object> rMap = new HashMap<String,Object>();
		rMap.put("msg", "삭제 실패");
		rMap.put("success", "false");
		int cnt = udao.userDelete(us);
		if(cnt==1) {
			rMap.put("msg", "삭제 성공");
			rMap.put("success", "true");
		}
		return rMap;
	}

}
