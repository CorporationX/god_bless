package school.faang.BJS2_32568CachingCaching;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeatherServiceTest {
    WeatherService weatherService;
    WeatherData newYorkWeather;
    WeatherData londonWeather;

    @BeforeEach
    void setUp() {
        weatherService = new WeatherService();
        newYorkWeather = new WeatherData("New York", 20.0, 60.0);
        londonWeather =  new WeatherData("London", 10.0, 80.0);
    }

    @Test
    @DisplayName("Updating weather data about cities (valid data)")
    void testUpdateWeatherData() {
        String newYork = "New York";
        String london = "London";

        weatherService.updateCityWeather(newYorkWeather);
        weatherService.updateCityWeather(londonWeather);

        assertEquals(2, weatherService.cityToWeather.size());
        assertTrue(weatherService.cityToWeather.containsKey(newYork));
        assertTrue(weatherService.cityToWeather.containsKey(london));
    }

    @Test
    @DisplayName("Updating weather data about city with null WeatherData")
    void testUpdateNullWeatherData() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> weatherService.updateCityWeather(null));
        assertEquals("Weather data can't be null.", exception.getMessage());
    }

    @Test
    @DisplayName("Getting city weather data")
    void testGetCityWeatherData() {
        WeatherData newYorkData = weatherService.getCityWeather("New York");
        WeatherData madridData = weatherService.getCityWeather("Madrid");

        assertEquals("New York", newYorkData.getCity());
        assertNotNull(madridData);
        assertEquals("Madrid", madridData.getCity());
    }

    @Test
    @DisplayName("Getting null city weather data")
    void testGetNullCityWeatherData() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> weatherService.getCityWeather(null));
        assertEquals("Invalid city name.", exception.getMessage());
    }

    @Test
    @DisplayName("Remove city weather data")
    void testRemoveCityWeatherData() {
        weatherService.updateCityWeather(newYorkWeather);
        weatherService.updateCityWeather(londonWeather);
        weatherService.removeCityWeather("New York");

        assertEquals(1, weatherService.cityToWeather.size());
        assertFalse(weatherService.cityToWeather.containsKey("New York"));
    }

    @Test
    @DisplayName("Remove null city weather data")
    void testRemoveNullCityWeatherData() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> weatherService.removeCityWeather(null));
        assertEquals("Invalid city name.", exception.getMessage());
    }
}