package school.faang.sprint_1.task_44835.cache.impl;

import lombok.RequiredArgsConstructor;
import school.faang.sprint_1.task_44835.cache.WeatherCacheTemplate;
import school.faang.sprint_1.task_44835.dto.WeatherData;
import school.faang.sprint_1.task_44835.service.WeatherService;

@RequiredArgsConstructor
public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    private final WeatherService weatherService = new WeatherService();

    @Override
    protected WeatherData fetchWeatherData(String city) {
        return weatherService.fetchWeatherData(city);
    }

    @Override
    protected boolean isCacheRelevant(long cacheCreationTime, long maxCacheAgeMillis) {
        return false;
    }
}
