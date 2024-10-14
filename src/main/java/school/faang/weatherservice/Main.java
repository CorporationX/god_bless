package school.faang.weatherservice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    // Create a HashMap to act as a cache for weather data
    private static final Map<String, WeatherData> weatherCache = new HashMap<>();
    private static final WeatherService weatherService = new WeatherService();
}