package com.ming.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import com.ming.entity.ChoiceStorages;
import com.ming.entity.ComprehensiveStorages;
import com.ming.entity.FillStorages;
import com.ming.entity.TFStorages;
import com.ming.entity.TestPaperChoice;
import com.ming.entity.TestPaperComprehensive;
import com.ming.entity.TestPaperFill;
import com.ming.entity.TestPaperInfo;
import com.ming.entity.TestPaperTF;
import com.ming.service.TestService;
import com.ming.util.AddQuestionParams;
import com.ming.util.ReturnIntUtil;

@Service
public class TestServiceImpl implements TestService{
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * 一层调度*4
	 * 题目类型
	 */
	@Override
	public void moveQuestionsToTestPaper(AddQuestionParams addQuestionParams){
		//1,需要传递变量有，章节数目、、、。
		//2,搬运选择题---获取，类转换，存储
			//科目信息（题库号），章节号，难度数量*3，
				//难度 易数量、、随机数要小于list的的长度并且随机数不能有重复。
		//3,搬运填空、判断、综合。
		//0，，，就跳过，不为零，计数后还要加到paperInfo里！
		moveChoiceToTestPaper( addQuestionParams);
		moveFillToTestPaper( addQuestionParams);
		moveTFToTestPaper( addQuestionParams);
		moveComprehensiveToTestPaper( addQuestionParams);
		
	}
//***********************************************************************************************
	/**
	 * 二层调度*3
	 * 难度
	 * @param addQuestionParams
	 */
	public void moveChoiceToTestPaper(AddQuestionParams addQuestionParams){
		//判断不为零再调度
		moveChoiceToTestPaperEasy(addQuestionParams);
		moveChoiceToTestPaperNormal(addQuestionParams);
		moveChoiceToTestPaperhard(addQuestionParams);
	}

	public void moveChoiceToTestPaperNormal(AddQuestionParams addQuestionParams){
		//根据科目id确定题库ID，不用确定，暂时控制为相等。
				//0,1,2代表三个难度等级,根据易中难搬运三次。
				StringBuffer hql0=new StringBuffer();
				hql0.append("from ChoiceStorages c where c.stoId=");
				hql0.append(addQuestionParams.getSubjectId());
				hql0.append(" and c.difficulty=");
				hql0.append(2);
				hql0.append(" and c.section=");
				hql0.append(addQuestionParams.getSectionNum());
				Query query=sessionFactory.getCurrentSession().createQuery(hql0.toString());
				List <ChoiceStorages> choiceStoragesList=query.list();
				//U生成随机数，然后获取，转化，存储。
				int [] randomNum=ReturnIntUtil.randomCommon(0, choiceStoragesList.size(), addQuestionParams.getNormalChoice());
				if(randomNum.length>0){
					List<TestPaperChoice> selectedList= new ArrayList<TestPaperChoice>();		
					for(int i=0;i<randomNum.length;i++){
						selectedList.add(choicerToTestPaperChoice(addQuestionParams.getTestPaperId(), choiceStoragesList.get(randomNum[i])));
					}
					selectedChoiceListSave(selectedList);
				}
			
	}
	public void moveChoiceToTestPaperhard(AddQuestionParams addQuestionParams){
		//根据科目id确定题库ID，不用确定，暂时控制为相等。
				//0,1,2代表三个难度等级,根据易中难搬运三次。
				StringBuffer hql0=new StringBuffer();
				hql0.append("from ChoiceStorages c where c.stoId=");
				hql0.append(addQuestionParams.getSubjectId());
				hql0.append(" and c.difficulty=");
				hql0.append(3);
				hql0.append(" and c.section=");
				hql0.append(addQuestionParams.getSectionNum());
				Query query=sessionFactory.getCurrentSession().createQuery(hql0.toString());
				List <ChoiceStorages> choiceStoragesList=query.list();
				//U生成随机数，然后获取，转化，存储。
				int [] randomNum=ReturnIntUtil.randomCommon(0, choiceStoragesList.size(), addQuestionParams.getHardChoice());
				if(randomNum.length>0){
					List<TestPaperChoice> selectedList= new ArrayList<TestPaperChoice>();		
					for(int i=0;i<randomNum.length;i++){
						selectedList.add(choicerToTestPaperChoice(addQuestionParams.getTestPaperId(), choiceStoragesList.get(randomNum[i])));
					}
					selectedChoiceListSave(selectedList);
				}
			
	}
	
