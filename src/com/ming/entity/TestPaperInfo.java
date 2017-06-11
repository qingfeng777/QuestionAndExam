package com.ming.entity;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class TestPaperInfo {
	/**
	 * Id
StorageId
BeginTime
EndTime
Location
Proctor
Tape

choiceCount
fillCount
tFCount
comprehensiveCount
choiceTotalScore
TFTotalScore
	 */
	private Integer TestPaperInfoId;
	private Integer subjectId;
	private Integer teacherId;

	@DateTimeFormat(pattern="yyyy-MM-ddHH:mm:ss")
	private Date beginTime;
	@DateTimeFormat(pattern="yyyy-MM-ddHH:mm:ss")
	private Date endTime;
	@NotEmpty
	private String location;
	@NotEmpty
	private String proctor;
	private String tape;
	private Integer choiceCount;
	private Integer fillCount;
	private Integer tFCount;
	private Integer comprehensiveCount;
	private Integer choiceTotalScore;
	private Integer TFTotalScore;
	
	
	
	public Integer getChoiceCount() {
		return choiceCount;
	}
	public void setChoiceCount(Integer choiceCount) {
		this.choiceCount = choiceCount;
	}
	public Integer getFillCount() {
		return fillCount;
	}
	public void setFillCount(Integer fillCount) {
		this.fillCount = fillCount;
	}
	public Integer gettFCount() {
		return tFCount;
	}
	public void settFCount(Integer tFCount) {
		this.tFCount = tFCount;
	}
	public Integer getComprehensiveCount() {
		return comprehensiveCount;
	}
	public void setComprehensiveCount(Integer comprehensiveCount) {
		this.comprehensiveCount = comprehensiveCount;
	}
	public Integer getChoiceTotalScore() {
		return choiceTotalScore;
	}
	public void setChoiceTotalScore(Integer choiceTotalScore) {
		this.choiceTotalScore = choiceTotalScore;
	}
	public Integer getTFTotalScore() {
		return TFTotalScore;
	}
	public void setTFTotalScore(Integer tFTotalScore) {
		TFTotalScore = tFTotalScore;
	}
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	public Integer getTestPaperInfoId() {
		return TestPaperInfoId;
	}
	public void setTestPaperInfoId(Integer testPaperInfoId) {
		TestPaperInfoId = testPaperInfoId;
	}
	public Integer getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getProctor() {
		return proctor;
	}
	public void setProctor(String proctor) {
		this.proctor = proctor;
	}
	public String getTape() {
		return tape;
	}
	public void setTape(String tape) {
		this.tape = tape;
	}
	
}
