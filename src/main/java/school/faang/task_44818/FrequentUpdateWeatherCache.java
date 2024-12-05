package school.faang.task_44818;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    private final WeatherProvider provider;

    @Override
    protected boolean isCacheValid(WeatherData cachedData, long maxCacheAgeMillis) {
        return false;
    }

    @Override
    protected WeatherData fetchWeatherData(String city) {
        return provider.fetchWeatherData(city);
    }
}
