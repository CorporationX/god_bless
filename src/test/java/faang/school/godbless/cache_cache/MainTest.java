package faang.school.godbless.cache_cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private Main main;
    private Map<String, WeatherData> testData;

    @BeforeEach
    void setUp() {
        main = new Main();
        testData = new HashMap<>();
        testData.put("Toronto", new WeatherData("Toronto", 20, 20));
        testData.put("Calgary", new WeatherData("Calgary", 20, 20));
        testData.put("New York", new WeatherData("New York", 20, 20));
        testData.put("Moscow", new WeatherData("Moscow", 20, 20));
        testData.put("Krasnodar", new WeatherData("Krasnodar", 20, 20));
        testData.put("St. Petersburg", new WeatherData("St. Petersburg", 20, 20));
    }

    @Test
    void testGetWeatherData_ExistingCity() {
        WeatherData weatherData = main.getWeatherData("Toronto");
        assertNotNull(weatherData);
        assertEquals("Toronto", weatherData.getCity());
        assertEquals(20, weatherData.getTemperature());
        assertEquals(20, weatherData.getHumidity());
    }

    @Test
    void testGetWeatherData_NonExistingCity() {
        WeatherData weatherData = main.getWeatherData("NonExistingCity");
        assertNull(weatherData);
    }

    @Test
    void testGetWeather_ExistingCity() {
        WeatherData weatherData = main.getWeather("Toronto");
        assertNotNull(weatherData);
        assertEquals("Toronto", weatherData.getCity());
        assertEquals(20, weatherData.getTemperature());
        assertEquals(20, weatherData.getHumidity());
    }

    @Test
    void testGetWeather_NonExistingCity() {
        WeatherData weatherData = main.getWeather("NonExistingCity");
        assertNull(weatherData);
    }

    @Test
    void testGetWeather_Cache() {
        // Get the weather data to put it in the cache
        main.getWeather("Toronto");
        assertTrue(main.getData().containsKey("Toronto"));
    }

    @Test
    void testUpdateWeather() {
        WeatherData newWeatherData = new WeatherData("Toronto", 25, 30);
        main.updateWeather(newWeatherData);

        WeatherData updatedWeatherData = main.getData().get("Toronto");
        assertNotNull(updatedWeatherData);
        assertEquals("Toronto", updatedWeatherData.getCity());
        assertEquals(25, updatedWeatherData.getTemperature());
        assertEquals(30, updatedWeatherData.getHumidity());
    }

    @Test
    void testClearCache() {
        main.getWeather("Toronto");
        assertTrue(main.getData().containsKey("Toronto"));

        main.clearCache("Toronto");
        assertFalse(main.getData().containsKey("Toronto"));
    }

    @Test
    void testObserveCache() {
        // Add some data to the cache
        main.getWeather("Toronto");
        main.getWeather("Calgary");

        // Observe the cache (not much to assert here, just ensuring it runs without error)
        main.observeCache();
    }
}
