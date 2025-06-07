package bjs2_79901;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.bjs2_79901.FrequentUpdateWeatherCache;
import school.faang.bjs2_79901.StandardWeatherCache;
import school.faang.bjs2_79901.WeatherData;
import school.faang.bjs2_79901.WeatherService;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherCacheTemplateTest {

    private StandardWeatherCache cache;
    private FrequentUpdateWeatherCache frequentCache;

    private final String city = "Moscow";

    @BeforeEach
    void setUp() {
        cache = new StandardWeatherCache();
        frequentCache = new FrequentUpdateWeatherCache();

        cache.setWeatherProvider(new WeatherService());
        frequentCache.setWeatherProvider(new WeatherService());
    }

    @Test
    void shouldReturnCachedDataIfNotExpired() {
        long now = System.currentTimeMillis();
        WeatherData data = new WeatherData(city, 25.0, 50.0, now);
        cache.getWeatherByCity().put(city, data);

        WeatherData result = cache.getWeatherData(city, TimeUnit.MINUTES.toMillis(5));

        assertEquals(data, result);
    }

    @Test
    void shouldFetchNewDataIfExpired() {
        long oldTimestamp = System.currentTimeMillis() - TimeUnit.HOURS.toMillis(1);
        WeatherData oldData = new WeatherData(city, 20.0, 40.0, oldTimestamp);
        cache.getWeatherByCity().put(city, oldData);

        WeatherData result = cache.getWeatherData(city, TimeUnit.MINUTES.toMillis(10));

        assertNotEquals(oldData, cache.getWeatherByCity().get(city));

        assertEquals(cache.getWeatherByCity().get(city), result);
    }

    @Test
    void shouldUpdateWeatherInMap() {
        WeatherData before = cache.getWeatherByCity().get(city);
        cache.forceUpdateWeather(city);
        WeatherData after = cache.getWeatherByCity().get(city);

        assertNotNull(after);
        if (before != null) {
            assertNotEquals(before.timestamp(), after.timestamp());
        }
    }

    @Test
    void shouldRemoveExpiredEntriesOnly() {
        long now = System.currentTimeMillis();

        WeatherData expired = new WeatherData("Moscow", 10, 10, now - TimeUnit.HOURS.toMillis(1));
        WeatherData fresh = new WeatherData("Paris", 20, 20, now);

        cache.getWeatherByCity().put("Moscow", expired);
        cache.getWeatherByCity().put("Paris", fresh);

        cache.clearExpiredCache(TimeUnit.MINUTES.toMillis(30));

        assertFalse(cache.getWeatherByCity().containsKey("Moscow"));
        assertTrue(cache.getWeatherByCity().containsKey("Paris"));
    }

    @Test
    void shouldNotFailIfNothingExpired() {
        long now = System.currentTimeMillis();
        WeatherData fresh = new WeatherData("London", 15, 50, now);
        cache.getWeatherByCity().put("London", fresh);

        assertDoesNotThrow(() -> cache.clearExpiredCache(TimeUnit.MINUTES.toMillis(30)));
        assertTrue(cache.getWeatherByCity().containsKey("London"));
    }

    @Test
    void standardCache_shouldReturnFalseIfWithinMaxAge() {
        long now = System.currentTimeMillis();
        WeatherData fresh = new WeatherData(city, 20, 60, now);

        boolean result = cache.isCacheExpired(fresh, TimeUnit.MINUTES.toMillis(5));

        assertFalse(result);
    }

    @Test
    void frequentUpdateCache_shouldAlwaysReturnTrue() {
        WeatherData any = new WeatherData(city, 20, 60, System.currentTimeMillis());

        boolean result = frequentCache.isCacheExpired(any, TimeUnit.MINUTES.toMillis(5));

        assertTrue(result);
    }
}