package com.ga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/{rolename}")
	public UserRole getRole(@PathVariable String rolename) {
		return userRoleService.getRole(rolename);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public UserRole createRole(@RequestBody UserRole userRole) {
		return userRoleService.createRole(userRole);
	}
}