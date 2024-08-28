package faang.school.godbless.BJS2_19166;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, WeatherData> weatherCache = new HashMap<>();

    public static void main(String[] args) {
        WeatherData weather = getWeatherData("Astana");
        System.out.println(weather);

        updateWeatherData(new WeatherData("Astana", 25.5, 60.0));
        System.out.println(getWeatherData("Astana"));

        removeWeatherData("Astana");
        System.out.println(getWeatherData("Astana"));

        printAllCitiesInCache();
    }

    public static WeatherData getWeatherData(String city) {
        if (weatherCache.containsKey(city)) {
            System.out.println("Returning cached data for " + city);
            return weatherCache.get(city);
        } else {
            WeatherData newWeatherData = fetchWeatherFromExternalService(city);
            weatherCache.put(city, newWeatherData);
            return newWeatherData;
        }
    }

    private static WeatherData fetchWeatherFromExternalService(String city) {
        System.out.println("Fetching new weather data for " + city);
        return new WeatherData(city, 20.0, 50.0);
    }

    private static void updateWeatherData(WeatherData weatherData) {
        System.out.println("Updating weather data for " + weatherData);
        weatherCache.put(weatherData.getCity(), weatherData);
    }

    private static void removeWeatherData(String city) {
        System.out.println("Removing weather data for " + city);
        weatherCache.remove(city);
    }

    private static void printAllCitiesInCache(){
        if (weatherCache.isEmpty()) {
            System.out.println("No weather data available in cache.");
        } else {
            System.out.println("Cities with cached weather data:");
            for (String city : weatherCache.keySet()) {
                System.out.println(city);
            }
        }
    }
}
