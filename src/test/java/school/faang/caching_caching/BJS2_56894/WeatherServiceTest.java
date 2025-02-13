package school.faang.caching_caching.BJS2_56894;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeatherServiceTest {

    private final WeatherService weatherService = new WeatherService();

    @Test
    void testFetchWeatherData_ThrowsExceptionForInvalidCity() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            weatherService.fetchWeatherData(null);
        });
        assertEquals("City name cannot be null or blank", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            weatherService.fetchWeatherData("");
        });
        assertEquals("City name cannot be null or blank", exception.getMessage());
    }

    @Test
    void testFetchWeatherData_ValidData() {
        String city = "Moscow";
        WeatherData data = weatherService.fetchWeatherData(city);

        assertNotNull(data);
        assertEquals(city, data.city());
        assertTrue(data.temperature() >= -89.2 && data.temperature() <= 170);
        assertTrue(data.humidity() >= 0 && data.humidity() <= 100);
        assertTrue(data.timestamp() > 0);
    }
}