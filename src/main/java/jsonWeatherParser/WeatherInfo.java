package jsonWeatherParser;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class WeatherInfo {
    public static String getDescription(JSONObject jsonWeather){
        JSONArray weatherArray = (JSONArray) jsonWeather.get("weather");
        JSONObject dataAtZeroPos = (JSONObject) weatherArray.get(0);
        return (String) dataAtZeroPos.get("description");
    }

    public static Double getTemperature(JSONObject jsonWeather){
        JSONObject mainPart = (JSONObject) jsonWeather.get("main");
        return (Double) mainPart.get("temp");
    }
}
