package school.faang.sprint1.task_BJS2_57007.cache;

import lombok.Getter;
import school.faang.sprint1.task_BJS2_57007.data.WeatherData;
import school.faang.sprint1.task_BJS2_57007.data.WeatherProvider;
import school.faang.sprint1.task_BJS2_57007.data.WeatherService;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Getter
public abstract class WeatherCacheTemplate {
    private static final WeatherProvider weatherProvider = new WeatherService();
    private final Map<String, WeatherData> citiesWeather = new HashMap<>();

    public abstract WeatherData getWeatherData(String city, long maxCacheAgeMillis);

    protected boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        long now = Instant.now().toEpochMilli();
        return now - data.getTimestamp() > maxCacheAgeMillis;
    }

    protected WeatherData updateWeatherData(String city) {
        WeatherData newData = weatherProvider.fetchWeatherData(city);
        citiesWeather.put(newData.getCity(), newData);
        return newData;
    }
}
