import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;


public class Weather {

    private static final String APIKey = "fa3065acd2bd081dbe845275b7e78eca";

    public static void main(String[] args) throws IOException {

        String zip = "2000";
        String Country = "au";

        WeatherGet.GetCurrentWeatherUpdate(APIKey);
        WeatherGet.GetThreeHourWeatherUpdate(APIKey, zip, Country);
    }



}

