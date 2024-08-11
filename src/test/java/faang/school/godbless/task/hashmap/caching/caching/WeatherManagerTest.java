package faang.school.godbless.task.hashmap.caching.caching;

import faang.school.godbless.task.hashmap.caching.caching.MockWeatherDataCenterForTest;
import faang.school.godbless.task.hashmap.caching.caching.WeatherManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WeatherManagerTest {
    WeatherManager weatherManager;
    List<String> citiesInCache;

    @BeforeEach
    void setUp() {
        weatherManager = new WeatherManager(new HashMap<>(),
                new MockWeatherDataCenterForTest(new Random()));
        citiesInCache = new ArrayList<>(List.of(
                "New York", "Amsterdam", "Paris"
        ));
        citiesInCache.forEach(city -> weatherManager.findWeatherDataByCity(city));
    }

    @Test
    void testFindWeatherDataByCity() {
        String city = "London";
        var weatherData = weatherManager.findWeatherDataByCity(city);
        assertEquals(weatherData.city(), city);
        assertTrue(weatherData.temperature() > -20.0 && weatherData.temperature() < 45.0);
        assertTrue(weatherData.humidity() > 5.0 && weatherData.humidity() < 95.0);
    }

    @Test
    void testUpdateWeatherDataByCityInCache() {
        String city = "London";
        var weatherData = weatherManager.findWeatherDataByCity(city);
        var updatedWeatherData = weatherManager.updateWeatherDataByCityInCache(city);
        assertTrue(weatherData.temperature() != updatedWeatherData.temperature());
        assertTrue(weatherData.humidity() != updatedWeatherData.humidity());
    }

    @Test
    void testDeleteWeatherDataByCityInCache() {
        String cityForDelete = "Paris";
        weatherManager.deleteWeatherDataByCityInCache(cityForDelete);
        List<String> actualCities = weatherManager.findAllCitiesInCache();
        assertTrue(citiesInCache.contains(cityForDelete));
        assertFalse(actualCities.contains(cityForDelete));
    }

    @Test
    void testFindAllCitiesInCache() {
        assertEquals(citiesInCache, weatherManager.findAllCitiesInCache());
    }
}
