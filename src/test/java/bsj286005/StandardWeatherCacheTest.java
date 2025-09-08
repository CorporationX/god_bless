package bsj286005;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

public class StandardWeatherCacheTest {
    private final WeatherProvider provider = new WeatherService();

    @Test
    void testStandardCacheKeepsFreshData() {
        WeatherCacheTemplate cache = new StandardWeatherCache(provider);
        long maxAge = 2000;

        WeatherData d1 = cache.getWeatherData("Moscow", maxAge);
        WeatherData d2 = cache.getWeatherData("Moscow", maxAge);

        assertSame(d1, d2, "Fresh data should come from cache");
    }

    @Test
    void testStandardCacheRefreshesExpiredData() throws InterruptedException {
        WeatherCacheTemplate cache = new StandardWeatherCache(provider);
        long maxAge = 500;

        WeatherData d1 = cache.getWeatherData("London", maxAge);
        Thread.sleep(600);
        WeatherData d2 = cache.getWeatherData("London", maxAge);

        assertNotSame(d1, d2, "Expired data should be refreshed");
    }

    @Test
    void testForceUpdateWeather() {
        WeatherCacheTemplate cache = new StandardWeatherCache(provider);

        WeatherData data = cache.forceUpdateWeather("Berlin");

        assertNotNull(data);
        assertEquals("Berlin", data.getCity());
    }
}
