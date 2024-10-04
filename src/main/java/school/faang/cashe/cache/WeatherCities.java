package school.faang.cashe.cache;

import java.util.HashMap;
import java.util.Map;

public class WeatherCities {
    private Map<String, WeatherData> cacheWeatherData;

    public WeatherCities() {
        this.cacheWeatherData = new HashMap<>();
    }

    public WeatherData getWeatherData(String city) {
        return cacheWeatherData.getOrDefault(city, MockWeatherInfo.getWeatherData(city));
    }

    public void updateWeatherDataForCity(String city) {
        WeatherData updatedWeatherData = MockWeatherInfo.getWeatherData(city);
        cacheWeatherData.put(city, updatedWeatherData);
    }

    public void removeWeatherDataForCity(String city) {
        cacheWeatherData.remove(city);
    }

    public void printAllCities() {
        cacheWeatherData.keySet().forEach(System.out::println);
    }

    public void printAllData() {
        cacheWeatherData.forEach(
                (city, data) -> System.out.println(city + " " + data)
        );
    }
}
