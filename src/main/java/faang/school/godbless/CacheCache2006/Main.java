package faang.school.godbless.CacheCache2006;

import java.util.HashMap;
import java.util.Map;

public class Main {

    static Map<String, WeatherData> weatherDataCache = new HashMap<>();
    private static final String SURGUT = "Surgut";
    private static final String MIAMI = "Miami";
    private static final String BANGKOK = "Bangkok";

    public static void main(String[] args) {
        weatherDataCache.put(SURGUT, new WeatherData(SURGUT, -50.0, 68.0));
        weatherDataCache.put(MIAMI, new WeatherData(MIAMI, 28, 55));

        System.out.println("Test 1: Printing dafault cache info:");
        System.out.println(getWeather(SURGUT));
        System.out.println(getWeather(MIAMI));

        System.out.println("Test 2: Printing not cached city info (should be 20/60)");
        System.out.println(getWeather(BANGKOK));
        removeWeatherData(SURGUT);

        System.out.println("Test 3: Removed Surgut. http request should be done (20/60 again)");
        System.out.println(getWeather(SURGUT));

        System.out.println("Test 4: Updated Surgut data. Should be -35/57");
        updateWeatherData(SURGUT, -35.0, 57);
        System.out.println(getWeather(SURGUT));

        System.out.println("Test 5: Print all cached cities (Miami, Surgut, Bangkok)");
        printAllCachedCities();
    }

    public static String getWeather(String city) {
        if (weatherDataCache.containsKey(city)) {
            return weatherDataCache.get(city).toString();
        } else {
            OpenWeather.cacheWeatherFromOpenSource("https://openweathermap.org", city);
            return weatherDataCache.get(city).toString();
        }
    }

    public static void updateWeatherData(String city, double temperature, double humidity) {
        weatherDataCache.put(city, new WeatherData(city, temperature, humidity));
    }

    public static void removeWeatherData(String city) {
        weatherDataCache.remove(city);
    }

    public static void printAllCachedCities() {
        for (var entry : weatherDataCache.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                System.out.println(entry.getKey());
            }
        }
    }
}
