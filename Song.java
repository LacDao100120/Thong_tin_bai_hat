package com.ktplayer;

import java.awt.Image;
//import javafx.scene.image.Image;

public class Song {
    private String id;
    private String artistName;
    private String songName;
    private String length;
    private String duration;
    private String album;
    private String url;
    private Image image;

    public Song() {}

    public Song(String url) {
        this.url = url;
    }

    public Song(String id, String artistName, String songName, String length, String duration, String album, String url) {
        this.id = id;
        this.artistName = artistName;
        this.songName = songName;
        this.length = length;
        this.duration = duration;
        this.album = album;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public String idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String artistNameProperty() {
        return artistName;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String songNameProperty() {
        return songName;
    }

    public String getDuration() {
        return length;
    }

    public void setDuration(String duration) {
        this.length = duration;
    }

    public String durationProperty() {
        return length;
    }

    public String getRate() {
        return duration;
    }

    public String rateProperty() {
        return duration;
    }

    public void setRate(String rate) {
        this.duration = rate;
    }

    public String getFormat() {
        return album;
    }

    public String formatProperty() {
        return album;
    }

    public void setFormat(String format) {
        this.album = format;
    }

    public String getUrl() {
        return url;
    }

    public String urlProperty() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

   
}

