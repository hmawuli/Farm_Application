package com.farmersmarket.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class WeatherService {
    private static final String API_URL = "http://dataservice.accuweather.com/currentconditions/v1/";
    private static final String API_KEY = "Na2BcTu21u0Onzwz4YznCaWZZLV7sxIn"; // Replace with your actual API key

    @SuppressWarnings("ConvertToTryWithResources")
    public static String getWeather(String locationKey) {
        try {
            String urlString = API_URL + locationKey + "?apikey=" + API_KEY;
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in= new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            conn.disconnect();

            JsonArray jsonArray = JsonParser.parseString(content.toString()).getAsJsonArray();
            JsonObject json = jsonArray.get(0).getAsJsonObject();
            return json.get("WeatherText").getAsString();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            return "Unable to get weather data";
        }
    }
}
