package faang.school.godbless.task.caching.caching;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WeatherManager {
    private Map<String, WeatherData> cityWeatherDataCache;

    public WeatherManager(Map<String, WeatherData> cityWeatherDataCache) {
        this.cityWeatherDataCache = cityWeatherDataCache;
    }

    public WeatherData findWeatherDataByCity(String city) {
        var weatherData = cityWeatherDataCache.get(city);
        if (weatherData == null) {
            weatherData = new MockWeatherDataCenterForTest().getRandomWeatherDataByCityMock(city);
            cityWeatherDataCache.put(city, weatherData);
        }
        return weatherData;
    }

    public WeatherData updateWeatherDataByCityInCache(String city) {
        var weatherData = new MockWeatherDataCenterForTest().getRandomWeatherDataByCityMock(city);
        cityWeatherDataCache.put(city, weatherData);
        return weatherData;
    }

    public void deleteWeatherDataByCityInCache(String city) {
        cityWeatherDataCache.remove(city);
    }

    public List<String> findAllCitiesInCache() {
        List<String> cities = new ArrayList<>();
        cityWeatherDataCache.forEach((k, v) -> cities.add(k));
        return cities;
    }
}
