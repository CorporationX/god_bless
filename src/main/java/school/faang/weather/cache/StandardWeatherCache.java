package school.faang.weather.cache;

import school.faang.weather.model.WeatherData;
import school.faang.weather.service.WeatherProvider;

public class StandardWeatherCache extends WeatherCacheTemplate {

    public StandardWeatherCache(WeatherProvider provider) {
        super(provider);
    }

    @Override
    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return System.currentTimeMillis() - data.getTimestamp() > maxCacheAgeMillis;
    }

    public WeatherData getWeatherDataForCity(String city, long maxCacheAgeMillis) {
        return getWeatherData(city, maxCacheAgeMillis);
    }
}
