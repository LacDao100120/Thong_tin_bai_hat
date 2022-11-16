/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hoa.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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
  private static final String USER_AGENT = "Mozilla/5.0";
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
			Connection.Response response = Jsoup.connect(url)
					.userAgent("Mozilla")
					.ignoreContentType(true)
					.execute();
			
			return response.body();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
    			
    }
    
 public String callAPI2(String url) throws IOException, ParseException, InterruptedException {
//	 HttpClient client = HttpClient.newHttpClient();
//	 HttpRequest request = HttpRequest.newBuilder()
//			 .GET()
//			 .header("content-type", "application/json;charset=utf-8")
//			 .uri(URI.create(url))
//			 .build();
//	 HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
//	 JSONObject result= new JSONObject(response.body()); 
//	// String res = new String(response.body().toString().getBytes(),StandardCharsets.UTF_8);
//	 //System.out.println(result);
//	 JSONArray byt = (JSONArray) result.get("bytes");
//	 byte[] t = new byte[byt.length()];
//	 for(int i = 0;i<byt.length();i++) {
//		  t[i] = (byte)(((int)byt.get(i)) & 0xFF);
//	 }
//	 
//	 System.out.println(new String(t, StandardCharsets.UTF_8));
	 HttpGet request = new HttpGet(url);
	 CloseableHttpClient client = HttpClients.createDefault();
	 CloseableHttpResponse response = client.execute(request);
	 HttpEntity entity = response.getEntity();
	 String result = EntityUtils.toString(entity);
     return result;			
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
 
