package com.rest.robert.web.service;

import com.rest.robert.web.models.User;

public interface UserSevice {

	public User getById(long id);

	public void update(User user);

	public User getByEmail(String email);

	public void delete(User user);

	public void create(User user);

}
