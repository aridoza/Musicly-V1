package com.ga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ga.dao.SongDao;
import com.ga.entity.Song;
import com.ga.entity.UserProfile;

@Service
public class SongServiceImpl implements SongService {

	@Autowired
	SongDao songDao;

//	@Override
//	public Song addSong(Song song) {
//		return songDao.addSong(song);
//	}
//
//	@Override
//	public List<Song> getSongs() {
//		return songDao.getSongs();
//	}

	@Override
	public Song addSong(String username, Song newSong) {
		return songDao.addSong(username, newSong);
	}

	@Override
	public List<Song> getSongs(String username) {
		return songDao.getSongs(username);
	}	
	
	@Override
	public Long deleteSong(Long songId) {
		return songDao.deleteSong(songId);
	}

}
