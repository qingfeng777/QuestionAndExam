package com.ming.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ming.entity.Teacher;
import com.ming.entity.User;
import com.ming.service.UserManager;
import com.ming.service.impl.TeacherServiceImpl;


@Controller
@RequestMapping("/user")
public class UserController {

	@Resource(name="userManager")
	private UserManager userManager;
	
	@Autowired
	TeacherServiceImpl teacherService;
	
	@ResponseBody
	@RequestMapping("/prLogin")
	public void prLogin(@RequestParam String userName,String password
			,HttpServletResponse response,PrintWriter out,HttpSession session) {
		// TODO Auto-generated method stub
		User user=userManager.getUserByName(userName);
		Teacher teacher=teacherService.getTeacherByName(userName);

		response.setContentType("text/javascript");
		//学生用户登录
		if(user!=null&&password!=null&&password.equals(user.getPassword())){
			session.setAttribute("user", user);
			session.setAttribute("show", false);
			out.write("{\"success\":"+true+",\"tip\":\"欢迎\"}");
		}else if(teacher!=null&&password!=null&&password.equals(teacher.getPassword())){
			//教师用户登录
			session.setAttribute("user", teacher);
			session.setAttribute("show", true);
			out.write("{\"success\":"+true+",\"tip\":\"欢迎\"}");
		}else{
			out.write("{\"success\":"+false+",\"tip\":\"用户名或密码错误\"} ");
		}
		return;
	}
	
	@RequestMapping("/login")
	public String login(String userName,String password) {
		// TODO Auto-generated method stub
	
		return "redirect:../index.jsp";
	}

	@RequestMapping("/getAllUser")
	public String getAllUser(HttpServletRequest request){

		request.setAttribute("userList", userManager.getAllUser());

		return "index";
	}

	@RequestMapping("/getUser")
	public String getUser(int id,HttpServletRequest request){

		request.setAttribute("user", userManager.getUser(id));
		return "editUser";
	}

	@RequestMapping("/toUserAdd")
	public ModelAndView toAddUser(){
		User user=new User();
		return new ModelAndView("register").addObject(user);
	}

	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public String addUser(@Valid User user,Errors errors,HttpServletRequest request){
		if(errors.getErrorCount()>0){
			System.out.println("tset");
			return "register";
		}
		userManager.addUser(user);

		return "redirect:../index.jsp";
	}

	@RequestMapping("/delUser")
	public void delUser(String id,HttpServletResponse response){

		String result = "{\"result\":\"error\"}";

		if(userManager.delUser(id)){
			result = "{\"result\":\"success\"}";
		}

		response.setContentType("application/json");

		try {
			PrintWriter out = response.getWriter();
			out.write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}