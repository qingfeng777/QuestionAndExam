package com.ming.entity;

import org.hibernate.validator.constraints.NotEmpty;

public class FilePaperChoice {
/**
 * Id
FileId
Category
Topic
Image
OptionA
OptionB
OptionC
OptionD
Answer
Analysis
Section
Difficulty
StudentAnswer
	
 */
	
	private Integer filePaperChoiceId;
	private Integer fileId;
	private Integer category;
	@NotEmpty
	private String topic;
	private String image;
	@NotEmpty
	private String optionA;
	@NotEmpty
	private String optionB;
	@NotEmpty
	private String optionC;
	private String optionD;
	@NotEmpty
	private String answer;
	private String analysis;
	private Integer section;
	private Integer difficulty;
	@NotEmpty
	private String studentAnswer;
	public Integer getFilePaperChoiceId() {
		return filePaperChoiceId;
	}
	public void setFilePaperChoiceId(Integer filePaperChoiceId) {
		this.filePaperChoiceId = filePaperChoiceId;
	}
	public Integer getFileId() {
		return fileId;
	}
	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
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
	public String getOptionA() {
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
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
	
}
