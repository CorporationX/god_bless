package school.faang.caching_caching.BJS2_56894;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StandardWeatherCacheTest {

    private StandardWeatherCache cache;

    @BeforeEach
    void setUp() {
        cache = new StandardWeatherCache();
    }

    @Test
    void testGetWeatherData_CacheHit() {
        String city = "St Petersburg";
        long maxCacheAgeMillis = 1000;

        WeatherData firstCall = cache.getWeatherData(city, maxCacheAgeMillis);

        WeatherData secondCall = cache.getWeatherData(city, maxCacheAgeMillis);

        assertEquals(firstCall, secondCall);
    }

    @Test
    void testGetWeatherData_CacheMiss() {
        String city = "St Petersburg";
        long maxCacheAgeMillis = 1000;

        WeatherData firstCall = cache.getWeatherData(city, maxCacheAgeMillis);

        try {
            Thread.sleep(maxCacheAgeMillis + 100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        WeatherData secondCall = cache.getWeatherData(city, maxCacheAgeMillis);

        assertNotEquals(firstCall, secondCall);
    }

    @Test
    void testIsCacheExpired() {
        String city = "St Petersburg";
        long maxCacheAgeMillis = 1000;

        WeatherData freshData = new WeatherData(city, 20, 50, System.currentTimeMillis());

        assertFalse(cache.isCacheExpired(freshData, maxCacheAgeMillis));

        WeatherData oldData = new WeatherData(city, 20, 50, System.currentTimeMillis() - 2000);

        assertTrue(cache.isCacheExpired(oldData, maxCacheAgeMillis));
    }

}