package com.ga.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "song")

public class Song {
	
	 @Id
	 @Column
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long song_id;
	

	@Column(unique = true, nullable = false)
	private String songName;
	
	@Column(nullable = false)
	private Double songLength;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "user_song",
            joinColumns = {@JoinColumn(name = "song_id")},
            inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> users;
	
	public List<User> getUsers() {return users; }
	
	public void setUsers(List<User> users) {this.users = users;}
	
	
	public Song() {
		
	}

	public Long getSongId() {
		return song_id;
	}

	public void setSongId(Long song_id) {
		this.song_id = song_id;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public Double getSongLength() {
		return songLength;
	}

	public void setSongLength(Double songLength) {
		this.songLength = songLength;
	}

}
