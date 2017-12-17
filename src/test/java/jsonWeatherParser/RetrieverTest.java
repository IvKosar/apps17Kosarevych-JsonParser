package jsonWeatherParser;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class RetrieverTest {
    @Test
    public void getPageTest() throws Exception {
        HashMap<String, String> params = new HashMap<>();
        params.put("APPID", "5496614f4ca95e6dcc0445c1e7f3916d");
        params.put("q", "Lviv");
        Retriever retriever = new Retriever("http://api.openweathermap.org/data/2.5/weather", params);
        String firstExpectedCharacters = "{\"coord\":{\"lon\":24.03,\"lat\":49.84},";
        assertEquals(firstExpectedCharacters, retriever.getPage().substring(0, firstExpectedCharacters.length()));
    }
}