	public void moveChoiceToTestPaperEasy(AddQuestionParams addQuestionParams){
		//根据科目id确定题库ID，不用确定，暂时控制为相等。
		//0,1,2代表三个难度等级,根据易中难搬运三次。
		StringBuffer hql0=new StringBuffer();
		hql0.append("from ChoiceStorages c where c.stoId=");
		hql0.append(addQuestionParams.getSubjectId());
		hql0.append(" and c.difficulty=");
		hql0.append(1);
		hql0.append(" and c.section=");
		hql0.append(addQuestionParams.getSectionNum());
		Query query=sessionFactory.getCurrentSession().createQuery(hql0.toString());
		List <ChoiceStorages> choiceStoragesList=query.list();
		//U生成随机数，然后获取，转化，存储。
		int [] randomNum=ReturnIntUtil.randomCommon(0, choiceStoragesList.size(), addQuestionParams.getEasyChoice());
		if(randomNum!=null&&randomNum.length>0){
			List<TestPaperChoice> selectedList= new ArrayList<TestPaperChoice>();		
			for(int i=0;i<randomNum.length;i++){
				selectedList.add(choicerToTestPaperChoice(addQuestionParams.getTestPaperId(), choiceStoragesList.get(randomNum[i])));
			}
			selectedChoiceListSave(selectedList);
		}
	}
	/**
	 * 存储
	 * @param selectedList
	 */
	public void selectedChoiceListSave(List<TestPaperChoice> selectedList){
		for (TestPaperChoice testPaperChoice : selectedList) {
			sessionFactory.getCurrentSession().save(testPaperChoice);
		}
	}
	/**
	 * 类转化器
	 * @param choiceStorages
	 * @return
	 */
	public TestPaperChoice choicerToTestPaperChoice(Integer testPaperId,ChoiceStorages choiceStorages){
		TestPaperChoice testPaperChoice=new TestPaperChoice();
		testPaperChoice.setAnalysis(choiceStorages.getAnalysis());
		testPaperChoice.setAnswer(choiceStorages.getAnswer());
		testPaperChoice.setCategory(choiceStorages.getCategory());
		testPaperChoice.setDifficulty(choiceStorages.getDifficulty());
		testPaperChoice.setImage(choiceStorages.getImage());
		testPaperChoice.setOptionA(choiceStorages.getOptionA());
		testPaperChoice.setOptionB(choiceStorages.getOptionB());
		testPaperChoice.setOptionC(choiceStorages.getOptionC());
		testPaperChoice.setOptionD(choiceStorages.getOptionD());
		testPaperChoice.setSection(choiceStorages.getSection());
		testPaperChoice.setTopic(choiceStorages.getTopic());
		testPaperChoice.setTestPaperId(testPaperId);
		return testPaperChoice;
		
	}
//*********************************************************************************************
	/**
	 * 二层调度
	 * 填空
	 */
	public void moveFillToTestPaper(AddQuestionParams addQuestionParams){
		moveFillToTestPaperEasy(addQuestionParams);
		moveFillToTestPaperNormal(addQuestionParams);
		moveFillToTestPaperHard(addQuestionParams);
	}
	public void moveFillToTestPaperEasy(AddQuestionParams addQuestionParams){
		//根据科目id确定题库ID，不用确定，暂时控制为相等。
		//0,1,2代表三个难度等级,根据易中难搬运三次。
		StringBuffer hql0=new StringBuffer();
		hql0.append("from FillStorages c where c.stoId=");
		hql0.append(addQuestionParams.getSubjectId());
		hql0.append(" and c.difficulty=");
		hql0.append(1);
		hql0.append(" and c.section=");
		hql0.append(addQuestionParams.getSectionNum());
		Query query=sessionFactory.getCurrentSession().createQuery(hql0.toString());
		List <FillStorages> fillStoragesList=query.list();
		//U生成随机数，然后获取，转化，存储。
		int [] randomNum=ReturnIntUtil.randomCommon(0, fillStoragesList.size(), addQuestionParams.getEasyfill());
		if(randomNum.length>0){
			List<TestPaperFill> selectedList= new ArrayList<TestPaperFill>();		
			for(int i=0;i<randomNum.length;i++){
				selectedList.add(fillToTestPaperFill(addQuestionParams.getTestPaperId(), fillStoragesList.get(randomNum[i])));
			}
			selectedFillListSave(selectedList);
		}
			
	}
	public void moveFillToTestPaperNormal(AddQuestionParams addQuestionParams){
		//根据科目id确定题库ID，不用确定，暂时控制为相等。
				//0,1,2代表三个难度等级,根据易中难搬运三次。
				StringBuffer hql0=new StringBuffer();
				hql0.append("from FillStorages c where c.stoId=");
				hql0.append(addQuestionParams.getSubjectId());
				hql0.append(" and c.difficulty=");
				hql0.append(2);
				hql0.append(" and c.section=");
				hql0.append(addQuestionParams.getSectionNum());
				Query query=sessionFactory.getCurrentSession().createQuery(hql0.toString());
				List <FillStorages> fillStoragesList=query.list();
				//U生成随机数，然后获取，转化，存储。
				int [] randomNum=ReturnIntUtil.randomCommon(0, fillStoragesList.size(), addQuestionParams.getNormalfill());
				if(randomNum.length>0){
					List<TestPaperFill> selectedList= new ArrayList<TestPaperFill>();		
					for(int i=0;i<randomNum.length;i++){
						selectedList.add(fillToTestPaperFill(addQuestionParams.getTestPaperId(), fillStoragesList.get(randomNum[i])));
					}
					selectedFillListSave(selectedList);
				}
		}
	public void moveFillToTestPaperHard(AddQuestionParams addQuestionParams){
		//根据科目id确定题库ID，不用确定，暂时控制为相等。
				//0,1,2代表三个难度等级,根据易中难搬运三次。
				StringBuffer hql0=new StringBuffer();
				hql0.append("from FillStorages c where c.stoId=");
				hql0.append(addQuestionParams.getSubjectId());
				hql0.append(" and c.difficulty=");
				hql0.append(3);
				hql0.append(" and c.section=");
				hql0.append(addQuestionParams.getSectionNum());
				Query query=sessionFactory.getCurrentSession().createQuery(hql0.toString());
				List <FillStorages> fillStoragesList=query.list();
				//U生成随机数，然后获取，转化，存储。
				int [] randomNum=ReturnIntUtil.randomCommon(0, fillStoragesList.size(), addQuestionParams.getHardfill());
				if(randomNum.length>0){
					List<TestPaperFill> selectedList= new ArrayList<TestPaperFill>();		
					for(int i=0;i<randomNum.length;i++){
						selectedList.add(fillToTestPaperFill(addQuestionParams.getTestPaperId(), fillStoragesList.get(randomNum[i])));
					}
					selectedFillListSave(selectedList);
				}
	}
	/**
		存储
	 * @param selectedList
	 */
	public void selectedFillListSave(List<TestPaperFill> selectedList){
		for (TestPaperFill testPaperFill : selectedList) {
			sessionFactory.getCurrentSession().save(testPaperFill);
		}
	}
	/**
	 * 类转化器
	 * @param testPaperId
	 * @param fillStorages
	 */
	public TestPaperFill fillToTestPaperFill(Integer testPaperId,FillStorages fillStorages){
		TestPaperFill testPaperFill=new TestPaperFill();
		testPaperFill.setAnalysis(fillStorages.getAnalysis());
		testPaperFill.setAnswer(fillStorages.getAnswer());
		testPaperFill.setDifficulty(fillStorages.getDifficulty());
		testPaperFill.setImage(fillStorages.getImage());
		testPaperFill.setTotalScore(2);
		
		testPaperFill.setSection(fillStorages.getSection());
		testPaperFill.setTopic(fillStorages.getTopic());
		testPaperFill.setTestPaperIdId(testPaperId);
		return testPaperFill;
	}
	/**
	 * 二层调度
	 * 判断
	 */
	public void moveTFToTestPaper(AddQuestionParams addQuestionParams){
		moveTFToTestPaperEasy(addQuestionParams);
		moveTFToTestPaperNormal(addQuestionParams);
		moveTFToTestPaperHard(addQuestionParams);
	}
	public void moveTFToTestPaperEasy(AddQuestionParams addQuestionParams){
		//根据科目id确定题库ID，不用确定，暂时控制为相等。
		//0,1,2代表三个难度等级,根据易中难搬运三次。
		StringBuffer hql0=new StringBuffer();
		hql0.append("from TFStorages c where c.stoId=");
		hql0.append(addQuestionParams.getSubjectId());
		hql0.append(" and c.difficulty=");
		hql0.append(1);
		hql0.append(" and c.section=");
		hql0.append(addQuestionParams.getSectionNum());
		Query query=sessionFactory.getCurrentSession().createQuery(hql0.toString());
		List <TFStorages> TFStoragesList=query.list();
		//U生成随机数，然后获取，转化，存储。
		int [] randomNum=ReturnIntUtil.randomCommon(0, TFStoragesList.size(), addQuestionParams.getEasyTF());
		if(randomNum.length>0){
			List<TestPaperTF> selectedList= new ArrayList<TestPaperTF>();		
			for(int i=0;i<randomNum.length;i++){
				selectedList.add(TFToTestPaperTF(addQuestionParams.getTestPaperId(), TFStoragesList.get(randomNum[i])));
			}
			selectedTFistSave(selectedList);
		}
	}
	public void moveTFToTestPaperNormal(AddQuestionParams addQuestionParams){
		//根据科目id确定题库ID，不用确定，暂时控制为相等。
				//0,1,2代表三个难度等级,根据易中难搬运三次。
				StringBuffer hql0=new StringBuffer();
				hql0.append("from TFStorages c where c.stoId=");
				hql0.append(addQuestionParams.getSubjectId());
				hql0.append(" and c.difficulty=");
				hql0.append(2);
				hql0.append(" and c.section=");
				hql0.append(addQuestionParams.getSectionNum());
				Query query=sessionFactory.getCurrentSession().createQuery(hql0.toString());
				List <TFStorages> TFStoragesList=query.list();
				//U生成随机数，然后获取，转化，存储。
				int [] randomNum=ReturnIntUtil.randomCommon(0, TFStoragesList.size(), addQuestionParams.getNormalTF());
				if(randomNum.length>0){
					List<TestPaperTF> selectedList= new ArrayList<TestPaperTF>();		
					for(int i=0;i<randomNum.length;i++){
						selectedList.add(TFToTestPaperTF(addQuestionParams.getTestPaperId(), TFStoragesList.get(randomNum[i])));
					}
					selectedTFistSave(selectedList);
				}	
	}
	public void moveTFToTestPaperHard(AddQuestionParams addQuestionParams){
		//根据科目id确定题库ID，不用确定，暂时控制为相等。
				//0,1,2代表三个难度等级,根据易中难搬运三次。
				StringBuffer hql0=new StringBuffer();
				hql0.append("from TFStorages c where c.stoId=");
				hql0.append(addQuestionParams.getSubjectId());
				hql0.append(" and c.difficulty=");
				hql0.append(3);
				hql0.append(" and c.section=");
				hql0.append(addQuestionParams.getSectionNum());
				Query query=sessionFactory.getCurrentSession().createQuery(hql0.toString());
				List <TFStorages> TFStoragesList=query.list();
				//U生成随机数，然后获取，转化，存储。
				int [] randomNum=ReturnIntUtil.randomCommon(0, TFStoragesList.size(), addQuestionParams.getHardTF());
				if(randomNum.length>0){
					List<TestPaperTF> selectedList= new ArrayList<TestPaperTF>();		
					for(int i=0;i<randomNum.length;i++){
						selectedList.add(TFToTestPaperTF(addQuestionParams.getTestPaperId(), TFStoragesList.get(randomNum[i])));
					}
					selectedTFistSave(selectedList);
				}
	}
	/**
		存储
	 * @param selectedList
	 */
	public void selectedTFistSave(List<TestPaperTF> selectedList){
		for (TestPaperTF testPaperTF : selectedList) {
			sessionFactory.getCurrentSession().save(testPaperTF);
		}
	}
	/**
	 * 类转化器
	 * @param testPaperId
	 * @param fillStorages
	 */
	public TestPaperTF TFToTestPaperTF(Integer testPaperId,TFStorages TFStorages){
		TestPaperTF testPaperTF=new TestPaperTF();
		testPaperTF.setAnalysis(TFStorages.getAnalysis());
		testPaperTF.setAnswer(TFStorages.getAnswer());
		testPaperTF.setDifficulty(TFStorages.getDifficulty());
		testPaperTF.setImage(TFStorages.getImage());
		testPaperTF.setSection(TFStorages.getSection());
		testPaperTF.setTopic(TFStorages.getTopic());
		testPaperTF.setTestPaperId(testPaperId);
		return testPaperTF;
	}
	
