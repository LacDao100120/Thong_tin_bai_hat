package com.hoa.Object;

import java.util.ArrayList;

public class PlayList {
	private String title;
	private ArrayList<Song> songs;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public ArrayList<Song> getSongs() {
		return songs;
	}
	public void setSongs(ArrayList<Song> songs) {
		this.songs = songs;
	}
	public PlayList() {
		
	}
	public PlayList(String title, ArrayList<Song> songs) {
		super();
		this.title = title;
		this.songs = songs;
	}
	
}
