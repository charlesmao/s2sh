package com.bufoon.service.user.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bufoon.dao.BaseDAO;
import com.bufoon.entity.User;
import com.bufoon.service.user.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource
	private BaseDAO<User> baseDAO;

	public void saveUser(User user) {
		baseDAO.save(user);
	}

	public void updateUser(User user) {
		baseDAO.update(user);
	}

	public User findUserById(int id) {
		return baseDAO.get(User.class, id);
	}

	public void deleteUser(User user) {
		baseDAO.delete(user);
	}

	public List<User> findAllList() {
		return baseDAO.find("from User u order by r.cteateTime");
	}

	public User findUserByNameAndPassword(String username, String password) {
		return baseDAO.get("from User u where u.username=? and u.password=?", new Object[]{username, password});
	}

}
