package com.ming.entity;



import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.internal.NotNull;

@Entity
public class User implements Serializable{

	/*
	*主键ID
	用户名
	密码
	入学时间
	所在城市
	用户性别
	邮箱
	登录次数
	年龄
	专业
	手机号
	班级

	*
	*/
	private int userId;
	@NotEmpty
	@Column(unique=true)
	private String userName;
	@NotEmpty
	private String password;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date rdate;
	private String city;
	//0男生，1女生
	private int gender;
	@Email
	@Column(unique=true)
	private String email;
	private int signCount;
	private int age;
	
	@NotEmpty
	private String major;
	@NotEmpty
	@Column(unique=true)
	private String mobilePhone;
	private String classs;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getRdate() {
		return rdate;
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSignCount() {
		return signCount;
	}
	public void setSignCount(int signCount) {
		this.signCount = signCount;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getClasss() {
		return classs;
	}
	public void setClasss(String classs) {
		this.classs = classs;
	}
	
	
	
	
	
	



}
