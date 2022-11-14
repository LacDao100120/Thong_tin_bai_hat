/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hoa.Server;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import com.hoa.encrypt.mh;


/**
 *
 * @author Admin
 */
public class ZingMp3Api {
  public String VERSION;
  public String URL;
  public String SECRET_KEY;
  public String API_KEY;
  public String CTIME;

    public ZingMp3Api(String VERSION, String URL, String SECRET_KEY, String API_KEY, String CTIME) {
    	
        this.VERSION = VERSION;
        this.URL = URL;
        this.SECRET_KEY = SECRET_KEY;
        this.API_KEY = API_KEY;
        this.CTIME = CTIME;
    }

    public String getVERSION() {
        return VERSION;
    }

    public void setVERSION(String VERSION) {
        this.VERSION = VERSION;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getSECRET_KEY() {
        return SECRET_KEY;
    }

    public void setSECRET_KEY(String SECRET_KEY) {
        this.SECRET_KEY = SECRET_KEY;
    }

    public String getAPI_KEY() {
        return API_KEY;
    }

    public void setAPI_KEY(String API_KEY) {
        this.API_KEY = API_KEY;
    }

    public String getCTIME() {
        return CTIME;
    }

    public void setCTIME(String CTIME) {
        this.CTIME = CTIME;
    }
    public String callAPI(String url) {
    	
		try {
			Connection.Response response = Jsoup.connect("https://zingmp3.vn"+url)
					.ignoreContentType(true)
					.method(Connection.Method.GET)
					.execute();
			return response.body();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
    			
    }
public String getParam(String path,String id) {
		
		try {
			String hashMac = !id.equals(null) || !id.equals("")?mh.getHMAC512(path+mh.getSHA256("ctime="+CTIME+"id="+id+"version="+VERSION), SECRET_KEY):mh.getHMAC512(path+mh.getSHA256("ctime="+CTIME+"version="+VERSION), SECRET_KEY);
			return hashMac;
		} catch (InvalidKeyException | SignatureException | NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
public String getParam2(String path,String id) {
	
	try {
		String hashMac = !id.equals(null) || !id.equals("")?mh.getHMAC512(path+mh.getSHA256("ctime="+CTIME+"id="+id), SECRET_KEY):mh.getHMAC512(path+mh.getSHA256("ctime="+CTIME+"version="+VERSION), SECRET_KEY);
		return hashMac;
	} catch (InvalidKeyException | SignatureException | NoSuchAlgorithmException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
	public String getParamHome(String path) {
		try {
			return mh.getHMAC512(path+mh.getSHA256("count=30"+"ctime="+CTIME+"page=1"+"version="+VERSION), SECRET_KEY);
		} catch (InvalidKeyException | SignatureException | NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public String getCategoryMV(String path,String id,String type) {
		try {
			return mh.getHMAC512(path+mh.getSHA256("ctime="+CTIME+"id="+id+"type="+type+"version="+VERSION), SECRET_KEY);
		} catch (InvalidKeyException | SignatureException | NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	} 
	 class homeRequest {
			public String page;
			public String segmentId;
			public String count;
			public String sig;
			public homeRequest(String page, String segmentId, String count, String sig) {
				super();
				this.page = page;
				this.segmentId = segmentId;
				this.count = count;
				this.sig = sig;
			}
			
	}

}
 
