/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.hoa.Server;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;

import org.json.simple.parser.ParseException;

/**
 *
 * @author Admin
 */
public class TTTBH {
	public static final String key = "acOrvUS15XRW2o9JksiK1KgQ6Vbds8ZW"; 
    public static void main(String[] args) throws IOException, ParseException, InterruptedException {
        long time =Instant.now().toEpochMilli();
        Double d = time/1000.0;
        String time2 = String.format ("%.0f", Math.floor(d));
        ZingMp3Controller controller= new ZingMp3Controller("1.7.63", "https://zingmp3.vn", key, "X5BM3w8N7MKozC0B85o4KMlzLZKhV00y", time2);
        System.out.println(controller.getSong("Z60EO89D"));
    }
}
