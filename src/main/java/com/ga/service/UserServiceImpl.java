package com.ga.service;

import com.ga.config.JwtUtil;
import com.ga.dao.UserDao;
import com.ga.entity.User;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Autowired
	JwtUtil jwtUtil;

	@Autowired
	@Qualifier("encoder")
	PasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.getUserByUsername(username);

		if (user == null)
			throw new UsernameNotFoundException("Unknown user: " + username);

		return new org.springframework.security.core.userdetails.User(user.getUsername(),
				bCryptPasswordEncoder.encode(user.getPassword()), true, true, true, true, getGrantedAuthorities(user));
	}

	private List<GrantedAuthority> getGrantedAuthorities(User user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		authorities.add(new SimpleGrantedAuthority(user.getUserRole().getName()));

		return authorities;
	}

	@Override
	public List<User> listUsers() {
		return userDao.listUsers();
	}

	@Override
	public String signup(User user) {
		if (userDao.signup(user).getUserId() != null) {
			UserDetails userDetails = loadUserByUsername(user.getUsername());
			
			return jwtUtil.generateToken(userDetails);
		}
		
		return null;
	}

	@Override
	public String login(User user) {
		if (userDao.login(user) != null) {
			UserDetails userDetails = loadUserByUsername(user.getUsername());

			return jwtUtil.generateToken(userDetails);
		}

		return null;
	}

	@Override
	public User addSong(String username, int songId) {
		return userDao.addSong(username, songId);
	}
}
