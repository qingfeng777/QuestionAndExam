package com.ming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ming.entity.User;

public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public User getUser(int id) {

		String hql = "from User u where u.userId=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);

		return (User)query.uniqueResult();
	}
	
	@Override
	public User getUserByName(String name) {

		String hql = "from User u where u.userName=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, name);

		return (User)query.uniqueResult();
	}

	@Override
	public List<User> getAllUser() {

		String hql = "from User";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		return query.list();
	}

	@Override
	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public boolean delUser(String id) {

		String hql = "delete User u where u.userId = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, id);

		return (query.executeUpdate() > 0);
	}

	@Override
	public void updateUser(User user) {
		//hql语句的方式，太麻烦，先试试save方法。
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	/*	String hql = "update User u set u.userName = ?,u.age=? where u.id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, user.getUserName());
		query.setString(1, user.getAge());
		query.setInteger(2, user.getId());

		return (query.executeUpdate() > 0);*/
		
		
		/*
		//读取配置文件
        Configuration cfg=new Configuration().configure(); 

        //创建sessionFactory,相当于数据库的一个镜像
        @SuppressWarnings("deprecation")
		SessionFactory factory=cfg.buildSessionFactory();

        //取得session
        Session session=null;
        try {
            session=factory.openSession(); //打开session
            //开启事务，设置默认的提交方式为手动提交
            session.beginTransaction();
            
            session.save(user);
            //提交事务
            session.getTransaction().commit(); //获得当前事务，然后提交


        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }finally{
            if (session != null) {
                if (session.isOpen()) {
                    //关闭session
                    session.close();
                }
            }
        }
		return true;
		
		*/
	}

}
