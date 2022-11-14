/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.hoa.Server;

import java.sql.Timestamp;
import java.time.Instant;

/**
 *
 * @author Admin
 */
public class TTTBH {
	public static final String key = "X5BM3w8N7MKozC0B85o4KMlzLZKhV00y"; 
    public static void main(String[] args) {
        long time =Instant.now().toEpochMilli();
        Double d = time/1000.0;
        String time2 = String.format ("%.0f", Math.floor(d));
        System.out.println(time/1000+"_"+time2+"_"+time);
        ZingMp3Controller controller= new ZingMp3Controller("1.7.63", "", key, key, time2);
        System.out.println(controller.getSongInfo("Z6O66IB8"));
    }
}
