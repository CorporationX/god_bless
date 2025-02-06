package school.faang.sprint.first.cachingcaching.service;

import school.faang.sprint.first.cachingcaching.model.WeatherData;

public class StandardWeatherCache extends WeatherCacheTemplate {
    @Override
    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return data.getTimestamp() < maxCacheAgeMillis;
    }

    @Override
    public WeatherData updateWeatherData(String city) {
        return new WeatherService().fetchWeatherData(city);
    }
}