	/**
	 * 二层调度
	 * 综合
	 */
	public void moveComprehensiveToTestPaper(AddQuestionParams addQuestionParams){
		moveCompreToTestPaperEasy(addQuestionParams);
		moveCompreToTestPaperNormal(addQuestionParams);
		moveCompreToTestPaperHard(addQuestionParams);
	}
	public void moveCompreToTestPaperEasy(AddQuestionParams addQuestionParams){
		//根据科目id确定题库ID，不用确定，暂时控制为相等。
				//0,1,2代表三个难度等级,根据易中难搬运三次。
				StringBuffer hql0=new StringBuffer();
				hql0.append("from ComprehensiveStorages c where c.stoId=");
				hql0.append(addQuestionParams.getSubjectId());
				hql0.append(" and c.difficulty=");
				hql0.append(1);
				hql0.append(" and c.section=");
				hql0.append(addQuestionParams.getSectionNum());
				Query query=sessionFactory.getCurrentSession().createQuery(hql0.toString());
				List <ComprehensiveStorages> comprehensiveStoragesList=query.list();
				//U生成随机数，然后获取，转化，存储。
				int [] randomNum=ReturnIntUtil.randomCommon(0, comprehensiveStoragesList.size(), addQuestionParams.getEasyComprehensive());
				if(randomNum.length>0){
					List<TestPaperComprehensive> selectedList= new ArrayList<TestPaperComprehensive>();		
					for(int i=0;i<randomNum.length;i++){
						selectedList.add(compreToTestPapercompre(addQuestionParams.getTestPaperId(), comprehensiveStoragesList.get(randomNum[i])));
					}
					selectedCompreistSave(selectedList);
				}
	}
	public void moveCompreToTestPaperNormal(AddQuestionParams addQuestionParams){
		//根据科目id确定题库ID，不用确定，暂时控制为相等。
				//0,1,2代表三个难度等级,根据易中难搬运三次。
				StringBuffer hql0=new StringBuffer();
				hql0.append("from ComprehensiveStorages c where c.stoId=");
				hql0.append(addQuestionParams.getSubjectId());
				hql0.append(" and c.difficulty=");
				hql0.append(2);
				hql0.append(" and c.section=");
				hql0.append(addQuestionParams.getSectionNum());
				Query query=sessionFactory.getCurrentSession().createQuery(hql0.toString());
				List <ComprehensiveStorages> comprehensiveStoragesList=query.list();
				//U生成随机数，然后获取，转化，存储。
				int [] randomNum=ReturnIntUtil.randomCommon(0, comprehensiveStoragesList.size(), addQuestionParams.getNormalComprehensive());
				if(randomNum.length>0){
					List<TestPaperComprehensive> selectedList= new ArrayList<TestPaperComprehensive>();		
					for(int i=0;i<randomNum.length;i++){
						selectedList.add(compreToTestPapercompre(addQuestionParams.getTestPaperId(), comprehensiveStoragesList.get(randomNum[i])));
					}
					selectedCompreistSave(selectedList);
				}
		}
	public void moveCompreToTestPaperHard(AddQuestionParams addQuestionParams){
		//根据科目id确定题库ID，不用确定，暂时控制为相等。
		//0,1,2代表三个难度等级,根据易中难搬运三次。
		StringBuffer hql0=new StringBuffer();
		hql0.append("from ComprehensiveStorages c where c.stoId=");
		hql0.append(addQuestionParams.getSubjectId());
		hql0.append("and c.difficulty=");
		hql0.append(3);
		hql0.append("and c.section=");
		hql0.append(addQuestionParams.getSectionNum());
		Query query=sessionFactory.getCurrentSession().createQuery(hql0.toString());
		List <ComprehensiveStorages> comprehensiveStoragesList=query.list();
		//U生成随机数，然后获取，转化，存储。
		int [] randomNum=ReturnIntUtil.randomCommon(0, comprehensiveStoragesList.size(), addQuestionParams.getHardComprehensive());
		if(randomNum.length>0){
			List<TestPaperComprehensive> selectedList= new ArrayList<TestPaperComprehensive>();		
			for(int i=0;i<randomNum.length;i++){
				selectedList.add(compreToTestPapercompre(addQuestionParams.getTestPaperId(), comprehensiveStoragesList.get(randomNum[i])));
			}
			selectedCompreistSave(selectedList);
		}
	}
	/**
		存储
	 * @param selectedList
	 */
	public void selectedCompreistSave(List<TestPaperComprehensive> selectedList){
		for (TestPaperComprehensive testPaperComprehensive : selectedList) {
			sessionFactory.getCurrentSession().save(testPaperComprehensive);
		}
	}
	/**
	 * 类转化器
	 * @param testPaperId
	 * @param fillStorages
	 */
	public TestPaperComprehensive compreToTestPapercompre(Integer testPaperId,ComprehensiveStorages comprehensiveStorages){
		TestPaperComprehensive testPaperComprehensive=new TestPaperComprehensive();
		testPaperComprehensive.setAnalysis(comprehensiveStorages.getAnalysis());
		testPaperComprehensive.setAnswer(comprehensiveStorages.getAnswer());
		testPaperComprehensive.setDifficulty(comprehensiveStorages.getDifficulty());
		testPaperComprehensive.setImage(comprehensiveStorages.getImage());
		testPaperComprehensive.setSection(comprehensiveStorages.getSection());
		testPaperComprehensive.setTopic(comprehensiveStorages.getTopic());
		testPaperComprehensive.setQuestion(comprehensiveStorages.getQuestion());
		testPaperComprehensive.setTestPaperId(testPaperId);
		return testPaperComprehensive;
	}
//**************************************以上为调度函数*****************************************
	//**************************************以上为调度函数*****************************************
	@Override
	public void testPaperSaveOrUpdate(TestPaperInfo testPaperInfo){
		sessionFactory.getCurrentSession().saveOrUpdate(testPaperInfo);;
	}

	@Override
	public List<TestPaperInfo> getTestPaperInfoByUser(Integer integer) {
		// TODO Auto-generated method stub
		if(integer==null)
			integer=-1;
		String hql="from TestPaperInfo where teacherId="+integer;
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	/**
	 * 四个设置函数
	 */
	@Override
	public void setTestChoice(TestPaperChoice testPaperChoice) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTestFill(TestPaperFill testPaperFill) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTestTF(TestPaperTF testPaperTF) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTestComprehensive(TestPaperComprehensive testPaperComprehensive) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 四个获取函数
	 * @param testPaperId
	 * @return
	 */
	public List<TestPaperComprehensive> getTestCompre(String testPaperId){
		String hql="from TestPaperComprehensive t where t.testPaperId ="+testPaperId;
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	public List<TestPaperTF> getTestTF(String testPaperId){
		String hql="from TestPaperTF t where t.testPaperId ="+testPaperId;
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	public List<TestPaperFill> getTestFill(String testPaperId){
		String hql="from TestPaperFill t where t.testPaperIdId ="+testPaperId;
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	public List<TestPaperChoice> getTestChoice(String testPaperId){
		String hql="from TestPaperChoice t where t.TestPaperId ="+testPaperId;
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

}
