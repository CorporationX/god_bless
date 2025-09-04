package school.faang.weather;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class FrequentUpdateWeatherCacheTest {

    private final WeatherCacheTemplate frequentUpdateWeatherCache = new FrequentUpdateWeatherCache();

    @ParameterizedTest
    @ValueSource(strings = {"New-York", "London", "Tokyo"})
    void testGetWeatherDataForDifferentCities(String city) {
        long cacheAge = 10000;

        WeatherData firstRequest = frequentUpdateWeatherCache.getWeatherData(city, cacheAge);
        WeatherData secondRequest = frequentUpdateWeatherCache.getWeatherData(city, cacheAge);

        Assertions.assertNotEquals(firstRequest, secondRequest);
    }

}