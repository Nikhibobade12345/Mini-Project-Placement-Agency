package com.yash.paw.Repo;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yash.paw.model.User;
@Repository
public interface UserRepo1 extends JpaRepository<User,Integer> {
	
	public User findUserBypassword(String username);
	
	
	
}
	

	


