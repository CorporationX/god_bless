package school.faang.task_57024;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class WeatherCacheTests {
    @Test
    public void testStandardWeatherCache() {
        WeatherProvider provider = new WeatherService();
        StandardWeatherCache cache = new StandardWeatherCache(provider);
        String city = "TestCity";
        long cacheAge = 5000;

        WeatherData firstFetch = cache.getWeatherData(city, cacheAge);
        WeatherData secondFetch = cache.getWeatherData(city, cacheAge);

        assertEquals(firstFetch, secondFetch, "Data should be the same within cache validity period");
    }

    @Test
    public void testFrequentUpdateWeatherCache() {
        WeatherProvider provider = new WeatherService();
        FrequentUpdateWeatherCache cache = new FrequentUpdateWeatherCache(provider);
        String city = "TestCity";
        long cacheAge = 5000;

        WeatherData firstFetch = cache.getWeatherData(city, cacheAge);
        WeatherData secondFetch = cache.getWeatherData(city, cacheAge);

        assertNotEquals(firstFetch, secondFetch, "Data should be updated on every request");
    }

    @Test
    public void testClearExpiredCache() throws InterruptedException {
        WeatherProvider provider = new WeatherService();
        StandardWeatherCache cache = new StandardWeatherCache(provider);
        String city = "TestCity";
        long cacheAge = 1000;

        cache.getWeatherData(city, cacheAge);
        Thread.sleep(1500);
        cache.clearExpiredCache(cacheAge);

        assertFalse(cache.cache.containsKey(city), "Cache should be cleared after removing expired data");
    }
}
