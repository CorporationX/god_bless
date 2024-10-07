package dima.evseenko.weather;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class MockedWeatherRepositoryTest {

    @Test
    void getWeather() {
        assertEquals(new WeatherData("Санкт-Петербург", 9, 91), new MockedWeatherRepository().getWeather("Санкт-Петербург"));
    }

    @Test
    void getWeatherNullCity() {
        assertNull(new MockedWeatherRepository().getWeather(null));
    }

    @Test
    void getNotExistsWeatherData() {
        assertNull(new MockedWeatherRepository().getWeather("Уфа"));
    }
}