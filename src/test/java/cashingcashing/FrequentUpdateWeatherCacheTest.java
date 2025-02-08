package cashingcashing;

import school.faang.cashingcashing.FrequentUpdateWeatherCache;
import school.faang.cashingcashing.WeatherData;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class FrequentUpdateWeatherCacheTest {
    private static final long MAX_CACHE_AGE_MILLIS = 200L;

    @Test
    public void testFrequentUpdateWeatherData() {
        FrequentUpdateWeatherCache fastChangingWeathers = new FrequentUpdateWeatherCache();
        WeatherData weatherData = fastChangingWeathers.getWeatherData("Moscow", MAX_CACHE_AGE_MILLIS);
        assertNotEquals(weatherData, fastChangingWeathers.getWeatherData("Moscow", MAX_CACHE_AGE_MILLIS));
    }
}
