package com.raven.component;

import com.google.gson.Gson;
import com.raven.model.Model_Music;
import com.raven.model.Song;
import java.awt.Color;
import java.net.Socket;
import java.util.ArrayList;

import org.json.simple.JSONObject;

public class Music extends javax.swing.JPanel {
	public Socket socket;
    public Music() {
        initComponents();
        init();
        
    }
    public Socket getSocket() {
		return socket;
	}
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	public void getSongs(ArrayList<Song> songs){
        this.list.resetList();
//        this.list.addItem(new Model_Music("1", "Peace Of Mind (feat. Vargas & Lagola)", "03:00"));
        int i=0;
        for(Song song:songs){
        	System.out.println(song.getTitle()+"( "+song.getArtistsNames() + ")"+ song.getDuration());
        	 if(song.getTitle() !=null) {
        		 i++;
                 
                 this.list.addItem(new Model_Music(String.valueOf(i), song.getTitle()+"( "+song.getArtistsNames() + ")", Integer.parseInt(song.getDuration())/60+":"+(Integer.parseInt(song.getDuration()) - (Integer.parseInt(song.getDuration())/60)*60)));
        	 }
            
        }
        list.setSongs(songs);
//        this.list.revalidate();
//        this.list.repaint();
    }
    private void init() {
        jScrollPane1.getViewport().setBackground(Color.WHITE);
//        list.addItem(new Model_Music("1", "Peace Of Mind (feat. Vargas & Lagola)", "03:00"));
//        list.addItem(new Model_Music("2", "Heaven", "04:37"));
//        list.addItem(new Model_Music("3", "SOS (feat. Aloe Blacc)", "02:37"));
//        list.addItem(new Model_Music("4", "Bad Reputation (feat. Joe Janiak)", "03:25"));
//        list.addItem(new Model_Music("5", "Ain't A Thing", "03:03"));
//        list.addItem(new Model_Music("6", "Hold The line (feat. A R I Z O N A)", "02:51"));
//        list.addItem(new Model_Music("7", "Freak (feat. Bonn)", "02:59"));
//        list.addItem(new Model_Music("8", "Excuse me Mr Sir (feat. Vargas & Lagola)", "03:07"));
//        list.addItem(new Model_Music("9", "Heart Upon My Sleeve (feat. Imagine Dragons)", "04:14"));
//        list.addItem(new Model_Music("10", "Never Leave Me (feat. Joe Janiak)", "02:51"));
//        list.addItem(new Model_Music("11", "Fades Away (feat. Noonie Bao)", "02:58"));
//        list.addItem(new Model_Music("12", "Wake Me Up", "04:07"));
//        list.addItem(new Model_Music("13", "You Make Me", "03:53"));
//        list.addItem(new Model_Music("14", "Hey Brother", "04:15"));
//        list.addItem(new Model_Music("15", "Addicted To You", "02:28"));
    }
    public void setLabel(String label){
        jLabel1.setText(label);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        list = new com.raven.component.ListMusic<>();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Most Trending Music");

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setViewportView(list);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(104, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.component.ListMusic<String> list;
    // End of variables declaration//GEN-END:variables
}
