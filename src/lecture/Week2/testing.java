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
		double rate;
        try{
            String theURL = "https://open.er-api.com/v6/latest/USD";

            URL url = new URL(theURL);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

            JSONParser jsonParser = new JSONParser();
            JSONObject myObject = (JSONObject) jsonParser.parse(br); // the actual json output

            // here on out is filtering and sifting what you want exactly

            JSONObject rates = (JSONObject) myObject.get("rates");
            rate = (double) ((JSONObject) myObject.get("rates")).get("ARS"); // Convert from object to double
            System.out.println("US dollar to Argentina Peso = " + rates.get("ARS"));
        } catch (Exception e) {

        }
		
	}
}