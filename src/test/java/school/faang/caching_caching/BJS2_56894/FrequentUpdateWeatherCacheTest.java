package school.faang.caching_caching.BJS2_56894;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrequentUpdateWeatherCacheTest {

    private FrequentUpdateWeatherCache cache;

    @BeforeEach
    void setUp() {
        cache = new FrequentUpdateWeatherCache();
    }

    @Test
    void testGetWeatherData_AlwaysUpdates() {
        String city = "St Petersburg";
        long maxCacheAgeMillis = 1000;

        // Первый вызов
        WeatherData firstCall = cache.getWeatherData(city, maxCacheAgeMillis);

        // Второй вызов
        WeatherData secondCall = cache.getWeatherData(city, maxCacheAgeMillis);

        // Данные должны быть разными, так как кэш всегда устаревает
        assertNotEquals(firstCall, secondCall);
    }

    @Test
    void testIsCacheExpired() {
        String city = "St Petersburg";
        long maxCacheAgeMillis = 1000;
        WeatherData data = new WeatherData(city, 20, 50, System.currentTimeMillis());

        // Проверяем, что данные всегда считаются устаревшими
        assertTrue(cache.isCacheExpired(data, maxCacheAgeMillis));
    }
}