package com.ga.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ga.entity.JwtResponse;
import com.ga.entity.User;
import com.ga.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

//	@GetMapping("/hello")
//	public String hello() {
//		return "Hello World!";
//	}

	@Autowired
	UserService userService;

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/list")
	public List<User> listUsers() {
		return userService.listUsers();
	}

	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody User user) {
		return ResponseEntity.ok(new JwtResponse(userService.signup(user)));
	}

//	@PostMapping("/signup")
//	public User signup(@RequestBody User user) {
//		return userService.signup(user);
//	}

//	@PostMapping("/login")
//	public Long login(@RequestBody User user) {
//		return userService.login(user);
//	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user) {
		return ResponseEntity.ok(new JwtResponse(userService.login(user)));
	}

	@PutMapping("/{username}/song/{songId}")
	public User addSong(@PathVariable String username, @PathVariable Long songId) {
		return userService.addSong(username, songId);
	}

}
