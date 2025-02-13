package school.faang.task_56899;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    @Override
    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return true;
    }

    @Override
    public void cleanExpiredCache(long maxCacheAgeMillis) {
        weatherDataCache.clear();
        logger.info("Удаление устаревших данных: все устаревшие данные удалены.");
    }
}
