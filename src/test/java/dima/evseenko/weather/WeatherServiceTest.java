package dima.evseenko.weather;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class WeatherServiceTest {

    @Test
    void getWeatherData() {
        assertEquals(new WeatherData("Санкт-Петербург", 9, 91), new WeatherService().getWeatherData("Санкт-Петербург"));
    }

    @Test
    void getWeatherDataNullCity() {
        assertNull(new WeatherService().getWeatherData(null));
    }

    @Test
    void getWeatherDataNotExistsCity() {
        assertNull(new WeatherService().getWeatherData("Уфа"));
    }

    @Test
    void getCachedWeatherData() {
        WeatherService weatherService = new WeatherService();
        weatherService.updateWeatherData("Москва");

        assertEquals(new WeatherData("Москва", 12, 79), weatherService.getCachedWeatherData("Москва"));
    }

    @Test
    void getCachedWeatherDataNullCity() {
        assertNull(new WeatherService().getCachedWeatherData(null));
    }

    @Test
    void getCachedWeatherDataNotExistsCity() {
        assertNull(new WeatherService().getCachedWeatherData("Уфа"));
    }

    @Test
    void updateWeatherData() {
        WeatherService weatherService = new WeatherService();
        weatherService.updateWeatherData("Москва");

        assertNotNull(weatherService.getWeatherData("Москва"));
    }

    @Test
    void updateWeatherDataNotExistsCity() {
        WeatherService weatherService = new WeatherService();
        weatherService.updateWeatherData("Уфа");

        assertNull(new WeatherService().getWeatherData("Уфа"));
    }

    @Test
    void deleteWeatherData() {
        WeatherService weatherService = new WeatherService();
        weatherService.updateWeatherData("Москва");
        weatherService.updateWeatherData("Санкт-Петербург");
        weatherService.deleteWeatherData("Москва");

        assertNull(weatherService.getCachedWeatherData("Москва"));
    }
}