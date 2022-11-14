package com.hoa.Server;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

import org.json.JSONObject;

import com.hoa.encrypt.mh;

public class ZingMp3Controller {
	 public String VERSION;
	  public String URL;
	  public String SECRET_KEY;
	  public String API_KEY;
	  public String CTIME;
	  public ZingMp3Api api;
	public ZingMp3Controller(String vERSION, String uRL, String sECRET_KEY, String aPI_KEY, String cTIME) {
		super();
		VERSION = vERSION;
		URL = uRL;
		SECRET_KEY = sECRET_KEY;
		API_KEY = aPI_KEY;
		CTIME = cTIME;
		api = new ZingMp3Api(vERSION, uRL, sECRET_KEY, aPI_KEY, cTIME);
	}
	public String getSong(String id) {
		String sig = api.getParam("/api/v2/song/get/streaming", id);
		String url = "/api/v2/song/get/streaming?id="+id+"&ctime="+CTIME+"&version="+VERSION+"&sig="+sig+"&apiKey="+SECRET_KEY;
		return api.callAPI(url);
	}
	public String getSongInfo(String id) {
		String sig = api.getParam("/api/v2/song/get/info", id);
		String url =  "/api/v2/song/get/info?id="+id+"&ctime="+CTIME+"&version="+VERSION+"&sig="+sig+"&apiKey="+SECRET_KEY;
		return api.callAPI(url);
	}
	public String getDetailPlayList(String playlistId) {
		String param = api.getParam("/api/v2/page/get/playlist", playlistId);
		return api.callAPI(param);
	}
	public String getTop100() {
		String param = api.getParam("/api/v2/page/get/top-100", null);
		return api.callAPI(param);
	}
	
	
}
