package school.faang.task_44831.cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.task_44831.entity.WeatherData;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class StandardWeatherCacheTest {
    private StandardWeatherCache weatherCache;

    @BeforeEach
    void setUp() {
        weatherCache = new StandardWeatherCache();
    }

    @Test
    void testGetWeatherData_nullOrBlankCityThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> weatherCache
                .getWeatherData(null, TimeUnit.MINUTES.toMillis(5)));
        assertThrows(IllegalArgumentException.class, () -> weatherCache
                .getWeatherData("", TimeUnit.MINUTES.toMillis(5)));
        assertThrows(IllegalArgumentException.class, () -> weatherCache
                .getWeatherData("   ", TimeUnit.MINUTES.toMillis(5)));
    }

    @Test
    void testGetWeatherData_cityNotInCache_generatesNewWeatherData() {
        String city = "Paris";
        WeatherData weatherData = weatherCache.getWeatherData(city, TimeUnit.MINUTES.toMillis(5));

        assertNotNull(weatherData, "Weather data should be generated for a new city.");
        assertTrue(weatherCache.weatherDataCache.containsKey(city),
                "Generated data should be saved to the cache.");
        assertEquals(city, weatherData.getCity(), "Generated weather data should correspond to the city.");
    }

    @Test
    void testGetWeatherData_cacheExpired_generatesNewWeatherData() {
        String city = "Paris";
        WeatherData expiredData = new WeatherData(city);
        expiredData.setTimestamp(System.currentTimeMillis() - TimeUnit.MINUTES.toMillis(10));
        weatherCache.weatherDataCache.put(city, expiredData);

        WeatherData newData = weatherCache.getWeatherData(city, TimeUnit.MINUTES.toMillis(5));

        assertNotNull(newData, "Weather data should be generated for an expired cache.");
        assertNotEquals(expiredData, newData, "New weather data should replace the expired data.");
    }

    @Test
    void testGetWeatherData_cacheValid_returnsCachedWeatherData() {
        String city = "Paris";
        WeatherData validData = new WeatherData(city);
        validData.setTimestamp(System.currentTimeMillis());
        weatherCache.weatherDataCache.put(city, validData);

        WeatherData result = weatherCache.getWeatherData(city, TimeUnit.MINUTES.toMillis(5));

        assertEquals(validData, result, "Cached weather data should be returned if it is not expired.");
    }
}