package com.bdi.mvc.dao;

import java.util.List;

import com.bdi.mvc.vo.User;

public interface UserDAO {
	public List<User> userSelectList(User us);
	public User userSelect(int uiNo);
	public int userInsert(User us);
	public int userUpdate(User us);
	public int userDelete(int us);
}
