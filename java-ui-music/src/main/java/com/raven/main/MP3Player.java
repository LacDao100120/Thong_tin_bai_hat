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


public class MP3Player
{
    MyThread th;
    private String mp3FileToPlay;
    private boolean isPlay = false;
    private Thread thread;
    public String getMp3FileToPlay() {
        return mp3FileToPlay;
    }

    public void setMp3FileToPlay(String mp3FileToPlay) {
        this.mp3FileToPlay = mp3FileToPlay;
    }
    private Player jlPlayer;
    public MP3Player() {
    }
    public MP3Player(String mp3FileToPlay) {
        this.mp3FileToPlay = mp3FileToPlay;
    }

    public void play() {
        try {
           // URI uri = new URI(mp3FileToPlay); 
             URLConnection urlConnection = new URL(mp3FileToPlay).openConnection();
            BufferedInputStream fileInputStream = new BufferedInputStream(urlConnection.getInputStream());
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            jlPlayer = new Player(bufferedInputStream);
           
        } catch (Exception e) {
            System.out.println("Problem playing mp3 file " + mp3FileToPlay);
            System.out.println(e.getMessage());
        }
        if(thread != null){
            System.out.println("here");
            Bottom.time = th!=null? th.stopping():0;
            thread.stop();
        }
        MyThread th = new MyThread(jlPlayer);
        thread = new Thread(th);
        thread.start();
        
    }
    
    public void close() {
        if (jlPlayer != null) jlPlayer.close();
    }
    class MyThread implements Runnable{
        //public static int stopTime = 0;
         private volatile boolean stopped = false;
        public Player player;
        public void stop() {
        stopped = true;
        }
        public MyThread(Player player){
            this.player = player;
        }
        @Override
        public void run() {
                try {
                    this.player.play();
                    if(stopped){
                        this.player.close();
                    }
                    
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

