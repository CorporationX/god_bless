package school.faang.cachecache;

/**
 * Всегда считает данные устаревшими, вызывая обновление при каждом запросе.
 * Используется для городов с быстро меняющейся погодой.
 */
public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {

    public FrequentUpdateWeatherCache(WeatherProvider provider) {
        super(provider);
    }

    @Override
    protected boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        //данные по умолчанию устаревшие
        return true;
    }
}
