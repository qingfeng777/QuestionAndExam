package com.ming.entity;

public class tips {
	/**
	 * 
	 * 5-11:试卷信息，添加和编辑的表类似，添加多一些空的，做两个form。
	 * 		添加时，根据设置，抽取不同的试题，放入试卷试题表。
	 * 		难度设置界面，a难度，从各难度的题目里随机抽取多少题。
	 * 		
	 * 
	 * 
	 * 
	 * 3.3.1 表名及其说明
表2-1是本系统所用到的表名及其说明信息。表2-1如下图所示。
表2-1 表名及其说明
表名	表名说明
User
Teacher
Subject
Teacher2Subject	      用户信息表
        教师表
       科目信息表
     教师科目对应表
StorageInformation
ChoiceStorages	题库信息表
选择题表
      FillStorages
      TFStorages	填空题表
判断题表
ComprehensiveStorages	综合题表
TestPaperInfo


**********************************分界线
TestPaperChoice
TestPaperFill
TestPaperTF
TestPaperComprehensive
FileInfo
FilePaperChoice
FilePaperFill
FilePaperTF
FilePaperComprehensive
OperRecordate	试卷信息表
试卷_选择表
试卷_填空表
试卷_判断表
试卷_综合表
档案信息表
档案_试卷_选择表
档案_试卷_填空表
档案_试卷_判断表
档案_试卷_综合表
操作记录表



	 */
}
