package school.faang.weather;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Danil Pudovkin
 * @since 06.06.2025
 */
@RequiredArgsConstructor
public abstract class WeatherCacheTemplate {

    @Getter
    protected final Map<String, WeatherData> weatherDataByCity = new HashMap<>();
    protected final WeatherProvider weatherProvider;

    public abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        var requestedWeatherData = weatherDataByCity.get(city);
        if (requestedWeatherData == null) {
            return forceUpdateWeather(city);
        }
        if (isCacheExpired(requestedWeatherData, maxCacheAgeMillis)) {
            return forceUpdateWeather(city);
        }
        return requestedWeatherData;
    }

    public WeatherData forceUpdateWeather(String city) {
        var newWeatherData = weatherProvider.fetchWeatherData(city);
        weatherDataByCity.put(city, newWeatherData);
        System.out.printf("Update weather data for %s%n", city);
        return newWeatherData;
    }

    public void clearExpiredCache(long maxCacheAgeMillis) {
        var it = weatherDataByCity.entrySet().iterator();
        while (it.hasNext()) {
            var entry = it.next();
            if (isCacheExpired(entry.getValue(), maxCacheAgeMillis)) {
                it.remove();
                System.out.println("Removed weather data for " + entry.getKey());
            }
        }
    }
}
