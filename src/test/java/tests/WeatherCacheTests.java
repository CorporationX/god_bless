package tests;

import org.junit.jupiter.api.*;
import school.faang.task_44830.WeatherCacheTemplate;
import school.faang.task_44830.WeatherData;
import school.faang.task_44830.WeatherProvider;
import school.faang.task_44830.WeatherService;
import school.faang.task_44830.stylesCache.FrequentWeatherCache;
import school.faang.task_44830.stylesCache.StandartWeatherCache;

public class WeatherCacheTests {
    private static WeatherProvider weatherProvider;
    private static long maxAge = 5000;

    @BeforeAll
    static void getWeatherProvider() {
        weatherProvider = new WeatherService();
    }

    @Test
    void standartCachingTest() {
        String city = "Moscow";

        WeatherCacheTemplate cache = new StandartWeatherCache(weatherProvider);

        WeatherData data1 = cache.getWeatherData(city, maxAge);
        WeatherData data2 = cache.getWeatherData(city, maxAge);

        Assertions.assertEquals(data1, data2);
    }

    @Test
    void frequentCachingTest() {
        String city = "Moscow";

        WeatherCacheTemplate cache = new FrequentWeatherCache(weatherProvider);

        WeatherData data1 = cache.getWeatherData(city, maxAge);
        WeatherData data2 = cache.getWeatherData(city, maxAge);

        Assertions.assertNotEquals(data1, data2);
    }

    @Test
    void clearCacheTest() throws InterruptedException {
        String city = "Moscow";

        WeatherCacheTemplate cache = new StandartWeatherCache(weatherProvider);

        WeatherData cachedData = cache.getWeatherData(city, maxAge);

        Thread.sleep(maxAge + 100);

        cache.clearCache(maxAge);

        WeatherData newData = cache.getWeatherData(city, maxAge);

        Assertions.assertNotEquals(cachedData, newData);
    }
}
