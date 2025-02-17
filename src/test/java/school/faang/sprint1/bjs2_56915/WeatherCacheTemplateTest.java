package school.faang.sprint1.bjs2_56915;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.bjs2_56915.FrequentUpdateWeatherCache;
import school.faang.bjs2_56915.StandardWeatherCache;
import school.faang.bjs2_56915.WeatherCacheTemplate;
import school.faang.bjs2_56915.WeatherData;
import school.faang.bjs2_56915.WeatherProvider;
import school.faang.bjs2_56915.WeatherService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WeatherCacheTemplateTest {
    private WeatherCacheTemplate standard;
    private WeatherCacheTemplate frequent;
    private WeatherProvider service;

    @BeforeEach
    public void setUp() {
        service = new WeatherService();
        standard = new StandardWeatherCache(service);
        frequent = new FrequentUpdateWeatherCache(service);
    }

    @Test
    public void testIsCacheExpired() {
        WeatherData data = service.fetchWeatherData("London");
        boolean result = standard.isCacheExpired(data, 500);
        boolean result2 = frequent.isCacheExpired(data, 500);
        assertFalse(result);
        assertTrue(result2);
    }

    @Test
    public void testGetWeatherDataStandard() {
        WeatherData data = service.fetchWeatherData("New York");
        standard.cache.put("New York", data);
        WeatherData result = standard.getWeatherData("New York", 500);
        assertEquals(data, result);
    }

    @Test
    public void testGetWeatherDataFrequent() {
        WeatherData data = service.fetchWeatherData("Amsterdam");
        frequent.cache.put("Amsterdam", data);
        WeatherData result = frequent.getWeatherData("Amsterdam", 500);
        assertNotEquals(data, result);
    }

    @Test
    public void testUpdateWeatherDataStandard() {
        WeatherData data = service.fetchWeatherData("Paris");
        WeatherData result = standard.updateWeatherData("Paris");
        assertNotEquals(data, result);
    }
}
