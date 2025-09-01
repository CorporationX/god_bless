package school.faang.weather;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FrequentUpdateWeatherCacheTest {

    private final WeatherCacheTemplate frequentUpdateWeatherCache = new FrequentUpdateWeatherCache();

    @Test
    void testGetWeatherData() {
        long cacheAge = 10000;
        String city = "New-York";

        for (int i = 0; i < 10; i++) {
            WeatherData firstRequest = frequentUpdateWeatherCache.getWeatherData(city, cacheAge);
            WeatherData secondRequest = frequentUpdateWeatherCache.getWeatherData(city, cacheAge);

            Assertions.assertNotEquals(firstRequest, secondRequest);
        }
    }

}