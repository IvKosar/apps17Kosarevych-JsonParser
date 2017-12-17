package jsonWeatherParser;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

public class Retriever {
    private String url;
    private HashMap<String, String> params;

    public Retriever(String url, HashMap<String, String> p) {
        this.url = url;
        this.params = p;
    }

    public String getPage() throws IOException {
        URL oracle = new URL(createUrl());
        Scanner scn = new Scanner(oracle.openStream());
        StringBuilder inputLine = new StringBuilder();
        while (scn.hasNextLine()){
             inputLine.append(scn.nextLine());
        }
        return inputLine.toString();
    }

    private String createUrl(){
        StringBuilder result = new StringBuilder(url);
        result.append("?");
        for (String k: params.keySet()){
            result.append(String.format("%s=%s&",k, params.get(k)));
        }
        return result.substring(0, result.length() - 1);
    }
}
