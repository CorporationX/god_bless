import org.junit.jupiter.api.Test;
import school.faang.task_44821.City;
import school.faang.task_44821.StandardWeatherCache;
import school.faang.task_44821.WeatherData;
import school.faang.task_44821.WeatherProvider;
import school.faang.task_44821.WeatherService;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StandardWeatherCacheTest {
    private final WeatherProvider weatherProvider = new WeatherService();
    private final long maxCacheAgeMillis = 5000;
    private final StandardWeatherCache cache = new StandardWeatherCache(weatherProvider, maxCacheAgeMillis);

    @Test
    void testCacheExpiresAndUpdatesData_standardWeatherCachePositive() throws InterruptedException {
        WeatherData initialData = cache.getWeatherData(City.MOSCOW);

        Thread.sleep(maxCacheAgeMillis + 1000);

        WeatherData updatedData = cache.getWeatherData(City.MOSCOW);
        assertNotEquals(initialData, updatedData, "Weather data should update after cache expiration.");
    }

    @Test
    void testClearExpiredCacheRemovesOldData_standardWeatherCachePositive() throws InterruptedException {
        cache.getWeatherData(City.MOSCOW);
        cache.getWeatherData(City.KAZAN);

        Thread.sleep(maxCacheAgeMillis + 1000);

        cache.clearExpiredCache(maxCacheAgeMillis);

        assertTrue(cache.getWeatherCache().isEmpty(), "Cache should be empty after clearing expired entries.");
    }
}