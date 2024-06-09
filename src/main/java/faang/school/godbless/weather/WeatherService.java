package faang.school.godbless.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherService {
    public static WeatherData getWeather(String city) throws WeatherServiceException {
        try {
            String urlString = String.format("https://wttr.in/%s?format=j1", city);
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String line;
                    StringBuilder response = new StringBuilder();
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    String json = response.toString();
                    String temperature = parseJson(json, "\"temp_C\": \"", "\",");
                    String humidity = parseJson(json, "\"humidity\": \"", "\",");
                    return new WeatherData(city, " " + temperature + " ℃ ", " " + humidity + " %");
                }
            } else {
                throw new WeatherServiceException("Weather information is currently unavailable.");
            }
        } catch (IOException e) {
            throw new WeatherServiceException("Weather information is currently unavailable.");
        }
    }

    private static String parseJson(String json, String start, String end) {
        int startInd = json.indexOf(start) + start.length();
        int endInd = json.indexOf(end, startInd);
        return json.substring(startInd, endInd);
    }
}
