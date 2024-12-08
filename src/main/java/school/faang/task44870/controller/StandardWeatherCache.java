package school.faang.task44870.controller;

import school.faang.task44870.model.WeatherData;

public class StandardWeatherCache extends WeatherCacheTemplate {
    @Override
    protected boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        long currentTime = System.currentTimeMillis();
        return currentTime - data.getTimestamp() > maxCacheAgeMillis;
    }
}
