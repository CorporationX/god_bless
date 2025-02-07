package school.faang.sprint.first.cachingcaching.service;

import lombok.RequiredArgsConstructor;
import school.faang.sprint.first.cachingcaching.model.WeatherData;

@RequiredArgsConstructor
public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    private final WeatherProvider weatherProvider;

    @Override
    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return true;
    }

    @Override
    public WeatherData updateWeatherData(String city) {
        return weatherProvider.fetchWeatherData(city);
    }
}
