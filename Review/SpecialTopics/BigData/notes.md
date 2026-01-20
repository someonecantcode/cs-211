# Big Data (API + JSON)


Just remember the buffer reader inputstreamreder and the json parser.
For the JSON parser, you can traverse it like an nested array.

```java
import org.json.simple.JSONObject;

public class exchangeRate {
    public static void main(String[] args){

        double rate;
        try{
            String theURL = "https://api-url"

            URL url = new URL(theURL);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

            JSONParser jsonParser = new JsonParser();
            JSONObject myObject = (JSONObject) jsonParser.parse(br);

            JSONArray PeopleArray = (JSONArray) myObject.get("people");​
            JSONObject p = (JSONObject) PeopleArray.get(2);
            // people = (String) p.get("name");
            ​​

            rate = (double) ((JSONObject) myObject.get("rates")).get("ARS")
            System.out.println("US dollar to Argentina Peso = " + rate);
        } catch (Exception e) {

        }
    }


}

```