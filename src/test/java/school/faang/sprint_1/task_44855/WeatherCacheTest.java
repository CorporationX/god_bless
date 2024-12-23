package school.faang.sprint_1.task_44855;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherCacheTest {
    @Test
    public void testStandardCache() {
        WeatherProvider provider = new WeatherService();
        WeatherCacheTemplate cache = new StandardWeatherCache(provider, 3000);

        String city = "Penza";
        WeatherData data1 = cache.getWeatherData(city, cache.getMaxCacheAgeMillis());
        cache.clearExpiredCache(0);
        WeatherData data2 = cache.getWeatherData(city, cache.getMaxCacheAgeMillis());

        assertNotSame(data1, data2);
    }

    @Test
    public void testFrequentCache() {
        WeatherProvider provider = new WeatherService();
        WeatherCacheTemplate cache = new FrequentUpdateWeatherCache(provider);

        String city = "Kazan";
        WeatherData data1 = cache.getWeatherData(city, cache.getMaxCacheAgeMillis());
        WeatherData data2 = cache.getWeatherData(city, cache.getMaxCacheAgeMillis());

        assertNotSame(data1, data2);
    }

}
