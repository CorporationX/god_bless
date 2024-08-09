package faang.school.godbless.cash;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeatherForecastTest {

    @Test
    void testWeatherForecast() {
        WeatherForecast forecast = new WeatherForecast();
        WeatherData london = forecast.getForecast("London");
        WeatherData madrid = forecast.getForecast("Madrid");
        System.out.println(london);
        System.out.println(madrid);
        assertEquals(2,forecast.getForecasts().size());
        forecast.clearCache("London");
        assertEquals(1,forecast.getForecasts().size());
        assertInstanceOf(WeatherData.class,forecast.getForecast("Madrid"));
    }
}
