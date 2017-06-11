package com.ming.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ming.entity.ChoiceStorages;
import com.ming.entity.StorageInformation;
import com.ming.entity.Subject;
import com.ming.service.QuestionsService;
import com.ming.service.impl.StoragesServiceimpl;

@Controller
@RequestMapping("/storages")
public class StoragesController {
	
	@Autowired
	StoragesServiceimpl storagesServiceimpl;
	@Autowired
	QuestionsService questionsService;
	
	@ResponseBody
	@RequestMapping(value="/getChoiceSto",method=RequestMethod.GET)
	public List<ChoiceStorages> getChoiceSto(@RequestParam(value="subject",required=false) Integer subjectId){
		System.out.println(subjectId);
		List<ChoiceStorages> choiceStoList=questionsService.getChoiceQuestionBySubject(subjectId);
		return choiceStoList;
	}
	
	
	/**
	 * 通过科目id确定试题对应的科目
	 * 通过题目类型确定四类（选、填等）
	 * 通过操作类型跳不同页面，（单题编辑、批量上传）
	 * @param subjectId
	 * @param questionType
	 * @param operateType
	 * 1，判断跳转方向如果是上传,直接跳，如果是编辑-》2
	 * 2，加载数据
	 * 3，带着数据跳转页面编辑
	 */
	@RequestMapping(value="switchPath",method=RequestMethod.POST)
	public String switchPath(HttpServletRequest request,String subjectId,String questionType,String operateType) {
		// TODO Auto-generated method stub
		request.setAttribute("subjectId", subjectId);

		if ("2".equals(operateType)){ //批量上传
			if("1".equals(questionType)){//上传数据，选择
				return "choice_lots_upload";
			}
			if("2".equals(questionType)){
				return "fill_lots_upload";
			}
			if("3".equals(questionType)){
				return "TF_lots_upload";
			}else{
				return "comprehensive_lots_upload";
			}
					}
		if("1".equals(operateType)){//单题编辑
			if("1".equals(questionType)){//加载数据，选择
				return "choices_edit";
			}
			if("2".equals(questionType)){
				return "fill_edit";
			}
			if("3".equals(questionType)){
				return "TF_edit";
			}else{
				return "comprehensive_edit";
			}
		}
		
		
		return "choices_edit";
	}
	
	/**
	 * 科目添加后去往添加题库
	 * @param subject
	 * @return
	 */
	@RequestMapping(value="/addSubject",method=RequestMethod.POST)
	public ModelAndView addSubject(Subject subject) {
		// TODO Auto-generated method stub
		storagesServiceimpl.saveSubject(subject);
		StorageInformation storageInformation= new StorageInformation();
		return new ModelAndView("creat_storage").addObject(storageInformation);
	}
	/**
	 * 去往添加科目
	 * @return
	 */
	@RequestMapping("/toAddStoSub")
	public ModelAndView toAddSto() {
		// TODO Auto-generated method stub
		Subject subject=new Subject();
		return new ModelAndView("creat_subject").addObject(subject);
	}
	/**
	 * 添加题库，顺便查出
	 * @param req
	 * @param storageInformation
	 * @return
	 */
	@RequestMapping(value="/addSto",method=RequestMethod.POST)
	public String AddSto(HttpServletRequest req,StorageInformation storageInformation) {
		// TODO Auto-generated method stub
		storagesServiceimpl.addStoInfo(storageInformation);
		List<StorageInformation> subjects=storagesServiceimpl.getAllSub();
		req.setAttribute("subjects", subjects);
		return "question_storages";
	}
	@RequestMapping("/toStoShow")
	public String toStoShow(HttpServletRequest req) {
		// TODO Auto-generated method stub
		List<StorageInformation> subjects=storagesServiceimpl.getAllSub();
		req.setAttribute("subjects", subjects);
		return "question_storages";
	}
}
