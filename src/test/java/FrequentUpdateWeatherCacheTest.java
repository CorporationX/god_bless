import org.junit.jupiter.api.Test;
import school.faang.task_44821.City;
import school.faang.task_44821.FrequentUpdateWeatherCache;
import school.faang.task_44821.WeatherData;
import school.faang.task_44821.WeatherProvider;
import school.faang.task_44821.WeatherService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FrequentUpdateWeatherCacheTest {
    private final WeatherProvider weatherProvider = new WeatherService();

    @Test
    void testCacheAlwaysUpdatesData_frequentUpdateWeatherCachePositive() {
        FrequentUpdateWeatherCache cache = new FrequentUpdateWeatherCache(weatherProvider);

        City city = City.STERLITAMAK;
        WeatherData firstFetch = cache.getWeatherData(city);
        assertNotNull(firstFetch, "Weather data should not be null after fetching.");

        WeatherData secondFetch = cache.getWeatherData(city);
        assertNotEquals(firstFetch, secondFetch, "Data should always update in FrequentUpdateWeatherCache.");
    }

    @Test
    void testCacheContainsLatestData_frequentUpdateWeatherCachePositive() {
        FrequentUpdateWeatherCache cache = new FrequentUpdateWeatherCache(weatherProvider);

        City city = City.MOSCOW;
        WeatherData latestData = cache.getWeatherData(city);

        assertEquals(latestData, cache.weatherCache.get(city), "Cache should always store the latest fetched data.");
    }
}