package jsonWeatherParser;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;

public class WeatherRetriever {
    private Retriever retriever;
    private String city;
    private final static String APPID = "5496614f4ca95e6dcc0445c1e7f3916d";

    public WeatherRetriever(String c) {
        this.city = c;
    }

    public boolean printWeather() throws IOException {
        // retrieve json page
        HashMap<String, String> params = new HashMap<>();
        params.put("APPID", APPID);
        params.put("q", city);
        retriever = new Retriever("http://api.openweathermap.org/data/2.5/weather", params);
        String page = retriever.getPage();

        // parse json page
        JSONParser jsonParser = new JSONParser();
        try {
            JSONObject jsonWeather = (JSONObject) jsonParser.parse(page);
            String description = getDescription(jsonWeather);
            Double tempInKelvin = getTemperature(jsonWeather);
            System.out.println(String.format("Description: %s", description));
            System.out.println(String.format("Temperature in Kelvin: %s", tempInKelvin));
            System.out.println(String.format("Temperature in Celsius: %s", tempInKelvin - 273.15));

        }catch (ParseException e){
            e.printStackTrace();
        }
        return true;
    }

    private static String getDescription(JSONObject jsonWeather){
        JSONArray weatherArray = (JSONArray) jsonWeather.get("weather");
        JSONObject dataAtZeroPos = (JSONObject) weatherArray.get(0);
        return (String) dataAtZeroPos.get("description");
    }

    private static Double getTemperature(JSONObject jsonWeather){
        JSONObject mainPart = (JSONObject) jsonWeather.get("main");
        return (Double) mainPart.get("temp");
    }
}
