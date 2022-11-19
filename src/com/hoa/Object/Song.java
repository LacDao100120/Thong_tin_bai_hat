package com.hoa.Object;

import java.util.ArrayList;

public class Song {
	private String id;
	private String title;
	private String ArtistsNames;
	private String thumbnail;
	private String duration;
	private String releaseDate;
	private ArrayList<Artist> artists;
	private String link;
	private String Description;
	public Song() {
		
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtistsNames() {
		return ArtistsNames;
	}
	public void setArtistsNames(String artistsNames) {
		ArtistsNames = artistsNames;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public ArrayList<Artist> getArtists() {
		return artists;
	}
	public void setArtists(ArrayList<Artist> artists) {
		this.artists = artists;
	}

	public Song(String id, String artistsNames, String thumbnail, String duration, String releaseDate) {
		super();
		this.id = id;
		ArtistsNames = artistsNames;
		this.thumbnail = thumbnail;
		this.duration = duration;
		this.releaseDate = releaseDate;

	}
	public Song(String id, String title, String artistsNames, String thumbnail, String duration, String releaseDate,
			ArrayList<Artist> artists) {
		super();
		this.id = id;
		this.title = title;
		this.ArtistsNames = artistsNames;
		this.thumbnail = thumbnail;
		this.duration = duration;
		this.releaseDate = releaseDate;
		this.artists = artists;
	}
	
}
