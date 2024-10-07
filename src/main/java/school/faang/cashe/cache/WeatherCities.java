package school.faang.cashe.cache;

import java.util.HashMap;
import java.util.Map;

public class WeatherCities {
    private Map<String, WeatherData> cachedWeatherData = new HashMap<>();

    public WeatherData getWeatherData(String city) {
        return cachedWeatherData.getOrDefault(city, MockWeatherInfo.getWeatherData(city));
    }

    public void updateWeatherDataForCity(String city) {
        WeatherData updatedWeatherData = MockWeatherInfo.getWeatherData(city);
        cachedWeatherData.put(city, updatedWeatherData);
    }

    public void removeWeatherDataForCity(String city) {
        cachedWeatherData.remove(city);
    }

    public void printAllCities() {
        cachedWeatherData.keySet().forEach(System.out::println);
    }

    public void printAllData() {
        cachedWeatherData.forEach(
                (city, data) -> System.out.println(city + " " + data)
        );
    }
}
