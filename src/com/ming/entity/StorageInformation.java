package com.ming.entity;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class StorageInformation {
	/**
	 * 主键ID
		教师ID
		科目ID
		创建时间
		题库名称
		题库类型--科目题库或者个人题库。
	 */
	private int StorageInformationId;
	private int teacherId;
	private int subjectId;
	private Date cDate;
	@NotEmpty
	private String storageName;
	//0为科目，1为个人。
	private int category;
	public int getStorageInformationId() {
		return StorageInformationId;
	}
	public void setStorageInformationId(int storageInformationId) {
		StorageInformationId = storageInformationId;
	}
	
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public Date getcDate() {
		return cDate;
	}
	public void setcDate(Date cDate) {
		this.cDate = cDate;
	}
	public String getStorageName() {
		return storageName;
	}
	public void setStorageName(String storageName) {
		this.storageName = storageName;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	
	
	
	
	
	

}
