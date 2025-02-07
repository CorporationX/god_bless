package school.faang.weathercache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestStandardWeatherCache {
    private StandardWeatherCache standardWeatherCache;

    @BeforeEach
    public void setUp() {
        standardWeatherCache = new StandardWeatherCache();
    }

    @Test
    public void testGetWeatherData() {
        WeatherData newData = standardWeatherCache.getWeatherData("New York", 10_000);

        assertNotNull(newData, "Must get new data");
        assertEquals("New York", newData.city(), "Сities must be equals");
    }

    @Test
    public void testWeatherDataNotExpired() {
        WeatherData initialData = standardWeatherCache.getWeatherData("London", 5000);
        WeatherData cachedData = standardWeatherCache.getWeatherData("London", 5000);

        assertSame(initialData, cachedData, "Must get data from cache");
    }

    @Test
    public void testWeatherDataExpired() throws InterruptedException {
        WeatherData initialData = standardWeatherCache.getWeatherData("London", 500);

        Thread.sleep(1001);

        WeatherData cachedData = standardWeatherCache.getWeatherData("London", 500);

        assertNotSame(initialData, cachedData, "Should receive updated data");
        assertTrue(cachedData.timestamp() > initialData.timestamp());
    }
}
