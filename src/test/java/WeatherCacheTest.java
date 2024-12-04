import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.task_44821.City;
import school.faang.task_44821.FrequentUpdateWeatherCache;
import school.faang.task_44821.StandardWeatherCache;
import school.faang.task_44821.WeatherData;
import school.faang.task_44821.WeatherProvider;
import school.faang.task_44821.WeatherService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class WeatherCacheTest {
    private WeatherProvider weatherProvider;

    @BeforeEach
    void setUp() {
        weatherProvider = new WeatherService();
    }

    @Test
    void testWeatherCache_StandardWeatherCachePositive() {
        long maxCacheAgeMillis = 5000;
        StandardWeatherCache standardWeatherCache = new StandardWeatherCache(weatherProvider, maxCacheAgeMillis);

        City city = City.KAZAN;

        WeatherData firstWeatherData = standardWeatherCache.getWeatherData(city);
        WeatherData secondWeatherData = standardWeatherCache.getWeatherData(city);

        assertEquals(firstWeatherData, secondWeatherData);
    }

    @Test
    void testWeatherCache_StandardWeatherCacheNegative() {
        long maxCacheAgeMillis = 5000;
        StandardWeatherCache standardWeatherCache = new StandardWeatherCache(weatherProvider, maxCacheAgeMillis);

        City city1 = City.KAZAN;
        City city2 = City.MOSCOW;

        WeatherData firstWeatherData = standardWeatherCache.getWeatherData(city1);
        WeatherData secondWeatherData = standardWeatherCache.getWeatherData(city2);

        assertNotEquals(firstWeatherData, secondWeatherData);
    }

    @Test
    void testWeatherCache_FrequentUpdateWeatherCachePositive() {
        FrequentUpdateWeatherCache frequentUpdateWeatherCache = new FrequentUpdateWeatherCache(weatherProvider);

        City city = City.KAZAN;

        WeatherData firstWeatherData = frequentUpdateWeatherCache.getWeatherData(city);
        WeatherData secondWeatherData = frequentUpdateWeatherCache.getWeatherData(city);

        assertEquals(firstWeatherData, secondWeatherData);
    }
}
