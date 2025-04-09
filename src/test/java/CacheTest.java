import org.junit.jupiter.api.*;
import school.faang.cache.FrequentUpdateWeatherCache;
import school.faang.cache.StandardWeatherCache;
import school.faang.cache.WeatherCacheTemplate;
import school.faang.cache.WeatherData;
import school.faang.cache.WeatherProvider;
import school.faang.cache.WeatherService;

import static org.junit.jupiter.api.Assertions.*;


public class CacheTest {
    private final WeatherProvider provider = new WeatherService();

    @Test
    @DisplayName("Стандартный кэш: данные не обновляются если не устарели")
    void standardWeatherCacheTest() throws InterruptedException {
        WeatherCacheTemplate standardCache = new StandardWeatherCache(provider);
        WeatherData first = standardCache.getWeatherData("НН", 1000);

        WeatherData second = standardCache.getWeatherData("НН", 3000);
        assertSame(first, second, "Должны возвращаться одинаковые объекты из кэша");

        Thread.sleep(2000);
        second = standardCache.getWeatherData("НН", 1000);
        assertNotSame(first, second, "Должны возвращаться разные объекты из кэша");
    }

    @Test
    @DisplayName("Частый кэш: данные обновляются при каждом запросе")
    void frequentUpdateWeatherTest() {
        WeatherCacheTemplate frequentCache = new FrequentUpdateWeatherCache(provider);
        WeatherData first = frequentCache.getWeatherData("НН", 1000);

        WeatherData second = frequentCache.getWeatherData("НН", 4000);
        assertNotSame(first, second, "Должны возвращаться разные объекты из кэша");
    }

    @Test
    @DisplayName("Принудительное обновление для всех кэшей")
    void forceUpdateWorksForAllCaches() {
        WeatherCacheTemplate standardCache = new StandardWeatherCache(provider);
        WeatherData first = standardCache.getWeatherData("НН", 5000);

        WeatherData second = standardCache.getWeatherData("НН", 5000);
        assertSame(first, second, "Должны возвращаться одинаковые объекты из кэша");

        second = standardCache.forceUpdateWeather("НН");
        assertNotSame(first, second, "Должны возвращаться разные объекты из кэша");
    }

    @Test
    @DisplayName("Очистка устаревших данных работает корректно")
    void clearExpiredCacheTest() throws InterruptedException {
        WeatherCacheTemplate standardCache = new StandardWeatherCache(provider);

        WeatherData first = standardCache.getWeatherData("НН", 1000);
        assertSame(first, standardCache.getWeatherData("НН", 3000),
                "Должны возвращаться одинаковые объекты из кэша");

        WeatherData second = standardCache.getWeatherData("Питер", 1000);
        assertSame(second, standardCache.getWeatherData("Питер", 3000),
                "Должны возвращаться одинаковые объекты из кэша");

        WeatherData third = standardCache.getWeatherData("Москва", 1200);
        assertSame(third, standardCache.getWeatherData("Москва", 3000),
                "Должны возвращаться одинаковые объекты из кэша");
        Thread.sleep(2000);
        WeatherData fourth = standardCache.getWeatherData("Казань", 4000);
        assertSame(fourth, standardCache.getWeatherData("Казань", 4000),
                "Должны возвращаться одинаковые объекты из кэша");

        Thread.sleep(2000);
        standardCache.clearExpiredCache(3000);

        assertNotSame(first, standardCache.getWeatherData("НН", 3000),
                "Должны возвращаться разные объекты из кэша");
        assertNotSame(second, standardCache.getWeatherData("Питер", 3000),
                "Должны возвращаться разные объекты из кэша");
        assertNotSame(third, standardCache.getWeatherData("Москва", 3000),
                "Должны возвращаться разные объекты из кэша");
        assertSame(fourth, standardCache.getWeatherData("Казань", 4000),
                "Должны возвращаться одинаковые объекты из кэша");
    }
}
