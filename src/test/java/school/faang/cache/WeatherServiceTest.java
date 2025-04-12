package school.faang.cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeatherServiceTest {
    private WeatherProvider weatherProvider;

    @BeforeEach
    void setUp() {
        weatherProvider = new WeatherService();
    }

    @Test
    void shouldFetchWeather() {
        WeatherData weatherData = weatherProvider.fetchWeatherData("Toronto");

        assertNotNull(weatherData);
        assertEquals("Toronto", weatherData.getCity());
    }
}