package faang.school.godbless.hashmap.cache;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Main {
    private final DataWeatherServer dataWeatherServer = new DataWeatherServer();
    private final Map<String, WeatherData> weatherDataCache = new HashMap<>(Map.of(
            "New York", new WeatherData("New York", 25.0, 60),
            "Los Angeles", new WeatherData("Los Angeles", 22.5, 50),
            "Chicago", new WeatherData("Chicago", 18.0, 70),
            "Houston", new WeatherData("Houston", 30.0, 80),
            "Phoenix", new WeatherData("Phoenix", 35.0, 20)));

    public WeatherData getWeatherData(String cityName) {
        return weatherDataCache.getOrDefault(cityName,
                updateWeatherDataFromServer(cityName));
    }

    public WeatherData updateWeatherDataFromServer(String cityName) {
        return dataWeatherServer.getData(cityName);
    }

    public WeatherData deleteWeatherDataFromCache(String cityName) {
        return weatherDataCache.remove(cityName);
    }

    public void printWeatherDataFromCache() {
        weatherDataCache.values().forEach(System.out::println);
    }
}
