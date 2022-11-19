package com.hoa.Server;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.hoa.Object.Artist;
import com.hoa.Object.PlayList;
import com.hoa.Object.Song;
import com.hoa.encrypt.mh;

public class ZingMp3Controller {
	 public String VERSION;
	  public String URL;
	  public String SECRET_KEY;
	  public String API_KEY;
	  public String CTIME;
	  public ZingMp3Api api;
	  public JSONConverter converter;
	public ZingMp3Controller(String vERSION, String uRL, String sECRET_KEY, String aPI_KEY, String cTIME) {
		super();
		VERSION = vERSION;
		URL = uRL;
		SECRET_KEY = sECRET_KEY;
		API_KEY = aPI_KEY;
		CTIME = cTIME;
		api = new ZingMp3Api(vERSION, uRL, sECRET_KEY, aPI_KEY, cTIME);
		converter = new JSONConverter();
	}
	public Song getSong(String id) {
		String response;
		try {
			response = api.getSongInfo(id);
			System.out.println(response);
			converter.setJson(response);
			JSONObject data = converter.getObject();
			Song song = new Song();
			song = converter.parseJsonObjectToSong(data);
			return song;
		} catch (IOException | ParseException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String getPlayer(String id) {
		try {
			String response = api.getSong(id);
			converter.setJson(response);
			JSONObject data = converter.getObject();
			String playerLink = (String) data.get("128");
			return playerLink;
		} catch (IOException | ParseException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<PlayList> getTop100() {
		ArrayList<PlayList> top100s = new ArrayList<PlayList>();
		String response = api.getTop100();
		JSONArray data = JSONConverter.getObject(response);
		for(int i =0 ;i<data.size();i++) {
			 JSONObject c = (JSONObject)data.get(i);
			PlayList playlist = new PlayList();
			JSONArray songs = (JSONArray) c.get("items");
			ArrayList<Song> lstSongs = new ArrayList<>();
			for(int j = 0 ;j<songs.size();j++) {
				Song s = converter.parseJsonObjectToSong((JSONObject)songs.get(j));
				lstSongs.add(s);
			}
			
			playlist.setTitle((String)c.get("title"));
			playlist.setSongs(lstSongs);
			top100s.add(playlist);
		}
		return top100s;
	}
	public ArrayList<Song> getSearch(String keyword){
		String response = api.search(keyword);
		converter.setJson(response);
		JSONObject data = converter.getObject();
		ArrayList<Song> songs = new ArrayList<>();
		Song top1 = converter.parseJsonObjectToSong((JSONObject)(data.get("top")));
		songs.add(top1);
		JSONArray lstSongs = (JSONArray) data.get("songs");
		for(int j = 0 ;j<lstSongs.size();j++) {
			Song s = converter.parseJsonObjectToSong((JSONObject)lstSongs.get(j));
			songs.add(s);
		}
		return songs;
	}
}
