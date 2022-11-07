package com.hms.service;

import java.util.List;

import com.hms.dto.userDTO;
import com.hms.exception.globalException;
import com.hms.model.user;

public interface userService {

	public user addUser(userDTO u1);
	public List<user> getUser();
	public user updateUser(userDTO u1);
	public String deleteUser(int userid) throws globalException;


}