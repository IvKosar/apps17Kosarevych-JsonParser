package jsonWeatherParser;

import org.junit.Test;

import static org.junit.Assert.*;

public class WeatherRetrieverTest {
    @Test
    public void printWeather() throws Exception {
        WeatherRetriever wr = new WeatherRetriever("Lviv");
        assertTrue(wr.printWeather());
    }

}