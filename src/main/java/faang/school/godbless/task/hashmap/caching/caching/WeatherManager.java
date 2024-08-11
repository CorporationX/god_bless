package faang.school.godbless.task.hashmap.caching.caching;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class WeatherManager {
    private final Map<String, WeatherData> cityWeatherDataCache;
    private final MockWeatherDataCenterForTest mockWeatherDataCenterForTest;

    public WeatherData findWeatherDataByCity(String city) {
        var weatherData = cityWeatherDataCache.get(city);
        if (weatherData == null) {
            weatherData = mockWeatherDataCenterForTest.getRandomWeatherDataByCityMock(city);
            cityWeatherDataCache.put(city, weatherData);
        }
        return weatherData;
    }

    public WeatherData updateWeatherDataByCityInCache(String city) {
        var weatherData = mockWeatherDataCenterForTest.getRandomWeatherDataByCityMock(city);
        cityWeatherDataCache.put(city, weatherData);
        return weatherData;
    }

    public void deleteWeatherDataByCityInCache(String city) {
        cityWeatherDataCache.remove(city);
    }

    public List<String> findAllCitiesInCache() {
        return cityWeatherDataCache.keySet().stream().toList();
    }
}
