package school.faang.weathercache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;

public class TestFrequentUpdateWeatherCache {
    private FrequentUpdateWeatherCache frequentUpdateWeatherCache;

    @BeforeEach
    public void setUp() {
        frequentUpdateWeatherCache = new FrequentUpdateWeatherCache();
    }

    @Test
    public void testGetWeatherData() {
        WeatherData newData = frequentUpdateWeatherCache.getWeatherData("New York", 10_000);

        assertNotNull(newData, "Must get new data");
        assertEquals("New York", newData.city(), "Сities must be equals");
    }

    @Test
    public void testGetWeatherCheckNotCaching() {
        WeatherData initialData = frequentUpdateWeatherCache.getWeatherData("London", 5000);
        WeatherData cachedData = frequentUpdateWeatherCache.getWeatherData("London", 5000);

        assertNotSame(initialData, cachedData, "Should receive updated data");
    }
}
