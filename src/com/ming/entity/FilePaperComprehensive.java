package com.ming.entity;

import org.hibernate.validator.constraints.NotEmpty;

public class FilePaperComprehensive {
/**
 * Id
fileId
Topic
Image
Question
Answer
Analys
Section
Difficulty
StudentAnswer
Score

 */
	private Integer filePaperComprehensiveId;
	private Integer fileId;
	@NotEmpty
	private String topic;
	private String image;
	@NotEmpty
	private String question;
	@NotEmpty
	private String answer;
	private String analysis;
	private Integer section;
	private Integer difficulty;
	@NotEmpty
	private String studentAnswer;
	private Integer score;
	public Integer getFilePaperComprehensiveId() {
		return filePaperComprehensiveId;
	}
	public void setFilePaperComprehensiveId(Integer filePaperComprehensiveId) {
		this.filePaperComprehensiveId = filePaperComprehensiveId;
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
