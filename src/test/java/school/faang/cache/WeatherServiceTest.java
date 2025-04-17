package school.faang.cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.weathercache.WeatherData;
import school.faang.weathercache.WeatherProvider;
import school.faang.weathercache.WeatherService;
import school.faang.weathercache.cachetemplate.FrequentUpdateWeatherCache;
import school.faang.weathercache.cachetemplate.StandardWeatherCache;
import school.faang.weathercache.cachetemplate.WeatherCacheTemplate;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherServiceTest {
    private WeatherProvider weatherProvider;

    @BeforeEach
    void setUp() {
        weatherProvider = new WeatherService();
    }

    @Test
    void shouldFetchWeather() {
        WeatherData weatherData = weatherProvider.fetchWeatherData("Voronezh");

        assertNotNull(weatherData);
        assertEquals("Voronezh", weatherData.getCity());
    }

    @Test
    public void testStandardCache() throws InterruptedException {
        WeatherProvider mockProvider = new WeatherService();
        WeatherCacheTemplate cache = new StandardWeatherCache(mockProvider);

        WeatherData firstCall = cache.getWeatherData("Moscow", 1000);
        assertNotNull(firstCall);

        WeatherData secondCall = cache.getWeatherData("Moscow", 1000);
        assertEquals(firstCall.getTimestamp(), secondCall.getTimestamp());

        Thread.sleep(1500);

        WeatherData thirdCall = cache.getWeatherData("Moscow", 1000);
        assertNotEquals(firstCall.getTimestamp(), thirdCall.getTimestamp());
    }

    @Test
    public void testFrequentUpdateCache() throws InterruptedException {
        WeatherProvider mockProvider = new WeatherService();
        WeatherCacheTemplate cache = new FrequentUpdateWeatherCache(mockProvider);

        WeatherData firstCall = cache.getWeatherData("London", 10000);
        assertNotNull(firstCall);
        Thread.sleep(1);

        WeatherData secondCall = cache.getWeatherData("London", 10000);
        assertNotEquals(firstCall.getTimestamp(), secondCall.getTimestamp());
    }

    @Test
    public void testForceUpdate() throws InterruptedException {
        WeatherProvider mockProvider = new WeatherService();
        WeatherCacheTemplate cache = new StandardWeatherCache(mockProvider);

        WeatherData firstCall = cache.getWeatherData("Paris", 10000);
        Thread.sleep(1);
        cache.forceUpdateWeather("Paris");
        WeatherData secondCall = cache.getWeatherData("Paris", 10000);

        assertNotEquals(firstCall.getTimestamp(), secondCall.getTimestamp());
    }

    @Test
    public void testClearExpiredCache() throws InterruptedException {
        WeatherProvider mockProvider = new WeatherService();
        WeatherCacheTemplate cache = new StandardWeatherCache(mockProvider);

        cache.getWeatherData("Berlin", 500);
        cache.getWeatherData("Madrid", 500);

        assertEquals(2, cache.getWeatherCache().size());

        Thread.sleep(600);
        cache.clearExpiredCache(500);

        assertEquals(0, cache.getWeatherCache().size());
    }
}
