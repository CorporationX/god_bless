package school.faang.sprint_1.task_44835;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.sprint_1.task_44835.cache.impl.FrequentUpdateWeatherCache;
import school.faang.sprint_1.task_44835.cache.impl.StandardWeatherCache;
import school.faang.sprint_1.task_44835.dto.WeatherData;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FrequencyWeatherCacheTest {
    private FrequentUpdateWeatherCache frequentUpdateWeatherCache;

    @BeforeEach
    void setUp() {
        frequentUpdateWeatherCache = new FrequentUpdateWeatherCache();
    }

    @Test
    void testGetWeatherDataWithActualCache() {
        var city = "Moscow";
        long maxCacheAgeMilli = 1000;
        WeatherData weatherData = frequentUpdateWeatherCache.getWeatherData(city, maxCacheAgeMilli);

        WeatherData newWeatherData = frequentUpdateWeatherCache.getWeatherData(city, maxCacheAgeMilli);

        assertNotEquals(weatherData, newWeatherData);
    }

    @Test
    void testGetWeatherDataWithNonActualCache() throws InterruptedException {
        var city = "Moscow";
        long maxCacheAgeMilli = 1;
        WeatherData weatherData = frequentUpdateWeatherCache.getWeatherData(city, maxCacheAgeMilli);

        Thread.sleep(10);

        WeatherData newWeatherData = frequentUpdateWeatherCache.getWeatherData(city, maxCacheAgeMilli);

        assertNotEquals(weatherData, newWeatherData);
    }

    @Test
    void testGetWeatherDataMaxCacheAgeMilliLess0() {
        var city = "Moscow";
        long maxCacheAgeMilli = -1;
        assertThrows(
                IllegalArgumentException.class,
                () -> frequentUpdateWeatherCache.getWeatherData(city, maxCacheAgeMilli)
        );
    }
}
