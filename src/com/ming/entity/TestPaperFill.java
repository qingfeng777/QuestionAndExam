package com.ming.entity;

import org.hibernate.validator.constraints.NotEmpty;

public class TestPaperFill {
/**
 * Id
TestPaperId
Topic
Image
Answer
Analysis
Section
Difficulty
totalScore
 */
	private Integer testPaperFillId;
	private Integer testPaperIdId;
	@NotEmpty
	private String topic;
	private String image;
	@NotEmpty
	private String answer;
	private String analysis;
	private Integer section;
	private Integer  difficulty;
	private Integer totalScore;
	
	public Integer getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}
	public Integer getTestPaperFillId() {
		return testPaperFillId;
	}
	public void setTestPaperFillId(Integer testPaperFillId) {
		this.testPaperFillId = testPaperFillId;
	}
	public Integer getTestPaperIdId() {
		return testPaperIdId;
	}
	public void setTestPaperIdId(Integer testPaperIdId) {
		this.testPaperIdId = testPaperIdId;
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
