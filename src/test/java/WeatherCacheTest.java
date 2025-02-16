import WeatherCache.FrequentUpdateWeatherCache;
import WeatherCache.StandardWeatherCache;
import WeatherCache.WeatherCacheTemplate;
import WeatherCache.WeatherData;
import WeatherCache.WeatherProvider;
import WeatherCache.WeatherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeatherCacheTest {
    private WeatherCacheTemplate standardCache;
    private WeatherCacheTemplate frequentUpdateCache;
    private final String city = "Moscow";
    private final long maxCacheAgeMillis = 30000;

    @BeforeEach
    void setUp() {
        WeatherProvider weatherProvider = new WeatherService();
        standardCache = new StandardWeatherCache(weatherProvider);
        frequentUpdateCache = new FrequentUpdateWeatherCache(weatherProvider);
    }

    @Test
    void testStandardWeatherCache_ShouldReturnFromCache() {
        WeatherData firstFetch = standardCache.getWeatherData(city, maxCacheAgeMillis);
        assertNotNull(firstFetch, "Data cannot be null!");
        assertTrue(firstFetch.getTemperature() >= -30 && firstFetch.getTemperature() <= 50,
                "The temperature must be between -30 and 50");

        WeatherData secondFetch = standardCache.getWeatherData(city, maxCacheAgeMillis);
        assertSame(firstFetch, secondFetch, "Data must be taken from cache!");
    }

    @Test
    void testStandardWeatherCache_ShouldUpdateCacheAfterTimeout() throws InterruptedException {
        WeatherData firstFetch = standardCache.getWeatherData(city, maxCacheAgeMillis);
        assertNotNull(firstFetch, "Data cannot be null!");

        Thread.sleep(maxCacheAgeMillis + 1000);

        WeatherData secondFetch = standardCache.getWeatherData(city, maxCacheAgeMillis);
        assertNotSame(firstFetch, secondFetch, "Data must be updated after cache expiration");
    }

    @Test
    void testFrequentUpdateWeatherCache_ShouldAlwaysUpdateData() {
        WeatherData firstFetch = frequentUpdateCache.getWeatherData(city, maxCacheAgeMillis);
        assertNotNull(firstFetch, "Data cannot be null!");

        WeatherData secondFetch = frequentUpdateCache.getWeatherData(city, maxCacheAgeMillis);
        assertNotSame(firstFetch, secondFetch, "Data must be updated on every request for FrequentUpdateWeatherCache!");
    }

    @Test
    void testClearExpiredCache() throws InterruptedException {
        WeatherData firstFetch = standardCache.getWeatherData(city, maxCacheAgeMillis);
        assertNotNull(firstFetch, "Data cannot be null!");

        Thread.sleep(maxCacheAgeMillis + 1000);

        standardCache.clearExpiredCache(maxCacheAgeMillis);

        WeatherData secondFetch = standardCache.getWeatherData(city, maxCacheAgeMillis);
        assertNotSame(firstFetch, secondFetch, "The cache must be cleared of obsolete data!");
    }
}