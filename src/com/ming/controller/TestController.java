package com.ming.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ming.entity.FilePaperChoice;
import com.ming.entity.FilePaperComprehensive;
import com.ming.entity.FilePaperFill;
import com.ming.entity.FilePaperTF;
import com.ming.entity.Teacher;
import com.ming.entity.TestPaperChoice;
import com.ming.entity.TestPaperComprehensive;
import com.ming.entity.TestPaperFill;
import com.ming.entity.TestPaperInfo;
import com.ming.entity.TestPaperTF;
import com.ming.service.impl.TestServiceImpl;
import com.ming.util.AddQuestionParams;

@Controller
@RequestMapping("/tests")
public class TestController {
	
	@Autowired
	TestServiceImpl testServiceImpl;
	
	/**
	 * 学生参加考试
	 * @param testPaperId
	 * @param req
	 * @return
	 */
	@RequestMapping("attendTest")
	public String attendTest(@RequestParam(value="paperId",required=false) String testPaperId,HttpServletRequest req){
		//加载四个试题list，然后放到request，跳转
		List<TestPaperComprehensive> compreList=testServiceImpl.getTestCompre(testPaperId);
		List<TestPaperTF> TFList=testServiceImpl.getTestTF(testPaperId);
		List<TestPaperFill> fillList=testServiceImpl.getTestFill(testPaperId);
		List<TestPaperChoice> choiceList=testServiceImpl.getTestChoice(testPaperId);
		
		req.setAttribute("compreList", compreList);
		req.setAttribute("TFList", TFList);
		req.setAttribute("fillList", fillList);
		req.setAttribute("choiceList", choiceList);
		
		//需要四个model类吗
		FilePaperChoice choice=new FilePaperChoice();
		FilePaperFill	fill=new FilePaperFill();
		FilePaperTF paperTF=new FilePaperTF();
		FilePaperComprehensive comprehensive=new FilePaperComprehensive();
		req.setAttribute("choice", choice);
		req.setAttribute("fill", fill);
		req.setAttribute("paperTF", paperTF);
		req.setAttribute("comprehensive", comprehensive);
		
		return "testRelate/student_test";
	}
	/**
	 * 学生去试卷展示页面
	 * @return
	 */
	@RequestMapping("tostudentTestInfo")
	public String tostudentTestInfo(HttpServletRequest req,@RequestParam(value="search",required=false) String id){
		if(id==null){
			id="-1";
		}
		List<TestPaperInfo> testPaperList= testServiceImpl.getTestPaperInfoByUser(Integer.parseInt(id));
		req.setAttribute("testPaperList", testPaperList);
		return "testRelate/student_test_show";
	}
	/**
	 * 去试题展示编辑页面
	 * @param testPaperId
	 */
	@RequestMapping("toEditTestPaper")
	public String toEditTestPaper(@RequestParam(value="paperId",required=false) String testPaperId,HttpServletRequest req){
		//加载四个试题list，然后放到request，跳转
		List<TestPaperComprehensive> compreList=testServiceImpl.getTestCompre(testPaperId);
		List<TestPaperTF> TFList=testServiceImpl.getTestTF(testPaperId);
		List<TestPaperFill> fillList=testServiceImpl.getTestFill(testPaperId);
		List<TestPaperChoice> choiceList=testServiceImpl.getTestChoice(testPaperId);
		
		req.setAttribute("compreList", compreList);
		req.setAttribute("TFList", TFList);
		req.setAttribute("fillList", fillList);
		req.setAttribute("choiceList", choiceList);
		
		//需要四个model类吗
		TestPaperChoice choice=new TestPaperChoice();
		TestPaperFill fill=new TestPaperFill();
		TestPaperTF paperTF=new TestPaperTF();
		TestPaperComprehensive comprehensive=new TestPaperComprehensive();
		req.setAttribute("choice", choice);
		req.setAttribute("fill", fill);
		req.setAttribute("paperTF", paperTF);
		req.setAttribute("comprehensive", comprehensive);
		
		return "testRelate/test_question_show";
	}
	
	/**
	 * 根据参数类里边的参数，搬运试题。
	 * @param addQuestionParams
	 * @return
	 */
	@RequestMapping("/moveQuestions")
	public ModelAndView moveQuestionsToTestPaper(AddQuestionParams filladdQuestionParams){
		testServiceImpl.moveQuestionsToTestPaper(filladdQuestionParams);
		AddQuestionParams addQuestionParams=new AddQuestionParams();
		return new ModelAndView("add_test_questions").addObject(addQuestionParams);
	}
	/**
	 * 保存试卷信息并跳转，可通过id属性判断跳转
	 * @param req
	 * @param testPaperInfo
	 * @return
	 */
	@RequestMapping("/testPaperSaveOrUpdate")
	public ModelAndView testPaperSaveOrUpdate(HttpServletRequest req,TestPaperInfo testPaperInfo){
		String page="testRelate/testpaper_show";//修改
		if(testPaperInfo.getTestPaperInfoId()==null)//添加
			page="testRelate/add_test_questions";
		testServiceImpl.testPaperSaveOrUpdate(testPaperInfo);
		req.setAttribute("testPaperInfo", testPaperInfo);
		AddQuestionParams addQuestionParams=new AddQuestionParams();
		return new ModelAndView(page).addObject(addQuestionParams);
	}
	/**
	 * 跳转添加界面
	 * @return
	 */
	@RequestMapping("/toPaperAdd")
	public ModelAndView paperAdd(){
		TestPaperInfo testPaperInfo=new TestPaperInfo();
		return new ModelAndView("testRelate/testpaper_add").addObject(testPaperInfo);
	}
	
	/**
	 * 根据登录信息获取用户对应的试卷信息
	 * @return
	 */
	@RequestMapping("/getTestPaperInfos")
	public String getTestPaperInfos(HttpSession session,HttpServletRequest req){
		Teacher teacher=(Teacher) session.getAttribute("user");
		if(teacher==null)
			return "redirect:/htmlPage/login.html";
		List<TestPaperInfo> testPaperList= testServiceImpl.getTestPaperInfoByUser(teacher.getTeacherId());
		req.setAttribute("testPaperList", testPaperList);
		return "testRelate/testpaper_show";
	}
}

