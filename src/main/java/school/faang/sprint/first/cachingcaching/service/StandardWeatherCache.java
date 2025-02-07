package school.faang.sprint.first.cachingcaching.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import school.faang.sprint.first.cachingcaching.model.WeatherData;

@RequiredArgsConstructor
public class StandardWeatherCache extends WeatherCacheTemplate {
    private final WeatherProvider weatherProvider;

    @Override
    public boolean isCacheExpired(@NonNull WeatherData data, long maxCacheAgeMillis) {
        return data.getTimestamp() - maxCacheAgeMillis <= 0;
    }

    @Override
    public WeatherData updateWeatherData(@NonNull String city) {
        return weatherProvider.fetchWeatherData(city);
    }
}
