package com.ming.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import com.ming.entity.ChoiceStorages;
import com.ming.service.QuestionsService;

@Service
public class QuestionsServiceImpl implements QuestionsService {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@Override
	public List<ChoiceStorages> getChoiceQuestionBySubject(Integer subjectId) {
		// TODO Auto-generated method stub
		StringBuffer hql=new StringBuffer();
		hql.append("from ChoiceStorages");
		if(subjectId!=null){
			hql.append(" where stoId= ");
			hql.append(subjectId);
		}
		//String hql="from ChoiceStorages where id="+subjectId;
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());

		return query.list();
	}

	@Override
	public List<ChoiceStorages> getFillQuestionBySubject(String subjectId) {
		// TODO Auto-generated method stub
		StringBuffer hql=new StringBuffer();
		hql.append("from FillStorages where id=");
		hql.append(subjectId);
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());

		return query.list();
	}

	@Override
	public List<ChoiceStorages> getTFQuestionBySubject(String subjectId) {
		// TODO Auto-generated method stub
		StringBuffer hql=new StringBuffer();
		hql.append("from TFStorages where id=");
		hql.append(subjectId);
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());

		return query.list();
	}

	@Override
	public List<ChoiceStorages> getComprehensiveQuestionBySubject(String subjectId) {
		// TODO Auto-generated method stub
		StringBuffer hql=new StringBuffer();
		hql.append("from ComprehensiveStorages where id=");
		hql.append(subjectId);
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());

		return query.list();
	}
	
}
