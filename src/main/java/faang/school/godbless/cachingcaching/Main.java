package faang.school.godbless.cachingcaching;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static final Map<String, WeatherData> CACHE = new HashMap<>();

    public static void main(String[] args) {
        getWeatherDataByCity("Moscow");
        getWeatherDataByCity("Kazan");
        getWeatherDataByCity("Voronezh");
        getWeatherDataByCity("Saint Petersburg");
        updateWeatherData("Voronezh", 23.2, 60);
        removeWeatherData("Saint Petersburg");
        showWeatherDataFromCache();
    }

    public static void updateWeatherData(String city, double temperature, int humidity) {
        CACHE.put(city, new WeatherData(city, temperature, humidity));
    }

    public static void removeWeatherData(String city) {
        CACHE.remove(city);
    }

    public static void getWeatherDataByCity(String city) {
        if (!CACHE.containsKey(city)) {
            CACHE.put(city, DB.getByCity(city));
        }
        CACHE.get(city);
    }

    public static void showWeatherDataFromCache() {
        for (WeatherData weatherData : CACHE.values()) {
            System.out.printf("City: %s%nTemperature: %s%nHumidity: %s%n%n", weatherData.city(), weatherData.temperature(), weatherData.humidity());
        }
    }
}