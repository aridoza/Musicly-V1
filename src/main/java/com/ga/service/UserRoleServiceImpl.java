package com.ga.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ga.dao.UserRoleDao;
import com.ga.entity.UserRole;

@Service
public class UserRoleServiceImpl implements UserRoleService {
	
	@Autowired
	UserRoleDao userRoleDao;

	@Override
	public UserRole createRole(UserRole newRole) {
		return userRoleDao.createRole(newRole);
	}

	@Override
	public UserRole getRole(String roleName) {
		return userRoleDao.getRole(roleName);
	}

}
