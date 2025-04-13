package school.faang.cachingweather;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FrequentUpdateWeatherCacheTest {

    FrequentUpdateWeatherCache frequentUpdateWeatherCache = new FrequentUpdateWeatherCache();

    @BeforeEach
    void setUp() {
        frequentUpdateWeatherCache = new FrequentUpdateWeatherCache();
    }

    @Test
    void getWeatherTest() {
        String city = "Rostov-on-Don";

        frequentUpdateWeatherCache.getWeather(city);

        assertTrue(frequentUpdateWeatherCache.getCityWeather().containsKey(city));
    }

    @Test
    void isCacheExpiredTest() {
        String city = "Rostov-on-Don";
        long maxCacheAgeMillis = 10_000;
        WeatherData weatherData = frequentUpdateWeatherCache.getWeather(city);

        assertTrue(frequentUpdateWeatherCache.isCacheExpired(weatherData));
    }

    @Test
    void clearExpiredCacheTest() {
        String city = "Rostov-on-Don";
        frequentUpdateWeatherCache.getWeather(city);

        frequentUpdateWeatherCache.clearExpiredCache();

        assertFalse(frequentUpdateWeatherCache.getCityWeather().containsKey(city));
        assertTrue(frequentUpdateWeatherCache.getCityWeather().isEmpty());
    }
}