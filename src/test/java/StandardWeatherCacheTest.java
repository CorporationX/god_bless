import org.junit.jupiter.api.Test;
import school.faang.task_44821.City;
import school.faang.task_44821.StandardWeatherCache;
import school.faang.task_44821.WeatherData;
import school.faang.task_44821.WeatherProvider;
import school.faang.task_44821.WeatherService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StandardWeatherCacheTest {
    private final WeatherProvider weatherProvider = new WeatherService();
    private final long maxCacheAgeMillis = 5000;

    @Test
    void testCacheStoresAndReturnsData_standardWeatherCachePositive() {
        StandardWeatherCache cache = new StandardWeatherCache(weatherProvider, maxCacheAgeMillis);

        City city = City.MOSCOW;
        WeatherData initialData = cache.getWeatherData(city);
        assertNotNull(initialData, "Weather data should not be null after fetching.");
        assertEquals(city, initialData.getCity(), "City in the cached data should match the requested city.");

        WeatherData cachedData = cache.getWeatherData(city);
        assertEquals(initialData, cachedData, "Cached data should match the initially fetched data.");
    }

    @Test
    void testCacheExpiresAndUpdatesData_standardWeatherCachePositive() throws InterruptedException {
        StandardWeatherCache cache = new StandardWeatherCache(weatherProvider, maxCacheAgeMillis);

        City city = City.KAZAN;
        WeatherData initialData = cache.getWeatherData(city);

        Thread.sleep(maxCacheAgeMillis + 1000);

        WeatherData updatedData = cache.getWeatherData(city);
        assertNotEquals(initialData, updatedData, "Weather data should update after cache expiration.");
    }

    @Test
    void testClearExpiredCacheRemovesOldData_standardWeatherCachePositive() throws InterruptedException {
        StandardWeatherCache cache = new StandardWeatherCache(weatherProvider, maxCacheAgeMillis);

        cache.getWeatherData(City.MOSCOW);
        cache.getWeatherData(City.KAZAN);

        Thread.sleep(maxCacheAgeMillis + 1000);

        cache.clearExpiredCache(maxCacheAgeMillis);

        assertTrue(cache.weatherCache.isEmpty(), "Cache should be empty after clearing expired entries.");
    }
}
