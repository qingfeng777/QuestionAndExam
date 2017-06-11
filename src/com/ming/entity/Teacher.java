package com.ming.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.internal.NotNull;

public class Teacher implements Serializable{
	/**
	 * 主键ID
	 *  教学科目
		用户名
		密码
		注册时间
		所在城市
		邮箱
		登录次数
		年龄
		电话
		性别
		私人密码
		教学编号
		
	

	 */
	private Integer TeacherId;
	
	private Integer subjectId;
	@NotEmpty
	private String userName;
	@NotEmpty
	private String password;
	@DateTimeFormat(pattern="YYYY-MM-DD")
	private Date rdate;
	private String city;
	@Email
	private String email;
	private Integer signCount;
	
	private Integer age;
	@NotEmpty
	private String phoneNum;
	private Integer gender;
	@NotEmpty
	private String privatePwd;
	@NotEmpty
	private String teachCode;
	public Integer getTeacherId() {
		return TeacherId;
	}
	public void setTeacherId(Integer teacherId) {
		TeacherId = teacherId;
	}
	public Integer getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getSignCount() {
		return signCount;
	}
	public void setSignCount(Integer signCount) {
		this.signCount = signCount;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getPrivatePwd() {
		return privatePwd;
	}
	public void setPrivatePwd(String privatePwd) {
		this.privatePwd = privatePwd;
	}
	public String getTeachCode() {
		return teachCode;
	}
	public void setTeachCode(String teachCode) {
		this.teachCode = teachCode;
	}
	
	
	
	
	
	
	
}
