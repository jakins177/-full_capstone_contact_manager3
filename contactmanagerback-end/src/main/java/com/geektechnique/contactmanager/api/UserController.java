package com.geektechnique.contactmanager.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geektechnique.contactmanager.model.User;
import com.geektechnique.contactmanager.service.UserService;

@RequestMapping("contactmanagerapi/v1/user")
@RestController
public class UserController {
	private final UserService userService;

	 @Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	 
	 @CrossOrigin
	 @PostMapping
	    public int addUser(@Valid @NonNull @RequestBody User user){
	       return userService.addUser(user);
	    }
	 
	 @CrossOrigin
	 @PostMapping("/dupes")
	 public int addForDupeUser(@Valid @NonNull @RequestBody User user){
	      return  userService.checkDupes(user);
	    }

}
