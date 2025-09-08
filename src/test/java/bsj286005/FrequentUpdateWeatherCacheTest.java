package bsj286005;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotSame;

public class FrequentUpdateWeatherCacheTest {
    private final WeatherProvider provider = new WeatherService();

    @Test
    void testFrequentCacheAlwaysUpdates() {
        WeatherCacheTemplate cache = new FrequentUpdateWeatherCache(provider);
        long maxAge = 5000;

        WeatherData d1 = cache.getWeatherData("Paris", maxAge);
        WeatherData d2 = cache.getWeatherData("Paris", maxAge);

        assertNotSame(d1, d2, "Frequent cache should always fetch new data");
    }
}
