package com.bdi.mvc.service;

import java.util.List;
import java.util.Map;

import com.bdi.mvc.vo.User;

public interface UserService {
	public List<User> getUserList(User us);
	public User getUser(int uiNo);
	public Map<String, Object> userInsert(User us);
	public Map<String, Object> userUpdate(User us);
	public Map<String, Object> userDelete(User us);
}
