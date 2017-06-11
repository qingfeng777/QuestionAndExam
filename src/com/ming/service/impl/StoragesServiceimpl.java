package com.ming.service.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ming.entity.StorageInformation;
import com.ming.entity.Subject;
import com.ming.service.StoragesService;

@Service
public class StoragesServiceimpl  implements StoragesService{
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void saveSubject(Subject subject) {
		// TODO Auto-generated method stub
		subject.setCdate(new Date());
		Session session=sessionFactory.getCurrentSession();
		session.save(subject);
		session.flush();
	}

	@Override
	public void addStoInfo(StorageInformation storageInformation) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(storageInformation);
	}

	@Override
	public List<StorageInformation> getAllSto() {
		// TODO Auto-generated method stub
		String hql="from StorageInformation";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	
	@Override
	public List<StorageInformation> getAllSub() {
		// TODO Auto-generated method stub
		String hql="from Subject";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

}
