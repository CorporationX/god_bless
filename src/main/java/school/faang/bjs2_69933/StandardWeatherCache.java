package school.faang.bjs2_69933;

import lombok.extern.slf4j.Slf4j;

public class StandardWeatherCache extends WeatherCacheTemplate {
    @Override
    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        if (System.currentTimeMillis() - data.getTimestamp() > maxCacheAgeMillis) {
            return true;
        }
        return false;
    }
}
