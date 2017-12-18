package jsonWeatherParser;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class WeatherRetriever {
    private Retriever retriever;
    private HashMap<String, String> params;
    private final static String APPID = "5496614f4ca95e6dcc0445c1e7f3916d";

    public WeatherRetriever(String city) {
        this.params = new HashMap<>();
        this.params.put("APPID", APPID);
        this.params.put("q", city);
        this.retriever = new Retriever("http://api.openweathermap.org/data/2.5/weather", params);
    }

    public boolean printWeather() throws IOException {
        // retrieve json page
        String page = retriever.getPage();

        // parse json page
        JSONParser jsonParser = new JSONParser();
        try {
            JSONObject jsonWeather = (JSONObject) jsonParser.parse(page);
            String description = WeatherInfo.getDescription(jsonWeather);
            Double tempInKelvin = WeatherInfo.getTemperature(jsonWeather);
            System.out.println(String.format("Description: %s", description));
            System.out.println(String.format("Temperature in Kelvin: %s", tempInKelvin));
            System.out.println(String.format("Temperature in Celsius: %s", tempInKelvin - 273.15));
        }catch (ParseException e){
            e.printStackTrace();
        }
        return true;
    }
}
