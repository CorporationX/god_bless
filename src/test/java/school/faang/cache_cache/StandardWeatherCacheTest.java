package school.faang.cache_cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class StandardWeatherCacheTest {
    private WeatherCacheTemplate standardWeatherCache;

    @BeforeEach
    public void setUp() {
        WeatherProvider weatherProvider = new WeatherService();
        standardWeatherCache = new StandardWeatherCache(weatherProvider);
    }

    @Test
    public void testGetWeatherData() throws InterruptedException {
        String city = "Astana";
        long maxCacheAgeMillis = 1000L;
        WeatherData astanaWeather = standardWeatherCache.getWeatherData(city, maxCacheAgeMillis);
        WeatherData astanaWeather2 = standardWeatherCache.getWeatherData(city, maxCacheAgeMillis);

        assertEquals(astanaWeather, astanaWeather2);
        
        Thread.sleep(maxCacheAgeMillis + 5L);

        WeatherData astanaWeather3 = standardWeatherCache.getWeatherData(city, maxCacheAgeMillis);
        assertNotEquals(astanaWeather, astanaWeather3);
    }

    @Test
    public void testForceUpdateWeather() {
        String city = "Astana";
        long maxCacheAgeMillis = 1000L;
        WeatherData astanaWeather = standardWeatherCache.getWeatherData(city, maxCacheAgeMillis);
        WeatherData astanaWeather2 = standardWeatherCache.forceUpdateWeather(city);

        assertNotEquals(astanaWeather, astanaWeather2);
    }

    @Test
    public void testClearExpiredCache() throws InterruptedException {
        String city = "Astana";
        long maxCacheAgeMillis = 1000L;
        WeatherData astanaWeather = standardWeatherCache.getWeatherData(city, maxCacheAgeMillis);

        Thread.sleep(maxCacheAgeMillis + 5L);

        String city2 = "Almaty";
        long maxCacheAgeMillis2 = 2000L;
        WeatherData almatyWeather = standardWeatherCache.getWeatherData(city2, maxCacheAgeMillis2);

        standardWeatherCache.clearExpiredCache(maxCacheAgeMillis);

        assertNotEquals(astanaWeather, standardWeatherCache.getWeatherData(city, maxCacheAgeMillis2));
        assertEquals(almatyWeather, standardWeatherCache.getWeatherData(city2, maxCacheAgeMillis2));
    }
}
