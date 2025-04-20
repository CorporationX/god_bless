package school.faang.cashcash;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StandardWeatherCacheTest {
    WeatherCacheTemplate standardWeatherCache;
    long maxCacheAgeMillis;
    String city1;
    String city2;

    @BeforeEach
    void setUp() {
        standardWeatherCache = new StandardWeatherCache();
        maxCacheAgeMillis = 5000;
        city1 = "Moscow";
        city2 = "spb";
    }


    @Test
    void isCacheExpiredTest() {
        WeatherData weatherData1 = standardWeatherCache.getWeatherData(city1, maxCacheAgeMillis);
        WeatherData weatherData2 = standardWeatherCache.getWeatherData(city2, maxCacheAgeMillis);
        weatherData1.setTimestamp(System.currentTimeMillis() - 5050);

        assertTrue(standardWeatherCache.isCacheExpired(weatherData1, maxCacheAgeMillis));
        assertFalse(standardWeatherCache.isCacheExpired(weatherData2, maxCacheAgeMillis));
    }

    @Test
    void clearExpiredCacheTest() {
        WeatherData weatherData1 = standardWeatherCache.getWeatherData(city1, maxCacheAgeMillis);
        WeatherData weatherData2 = standardWeatherCache.getWeatherData(city2, maxCacheAgeMillis);
        weatherData1.setTimestamp(System.currentTimeMillis() - 6001);

        standardWeatherCache.clearExpiredCache(maxCacheAgeMillis);

        assertFalse(standardWeatherCache.getCacheWeather().containsKey(city1));
        assertTrue(standardWeatherCache.getCacheWeather().containsKey(city2));
    }

    @Test
    void getWeatherDataTest() {
        WeatherData weatherData2 = standardWeatherCache.getWeatherData(city2, maxCacheAgeMillis);
        WeatherData weatherData1 = standardWeatherCache.getWeatherData(city1, maxCacheAgeMillis);

        assertTrue(weatherData2.getTimestamp() <= weatherData1.getTimestamp());

        weatherData2.setTimestamp(System.currentTimeMillis() - 8001);
        weatherData1.setTimestamp(System.currentTimeMillis());
        WeatherData weatherData2New = standardWeatherCache.getWeatherData(city2, maxCacheAgeMillis);
        WeatherData weatherData1New = standardWeatherCache.getWeatherData(city1, maxCacheAgeMillis);

        assertFalse(weatherData2New.getTimestamp() < weatherData1New.getTimestamp());
    }
}