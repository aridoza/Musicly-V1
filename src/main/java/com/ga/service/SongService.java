package com.ga.service;

import java.util.List;

import com.ga.entity.Song;

public interface SongService {

	public Song addSong(Song song);
	
	public List<Song> getSongs();
	
}
