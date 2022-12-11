package com.raven.main;
import com.raven.component.Bottom;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javazoom.jl.player.Player;
import uk.co.caprica.vlcj.player.component.AudioPlayerComponent;


public class MP3Player
{
    MyThread th;
    private String mp3FileToPlay;
    private boolean isPlay = false;
    private int stopTime = 0;
    public String getMp3FileToPlay() {
        return mp3FileToPlay;
    }

    public int getStopTime() {
        return stopTime;
    }

    public void setStopTime(int stopTime) {
        this.stopTime = stopTime;
    }

    public void setMp3FileToPlay(String mp3FileToPlay) {
        this.mp3FileToPlay = mp3FileToPlay;
    }
    private AudioPlayerComponent audio;
    public MP3Player() {
        this.audio = new AudioPlayerComponent();
    }
    public MP3Player(String mp3FileToPlay) {
        this.audio = new AudioPlayerComponent();
        this.mp3FileToPlay = mp3FileToPlay;
    }
    public void loadAudio(String path) {
         this.audio.mediaPlayer().media().startPaused(path);
         this.setStopTime(0);
      }
    public void play() {
        this.setStopTime(this.audio.mediaPlayer().audio().track());
        if(stopTime > 0){
            this.audio.mediaPlayer().controls().setPosition(stopTime);
            this.audio.mediaPlayer().controls().play();
        }else{
            this.audio.mediaPlayer().controls().setPosition(0);
            this.audio.mediaPlayer().controls().play();
        }
         
        
    }
    public void pause(){
        this.audio.mediaPlayer().audio().track();
        this.audio.mediaPlayer().controls().pause();
    }
    class MyThread implements Runnable{
        //public static int stopTime = 0;
         private volatile boolean stopped = false;
        public AudioPlayerComponent audio;
        public void stop() {
        stopped = true;
        }
        public MyThread(AudioPlayerComponent audio){
            this.audio = audio;
        }
        @Override
        public void run() {
                try {
                    
//                    if(stopped){
//                        this.player.close();
//                    }
                    
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        public int stopping(){
           // stopTime = player.getPosition();
            return 0;
        }
    }
}

