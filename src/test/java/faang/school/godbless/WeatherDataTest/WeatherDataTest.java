package faang.school.godbless.WeatherDataTest;

import faang.school.godbless.WeatherData.WeatherData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherDataTest {
    @Test
    public void testWeatherDataCreation(){
        WeatherData weatherData = new WeatherData("New York",25.0F,70.0F);
        assertEquals(25.0F,weatherData.getTemperature());
        assertEquals(70.0F,weatherData.getHumidity());
        assertEquals("New York",weatherData.getCity());

    }



}
