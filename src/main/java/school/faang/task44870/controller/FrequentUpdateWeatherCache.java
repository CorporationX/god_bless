package school.faang.task44870.controller;

import school.faang.task44870.model.WeatherData;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    @Override
    protected boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return true;
    }


}
