package Caching;

import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@NoArgsConstructor
public class WeatherService {
    private static final Map<String, WeatherData> WEATHER_CACHE = new HashMap<>();

    public WeatherData getWeatherInfo(String city) {
        if (WEATHER_CACHE.containsKey(city)) {
            return WEATHER_CACHE.get(city);
        } else {
            WeatherData weatherData = getWeather(city);
            WEATHER_CACHE.put(city, weatherData);
            return weatherData;
        }
    }

    public WeatherData getWeather(String city) {
        Random random = new Random();
        double temperature = (double) (random.nextInt(3000) - 1000) / 100;
        double humidity = (double) (random.nextInt(3000) - 1000) / 100;
        return new WeatherData(city, temperature, humidity);
    }

    public void updateInfo(String city) {
        if (WEATHER_CACHE.containsKey(city)) {
            WEATHER_CACHE.put(city, new WeatherData(city, 16.0, 22.0));
            System.out.println("\nИнформация обновлена.");
            return;
        }
        System.out.println("\nТакого города в кэше нет.");
    }

    public void removeInfo(String city) {
        WEATHER_CACHE.remove(city);
        System.out.println("\nГород удален из кэша.");
    }

    public void printInfoCache() {
        System.out.println("------------------------");
        System.out.println("На данный момент в кэше доступны следующие города: ");
        for (Map.Entry<String, WeatherData> entry : WEATHER_CACHE.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
