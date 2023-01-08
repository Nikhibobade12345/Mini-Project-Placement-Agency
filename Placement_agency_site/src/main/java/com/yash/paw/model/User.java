package com.yash.paw.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;

	@NotEmpty(message = " Please Enter First name.")
	@Size(min = 2, max = 30)
	@NotNull
	private String fname;
	@NotEmpty(message = " Please Enter Last name.")
	@Size(min = 2, max = 30)
	@NotNull
	private String lname;
	@NotEmpty(message = " Please Enter Gender.")
	@Size(min = 2, max = 30)
	@NotNull
	private String gender;
	@NotEmpty(message = " Please Enter userName.")
	@Size(min = 2, max = 15)
	@NotNull
	private String username;
	@NotEmpty(message = " Please Enter Password atleast one charecter of Name.")
	@Size(min = 2, max = 30)
	@NotNull
	private String password;
	@NotEmpty(message = " Please Enter email.")
	@Size(min = 2, max = 30)
	@NotNull
	private String email;
	@NotEmpty(message = " Please Enter Date of birth.")
	@Size(min = 2, max = 30)
	@NotNull
	private String dob;
	@NotEmpty(message = " Please Enter Mobile Number.")
	@Size(min = 10, max = 10)
	@NotNull
	private String mobno;
	@NotEmpty(message = " Please Enter Qualification.")
	@NotNull
	private String qualification;
	@NotEmpty(message = " Please Enter Passing Year.")
	@Size(min = 4, max = 20)
	@NotNull
	private String passingYear;
	@NotEmpty(message = " Please Enter Collage Name.")
	@NotNull
	private String collgename;
	@NotEmpty(message = " Please Enter Job Roll.")

	private String jobroll;

	private String skills;
	@NotEmpty(message = " Please Enter City.")
	@Size(min = 4, max = 20)
	@NotNull
	private String city;
	@NotEmpty(message = " Please Enter State.")
	@Size(min = 4, max = 20)
	@NotNull
	private String state;
	@NotEmpty(message = " Please Enter pincode.")

	@Size(min = 4, max = 6)
	private String pincode;
	@NotEmpty(message = " Please Enter Job Type.")
	@NotNull
	private String jobtype;
	@NotEmpty(message = " Please Enter Language.")
	@NotNull
	private String lang;
	@NotEmpty(message = " Please upload Document.")
	@NotNull
	private String docname;
	private String doctype;

	
	public User() {
		super();
	}

	public String getDoctype() {
		return doctype;
	}

	public void setDoctype(String doctype) {
		this.doctype = doctype;
	}

	public void setDocname(String docname) {
		this.docname = docname;
	}

	public String getDocname() {
		return docname;
	}

	

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getMobno() {
		return mobno;
	}

	public void setMobno(String mobno) {
		this.mobno = mobno;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getPassingYear() {
		return passingYear;
	}

	public void setPassingYear(String passingYear) {
		this.passingYear = passingYear;
	}

	public String getCollgename() {
		return collgename;
	}

	public void setCollgename(String collgename) {
		this.collgename = collgename;
	}

	public String getJobroll() {
		return jobroll;
	}

	public void setJobroll(String jobroll) {
		this.jobroll = jobroll;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getJobtype() {
		return jobtype;
	}

	public void setJobtype(String jobtype) {
		this.jobtype = jobtype;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	

}
