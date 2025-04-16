package school.faang.bjs2_69933;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WeatherServiceTest {
    private final WeatherService weatherService = new WeatherService();

    @Test
    public void testFetchWeatherData() {
        // arrange

        // act
        WeatherData weatherData = weatherService.fetchWeatherData("Moscow");
        boolean isCorrectTemp = weatherData.getTemperature() > -5.0 || weatherData.getTemperature() < 29.0;
        boolean isCorrectHumidity = weatherData.getHumidity() > 60.0 || weatherData.getHumidity() < 90.0;
        // assert
        Assertions.assertTrue(isCorrectTemp);
        Assertions.assertTrue(isCorrectHumidity);
        Assertions.assertEquals("Moscow", weatherData.getCity());
    }
}
