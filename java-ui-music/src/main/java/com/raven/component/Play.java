package com.raven.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.raven.model.Lyric;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.JPanel;

import javazoom.jl.decoder.JavaLayerException;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

public class Play extends javax.swing.JPanel {
	public static Lyric lyric;
    public Play() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        jButton5.setText("jButton5");

        setOpaque(false);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/back.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/playing.png"))); // NOI18N
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton2.addActionListener(new ActionListener() {
			
     			@Override
     			public void actionPerformed(ActionEvent e) {
     				Bottom.ToggleMusic();
     				
     			}
     		});
jButton4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(lyric != null) {
					JFrame frame = new JFrame();
					lyric lyric = new lyric();
					ImageIcon icon = new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/Untitled.png"));
					ImagePanel panel11 = new ImagePanel(icon.getImage());
					lyric.setOpaque(false);
					
					lyric.add(panel11);
					lyric.setBackground(Color.black);
					lyric.setUpLyric(Play.lyric);
					frame.setBackground(Color.black);
					frame.add(lyric);
					
					frame.pack();
					frame.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Hiện chưa có lời cho bài hát này!!!");
				}
			}
		});
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/next.png"))); // NOI18N
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/play.png"))); // NOI18N
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton6.setText("MV");
        jButton6.setBorder(null);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    	if(!urlMp4Stream.equals("")) {
                Bottom.mp3Player.pause();
                Bottom.isPlay = false;
    		EmbeddedMediaPlayerComponent component = new EmbeddedMediaPlayerComponent();
        	JFrame frame = new JFrame();
        	frame.setContentPane(component);
        	component.setBounds(new Rectangle(200, 200, 800, 600));
        	frame.setBounds(new Rectangle(200, 200, 800, 600));
        	frame.addWindowListener(new WindowAdapter() {
        		@Override
        		public void windowClosing(WindowEvent e) {
        			component.release();
        		}
        	}
        	);
        	frame.pack();
        	frame.setVisible(true);
        	component.mediaPlayer().media().play(urlMp4Stream);

    	}else {
    		JOptionPane.showMessageDialog(null, "Không tìm thấy MV");
    	}
    	
    }//GEN-LAST:event_jButton6ActionPerformed
    public static String urlMp4Stream = "";
public class ImagePanel extends JPanel
{
private static final long serialVersionUID = 1L;
private Image image = null;
private int iWidth2;
private int iHeight2;

public ImagePanel(Image image)
{
    this.image = image;
    this.iWidth2 = image.getWidth(this)/2;
    this.iHeight2 = image.getHeight(this)/2;
}

@Override
public void paintComponent(Graphics g)
{
    super.paintComponent(g);
    if (image != null)
    {
        int x = this.getParent().getWidth()/2 - iWidth2;
        int y = this.getParent().getHeight()/2 - iHeight2;
        g.drawImage(image,x,y,this);
    }
}
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    // End of variables declaration//GEN-END:variables
}
