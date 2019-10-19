package com.ga.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ga.entity.Song;
import com.ga.entity.User;

@Repository
public class SongDaoImpl implements SongDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Song addSong(Song song) {
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

	@Override
	public List<Song> getSongs() {
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
}
