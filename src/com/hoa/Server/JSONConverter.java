package com.hoa.Server;


import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.hoa.Object.Artist;
import com.hoa.Object.Song;

public class JSONConverter {
	private String json;
	private JSONParser parser = new JSONParser();
	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}
	public JSONConverter() {
		
	}
	public JSONConverter(String json) {
		super();
		this.json = json;
	}
	public JSONObject getObject() {
		
		try {
			JSONObject  obj = (JSONObject) parser.parse(json);
			
			return (JSONObject)obj.get("data");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static JSONArray getObject(String obj) {
		
		try {
			JSONParser parser2 = new JSONParser();
			JSONObject  arr = (JSONObject) parser2.parse(obj);
			
			return (JSONArray)arr.get("data");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<Object> convertToArrayList(JSONArray arr){
		ArrayList<Object> listdata = new ArrayList<Object>();  
		if(arr != null) {
			for (int i=0;i<arr.size();i++){   
                
                //Adding each element of JSON array into ArrayList  
                listdata.add(arr.get(i));  
            }
			return listdata;
		}
		return null;
	}
	public Artist parseJSONObjectToArtist(JSONObject data) {
		Artist art = new Artist();
		art.setId(data.containsKey("encodeId")?(String)data.get("encodeId"):null);
		art.setLink(data.containsKey("link")?(String)data.get("link"):null);
		art.setPlaylistId(data.containsKey("playlistId")?(String)data.get("playlistId"):null);
		art.setThumnail(data.containsKey("thumbnail")?(String)data.get("thumbnail"):null);
		art.setTotalFollow(data.containsKey("totalFollow")?(Long)data.get("totalFollow")+"":null);
		art.setName(data.containsKey("name")?(String)data.get("name"):null);
		return art;
	}
	public Song parseJsonObjectToSong(JSONObject data) {
		Song song = new Song();
		song.setId(data.containsKey("encodeId")?(String)data.get("encodeId"):null);
		song.setTitle(data.containsKey("title")?(String)data.get("title"):null);
		song.setArtistsNames(data.containsKey("artistsNames")?(String)data.get("artistsNames"):null);
		song.setDuration(data.containsKey("duration")?(Long)data.get("duration")+"":null);
		if(data.get("releaseDate") != null) {
			Date d = new Date((long)data.get("releaseDate"));
			 Format format = new SimpleDateFormat("yyyy MM dd HH:mm:ss");
			 song.setReleaseDate(format.format(d));
		}
		if(data.get("artists")!= null) {
			ArrayList<Object> objs = convertToArrayList((JSONArray)data.get("artists"));
			System.out.println(objs);
			 ArrayList<Artist> artists = new ArrayList<Artist>();
			 for(int i=0;i<objs.size();i++) {
				 Artist a = parseJSONObjectToArtist((JSONObject)objs.get(i));
				 artists.add(a);
			 }
			song.setArtists(artists);
		}
		song.setLink(data.containsKey("link")?(String)data.get("link"):null);
		song.setDescription(data.containsKey("sortDescription")?(String)data.get("sortDescription"):null);
		song.setThumbnail(data.containsKey("thumbnail")?(String)data.get("thumbnail"):null);
		return song;
	}
	
	
}
