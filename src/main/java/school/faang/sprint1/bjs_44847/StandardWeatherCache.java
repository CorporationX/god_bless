package school.faang.sprint1.bjs_44847;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StandardWeatherCache extends WeatherCacheTemplate {
    private final WeatherService weatherService = new WeatherService();

    @Override
    protected final WeatherData fetchWeatherData(String city) {
        return weatherService.fetchWeatherData(city);
    }

    @Override
    protected boolean isCacheValid(long cacheCreationTime, long maxCacheAgeMillis) {
        return (System.currentTimeMillis() - cacheCreationTime) < maxCacheAgeMillis;
    }
}
