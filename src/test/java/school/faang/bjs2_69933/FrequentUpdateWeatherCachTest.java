package school.faang.bjs2_69933;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FrequentUpdateWeatherCachTest {
    private final FrequentUpdateWeatherCache freqWeatherCash = new FrequentUpdateWeatherCache();
    private final WeatherProvider weatherProvider = new WeatherService();

    @Test
    public void testIsCacheExpired() {
        // arrange

        // act
        boolean actualResult = freqWeatherCash.isCacheExpired(weatherProvider.fetchWeatherData("M"), 1);
        // assert
        Assertions.assertTrue(actualResult);
    }

    @Test
    public void testGetWeatherData()  {
        // arrange
        int expectedResult = 1;
        // act
        freqWeatherCash.getWeatherData("Cheboksary", 7_000);
        // assert
        Assertions.assertEquals(expectedResult, freqWeatherCash.weatherCash.size());
    }

    @Test
    public void testForceUpdateWeather() {
        // arrange
        freqWeatherCash.getWeatherData("Cheboksary", 7_000);
        long resultBefore = freqWeatherCash.weatherCash.get("Cheboksary").getTimestamp();
        // act
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        freqWeatherCash.forceUpdateWeather("Cheboksary");
        long resultAfter = freqWeatherCash.weatherCash.get("Cheboksary").getTimestamp();
        // assert
        Assertions.assertNotEquals(resultBefore, resultAfter);
    }

    @Test
    public void testClearExpiredCache() {
        // arrange
        freqWeatherCash.getWeatherData("Cheboksary", 7_000);
        long resultBefore = freqWeatherCash.weatherCash.get("Cheboksary").getTimestamp();
        // act
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        freqWeatherCash.clearExpiredCache(1);
        // assert
        Assertions.assertNull(freqWeatherCash.weatherCash.get("Cheboksary"));
    }
}
