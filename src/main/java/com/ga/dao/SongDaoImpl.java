package com.ga.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ga.entity.Song;
import com.ga.entity.User;
import com.ga.entity.UserProfile;

@Repository
public class SongDaoImpl implements SongDao {

	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public Song addSong(String username, Song song) {
		
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			session.save(song);
			session.getTransaction().commit();
		} finally {
			session.close();
		}

		return song;
	}
	
	
//	@Override
//	public Song addSong(String username, Song song) {
//		User user = songDao.getUserByUsername(username);
//		
//		Session session = sessionFactory.getCurrentSession();
//		
//		try {
//			session.beginTransaction();
//			
//			session.save(userProfile);
//			user.setUserProfile(userProfile);
//			session.update(user);
//			
//			session.getTransaction().commit();
//		} finally {
//			session.close();
//		}
//
//		return userProfile;
//	}

	@Override
	public List<Song> getSongs(String username) {
		List<Song> allSongs = null;
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			allSongs = session.createQuery("FROM Song").getResultList();
		} finally {
			session.close();
		}
		
		return allSongs;
	}
	
//

//	@Override
//	public UserProfile getUserProfile(String username) {
//		User user = userDao.getUserByUsername(username);
//		return user.getUserProfile();
//	}
	
	@Override
	public Long deleteSong(Long songId) {
		Session session = sessionFactory.getCurrentSession();
		
		Song savedSong = null;
		
		try {
			session.beginTransaction();
			
			savedSong = session.get(Song.class, songId);
			session.delete(savedSong);
			
			session.getTransaction().commit();
		} finally {
			session.close();
		}
		
		return savedSong.getSongId();
	}

}
