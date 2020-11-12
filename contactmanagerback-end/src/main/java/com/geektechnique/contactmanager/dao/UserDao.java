package com.geektechnique.contactmanager.dao;

import java.util.List;

import com.geektechnique.contactmanager.model.User;

public interface UserDao {
	int insertUser(User user);
	int checkForDupes(User user);

}
