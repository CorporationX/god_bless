package school.faang.weather.cache;

import school.faang.weather.model.WeatherData;
import school.faang.weather.service.WeatherProvider;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {

    public FrequentUpdateWeatherCache(WeatherProvider provider) {
        super(provider);
    }

    @Override
    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return true;
    }

    public WeatherData getWeatherDataForCity(String city, long maxCacheAgeMillis) {
        return getWeatherData(city, maxCacheAgeMillis);
    }
}