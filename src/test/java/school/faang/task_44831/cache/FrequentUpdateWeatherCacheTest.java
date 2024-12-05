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
    void testGetWeatherData_generatesNewDataEveryTime() throws InterruptedException {
        String city = "New York";
        WeatherData data1 = weatherCache.getWeatherData(city, 10000);
        Thread.sleep(10);
        WeatherData data2 = weatherCache.getWeatherData(city, 10000);

        assertNotEquals(data1.getTimestamp(), data2.getTimestamp(),
                "Each call should generate new weather data with a different timestamp.");
    }
}