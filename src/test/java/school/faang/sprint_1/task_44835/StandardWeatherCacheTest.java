package school.faang.sprint_1.task_44835;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.sprint_1.task_44835.cache.impl.StandardWeatherCache;
import school.faang.sprint_1.task_44835.dto.WeatherData;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StandardWeatherCacheTest {
    private StandardWeatherCache standardWeatherCache;

    @BeforeEach
    void setUp() {
        standardWeatherCache = new StandardWeatherCache();
    }

    @Test
    void testGetWeatherDataWithActualCache() {
        var city = "Moscow";
        long maxCacheAgeMilli = 1000;
        WeatherData weatherData = standardWeatherCache.getWeatherData(city, maxCacheAgeMilli);

        WeatherData newWeatherData = standardWeatherCache.getWeatherData(city, maxCacheAgeMilli);

        assertEquals(weatherData, newWeatherData);
    }

    @Test
    void testGetWeatherDataWithNonActualCache() throws InterruptedException {
        var city = "Moscow";
        long maxCacheAgeMilli = 1;
        WeatherData weatherData = standardWeatherCache.getWeatherData(city, maxCacheAgeMilli);

        Thread.sleep(10);

        WeatherData newWeatherData = standardWeatherCache.getWeatherData(city, maxCacheAgeMilli);

        assertNotEquals(weatherData, newWeatherData);
    }

    @Test
    void testGetWeatherDataMaxCacheAgeMilliLess0() {
        var city = "Moscow";
        long maxCacheAgeMilli = -1;
        assertThrows(
                IllegalArgumentException.class,
                () -> standardWeatherCache.getWeatherData(city, maxCacheAgeMilli)
        );
    }
}
