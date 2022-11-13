/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tttbh;

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
    
}
