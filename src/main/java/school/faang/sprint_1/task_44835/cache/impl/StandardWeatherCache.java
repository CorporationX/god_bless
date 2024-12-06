package school.faang.sprint_1.task_44835.cache.impl;

import school.faang.sprint_1.task_44835.dto.WeatherData;
import school.faang.sprint_1.task_44835.service.WeatherService;
import school.faang.sprint_1.task_44835.cache.WeatherCacheTemplate;

public class StandardWeatherCache extends WeatherCacheTemplate {
    private WeatherService weatherService = new WeatherService();

    @Override
    protected WeatherData fetchWeatherData(String city) {
        return weatherService.fetchWeatherData(city);
    }

    @Override
    protected boolean checkRelevanceCache(long cacheCreationTime, long maxCacheAgeMillis) {
        return (getCurrentTime() - cacheCreationTime) < maxCacheAgeMillis;
    }
}
