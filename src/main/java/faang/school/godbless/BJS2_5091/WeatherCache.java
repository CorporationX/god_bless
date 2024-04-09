package faang.school.godbless.BJS2_5091;

import java.util.HashMap;
import java.util.Map;

public class WeatherCache {

    Map<String, WeatherData> cache = new HashMap<>();

    public WeatherData getWeatherByCity(String city) {
        if (cache.containsKey(city)) {
            return cache.get(city);
        } else {
            WeatherData weatherDataFromService = getWeatherFromService(city);
            cache.put(city, weatherDataFromService);
            return weatherDataFromService;
        }
    }

    private WeatherData getWeatherFromService(String city) {
        return new WeatherData(city, (int) (Math.random() * 30), (int) (Math.random() * 100));
    }

    public void updateWeather(WeatherData data) {
        cache.put(data.getCity(), data);
    }

    public void removeWeather(String city) {
        cache.remove(city);
    }

    public void printAllWeatherCity() {
        for (Map.Entry<String, WeatherData> entry : cache.entrySet()) {
            if (entry.getValue() != null) {
                System.out.println(entry.getKey() + ": " + "temperature = " + entry.getValue().getTemperature() +
                        ", humidity = " + entry.getValue().getHumidity());
            }
        }
    }
}
