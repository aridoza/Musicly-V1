package com.ga.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ga.entity.Song;
import com.ga.entity.UserProfile;
import com.ga.service.SongService;

@RestController
@RequestMapping("/song")
public class SongController {

	@Autowired
	SongService songService;
	
	
//	@PostMapping
//	public Song addSong(@RequestBody Song song) {
//		return songService.addSong(song);
//	}
//	
//	@GetMapping("/list")
//    public Iterable<Song> getSongs() {
//        return songService.getSongs();
//    }
	
    @GetMapping("/{username}")
    public List<Song> getSongs(@PathVariable String username) {
        return songService.getSongs(username);
    }
    
    @PostMapping("/{username}")
    public Song addSong(@PathVariable String username, @RequestBody Song song) {
        return songService.addSong(username, song);
    }
    
    @DeleteMapping("/{songId}")
	public Long deleteSong(@PathVariable Long songId) {
		return songService.deleteSong(songId);
	}
}
