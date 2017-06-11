package com.ming.entity;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class FileInfo {
/**
 * Id
TestPaperId
UserId
CData
TotalScore
Score
Declare
 */
	private Integer fileInfoId;
	private Integer testPaperId;
	private Integer userId;
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date cData;
	private Integer totalScore;
	private Integer score;
	@NotEmpty
	private String someDeclare;
	private Integer category;
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
	}
	public Integer getFileInfoId() {
		return fileInfoId;
	}
	public void setFileInfoId(Integer fileInfoId) {
		this.fileInfoId = fileInfoId;
	}
	public Integer getTestPaperId() {
		return testPaperId;
	}
	public void setTestPaperId(Integer testPaperId) {
		this.testPaperId = testPaperId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Date getcData() {
		return cData;
	}
	public void setcData(Date cData) {
		this.cData = cData;
	}
	public Integer getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getSomeDeclare() {
		return someDeclare;
	}
	public void setSomeDeclare(String someDeclare) {
		this.someDeclare = someDeclare;
	}
	
	
}
