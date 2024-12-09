package school.faang.bjs244827.cache;

import lombok.RequiredArgsConstructor;
import school.faang.bjs244827.model.WeatherData;
import school.faang.bjs244827.service.WeatherProvider;

@RequiredArgsConstructor
public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    private final WeatherProvider service;

    @Override
    protected boolean isCacheValid(WeatherData data, long maxCacheAgeMillis) {
        return false;
    }

    @Override
    protected WeatherData refreshWeatherData(String city) {
        return service.fetchWeatherData(city);
    }
}