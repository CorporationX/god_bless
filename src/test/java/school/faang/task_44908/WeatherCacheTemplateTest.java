package school.faang.task_44908;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WeatherCacheTemplateTest {
    private WeatherCacheTemplate standardWeatherCache;
    private WeatherCacheTemplate frequentUpdateWeatherCache;

    @BeforeEach
    void setUp() {
        WeatherProvider weatherProvider = new WeatherService();
        standardWeatherCache = new StandardWeatherCache(weatherProvider);
        frequentUpdateWeatherCache = new FrequentUpdateWeatherCache(weatherProvider, 1000);
    }

    @Test
    @DisplayName("WeatherCacheTemplate: should fetch new data if cache is empty")
    void weatherCacheTemplate_shouldFetchNewDataIfCacheIsEmpty() {
        // Act
        standardWeatherCache.clearExpiredCache(2000);
        WeatherData fetchedWeatherData = standardWeatherCache.getWeatherData("New York");

        // Assert
        assertAll("Weather Cache Fetching",
                () -> assertNotNull(fetchedWeatherData, "Fetched data should not be null"),
                () -> assertEquals("New York", fetchedWeatherData.getCity(), "Cities should match"),
                () -> assertTrue(fetchedWeatherData.getTemperature() > -100,
                        "Temperature should be a reasonable value")
        );
    }

    @Test
    @DisplayName("StandardWeatherCache: should return cached data if fresh")
    void standardWeatherCache_shouldReturnCachedDataIfFresh() {
        // Act
        WeatherData initialWeatherData = standardWeatherCache.getWeatherData("New York");
        WeatherData cachedWeatherData = standardWeatherCache.getWeatherData("New York");

        // Assert
        assertAll("Standard Weather Cache",
                () -> assertNotNull(cachedWeatherData, "Data should be not null"),
                () -> assertEquals(initialWeatherData.getCity(), cachedWeatherData.getCity(), "Cities should match"),
                () -> assertEquals(initialWeatherData.getTemperature(), cachedWeatherData.getTemperature(),
                        "Temperatures should match")
        );
    }

    @Test
    @DisplayName("FrequentUpdateWeatherCache: should update data when cache expires")
    void frequentUpdateWeatherCache_shouldUpdateDataWhenCacheExpires() throws InterruptedException {
        // Act
        WeatherData initialWeatherData = frequentUpdateWeatherCache.getWeatherData("Seattle");
        Thread.sleep(1500);
        WeatherData updatedWeatherData = frequentUpdateWeatherCache.getWeatherData("Seattle");

        // Assert
        assertAll("Frequent Update Weather Cache",
                () -> assertNotNull(initialWeatherData, "Initial data should be not null"),
                () -> assertNotNull(updatedWeatherData, "Updated data should be not null"),
                () -> assertNotEquals(initialWeatherData.getTimestamp(), updatedWeatherData.getTimestamp(),
                        "Timestamps should not match (data should be updated)")
        );
    }

    @Test
    @DisplayName("WeatherCacheTemplate: should not fetch new data if cache is fresh")
    void weatherCacheTemplate_shouldNotFetchNewDataIfCacheIsFresh() {
        // Act
        WeatherData initialWeatherData = standardWeatherCache.getWeatherData("New York");
        WeatherData cachedWeatherData = standardWeatherCache.getWeatherData("New York");

        // Assert
        assertAll("Weather Cache Freshness",
                () -> assertNotNull(initialWeatherData, "Initial data should be not null"),
                () -> assertNotNull(cachedWeatherData, "Cached data should be not null"),
                () -> assertEquals(initialWeatherData.getCity(), cachedWeatherData.getCity(), "Cities should match"),
                () -> assertEquals(initialWeatherData.getTemperature(), cachedWeatherData.getTemperature(),
                        "Temperatures should match")
        );
    }

    @Test
    @DisplayName("WeatherCacheTemplate: should clear expired cache entries")
    void weatherCacheTemplate_shouldClearExpiredCacheEntries() throws InterruptedException {
        // Act
        standardWeatherCache.getWeatherData("New York");
        Thread.sleep(3000);
        standardWeatherCache.clearExpiredCache(2000);

        // Assert
        assertTrue(standardWeatherCache.isEmpty(), "Cache should be empty after clearing expired data");
    }
}