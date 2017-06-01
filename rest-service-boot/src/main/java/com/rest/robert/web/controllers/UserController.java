package com.rest.robert.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.robert.web.models.User;
import com.rest.robert.web.service.UserSevice;

/**
 * Class UserController
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserSevice userservice ;

	// ------------------------
	// PUBLIC METHODS
	// ------------------------

	/**
	 * Create a new user with an auto-generated id and email and name as passed
	 * values.
	 */
	@RequestMapping(value = "/create")
	@ResponseBody
	public String create(String email, String name) {
		try {
			User user = new User(email, name);
			userservice.create(user);
		} catch (Exception ex) {
			return "Error creating the user: " + ex.toString();
		}
		return "User succesfully created!";
	}

	/**
	 * Delete the user with the passed id.
	 */
	@RequestMapping(value = "/delete")
	@ResponseBody
	public String delete(long id) {
		try {
			User user = new User(id);
			userservice.delete(user);
		} catch (Exception ex) {
			return "Error deleting the user: " + ex.toString();
		}
		return "User succesfully deleted!";
	}

	/**
	 * Retrieve the id for the user with the passed email address.
	 */
	@RequestMapping(value = "/get-by-email")
	@ResponseBody
	public String getByEmail(String email) {
		String userId;
		try {
			User user = userservice.getByEmail(email);
			userId = String.valueOf(user.getId());
		} catch (Exception ex) {
			return "User not found: " + ex.toString();
		}
		return "The user id is: " + userId;
	}

	/**
	 * Update the email and the name for the user indentified by the passed id.
	 */
	@RequestMapping(value = "/update")
	@ResponseBody
	public String updateName(long id, String email, String name) {
		try {
			User user = userservice.getById(id);
			user.setEmail(email);
			user.setName(name);
			userservice.update(user);
		} catch (Exception ex) {
			return "Error updating the user: " + ex.toString();
		}
		return "User succesfully updated!";
	}

}
