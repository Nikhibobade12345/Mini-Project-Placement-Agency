package com.yash.paw.service;


import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.yash.paw.Repo.UserRepo1;

import com.yash.paw.model.User;

import java.util.Optional;

@Service

public class UserService1 {
	@Autowired
	UserRepo1 objSR;

	public int addUser(User objS) {
		User obj2 = objSR.save(objS);
		return obj2.getUserid();
	}

	

	public List<User> getAllUser() {
		List<User> slist = new ArrayList<User>();

		objSR.findAll().forEach(slist::add);
		return slist;
	}

	public Optional<User> getFile(Integer fileId) {
		return objSR.findById(fileId);
	}
	
	
	 
	
    
}
