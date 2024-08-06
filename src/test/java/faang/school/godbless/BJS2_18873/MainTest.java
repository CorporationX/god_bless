package faang.school.godbless.BJS2_18873;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    Main main;

    @BeforeEach
    void init() {
        main = new Main();
    }

    @Test
    void getCurrentWeatherTest() {
        assertEquals(new WeatherData("London", 15, 55), main.getCurrentWeather("London"));
    }

    @Test
    void getCurrentWeatherWithMissingCityTest() {
        int sizeBefore = main.getWeatherMap().size();
        assertFalse(main.getWeatherMap().containsKey("Dubai"));

        main.getCurrentWeather("Dubai");

        assertEquals(sizeBefore + 1, main.getWeatherMap().size());
        assertTrue(main.getWeatherMap().containsKey("Dubai"));
    }

    @Test
    void updateWeatherTest() {
        WeatherData requested = main.getCurrentWeather("London");
        assertEquals(new WeatherData("London", 15, 55), requested);

        main.updateWeather("London");

        assertNotEquals(requested, main.getCurrentWeather("London"));
    }

    @Test
    void clearCityCashTest() {
        int sizeBefore = main.getWeatherMap().size();
        boolean result = main.clearCityCash("London");
        assertTrue(result);
        assertEquals(sizeBefore - 1, main.getWeatherMap().size());
    }

    @Test
    void availableCitiesTest() {
        assertEquals(3, main.availableCities().size());
        assertEquals(main.getWeatherMap().keySet(), main.availableCities());
    }
}