package com.ming.entity;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class Subject {
	/**
	 * 主键ID
		科目名称
		简介
		当前教学所用书本信息
		创建时间
		章节数目
		章节1信息
		章节2信息
		章节3信息
		章节4信息
		章节5信息
		章节6信息
		章节7信息
		章节8信息
		章节9信息
		章节10信息
		章节11信息
		章节12信息
		章节13信息
		章节14信息
		章节15信息

	 */
	
	private Integer SubjectId;
	@NotEmpty
	private String subName;
	@NotEmpty
	private String bookDesc;
	@NotEmpty
	private String bookInfo;
	
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date cdate;
	
	private Integer sectionNum;
	//预设十五个章节
	private String SOneDesc;
	private String STwoDesc;
	private String SThreeDesc;
	private String SFourDesc;
	private String SFiveDesc;
	private String SSixDesc;
	private String SSevenDesc;
	private String SEightDesc;
	private String SNineDesc;
	private String STenDesc;
	private String SElevenDesc;
	private String STwelveDesc;
	private String SThirteenDesc;
	private String SFourteenOneDesc;
	private String SFifteenDesc;
	public Integer getSubjectId() {
		return SubjectId;
	}
	public void setSubjectId(Integer subjectId) {
		SubjectId = subjectId;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public String getBookDesc() {
		return bookDesc;
	}
	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}
	public String getBookInfo() {
		return bookInfo;
	}
	public void setBookInfo(String bookInfo) {
		this.bookInfo = bookInfo;
	}
	public Date getCdate() {
		return cdate;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	public Integer getSectionNum() {
		return sectionNum;
	}
	public void setSectionNum(Integer sectionNum) {
		this.sectionNum = sectionNum;
	}
	public String getSOneDesc() {
		return SOneDesc;
	}
	public void setSOneDesc(String sOneDesc) {
		SOneDesc = sOneDesc;
	}
	public String getSTwoDesc() {
		return STwoDesc;
	}
	public void setSTwoDesc(String sTwoDesc) {
		STwoDesc = sTwoDesc;
	}
	public String getSThreeDesc() {
		return SThreeDesc;
	}
	public void setSThreeDesc(String sThreeDesc) {
		SThreeDesc = sThreeDesc;
	}
	public String getSFourDesc() {
		return SFourDesc;
	}
	public void setSFourDesc(String sFourDesc) {
		SFourDesc = sFourDesc;
	}
	public String getSFiveDesc() {
		return SFiveDesc;
	}
	public void setSFiveDesc(String sFiveDesc) {
		SFiveDesc = sFiveDesc;
	}
	public String getSSixDesc() {
		return SSixDesc;
	}
	public void setSSixDesc(String sSixDesc) {
		SSixDesc = sSixDesc;
	}
	public String getSSevenDesc() {
		return SSevenDesc;
	}
	public void setSSevenDesc(String sSevenDesc) {
		SSevenDesc = sSevenDesc;
	}
	public String getSEightDesc() {
		return SEightDesc;
	}
	public void setSEightDesc(String sEightDesc) {
		SEightDesc = sEightDesc;
	}
	public String getSNineDesc() {
		return SNineDesc;
	}
	public void setSNineDesc(String sNineDesc) {
		SNineDesc = sNineDesc;
	}
	public String getSTenDesc() {
		return STenDesc;
	}
	public void setSTenDesc(String sTenDesc) {
		STenDesc = sTenDesc;
	}
	public String getSElevenDesc() {
		return SElevenDesc;
	}
	public void setSElevenDesc(String sElevenDesc) {
		SElevenDesc = sElevenDesc;
	}
	public String getSTwelveDesc() {
		return STwelveDesc;
	}
	public void setSTwelveDesc(String sTwelveDesc) {
		STwelveDesc = sTwelveDesc;
	}
	public String getSThirteenDesc() {
		return SThirteenDesc;
	}
	public void setSThirteenDesc(String sThirteenDesc) {
		SThirteenDesc = sThirteenDesc;
	}
	public String getSFourteenOneDesc() {
		return SFourteenOneDesc;
	}
	public void setSFourteenOneDesc(String sFourteenOneDesc) {
		SFourteenOneDesc = sFourteenOneDesc;
	}
	public String getSFifteenDesc() {
		return SFifteenDesc;
	}
	public void setSFifteenDesc(String sFifteenDesc) {
		SFifteenDesc = sFifteenDesc;
	}
	
}
