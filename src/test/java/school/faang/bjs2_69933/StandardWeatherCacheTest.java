package school.faang.bjs2_69933;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StandardWeatherCacheTest {
    StandardWeatherCache stdWeatherCash = new StandardWeatherCache();

    @Test
    public void testIsCacheExpired() {
        // arrange
        WeatherData weatherData = stdWeatherCash.getWeatherData("Moscow", 1);
        // act
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        boolean result = stdWeatherCash.isCacheExpired(weatherData, 1);
        // assert
        Assertions.assertTrue(result);
    }

    @Test
    public void testGetWeatherData()  {
        // arrange
        int expectedResult = 1;
        // act
        stdWeatherCash.getWeatherData("Moscow", 1);
        // assert
        Assertions.assertEquals(expectedResult, stdWeatherCash.weatherCash.size());
    }

    @Test
    public void testForceUpdateWeather() {
        // arrange
        stdWeatherCash.getWeatherData("Cheboksary", 7_000);
        long resultBefore = stdWeatherCash.weatherCash.get("Cheboksary").getTimestamp();
        // act
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        stdWeatherCash.forceUpdateWeather("Cheboksary");
        long resultAfter = stdWeatherCash.weatherCash.get("Cheboksary").getTimestamp();
        // assert
        Assertions.assertNotEquals(resultBefore, resultAfter);
    }

    @Test
    public void testClearExpiredCache() {
        // arrange
        stdWeatherCash.getWeatherData("Cheboksary", 7_000);
        long resultBefore = stdWeatherCash.weatherCash.get("Cheboksary").getTimestamp();
        // act
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        stdWeatherCash.clearExpiredCache(1);
        // assert
        Assertions.assertNull(stdWeatherCash.weatherCash.get("Cheboksary"));
    }
}
