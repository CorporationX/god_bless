package school.faang.cashcash;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrequentUpdateWeatherCacheTest {

    WeatherCacheTemplate frequentUpdateWeatherCache;
    long maxCacheAgeMillis;
    String city;

    @BeforeEach
    void setUp() {
        frequentUpdateWeatherCache = new FrequentUpdateWeatherCache();
        maxCacheAgeMillis = 5000;
        city = "Moscow";
    }

    @Test
    void getWeatherDataTest() {
        frequentUpdateWeatherCache.getWeatherData(city, maxCacheAgeMillis);

        assertTrue(frequentUpdateWeatherCache.getCacheWeather().containsKey(city));

    }

    @Test
    void isCacheExpiredTest() {
        WeatherData weatherData = frequentUpdateWeatherCache.getWeatherData(city, maxCacheAgeMillis);

        assertTrue(frequentUpdateWeatherCache.isCacheExpired(weatherData, maxCacheAgeMillis));
    }

    @Test
    void clearExpiredCacheTest() {
        frequentUpdateWeatherCache.getWeatherData(city, maxCacheAgeMillis);

        frequentUpdateWeatherCache.clearExpiredCache(maxCacheAgeMillis);

        assertFalse(frequentUpdateWeatherCache.getCacheWeather().containsKey(city));
        assertTrue(frequentUpdateWeatherCache.getCacheWeather().isEmpty());
    }
}