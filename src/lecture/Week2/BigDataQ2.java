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
* Description: Allow user to find eclipse data of their requested year.
*/

public class BigDataQ1 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("Input the year: ");
		int year = s.nextInt();

        while(!((year >=1800) && (year <= 2050))) {
            System.out.println("Year must be between 1800 and 2050");
            System.out.print("Input the year: ");
		    year = s.nextInt();
        }
		try {
			String link = "https://aa.usno.navy.mil/api/eclipses/solar/year?year=" + Integer.toString(year);
			URL url = new URL(link);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

            JSONParser jsonParser = new JSONParser();
            JSONObject myObject = (JSONObject) jsonParser.parse(br); // the json output
	            
            JSONArray thisYear = (JSONArray) myObject.get("eclipses_in_year");
            System.out.println(String.format("%n1) Number of eclipses in requested year: %d", thisYear.size()));
	           
            for(int i = 0; i< thisYear.size(); i++) {
            	JSONObject obj = (JSONObject) thisYear.get(i);
            	System.out.println(obj.get("event"));
            }
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}


