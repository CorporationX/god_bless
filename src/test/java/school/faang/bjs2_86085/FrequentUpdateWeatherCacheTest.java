package school.faang.bjs2_86085;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class FrequentUpdateWeatherCacheTest {
    private final WeatherService provider = new WeatherService();

    @Test
    void testFrequentCacheReturnsNewDataAfterTimeout() throws InterruptedException {
        WeatherCacheTemplate cache = new FrequentUpdateWeatherCache(provider);

        WeatherData d1 = cache.getWeatherData("Paris", 100);
        WeatherData d2 = cache.getWeatherData("Paris", 100);

        assertEquals(d1, d2);

        Thread.sleep(150);

        WeatherData d3 = cache.getWeatherData("Paris", 100);

        assertNotEquals(d1, d3);
    }

    @Test
    void testFrequentCacheReturnsSameDataWithinTimeout() {
        WeatherCacheTemplate cache = new FrequentUpdateWeatherCache(provider);

        WeatherData d1 = cache.getWeatherData("London", 1000);
        WeatherData d2 = cache.getWeatherData("London", 1000);

        assertEquals(d1, d2);
    }
}