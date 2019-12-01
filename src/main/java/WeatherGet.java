import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

public class WeatherGet {
    public static void GetCurrentWeatherUpdate(String APIKey) throws IOException {
        Double lat = 40.730610;
        Double lon = -73.935242;


        // creating the URL
        //http://api.openweathermap.org/data/2.5/weather?lat=40.730610&lon=-73.935242&apikey=fa3065acd2bd081dbe845275b7e78eca
        String url = "http://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=" + APIKey;

        // printing out json as default
        URL urlString = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) urlString.openConnection();

        try {
            conn.setRequestMethod("GET");
            try {
                int responseCode = conn.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader input = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String line;
                    StringBuffer response = new StringBuffer();
                    while ((line = input.readLine()) != null) {
                        response.append(line);
                    }

                    try {
                        input.close();
                        // Print to file
                        PrintWriter result = new PrintWriter("GetCurrentWeather.json");
                        result.write(response.toString());
                        result.flush();
                        result.close();

                        //get status/code
                        JSONObject jsonObj = new JSONObject(response.toString());
                        String country = jsonObj.getJSONObject("sys").getString("country");
                        String city = jsonObj.get("name").toString();
                        String cityId = jsonObj.get("id").toString();
                        System.out.println("Get Current Weather");
                        System.out.println("code : " + country);
                        System.out.println("city : " + city);
                        System.out.println("cityId : " + cityId);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("GET Request didn't Work");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void GetThreeHourWeatherUpdate(String APIKey, String Zip, String CountryCode) throws IOException {
        // creating the URL
        // //http://api.openweathermap.org/data/2.5/forecast?zip=2000,au&apikey=fa3065acd2bd081dbe845275b7e78eca

        String url = "http://api.openweathermap.org/data/2.5/weather?zip=" + Zip + "," + CountryCode + "&appid=" + APIKey;

        // printing out json as default
        URL urlString = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) urlString.openConnection();

        try {
            conn.setRequestMethod("GET");
            try {
                int responseCode = conn.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader input = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String line;
                    StringBuffer response = new StringBuffer();
                    while ((line = input.readLine()) != null) {
                        response.append(line);
                    }

                    try {
                        input.close();
                        // Print to file
                        PrintWriter result = new PrintWriter("GetThreeHoursWeather.json");
                        result.write(response.toString());
                        result.flush();
                        result.close();

                        //get status/code
                        JSONObject jsonObj = new JSONObject(response.toString());
                        String timezone = jsonObj.get("timezone").toString();
                        String weather = jsonObj.get("weather").toString();
                        System.out.println("Get 3 Hours Weather");
                        System.out.println("timezone : " + timezone);
                        System.out.println("weather : " + weather);

                       /* for (String keyStr : jsonObj.keySet()) {
                            Object keyvalue = jsonObj.get(keyStr);
                            System.out.println("key: "+ keyStr + " value: " + keyvalue);

                        }*/

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("GET Request didn't Work");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
