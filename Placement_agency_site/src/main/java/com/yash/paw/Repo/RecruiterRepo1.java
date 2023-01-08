package com.yash.paw.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.yash.paw.model.Recruiter;
import com.yash.paw.model.User;


public interface RecruiterRepo1 extends CrudRepository<Recruiter,Integer> {
	@Query(value = "select * from recruiter r where r.cname like %:keyword% or r.location like %:keyword%", nativeQuery = true)
	 List<Recruiter> findByKeyword(@Param("keyword") String keyword);
	
	public Recruiter findRecruiterBypassword(String username);
}
     