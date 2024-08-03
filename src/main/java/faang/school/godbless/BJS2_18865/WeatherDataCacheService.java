package faang.school.godbless.BJS2_18865;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

public class WeatherDataCacheService {
    @Getter @Setter
    private HashMap<String, WeatherData> allCitiesToWeatherCacheData = new HashMap<>();

    public void storeCityToWeatherCache(final String city, final WeatherData weatherData) {
        allCitiesToWeatherCacheData.put(city, weatherData);
    }

    public boolean containsCity(final String city) {
        return allCitiesToWeatherCacheData.containsKey(city);
    }

    public WeatherData getCityWeatherData(final String city) {
        return allCitiesToWeatherCacheData.get(city);
    }

    public void editCityWeatherData(final String city, final WeatherData weatherData) {
        allCitiesToWeatherCacheData.put(city, weatherData);
    }

    public void removeCityWeatherData(final String city) {
        allCitiesToWeatherCacheData.remove(city);
    }

    public void printAllCacheData() {
        for (final WeatherData weatherData : allCitiesToWeatherCacheData.values()) {
            System.out.println(weatherData);
        }
    }


}
