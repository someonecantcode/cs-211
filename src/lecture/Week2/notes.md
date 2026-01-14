# JSON BigData Real Time API

* Imports

```java
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
```

* Setup

```java
public class BigData {
    public static void main(String[] args){
        double rate;
        try{
            String theURL = "https://api-url";

            URL url = new URL(theURL);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

            JSONParser jsonParser = new JSONParser();
            JSONObject myObject = (JSONObject) jsonParser.parse(br); // the actual json output

            // here on out is filtering and sifting what you want exactly

            JSONArray PeopleArray = (JSONArray) myObject.get("people");​
            JSONObject p = (JSONObject) PeopleArray.get(2);
            // people = (String) p.get("name");
            ​​

            rate = (double) ((JSONObject) myObject.get("rates")).get("ARS");
            System.out.println("US dollar to Argentina Peso = " + rate);
        } catch (Exception e) {

        }
    }
}
```

## How to filter and look through items
> 
> A `JSONObject` is in the same way in javaa normal `Object` is. 

Now that you have done used the `.parse()` and received a JSON output, you will
want to look through specific properties and data values. 

The easiest is just grabbing it through `.get(key)` method. It is important to note that
the `.get(key)` returns an `Object` so you will have to recast to back to `JSONObject`. 
If you just want to print it out, just put inside the `System.out.print` because the `Object`
has a `toString()` method in it.

You can nest and do multiple `.get` but you will have to recast it each time to `JSONObject`.
 
Nesting Example (same implementation):
```java
JSONObject pr = (JSONObject) ((JSONObject) child).get("properties");

JSONObject obj = (JSONObject) child;
JSONObject pr = (JSONObject) obj.get("properties");
```


Example:

```java
BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
JSONParser jsonParser = new JSONParser();
JSONObject myObject = (JSONObject) jsonParser.parse(br);

String output = (String) myObject.get("USD"); // converting from Object to String
```

Use `JSONArray` for when you want to iterate through it. You can use `.size()` and `.get(int index)`.
Use a for each loop and make the child as `Object`

Example:

```java
JSONObject myObject = (JSONObject) jsonParser.parse(br); // the json output
JSONArray weatherArray = (JSONArray) myObject.get("weather"); // .get returns Object -> recasted to JSONArray

for(Object child : weatherArray){
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

```


## How to run with `java` cli

You can see that really quickly, you can't seem to run your java easily with `java filename.java`. You need to add 
a class path to your external library. You can try creating a java project and importing your external `.jar` file into
the reference libraries. The most consistent way is to simply use `java -cp jarfile.jar filename.jar`.

Example:
```bash 
C:\Users\someonecantcode\program> java -cp json-simple-1.1.1.jar BigDataQ1.java
```