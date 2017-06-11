package com.ming.entity;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class OperRecordate {
/**
 * Id
fileId
Topic
OperateTime
OperateUser
OperateDeclare

 */
	private String operRecordateId;
	private Integer fileId;
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date odata;
	@NotEmpty
	private String OperateUser;
	private Integer operateDeclare;
	public String getOperRecordateId() {
		return operRecordateId;
	}
	public void setOperRecordateId(String string) {
		this.operRecordateId = string;
	}
	public Integer getFileId() {
		return fileId;
	}
	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}
	public Date getOdata() {
		return odata;
	}
	public void setOdata(Date odata) {
		this.odata = odata;
	}
	public String getOperateUser() {
		return OperateUser;
	}
	public void setOperateUser(String operateUser) {
		OperateUser = operateUser;
	}
	public Integer getOperateDeclare() {
		return operateDeclare;
	}
	public void setOperateDeclare(Integer operateDeclare) {
		this.operateDeclare = operateDeclare;
	}
	
}
