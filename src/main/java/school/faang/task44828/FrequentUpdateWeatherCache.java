package school.faang.task44828;

import java.util.Map;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    private long maxCacheTime;

    public FrequentUpdateWeatherCache(long maxCacheAgeMillis) {
        super();
        this.maxCacheTime = maxCacheAgeMillis;
    }

    @Override
    public WeatherData getWeatherData(String city) {
        return validityPeriod(city, maxCacheTime);
    }

    @Override
    protected void isExpired(String city) {
        validityPeriod(city, maxCacheTime);
    }

}
