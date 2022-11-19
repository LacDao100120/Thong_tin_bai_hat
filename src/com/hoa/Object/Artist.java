package com.hoa.Object;

public class Artist {
	private String id;
	private String name;
	private String link;
	private String thumnail;
	private String playlistId;
	private String totalFollow;
	public Artist() {
		
	}
	public Artist(String id, String name, String link, String thumnail, String playlistId, String totalFollow) {
		super();
		this.id = id;
		this.name = name;
		this.link = link;
		this.thumnail = thumnail;
		this.playlistId = playlistId;
		this.totalFollow = totalFollow;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getThumnail() {
		return thumnail;
	}
	public void setThumnail(String thumnail) {
		this.thumnail = thumnail;
	}
	public String getPlaylistId() {
		return playlistId;
	}
	public void setPlaylistId(String playlistId) {
		this.playlistId = playlistId;
	}
	public String getTotalFollow() {
		return totalFollow;
	}
	public void setTotalFollow(String totalFollow) {
		this.totalFollow = totalFollow;
	}
	
	
}
