package school.faang.task_44860;

import lombok.NonNull;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    private static final int maxCacheAgeMillis = 1000;


    @Override
    protected boolean isCacheExpired(@NonNull String city) {
        long currentTime = System.currentTimeMillis();
        return currentTime - getCachedWeather().get(city).getTimestamp() > maxCacheAgeMillis;
    }

    @Override
    protected void clearExpiredCache() {
        long currentTime = System.currentTimeMillis();
        getCachedWeather().entrySet()
                .removeIf((entry) -> (currentTime - entry.getValue().getTimestamp()) > maxCacheAgeMillis);
    }
}
