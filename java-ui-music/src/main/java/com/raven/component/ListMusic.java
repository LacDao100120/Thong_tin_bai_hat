package com.raven.component;

import com.raven.model.Model_Music;
import com.raven.model.Song;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;

public class ListMusic<E extends Object> extends JList<E> {
	private ArrayList<Song> songs = new ArrayList<>();
    private  DefaultListModel model;
    private int playIndex = -1;
    public Socket socket;
    public ListMusic() {
        model = new DefaultListModel();
        setModel(model);
        setOpaque(false);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    playIndex = locationToIndex(me.getPoint());
                    repaint();
                }
            }
        });
    }

    public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public ArrayList<Song> getSongs() {
		return songs;
	}

	public void setSongs(ArrayList<Song> songs) {
		this.songs = songs;
	}

	@Override
    public ListCellRenderer getCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> jlist, Object o, int index, boolean selected, boolean focus) {
                Model_Music data;
                if (o instanceof Model_Music) {
                    data = (Model_Music) o;
                } else {
                    data = new Model_Music("1", "No Music", "00:00");
                }
                ItemMusic item = new ItemMusic(data);
                ArrayList<Song> songss = getSongs();
                if(selected) {
                	 Bottom.playMusic(songss.get(index));
                }
              
                item.setPlay(index == playIndex);
                return item;
            }
        };
    }
    public void resetList(){
        model.removeAllElements();
    }
    public void addItem(Model_Music data) {
        model.addElement(data);
    }
}
