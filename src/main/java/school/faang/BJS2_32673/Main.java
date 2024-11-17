package school.faang.BJS2_32673;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final Map<String, WeatherData> weatherCache = new HashMap<>();
    private static final WeatherService weatherService = new WeatherService();

    public static WeatherData getWeatherData(String city) {
        if (weatherCache.containsKey(city)) {
            System.out.println("Getting data from the cache...");
            return weatherCache.get(city);
        } else {
            System.out.println("Getting data from an external service...");
            WeatherData weatherData = weatherService.fetchWeatherData(city);
            weatherCache.put(city, weatherData);
            return weatherData;
        }
    }

    public static void updateWeatherData(String city, WeatherData newWeatherData) {
        weatherCache.put(city, newWeatherData);
        System.out.println("Weather information for " + city + " updated in the cache.");
    }

    public static void removeWeatherData(String city) {
        weatherCache.remove(city);
        System.out.println("Weather information for " + city + " remove in the cache.");
    }

    public static Set<String> getAllCities() {
        return weatherCache.keySet();
    }

    public static void main(String[] args) {

        WeatherData moscowWeather = getWeatherData("Moscow");
        System.out.println("Weather in Moscow: " + moscowWeather);

        moscowWeather = getWeatherData("Moscow");
        System.out.println("Weather in Moscow: " + moscowWeather);

        updateWeatherData("Moscow", new WeatherData("Moscow", 20.0, 70.0));
        System.out.println("Updated weather data in Moscow: " + getWeatherData("Moscow"));

        Set<String> cities = getAllCities();
        System.out.println("Cities in the cache: " + cities);

        removeWeatherData("Moscow");
        System.out.println("Cities in the cache after deletion: " + getAllCities());
    }
}
