package faang.school.godbless.cash;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class WeatherForecastTest {

    @DisplayName("should be able to add and remove city forecasts")
    @Test
    void testWeatherForecast() {
        WeatherForecast forecast = new WeatherForecast();
        WeatherData london = forecast.getForecast("London");
        WeatherData madrid = forecast.getForecast("Madrid");
        System.out.println(london);
        System.out.println(madrid);
        assertEquals(2,forecast.getForecastMap().size());
        forecast.removeFromCache("London");
        assertEquals(1,forecast.getForecastMap().size());
        assertInstanceOf(WeatherData.class,forecast.getForecast("Madrid"));
    }
}
