package school.faang.task_44831.cache;

import school.faang.task_44831.entity.WeatherData;
import school.faang.task_44831.provider.WeatherProvider;
import school.faang.task_44831.provider.WeatherService;

import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {
    protected final Map<String, WeatherData> weatherDataCache = new HashMap<>();
    //Хорошо было бы сделать возможность внешней инициализации данного поля разными сервисами,
    //но в ТЗ этого нет, поэтому реализовывать не стал
    protected WeatherProvider weatherProvider = new WeatherService();

    public abstract WeatherData getWeatherData(String city, long maxCacheAgeMillis);

    protected boolean isCacheExpired(WeatherData weatherData, long maxCacheAgeMillis) {
        long weatherDataAge = System.currentTimeMillis() - weatherData.getTimestamp();
        return weatherDataAge > maxCacheAgeMillis;
    }

    protected WeatherData generateAndSaveWeatherData(String city) {
        WeatherData weatherData = weatherProvider.fetchWeatherData(city);
        weatherDataCache.put(city, weatherData);
        return weatherData;
    }

    protected void clearExpiredCache(long maxCacheAgeMillis) {
        weatherDataCache.entrySet()
                .removeIf(entry -> (System.currentTimeMillis() - entry
                        .getValue().getTimestamp()) > maxCacheAgeMillis);
    }
}
