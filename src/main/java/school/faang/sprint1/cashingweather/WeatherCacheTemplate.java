package school.faang.sprint1.cashingweather;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * Abstract base class, defines the template method for caching weather data.
 * Subclasses customize the expiration policy.
 */
@RequiredArgsConstructor
public abstract class WeatherCacheTemplate {

    protected final Map<String, WeatherData> cache = new HashMap<>();
    protected final WeatherProvider provider;

    /**
     * Determines whether cashed weather data is expired or not
     *
     * @param data              the weather data
     * @param maxCacheAgeMillis max cache age in milliseconds
     * @return trueif expired, false otherwise
     */
    public abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    /**
     * Retrieves weather data for a specific city.
     * <ul>
     *     <li>If valid cache data exist, returns it</li>
     *     <li>Or fetches the latest data from the provider, stores it in cache</li>
     * </ul>
     *
     * @param city              city name
     * @param maxCacheAgeMillis max cache age in miliseconds
     * @return weather data
     */
    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData weatherCached = cache.get(city);

        if (weatherCached != null && isCacheExpired(weatherCached, maxCacheAgeMillis)) {
            return weatherCached;
        }
        WeatherData latestWeather = provider.fetchWeatherData(city);
        cache.put(city, latestWeather);
        return latestWeather;
    }

    /**
     * Forces cache refresh for a city regardless of expiration status
     *
     * @param city city name
     * @return refreshed weather data
     */
    protected WeatherData forceUpdateWeather(String city) {
        WeatherData latest = provider.fetchWeatherData(city);
        cache.put(city, latest);
        return latest;
    }

    /**
     * Removes expired data records from the cache
     *
     * @param maxCacheAgeMillis max cache age in milliseconds
     */
    public void clearExpiredCache(long maxCacheAgeMillis) {
        cache.entrySet().removeIf(entry ->
            isCacheExpired(entry.getValue(), maxCacheAgeMillis));
    }
}
