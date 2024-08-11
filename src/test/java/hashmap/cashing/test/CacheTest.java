package hashmap.cashing.test;

import hashmap.cashing.Main;
import hashmap.cashing.WeatherData;
import hashmap.cashing.WeatherService;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CacheTest {
    @BeforeAll
    static void setUp() {
        Main.WEATHER_CACHE.put("NY", WeatherService.getWeather("NY"));
        Main.WEATHER_CACHE.put("Moscow", WeatherService.getWeather("Moscow"));
        Main.WEATHER_CACHE.put("Amsterdam", WeatherService.getWeather("Amsterdam"));
    }

    @Test
    @DisplayName("Test getWeather method with city in cache")
    void cacheTest_getWeatherFromCache() {
        assertNotNull(Main.getWeather("NY"));
    }

    @Test
    @DisplayName("Test getWeather method with city not in cahce")
    void cacheTest_getWeatherNotFromCache() {
        assertNotNull(Main.getWeather("Yakutsk"));
    }

    @Test
    @DisplayName("Test getWeather method with null city")
    void cacheTest_getWeatherForNullCity() {
        assertThrows(NullPointerException.class, () -> Main.getWeather(null));
    }

    @Test
    @DisplayName("Test updateCache method with city in cache")
    void cacheTest_updateDataFromCache() {
        WeatherData weatherData = Main.getWeather("NY");

        Main.updateCache("NY");

        assertNotEquals(weatherData, Main.getWeather("NY"));
    }

    @Test
    @DisplayName("Test updateCache method with city not in cache")
    void cacheTest_updateForCityNotInCache() {
        int oldCacheSize = Main.WEATHER_CACHE.size();

        Main.updateCache("Omsk");

        assertNotEquals(oldCacheSize, Main.WEATHER_CACHE.size());
    }

    @Test
    @DisplayName("Test updateCache method with null city")
    void cacheTest_updateCacheWithNullCity() {
        assertThrows(NullPointerException.class, () -> Main.updateCache(null));
    }

    @Test
    @DisplayName("Test removeDataFromCache method with city in cache")
    void cacheTest_removeFromCache() {
        Main.removeDataFromCache("Omsk");

        assertFalse(Main.WEATHER_CACHE.containsKey("Omsk"));
    }

    @Test
    @DisplayName("Test removeDataFromCache method with city not in cache")
    void cacheTest_removeDataNotInCache() {
        int expected = Main.WEATHER_CACHE.size();

        Main.removeDataFromCache("London");

        assertEquals(expected, Main.WEATHER_CACHE.size());
    }

    @Test
    @DisplayName("Test removeDataFromCache method with null arguments")
    void cacheTest_removeFromCacheWithNullArguments() {
        assertThrows(NullPointerException.class, () -> Main.removeDataFromCache(null));
    }
}
