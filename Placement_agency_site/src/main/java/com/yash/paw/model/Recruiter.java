package com.yash.paw.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Recruiter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int rid;
	@NotEmpty(message = " Please Enter Company name.")
	@Size(min = 2, max = 70)
	@NotNull
	private String cname;
	@NotEmpty(message = " Please Enter Location name.")
	@Size(min = 2, max = 30)
	@NotNull
	private String location;
	@NotEmpty(message = " Please Enter userName.")

	@NotNull
	private String username;
	@NotEmpty(message = " Please Enter Password atleast one charecter of Name.")
	@Size(min = 2, max = 30)
	@NotNull
	private String password;
	@NotEmpty(message = " Please Enter Date of Posting.")
	@Size(min = 2, max = 30)
	@NotNull
	private String dop;
	@NotEmpty(message = " Please Enter Name.")
	@Size(min = 2, max = 30)
	@NotNull
	private String postby;

	private String jobroll;

	public Recruiter() {
		super();
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDop() {
		return dop;
	}

	public void setDop(String dop) {
		this.dop = dop;
	}

	public String getPostby() {
		return postby;
	}

	public void setPostby(String postby) {
		this.postby = postby;
	}

	public int getId() {
		return rid;
	}

	public void setId(int id) {
		this.rid = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getJobroll() {
		return jobroll;
	}

	public void setJobroll(String jobroll) {
		this.jobroll = jobroll;
	}

}
