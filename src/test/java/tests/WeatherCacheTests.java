package tests;

import org.junit.jupiter.api.*;
import school.faang.task_44830.WeatherCacheTemplate;
import school.faang.task_44830.WeatherData;
import school.faang.task_44830.WeatherProvider;
import school.faang.task_44830.WeatherService;
import school.faang.task_44830.styles.FrequentWeatherCache;
import school.faang.task_44830.styles.StandartWeatherCache;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class WeatherCacheTests {
    private static WeatherProvider weatherProvider = new WeatherService();
    private static final long MAXAGE = 5000;

    @Test
    void standartCachingTest() {
        String city = "Moscow";

        WeatherCacheTemplate cache = new StandartWeatherCache(weatherProvider);

        WeatherData data1 = cache.getWeatherData(city, MAXAGE);
        WeatherData data2 = cache.getWeatherData(city, MAXAGE);

        Assertions.assertEquals(data1, data2);
    }

    @Test
    void frequentCachingTest() {
        String city = "Moscow";

        WeatherCacheTemplate cache = new FrequentWeatherCache(weatherProvider);

        WeatherData data1 = cache.getWeatherData(city, MAXAGE);
        WeatherData data2 = cache.getWeatherData(city, MAXAGE);

        Assertions.assertNotEquals(data1, data2);
    }

    @Test
    void clearCacheTest() throws InterruptedException {
        String city = "Moscow";

        WeatherCacheTemplate cache = new StandartWeatherCache(weatherProvider);

        WeatherData cachedData = cache.getWeatherData(city, MAXAGE);

        await().atMost(MAXAGE + 100, TimeUnit.MILLISECONDS)
                .until(() -> {
                    cache.clearCache(MAXAGE);
                    return cache.getWeatherData(city, MAXAGE) != cachedData;
                });

        WeatherData newData = cache.getWeatherData(city, MAXAGE);

        Assertions.assertNotEquals(cachedData, newData);
    }
}
