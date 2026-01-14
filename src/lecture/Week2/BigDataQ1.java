import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

/*
* CS 211 Big Data Quiz
* @author Brendan Tea
* @date   1/14/2026
* Description: Use API to find earthquakes last hour and properties.
*/

public class BigDataQ1 {
	public static void main(String[] args) {
		try {
           URL url = new URL("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_hour.geojson");
           BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

           JSONParser jsonParser = new JSONParser();
           JSONObject myObject = (JSONObject) jsonParser.parse(br); // the json output
           
           JSONArray LastHour = (JSONArray) myObject.get("features");
           System.out.println(String.format("1) Total earthquakes last hour: %d %n", LastHour.size()));

           
        //    for(int i = 0; i <  LastHour.size(); i++ ) {
        //    	 JSONObject obj = 	(JSONObject)LastHour.get(i);
        //    	 JSONObject pr = 	(JSONObject)obj.get("properties");
           	 
           	//  System.out.printf(
           	// 		"2) Location: %s %n3) Magnitude: %f %n4) Tsunami: %d %n5) Two Values: sig %s gap %s %n%n" , pr.get("place"),
           	// 		pr.get("mag"), 
           	// 		pr.get("tsunami"),
           	// 		pr.get("sig"),
           	// 		pr.get("gap")
           	// 		 );

        //    }

			for(Object child : LastHour){
				JSONObject obj = (JSONObject) child;
				JSONObject pr = (JSONObject) ((JSONObject) child).get("properties");
				System.out.printf(
						"2) Location: %s %n3) Magnitude: %f %n4) Tsunami: %d %n5) Two Values: sig %s gap %s %n%n" , pr.get("place"),
						pr.get("mag"), 
						pr.get("tsunami"),
						pr.get("sig"),
						pr.get("gap")
						);
			}
           

       } catch (Exception e) {
       	System.out.println(e);
       }
		
	}
}