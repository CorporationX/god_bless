package faang.school.godbless.caching;

import java.util.Map;
import java.util.Random;

public class WeatherDataService {
    public void getWeatherDataForCity(Map<String, WeatherData> weatherCache, String city) {
        weatherCache.computeIfAbsent(city, this::getRandomWeatherData);
        System.out.println(weatherCache.get(city).getCity() +
                " Temperature: " + weatherCache.get(city).getTemperature() +
                " Humidity: " + weatherCache.get(city).getHumidity()
        );
    }

    private WeatherData getRandomWeatherData(String city) {
        Random random = new Random();
        return new WeatherData(city, random.nextInt(-20, 50), random.nextInt(0, 90));
    }

    public void updateWeatherData(Map<String, WeatherData> weatherCache, String city) {
        weatherCache.put(city, getRandomWeatherData(city));
    }

    public void removeWeatherData(Map<String, WeatherData> weatherCache, String city) {
        weatherCache.remove(city);
    }

    public void weatherInfoForAllCities(Map<String, WeatherData> weatherCache) {
        weatherCache.forEach((key, value) -> {
            if (key != null) {
                System.out.println(key +
                        " Temperature: " + value.getTemperature() +
                        " Humidity: " + value.getHumidity());
            }
        });
    }
}
