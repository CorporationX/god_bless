package school.faang.task_44825;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WeatherServiceTest {
    private final WeatherService weatherService = new WeatherService();

    @Test
    void shouldFetchWeatherData() {
        WeatherData weatherData = weatherService.fetchWeatherData("Moscow");

        assertNotNull(weatherData);
    }

    @Test
    void shouldThrowFetchWeatherData() {
        assertThrows(IllegalArgumentException.class, () -> weatherService.fetchWeatherData(null));
    }
}