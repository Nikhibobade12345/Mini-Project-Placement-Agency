package com.yash.paw.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.paw.Repo.RecruiterRepo1;
import com.yash.paw.model.Recruiter;
import com.yash.paw.model.User;

@Service
public class RecruiterService1 {
	@Autowired
	RecruiterRepo1 objSR1;

	public int addRecruiter(Recruiter objstd1) {
		Recruiter obj3 = objSR1.save(objstd1);
		return obj3.getRid();
	}

	List<Recruiter> slist1 = new ArrayList<Recruiter>();

	

	public List<Recruiter> getByKeyword(String keyword) {
		return objSR1.findByKeyword(keyword);
	}

	public List<Recruiter> getAllRecruiters() {
		List<Recruiter> list = (List<Recruiter>) objSR1.findAll();
		return list;
	}
}
