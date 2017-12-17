package jsonWeatherParser;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class WeatherRetrieverTest {
    @Test
    public void printWeather() throws Exception {
        WeatherRetriever wr = new WeatherRetriever("Lviv");
        assertTrue(wr.printWeather());
    }
}