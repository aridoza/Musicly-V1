package com.ga.dao;

import java.util.List;

import com.ga.entity.Song;

public interface SongDao {

	public Song addSong(Song song);
	
	public List<Song> getSongs();
}
