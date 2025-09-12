package school.faang.bjs2_86085;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StandardWeatherCacheTest {
    private final WeatherService provider = new WeatherService();

    @Test
    void testStandardCacheReturnsCachedData() {
        WeatherCacheTemplate cache = new StandardWeatherCache(provider);
        WeatherData d1 = cache.getWeatherData("Paris", 5000);
        WeatherData d2 = cache.getWeatherData("Paris", 5000);

        assertEquals(d1, d2);
    }
}