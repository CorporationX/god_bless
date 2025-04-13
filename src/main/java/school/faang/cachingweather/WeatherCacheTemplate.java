package school.faang.cachingweather;

import java.util.Map;

public abstract class WeatherCacheTemplate {
    private Map<String, WeatherData> cityWeather;
    private WeatherService weatherService;

    public abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        if (cityWeather.containsKey(city)) {
            if (!isCacheExpired(cityWeather.get(city), maxCacheAgeMillis)) {
                return cityWeather.get(city);
            }
        }
        WeatherData weatherData = getWeather(city);
        cityWeather.put(city, weatherData);
        return weatherData;
    }

    public WeatherData forceUpdateWeather(String city) {
        WeatherData weatherData = getWeather(city);
        return weatherData;
    }

    public WeatherData getWeather(String city) {
        WeatherData weatherData = weatherService.fetchWeatherData(city);
        cityWeather.put(city, weatherData);
        return weatherData;
    }

    public void clearExpiredCache(long maxCacheAgeMillis) {
        cityWeather.forEach((city, weatherData) -> {
            long cacheAgeMillis = System.currentTimeMillis() - weatherData.getTimestamp();
            if (maxCacheAgeMillis < cacheAgeMillis) {
                cityWeather.remove(city);
            }
        });
    }
}
