package faang.school.godbless.weather;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    private static final Map<String, WeatherData> WEATHER_CACHE = new HashMap<>();

    public static void main(String[] args) {
        try {
            WEATHER_CACHE.put("New York", new WeatherData("New York", " 20.0 ℃", " 60.0 %"));
            WEATHER_CACHE.put("London", new WeatherData("London", " 15.0 ℃", " 45.0 %"));
            printCachedCities();
            System.out.println("--------------------------");
            updateWeatherData("New York", new WeatherData("New York", " 25.0 ℃", " 77.0 %"));
            removeWeatherData("London");
            System.out.println(getWeatherData("Minsk"));
            System.out.println("--------------------------");
            printCachedCities();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateWeatherData(String city, WeatherData weatherData) {
        Objects.requireNonNull(city);
        Objects.requireNonNull(weatherData);
        if (WEATHER_CACHE.replace(city, WEATHER_CACHE.get(city), weatherData)) {
            System.out.println("City data : \"" + city + "\" updated successfully");
        } else {
            throw new NullPointerException("City : \"" + city + "\" isn't updated. No such city");
        }
    }

    public static void removeWeatherData(String city) {
        Objects.requireNonNull(city);
        if (WEATHER_CACHE.remove(city) != null) {
            System.out.println("City data : \"" + city + "\" removed successfully");
        } else {
            throw new NullPointerException("City : \"" + city + "\" isn't deleted. No such city");
        }
    }

    public static String getWeatherData(String city) {
        Objects.requireNonNull(city);
        if (WEATHER_CACHE.containsKey(city)) {
            return WEATHER_CACHE.get(city).toString();
        } else {
            try {
                WeatherData data = WeatherService.getWeather(city);
                WEATHER_CACHE.put(city, data);
                return data.toString();
            } catch (WeatherServiceException e) {
                System.out.println(e.getMessage());
                return "Check city name";
            }
        }
    }

    public static void printCachedCities() {
        WEATHER_CACHE.forEach((k, v) -> System.out.println(v));
    }
}
