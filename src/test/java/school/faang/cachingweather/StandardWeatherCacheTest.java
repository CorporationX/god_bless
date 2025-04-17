package school.faang.cachingweather;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.stream1.cachingweather.StandardWeatherCache;
import school.faang.stream1.cachingweather.WeatherData;

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

        standardWeatherCache.getWeatherData(city);

        assertTrue(standardWeatherCache.getCityWeather().containsKey(city));
    }

    @Test
    void isCacheExpiredTest() {
        String city1 = "Rostov-on-Don";
        String city2 = "Novocherkassk";
        WeatherData weatherData1 = standardWeatherCache.getWeatherData(city1);
        WeatherData weatherData2 = standardWeatherCache.getWeatherData(city2);
        weatherData1.setTimestamp(System.currentTimeMillis() - 6001);

        assertTrue(standardWeatherCache.isCacheExpired(weatherData1));
        assertFalse(standardWeatherCache.isCacheExpired(weatherData2));
    }

    @Test
    void clearExpiredCacheTest() {
        String city1 = "Rostov-on-Don";
        String city2 = "Novocherkassk";
        WeatherData weatherData1 = standardWeatherCache.getWeatherData(city1);
        WeatherData weatherData2 = standardWeatherCache.getWeatherData(city2);
        weatherData1.setTimestamp(System.currentTimeMillis() - 6001);

        standardWeatherCache.clearExpiredCache();

        assertFalse(standardWeatherCache.getCityWeather().containsKey(city1));
        assertTrue(standardWeatherCache.getCityWeather().containsKey(city2));
    }

    @Test
    void getWeatherDataTest() {
        String city1 = "Voronezh";
        String city2 = "Rostov-on-Don";

        WeatherData weatherData2 = standardWeatherCache.getWeatherData(city2);
        WeatherData weatherData1 = standardWeatherCache.getWeatherData(city1);

        assertTrue(weatherData2.getTimestamp() <= weatherData1.getTimestamp());

        weatherData2.setTimestamp(System.currentTimeMillis() - 8001);
        weatherData1.setTimestamp(System.currentTimeMillis());
        WeatherData weatherData2New = standardWeatherCache.getWeatherData(city2);
        WeatherData weatherData1New = standardWeatherCache.getWeatherData(city1);

        assertFalse(weatherData2New.getTimestamp() < weatherData1New.getTimestamp());
    }
}