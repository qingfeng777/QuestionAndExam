package com.ming.entity;

import java.util.Date;

public class Teacher2Subject {
	/**
	 * 主键ID
		教师ID
		科目ID
		创建时间

	 */
	private Integer Teacher2SubjectId;
	private Integer teacherId;
	private Integer SubjectId;
	private Date Cdate;
	public Integer getTeacher2SubjectId() {
		return Teacher2SubjectId;
	}
	public void setTeacher2SubjectId(Integer teacher2SubjectId) {
		Teacher2SubjectId = teacher2SubjectId;
	}
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	public Integer getSubjectId() {
		return SubjectId;
	}
	public void setSubjectId(Integer subjectId) {
		SubjectId = subjectId;
	}
	public Date getCdate() {
		return Cdate;
	}
	public void setCdate(Date cdate) {
		Cdate = cdate;
	}
	
	

}
