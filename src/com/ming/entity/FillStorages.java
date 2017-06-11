package com.ming.entity;

import java.util.Date;

import javax.persistence.Column;

import org.hibernate.validator.constraints.NotEmpty;

public class FillStorages {
	/**
	 * 主键ID
题库ID
题干
图片
答案
解析
所属章节
难度

	 */
	private Integer FillStoragesId;
	private Integer storageId;
	@NotEmpty
	@Column(unique=true)
	private String topic;
	private String image;
	@NotEmpty
	private String answer;
	private String analysis;
	private Integer section;
	private Integer  difficulty;
	public Integer getFillStoragesId() {
		return FillStoragesId;
	}
	public void setFillStoragesId(Integer fillStoragesId) {
		FillStoragesId = fillStoragesId;
	}
	public Integer getStorageId() {
		return storageId;
	}
	public void setStorageId(Integer storageId) {
		this.storageId = storageId;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getAnalysis() {
		return analysis;
	}
	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}
	public Integer getSection() {
		return section;
	}
	public void setSection(Integer section) {
		this.section = section;
	}
	public Integer getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}
	

	
}
