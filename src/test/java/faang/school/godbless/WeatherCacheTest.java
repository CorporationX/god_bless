package faang.school.godbless;

import faang.school.godbless.dolbahlop.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WeatherCacheTest {
    private WeatherCache weatherCache;
    private WeatherService mockWeatherService;

    @BeforeEach
    public void setup() {
        mockWeatherService = new WeatherService();
        weatherCache = new WeatherCache(mockWeatherService);
    }

    @Test
    public void testGetWeather_CityNotInCache_ShouldFetchFromService() {
        // Arrange
        String city = "Paris";

        // Act
        WeatherData weatherData = weatherCache.getWeather(city);

        // Assert
        assertNotNull(weatherData);
        assertEquals(city, weatherData.getCity());
    }

    @Test
    public void testGetWeather_CityInCache_ShouldReturnCachedData() {
        // Arrange
        String city = "London";
        weatherCache.getWeather(city); // Добавляем данные в кэш

        // Act
        WeatherData cachedWeather = weatherCache.getWeather(city);

        // Assert
        assertNotNull(cachedWeather);
        assertEquals(city, cachedWeather.getCity());
    }

    @Test
    public void testUpdateWeather_ShouldUpdateCache() {
        // Arrange
        String city = "Berlin";
        weatherCache.getWeather(city); // Заполняем кэш

        // Act
        weatherCache.updateWeather(city); // Обновляем данные в кэше
        WeatherData updatedWeather = weatherCache.getWeather(city);

        // Assert
        assertNotNull(updatedWeather);
    }

    @Test
    public void testRemoveWeather_ShouldRemoveFromCache() {
        // Arrange
        String city = "Tokyo";
        weatherCache.getWeather(city); // Добавляем данные в кэш

        // Act
        weatherCache.removeWeather(city); // Удаляем данные из кэша

        // Assert
        assertFalse(weatherCache.getAllCities().containsKey(city));
    }

    @Test
    public void testGetAllCities_ShouldReturnAllCachedCities() {
        // Arrange
        weatherCache.getWeather("Sydney");
        weatherCache.getWeather("Melbourne");

        // Act
        int numberOfCities = weatherCache.getAllCities().size();

        // Assert
        assertEquals(2, numberOfCities);
    }
}
