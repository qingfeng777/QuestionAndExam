package com.ming.entity;

import javax.persistence.Column;

import org.hibernate.validator.constraints.NotEmpty;

public class ComprehensiveStorages {
	/**
	 * Id
storageId

Topic
Image
Question
Answer
Analys
Section
Difficulty

	 */
	private Integer ComprehensiveStoragesId;
	private Integer storageId;
	@NotEmpty
	@Column(unique=true)
	private String topic;
	private String image;
	@NotEmpty
	private String question;
	@NotEmpty
	private String answer;
	private String analysis;
	private Integer section;
	private Integer difficulty;
	
	public Integer getComprehensiveStoragesId() {
		return ComprehensiveStoragesId;
	}
	public void setComprehensiveStoragesId(Integer comprehensiveStoragesId) {
		ComprehensiveStoragesId = comprehensiveStoragesId;
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
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
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
