package bjs2_68842;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import school.faang.bjs2_68842.City;
import school.faang.bjs2_68842.FrequentUpdateWeatherCache;
import school.faang.bjs2_68842.StandardWeatherCache;
import school.faang.bjs2_68842.WeatherCacheTemplate;
import school.faang.bjs2_68842.WeatherData;
import school.faang.bjs2_68842.WeatherService;
import school.faang.bjs2_68842.WeatherServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class StandardWeatherCacheTest {
    private WeatherServiceImpl weatherService;

    private WeatherCacheTemplate standardWeatherCache;
    private WeatherCacheTemplate frequentUpdateWeatherCache;

    @BeforeEach
    public void init() {
        weatherService = new WeatherService();
        standardWeatherCache = new StandardWeatherCache(weatherService);
        frequentUpdateWeatherCache = new FrequentUpdateWeatherCache(weatherService);
    }

    @Test
    public void getWeatherDataStrTest() throws InterruptedException {
        WeatherData weatherData = standardWeatherCache.getWeatherData(City.MOSCOW, 500);
        assertNotNull(weatherData);
        WeatherData weatherData2 = standardWeatherCache.getWeatherData(City.MOSCOW, 650);
        assertNotNull(weatherData2);
        assertEquals(weatherData, weatherData2);
        Thread.sleep(1200);
        weatherData2 = standardWeatherCache.getWeatherData(City.MOSCOW, 500);
        assertNotEquals(weatherData, weatherData2);
    }

    @Test
    public void getWeatherDataFreqTest() {
        WeatherData weatherData = frequentUpdateWeatherCache.getWeatherData(City.MOSCOW, 500);
        assertNotNull(weatherData);
        assertTrue(frequentUpdateWeatherCache.isCacheExpired(weatherData, 500));
        WeatherData weatherData2 = frequentUpdateWeatherCache.getWeatherData(City.MOSCOW, 77000);
        assertNotEquals(weatherData, weatherData2);
    }

    @Test
    public void shouldCorrectlyAddDataIfDataNotExist() {
        frequentUpdateWeatherCache.getWeatherData(City.ISTANBUL, 800);
        assertTrue(frequentUpdateWeatherCache.getWeatherInfo().containsKey(City.ISTANBUL));
    }

    @Test
    void forceUpdateWorksForAllCaches() {
        WeatherData first = standardWeatherCache.getWeatherData(City.MOSCOW, 1000);
        WeatherData second = standardWeatherCache.getWeatherData(City.MOSCOW, 1000);
        assertEquals(first, second);
        second = standardWeatherCache.forceUpdateWeather(City.MOSCOW);
        assertNotEquals(first, second);
    }

    @Test
    public void clearExpiredCacheTest() throws InterruptedException {
        WeatherData weatherData = standardWeatherCache.getWeatherData(City.MOSCOW, 1000);
        assertSame(weatherData, standardWeatherCache.getWeatherData(City.MOSCOW, 1800),
                "Объекты должны быть одинаковые");
        assertFalse(standardWeatherCache.isCacheExpired(weatherData, 1000));
        WeatherData weatherData2 = standardWeatherCache.getWeatherData(City.NY, 500);
        assertSame(weatherData2, standardWeatherCache.getWeatherData(City.NY, 650),
                "Объекты должны быть одинаковые");
        WeatherData weatherData3 = frequentUpdateWeatherCache.getWeatherData(City.ISTANBUL, 400);
        assertNotSame(weatherData3, frequentUpdateWeatherCache.getWeatherData(City.ISTANBUL, 400),
                "Объекты должны быть одинаковые");
        Thread.sleep(1000);
        WeatherData weatherData4 = frequentUpdateWeatherCache.getWeatherData(City.ZURICH, 700);
        assertNotSame(weatherData4, frequentUpdateWeatherCache.getWeatherData(City.ZURICH, 900),
                "Объекты должны быть одинаковые");

        Thread.sleep(1000);
        standardWeatherCache.clearExpiredCache(1900);

        assertNotEquals(weatherData, standardWeatherCache.getWeatherData(City.MOSCOW, 1000));
        assertNotEquals(weatherData2, standardWeatherCache.getWeatherData(City.NY, 500));
        assertNotEquals(weatherData3, standardWeatherCache.getWeatherData(City.ISTANBUL, 400));
        assertNotEquals(weatherData4, standardWeatherCache.getWeatherData(City.ZURICH, 700));
    }
}
