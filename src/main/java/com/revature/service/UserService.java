package com.revature.service;

import com.revature.models.User;
import com.revature.models.UsernamePasswordAuthentication;
import com.revature.repository.UserDao;

public class UserService {

	private UserDao dao;

	public UserService(){
		this.dao = new UserDao();
	}

	public User getUserByUsername(String username) {
		return this.dao.getUserByUsername(username);
	}

	public User register(UsernamePasswordAuthentication registerRequest) {
		return this.dao.createUser(registerRequest);
	}

	public static void main(String[] args) {
		UserService userService = new UserService();
		System.out.println(userService.getUserByUsername("username"));
		UsernamePasswordAuthentication newUser = new UsernamePasswordAuthentication();
		newUser.setUsername("password");
		newUser.setPassword("bad username");
		System.out.print((userService.register(newUser)));
	}
}
