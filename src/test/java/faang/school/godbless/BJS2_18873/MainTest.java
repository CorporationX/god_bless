package faang.school.godbless.BJS2_18873;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        int sizeBefore = main.getData().size();
        main.getCurrentWeather("Dubai");
        assertEquals(sizeBefore + 1, main.getData().size());
        assertEquals(new WeatherData("Dubai", 10, 5), main.getCurrentWeather("Dubai"));
    }

    @Test
    void updateWeatherTest() {
        WeatherData requested = main.getCurrentWeather("London");
        assertEquals(new WeatherData("London", 15, 55), requested);

        main.updateWeather("London");

        assertEquals(new WeatherData("London", 10, 5), main.getCurrentWeather("London"));
    }

    @Test
    void clearCityCashTest() {
        int sizeBefore = main.getData().size();
        boolean result = main.clearCityCash("London");
        assertTrue(result);
        assertEquals(sizeBefore - 1, main.getData().size());
    }

    @Test
    void availableCitiesTest() {
        assertEquals(3, main.availableCities().size());
        assertEquals(main.getData().keySet(), main.availableCities());
    }
}