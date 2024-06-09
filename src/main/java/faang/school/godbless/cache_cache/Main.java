package faang.school.godbless.cache_cache;

import lombok.Data;

import java.util.*;

@Data
public class Main {
    private Map<String, WeatherData> data = new HashMap<>();
    private List<WeatherData> weatherData;

    public Main() {
        weatherData = new ArrayList<>(List.of(new WeatherData("Toronto", 20, 20),
                new WeatherData("Calgary", 20, 20),
                new WeatherData("New York", 20, 20),
                new WeatherData("Moscow", 20, 20),
                new WeatherData("Krasnodar", 20, 20),
                new WeatherData("St. Petersburg", 20, 20)
        ));
    }

    WeatherData getWeatherData(String city) {
        for (WeatherData weatherData : weatherData) {
            if (Objects.equals(weatherData.getCity(), city)) return weatherData;
        }
        return null;
    }

    public WeatherData getWeather(String city) {
        if (data.containsKey(city)) return data.get(city);
        WeatherData weatherData = getWeatherData(city);
        if (weatherData != null) {
            data.put(city, weatherData);
        }
        return weatherData;
    }

    public void updateWeather(WeatherData weatherData) {
        Objects.requireNonNull(weatherData);
        this.data.put(weatherData.getCity(), weatherData);
    }

    public void clearCache(String city) {
        data.remove(city);
    }

    public void observeCache() {
        for (Map.Entry<String, WeatherData> entry : data.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
