package com.ming.service.impl;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import com.ming.entity.Teacher;
import com.ming.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService{

	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Teacher getTeacherByName(String name) {
		// TODO Auto-generated method stub
		String hql="from Teacher t where t.userName='"+name+"'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return (Teacher)query.uniqueResult();
	}

	@Override
	public Teacher setTeacherByName(Teacher teacher) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Teacher deleteTeacherByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Teacher addTeacherByName(Teacher teacher) {
		// TODO Auto-generated method stub
		return null;
	}

}
