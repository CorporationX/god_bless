package school.faang.BJS2_32586;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class WeatherDataTest {
    @Test
    void getWeatherDataTest() {
        WeatherData weatherInHamburg = new WeatherData("Hamburg", 15, 45);

        Main.addData(weatherInHamburg);

        assertEquals(weatherInHamburg, Main.getWeatherData(weatherInHamburg.getCity()));
    }

    @Test
    void updateWeatherDataTest() {
        WeatherData weatherInHamburg = new WeatherData("Hamburg", 15, 45);
        WeatherData newWeatherInHamburg = new WeatherData("Hamburg", 10, 50);

        Main.addData(weatherInHamburg);
        Main.updateWeatherData(weatherInHamburg.getCity(), newWeatherInHamburg.getTemperature(), newWeatherInHamburg.getHumidity());

        assertEquals(newWeatherInHamburg, Main.getWeatherData(weatherInHamburg.getCity()));
    }

    @Test
    void removeWeatherDataTest() {
        WeatherData weatherInHamburg = new WeatherData("Hamburg", 15, 45);

        Main.addData(weatherInHamburg);
        Main.removeWeatherData(weatherInHamburg.getCity());

        assertNull(Main.getWeatherData(weatherInHamburg.getCity()));
    }
}
