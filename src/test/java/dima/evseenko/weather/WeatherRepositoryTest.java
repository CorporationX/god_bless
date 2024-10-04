package dima.evseenko.weather;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNull;

class WeatherRepositoryTest {

    @Test
    void getWeather() {
        assertEquals(new WeatherData("Санкт-Петербург", 9, 91), WeatherRepository.getWeather("Санкт-Петербург"));
    }

    @Test
    void getWeatherNullCity(){
        assertThrows(IllegalArgumentException.class, () -> WeatherRepository.getWeather(null));
    }

    @Test
    void getNotExistsWeatherData(){
        assertNull(WeatherRepository.getWeather("Уфа"));
    }
}