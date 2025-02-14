package school.faang.bjs2_56915;

import lombok.Getter;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@Getter
public abstract class WeatherCacheTemplate {
    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherCacheTemplate.class);
    protected final Map<String, WeatherData> cache = new HashMap<>();
    private final WeatherProvider weatherProvider;

    public WeatherCacheTemplate(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }

    public WeatherData getWeatherData(@NonNull String city, @NonNull long maxCacheAgeMillis) {
        if (city.isEmpty()) {
            String message = "Значение 'Город' не может быть пустым";
            LOGGER.error(message);
            throw new IllegalArgumentException(message);
        }
        if (maxCacheAgeMillis < 0) {
            String message = "Значение максимального возраста кэша не может быть меньше 0";
            LOGGER.error(message);
            throw new IllegalArgumentException(message);
        }
        WeatherData cacheData = cache.get(city);
        if (cacheData == null && isCacheExpired(cacheData, maxCacheAgeMillis)) {
            return updateWeatherData(city);
        }
        return cacheData;
    }

    public abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    public WeatherData updateWeatherData(@NonNull String city) {
        WeatherData data = weatherProvider.fetchWeatherData(city);
        cache.put(city, data);
        return data;
    }

}
