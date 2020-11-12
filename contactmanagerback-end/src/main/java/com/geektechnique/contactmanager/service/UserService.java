package com.geektechnique.contactmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.geektechnique.contactmanager.model.User;
import com.geektechnique.contactmanager.dao.UserDao;

@Service
public class UserService {
	
	private final UserDao userDao;
	
	 @Autowired
	    public UserService(@Qualifier("contactManagerPsql") UserDao userDao) {
	        this.userDao = userDao;
	    }
	 
	 public int addUser(User user){
	        return userDao.insertUser(user);
	    }
	 
	 public int checkDupes(User user){
	        return userDao.checkForDupes(user);
	    }
	 

}
