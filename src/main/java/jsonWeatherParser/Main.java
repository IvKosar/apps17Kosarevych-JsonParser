package jsonWeatherParser;

import java.io.IOException;

import org.json.simple.parser.ParseException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        WeatherRetriever wr = new WeatherRetriever("Lviv");
        wr.printWeather();
    }
}