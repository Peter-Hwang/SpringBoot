package com.rest.robert.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.robert.web.dao.UserDao;
import com.rest.robert.web.models.User;

@Service
public class UserServiceImpl implements UserSevice{
	
	@Autowired
	private UserDao userDao;

	@Override
	public User getById(long id) {
		return userDao.getById(id);
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public User getByEmail(String email) {
		return userDao.getByEmail(email);
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
	}

	@Override
	public void create(User user) {
		userDao.create(user);
	}

}
