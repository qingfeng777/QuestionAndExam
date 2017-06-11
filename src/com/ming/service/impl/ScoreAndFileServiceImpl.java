package com.ming.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ming.entity.FileInfo;
import com.ming.entity.FilePaperComprehensive;
import com.ming.entity.FilePaperFill;
import com.ming.entity.OperRecordate;
import com.ming.service.ScoreAndFileService;

@Service
@Component
public class ScoreAndFileServiceImpl implements ScoreAndFileService{
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	public List<FilePaperFill> getFillByfileId(Integer id){
		String hql ="from FilePaperFill where fileId = "+id;
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	public List<FilePaperComprehensive> getCompreByfileId(Integer id){
		String hql ="from FilePaperComprehensive where fileId = "+id;
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Override
	public List<FileInfo> searchScoreByUserId(Integer userId) {
		if(userId==null)
			userId=-1;
		String hql="from FileInfo where userId="+userId;
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	public List<FileInfo> searchScoreByPaperId(Integer id){
		if(id==null)
			id=-1;
		String hql="from FileInfo where category = 0 and testPaperId="+id;
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	
	public List<FileInfo> searchScoreByPaperIded(String id,String userId){
		
		String hql="from FileInfo where 1 = 1";//category
		if(id!=null&&!"".equals(id))
			hql+=" and testPaperId="+id;
		if(userId!=null&&!"".equals(userId))
			hql+=" and userId ="+userId;
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}


	public void saveOperRecordate(OperRecordate operRecordate) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(operRecordate);
		sessionFactory.getCurrentSession().flush();
	}


	public void saveFileCompre(FilePaperComprehensive filePaperComprehensive) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(filePaperComprehensive);
	}
	public void saveFilFill(FilePaperFill fill) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(fill);
	}


	public List<OperRecordate> searchOperaByidOrTime(String id, String time) {
		// TODO Auto-generated method stub
			String hql="from OperRecordate where 1= 1";
			if(id!=null&&!"".equals(id))
				hql+=" and fileId="+id;
			if(time!=null&&!"".equals(time))
				hql+=" and odata ="+time;
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
			return query.list();
	}
	
}
