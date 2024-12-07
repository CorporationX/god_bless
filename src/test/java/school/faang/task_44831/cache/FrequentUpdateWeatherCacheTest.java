package school.faang.task_44831.cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.task_44831.entity.WeatherData;

import static org.junit.jupiter.api.Assertions.*;

class FrequentUpdateWeatherCacheTest {
    private FrequentUpdateWeatherCache weatherCache;

    @BeforeEach
    void setUp() {
        weatherCache = new FrequentUpdateWeatherCache();
    }

    @Test
    void testGetWeatherData_nullOrBlankCityThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> weatherCache
                .getWeatherData(null, 1000));
        assertThrows(IllegalArgumentException.class, () -> weatherCache
                .getWeatherData("", 1000));
        assertThrows(IllegalArgumentException.class, () -> weatherCache
                .getWeatherData("   ", 1000));
    }

    @Test
    void testGetWeatherData_cacheIsNotExpired() throws InterruptedException {
        String city = "New York";
        WeatherData data1 = weatherCache.getWeatherData(city, 10000);
        Thread.sleep(10);
        WeatherData data2 = weatherCache.getWeatherData(city, 10000);

        assertNotEquals(data1.timestamp(), data2.timestamp(),
                "Each call should generate new weather data with a different timestamp.");
    }

    @Test
    void testGetWeatherData_cacheIsExpired() throws InterruptedException {
        String city = "New York";
        WeatherData data1 = weatherCache.getWeatherData(city, 10);
        Thread.sleep(100);
        WeatherData data2 = weatherCache.getWeatherData(city, 10);

        assertNotEquals(data1.timestamp(), data2.timestamp(),
                "Each call should generate new weather data with a different timestamp.");
    }
}