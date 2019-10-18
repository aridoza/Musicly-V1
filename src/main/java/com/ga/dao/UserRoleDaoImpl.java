package com.ga.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ga.entity.UserRole;

@Repository
public class UserRoleDaoImpl implements UserRoleDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public UserRole createRole(UserRole newRole) {
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			session.save(newRole);
			session.getTransaction().commit();
		} finally {
			session.close();
		}
		
		return newRole;
	}

	@Override
	public UserRole getRole(String roleName) {
		UserRole userRole = null;
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			userRole = (UserRole) session.createQuery("FROM UserRole r WHERE r.name = '" + 
				roleName + "'").uniqueResult();
		} finally {
			session.close();
		}
		
		return userRole;
	}

}