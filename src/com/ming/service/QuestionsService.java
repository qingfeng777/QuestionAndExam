package com.ming.service;

import java.util.List;

import com.ming.entity.ChoiceStorages;

/**
 * 对题目的操作
 * @author 素青
 *
 */
public interface QuestionsService {
	/**
	 * 按科目，加载选择题
	 */
	public List<ChoiceStorages> getChoiceQuestionBySubject(Integer subjectId);
	/**
	 * 按科目，加载填空题
	 */
	public List<ChoiceStorages> getFillQuestionBySubject(String subjectId);
	/**
	 * 按科目，加载判断题
	 */
	public List<ChoiceStorages> getTFQuestionBySubject(String subjectId);
	/**
	 * 按科目，加载综合题
	 */
	public List<ChoiceStorages> getComprehensiveQuestionBySubject(String subjectId);

}
