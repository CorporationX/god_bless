package school.faang.BJS2_56884;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        WeatherData data = service.fetchWeatherData("Moscow");
        boolean result = standard.isCacheExpired(data, 300);
        boolean result2 = frequent.isCacheExpired(data, 300);
        assertFalse(result);
        assertTrue(result2);
    }

    @Test
    public void testGetWeatherDataStandard() {
        WeatherData data = service.fetchWeatherData("Moscow");
        standard.cache.put("Moscow", data);
        WeatherData result = standard.getWeatherData("Moscow", 300);
        assertEquals(data, result);
    }

    @Test
    public void testGetWeatherDataFrequent() {
        WeatherData data = service.fetchWeatherData("Moscow");
        frequent.cache.put("Moscow", data);
        WeatherData result = frequent.getWeatherData("Moscow", 300);
        assertNotEquals(data, result);
    }

    @Test
    public void testUpdateWeatherDataStandard() {
        WeatherData data = service.fetchWeatherData("Moscow");
        WeatherData result = standard.updateWeatherData("Moscow");
        assertNotEquals(data, result);
    }
}
