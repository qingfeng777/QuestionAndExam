package com.ming.entity;

import org.hibernate.validator.constraints.NotEmpty;

public class TestPaperTF {
/**
 * Id
TestPaperId
Topic
Image
Answer
Analysis
Section
Difficulty

 */
	private Integer testPaperTFId;
	private Integer testPaperId;
	@NotEmpty
	private String topic;
	private String image;
	@NotEmpty
	private String answer;
	private String analysis;
	private Integer section;
	private Integer difficulty;
	public Integer getTestPaperTFId() {
		return testPaperTFId;
	}
	public void setTestPaperTFId(Integer testPaperTFId) {
		this.testPaperTFId = testPaperTFId;
	}
	public Integer getTestPaperId() {
		return testPaperId;
	}
	public void setTestPaperId(Integer testPaperId) {
		this.testPaperId = testPaperId;
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
