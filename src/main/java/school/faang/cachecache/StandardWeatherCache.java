package school.faang.cachecache;

/**
 * Проверяет актуальность данных с помощью maxCacheAgeMillis.
 * Возвращает данные из кэша, если они актуальны, и запрашивает новые только при необходимости
 */
public class StandardWeatherCache extends WeatherCacheTemplate {

    public StandardWeatherCache(WeatherProvider provider) {
        super(provider);
    }

    @Override
    protected boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return System.currentTimeMillis() - data.getTimestamp() > maxCacheAgeMillis;
    }
}
