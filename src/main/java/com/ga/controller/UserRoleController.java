package com.ga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ga.entity.UserRole;
import com.ga.service.UserRoleService;

@RestController
@RequestMapping("/role")
public class UserRoleController {

	@Autowired
	UserRoleService userRoleService;
	
	@GetMapping("/{rolename}")
	public UserRole getRole(@PathVariable String rolename) {
		return userRoleService.getRole(rolename);
	}
	
	@PostMapping
	public UserRole createRole(@RequestBody UserRole userRole) {
		return userRoleService.createRole(userRole);
	}
}