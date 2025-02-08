package school.faang.cashingcashing;

import java.util.Iterator;
import java.util.Map;

public class StandardWeatherCache extends WeatherCacheTemplate {
    @Override
    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        if (getWeathersDataCache().containsKey(city)) {
            if (isCacheExpired(getWeathersDataCache().get(city), maxCacheAgeMillis)) {
                updateWeatherData(city);
            }
        } else {
            updateWeatherData(city);
        }
        return getWeathersDataCache().get(city);
    }

    public void clearExpiredCache(long maxCacheAgeMillis) {
        Iterator<Map.Entry<String, WeatherData>> iterator = getWeathersDataCache().entrySet().iterator();

        while (iterator.hasNext()) {
            String city = iterator.next().getKey();
            if (isCacheExpired(getWeathersDataCache().get(city), maxCacheAgeMillis)) {
                iterator.remove();
            }
        }
    }
}
