package com.ga.service;

import java.util.List;

import com.ga.entity.Song;
import com.ga.entity.UserProfile;

public interface SongService {

//	public Song addSong(Song song);
//	
//	public List<Song> getSongs();
	
	public Song addSong(String username, Song newSong);
	
	public List<Song> getSongs(String username);
	
	public Long deleteSong(Long songId);
	
}
