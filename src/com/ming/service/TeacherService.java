package com.ming.service;

import com.ming.entity.Teacher;

public interface TeacherService {
	/**
	 * 名称获取教师、曾、删、改
	 * @param name
	 * @return
	 */
	public Teacher getTeacherByName(String name);
	
	public Teacher setTeacherByName(Teacher teacher);
	public Teacher deleteTeacherByName(String name);
	public Teacher addTeacherByName(Teacher teacher);
}
