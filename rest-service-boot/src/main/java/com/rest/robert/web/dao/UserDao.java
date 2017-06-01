package com.rest.robert.web.dao;

import com.rest.robert.web.models.User;

public interface UserDao {

	public User getById(long id);

	public void update(User user);

	public User getByEmail(String email);

	public void delete(User user);

	public void create(User user);

}
