package school.faang.task_56899;

import lombok.NonNull;

import java.util.Iterator;
import java.util.Map;

public class StandardWeatherCache extends WeatherCacheTemplate {
    @Override
    public boolean isCacheExpired(@NonNull WeatherData data, long maxCacheAgeMillis) {
        long currentTime = System.currentTimeMillis();
        return (currentTime - data.getTimestamp()) > maxCacheAgeMillis;
    }

    @Override
    public void cleanExpiredCache(long maxCacheAgeMillis) {
        Iterator<Map.Entry<String, WeatherData>> iterator = weatherDataCache.entrySet().iterator();
        while (iterator.hasNext()) {
            var entry = iterator.next();
            WeatherData data = entry.getValue();
            if (data != null && isCacheExpired(data, maxCacheAgeMillis)) {
                iterator.remove();
                logger.info("Удаление устаревших данных: данные для \"{}\" удалены.", entry.getKey());
            }
        }
    }
}
