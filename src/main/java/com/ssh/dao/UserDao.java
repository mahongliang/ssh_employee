package com.ssh.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
  
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		// TODO Auto-generated method stub
		return sessionFactory.openSession();
	}
	
    public void saveObject(Object obj) {
    	this.getCurrentSession().save(obj);  
    	//this.getHibernateTemplate().save(obj);
    }

	
}
