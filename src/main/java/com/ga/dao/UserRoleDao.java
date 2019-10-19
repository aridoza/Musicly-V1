package com.ga.dao;

import com.ga.entity.UserRole;

public interface UserRoleDao {
	
	public UserRole createRole(UserRole newRole);
	
	public UserRole getRole(String roleName);

}
