package faang.school.godbless.WeatherDataTest;

import faang.school.godbless.WeatherData.WeatherData;
import faang.school.godbless.WeatherData.WeatherService;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WeatherServiceTest {
    @Test
    public void TestGetWeatherData() {
        WeatherService weatherService = new WeatherService();
        WeatherData weatherData = weatherService.getWeatherData("New York");
        assertEquals("New York", weatherData.getCity());
        assertTrue(weatherData.getTemperature()>=-10 && weatherData.getTemperature()<=30 );
        assertTrue(weatherData.getHumidity()>0 && weatherData.getHumidity()<=100 );
    }

}
