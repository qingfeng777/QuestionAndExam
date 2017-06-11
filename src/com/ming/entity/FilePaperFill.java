package com.ming.entity;

import org.hibernate.validator.constraints.NotEmpty;

public class FilePaperFill {
/**
 * Id
FileId
Topic
Image
Answer
Analysis
Section
Difficulty
StudentAnswer
Score

 */
	private Integer filePaperFillId;
	private Integer fileId;
	@NotEmpty
	private String topic;
	private String image;
	@NotEmpty
	private String answer;
	private String analysis;
	private Integer section;
	private Integer  difficulty;
	@NotEmpty
	private String studentAnswer;
	private Integer score;
	public Integer getFilePaperFillId() {
		return filePaperFillId;
	}
	public void setFilePaperFillId(Integer filePaperFillId) {
		this.filePaperFillId = filePaperFillId;
	}
	public Integer getFileId() {
		return fileId;
	}
	public void setFileId(Integer fileId) {
		this.fileId = fileId;
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
	public String getStudentAnswer() {
		return studentAnswer;
	}
	public void setStudentAnswer(String studentAnswer) {
		this.studentAnswer = studentAnswer;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	
}
