package school.faang.cashe.cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeatherCitiesTest {

    private WeatherCities weatherCities;

    @BeforeEach
    public void setUp() {
        weatherCities = new WeatherCities();

        weatherCities.updateWeatherDataForCity("City1");
        weatherCities.updateWeatherDataForCity("City2");
    }

    @Test
    void getWeatherDataTest() {
        WeatherData city1Weather = weatherCities.getWeatherData("City1");
        assertEquals("City1", city1Weather.getCity());

        WeatherData city3Weather = weatherCities.getWeatherData("City3");
        assertEquals("City3", city3Weather.getCity());
    }

    @Test
    void updateWeatherDataForCityTest() {
        weatherCities.updateWeatherDataForCity("City1");
        WeatherData updatedWeather = weatherCities.getWeatherData("City1");

        assertNotEquals(30.0, updatedWeather.getTemperature());
        assertNotEquals(70.0, updatedWeather.getHumidity());
    }

    @Test
    void removeWeatherDataForCityTest() {
        weatherCities.removeWeatherDataForCity("City2");

        WeatherData londonWeather = weatherCities.getWeatherData("City2");
        assertNotNull(londonWeather);
    }

    @Test
    void printAllCitiesTest() {
        weatherCities.printAllCities();
    }

    @Test
    void printAllDataTest() {
        weatherCities.printAllData();
    }
}
