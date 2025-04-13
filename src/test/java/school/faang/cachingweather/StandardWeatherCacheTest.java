package school.faang.cachingweather;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StandardWeatherCacheTest {

    StandardWeatherCache standardWeatherCache = new StandardWeatherCache();

    @BeforeEach
    void setUp() {
        standardWeatherCache = new StandardWeatherCache();
    }

    @Test
    void getWeatherTest() {
        String city = "Rostov-on-Don";

        standardWeatherCache.getWeather(city);

        assertTrue(standardWeatherCache.getCityWeather().containsKey(city));
    }

    @Test
    void isCacheExpiredTest() {
        String city1 = "Rostov-on-Don";
        String city2 = "Novocherkassk";
        WeatherData weatherData1 = standardWeatherCache.getWeather(city1);
        WeatherData weatherData2 = standardWeatherCache.getWeather(city2);
        weatherData1.setTimestamp(System.currentTimeMillis() - 6001);

        assertTrue(standardWeatherCache.isCacheExpired(weatherData1));
        assertFalse(standardWeatherCache.isCacheExpired(weatherData2));
    }

    @Test
    void clearExpiredCacheTest() {
        String city1 = "Rostov-on-Don";
        String city2 = "Novocherkassk";
        WeatherData weatherData1 = standardWeatherCache.getWeather(city1);
        WeatherData weatherData2 = standardWeatherCache.getWeather(city2);
        weatherData1.setTimestamp(System.currentTimeMillis() - 6001);

        standardWeatherCache.clearExpiredCache();

        assertFalse(standardWeatherCache.getCityWeather().containsKey(city1));
        assertTrue(standardWeatherCache.getCityWeather().containsKey(city2));
    }
}