package com.ming.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ming.entity.FileInfo;
import com.ming.entity.FilePaperChoice;
import com.ming.entity.FilePaperComprehensive;
import com.ming.entity.FilePaperFill;
import com.ming.entity.FilePaperTF;
import com.ming.entity.TestPaperChoice;
import com.ming.entity.TestPaperComprehensive;
import com.ming.entity.TestPaperFill;
import com.ming.entity.TestPaperTF;
import com.ming.service.impl.ScoreAndFileServiceImpl;

@Controller
@RequestMapping("score")
public class ScoreController {
	
	@Autowired
	ScoreAndFileServiceImpl scoreAndFileServiceImpl;
	
	@RequestMapping("markPaper")
	public String markPaper(@RequestParam(value="paperId",required=false) String testPaperId,HttpServletRequest req){
		//加载四个试题list，然后放到request，跳转
		List<FilePaperFill> fillList=scoreAndFileServiceImpl.getFillByfileId(Integer.parseInt(testPaperId));
		List<FilePaperComprehensive> compreList=scoreAndFileServiceImpl.getCompreByfileId(Integer.parseInt(testPaperId));

		req.setAttribute("fillList", fillList);
		req.setAttribute("compreList", compreList);
		
		//需要两个model类吗
		FilePaperFill	fill=new FilePaperFill();
		FilePaperComprehensive comprehensive=new FilePaperComprehensive();
		req.setAttribute("fill", fill);
		req.setAttribute("comprehensive", comprehensive);
		
		return "scoreAndFile/mark_paper";
	}
	/**
	 * 通过testPaperId，查询出来试卷，未判卷档案信息
	 * @return
	 */
	@RequestMapping("mark")
	public String mark(HttpServletRequest req,@RequestParam(value="search",required=false) String id){
		if(id==null){
			id="-1";
		}
		List<FileInfo> fileList= scoreAndFileServiceImpl.searchScoreByPaperId(Integer.parseInt(id));
		req.setAttribute("fileList", fileList);
		return "scoreAndFile/mark_papers";
	}
	/**
	 * 查询分数的函数*2
	 * @param req
	 * @param id
	 * @return
	 */
	@RequestMapping("studentSearchScore")
	public String studentSearchScore(HttpServletRequest req,@RequestParam(value="search",required=false) String id){
		if(id==null){
			id="-1";
		}
		List<FileInfo> fileList= scoreAndFileServiceImpl.searchScoreByUserId(Integer.parseInt(id));
		req.setAttribute("fileList", fileList);
		return "scoreAndFile/student_score";
	}
	@RequestMapping("searchScore")
	public String searchScore(HttpServletRequest req,@RequestParam(value="search",required=false) String id){
		if(id==null){
			id="-1";
		}
		List<FileInfo> fileList= scoreAndFileServiceImpl.searchScoreByUserId(Integer.parseInt(id));
		req.setAttribute("fileList", fileList);
		return "scoreAndFile/teach_score";
	}

}
