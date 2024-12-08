package school.faang.bjs244827.cache;

import lombok.RequiredArgsConstructor;
import school.faang.bjs244827.model.WeatherData;
import school.faang.bjs244827.service.WeatherProvider;
import school.faang.bjs244827.service.WeatherService;

@RequiredArgsConstructor
public class StandardWeatherCache extends WeatherCacheTemplate {
    private final WeatherProvider service;

    @Override
    protected boolean isCacheValid(WeatherData data, long maxCacheAgeMillis) {
        return System.currentTimeMillis() - data.timestamp() <= maxCacheAgeMillis;
    }

    @Override
    protected WeatherData refreshWeatherData(String city) {
        return service.fetchWeatherData(city);
    }
}
