package cashingcashing;

import school.faang.cashingcashing.StandardWeatherCache;
import school.faang.cashingcashing.WeatherData;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class StandardWeatherCacheTest {
    private static final long MAX_CACHE_AGE_MILLIS = 200L;

    @Test
    public void testGetStandardWeatherData() throws InterruptedException {
        StandardWeatherCache standardWeathers = new StandardWeatherCache();
        WeatherData weatherData = standardWeathers.getWeatherData("Moscow", MAX_CACHE_AGE_MILLIS);
        assertEquals(weatherData, standardWeathers.getWeatherData("Moscow", MAX_CACHE_AGE_MILLIS));

        TimeUnit.MILLISECONDS.sleep(MAX_CACHE_AGE_MILLIS);
        assertNotEquals(weatherData, standardWeathers.getWeatherData("Moscow", MAX_CACHE_AGE_MILLIS));
    }
}
