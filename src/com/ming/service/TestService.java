package com.ming.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ming.entity.TestPaperChoice;
import com.ming.entity.TestPaperComprehensive;
import com.ming.entity.TestPaperFill;
import com.ming.entity.TestPaperInfo;
import com.ming.entity.TestPaperTF;
import com.ming.util.AddQuestionParams;

@Service
public interface TestService {
	/**
	 * 根据当前登录用户获取试卷信息
	 * @return
	 */
	public List<TestPaperInfo> getTestPaperInfoByUser(Integer teacherId);
	
	/**
	 * 编辑试卷中的选择题、填空题、判断题、综合题等。
	 * @param testPaperChoice
	 */
	public void setTestChoice(TestPaperChoice testPaperChoice);
	public void setTestFill(TestPaperFill testPaperFill);
	public void setTestTF(TestPaperTF testPaperTF);
	public void setTestComprehensive(TestPaperComprehensive testPaperComprehensive);
	/**
	 * 保存或者更新试卷信息
	 * @param testPaperInfo
	 */
	public void testPaperSaveOrUpdate(TestPaperInfo testPaperInfo);
	/**
	 * 根据参数类里边的参数，搬运试题。
	 * @param addQuestionParams
	 */
	public void moveQuestionsToTestPaper(AddQuestionParams addQuestionParams);

}
