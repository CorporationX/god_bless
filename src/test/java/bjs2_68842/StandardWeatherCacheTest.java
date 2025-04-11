package bjs2_68842;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import school.faang.bjs2_68842.City;
import school.faang.bjs2_68842.FrequentUpdateWeatherCache;
import school.faang.bjs2_68842.StandardWeatherCache;
import school.faang.bjs2_68842.WeatherCacheTemplate;
import school.faang.bjs2_68842.WeatherData;
import school.faang.bjs2_68842.WeatherService;
import school.faang.bjs2_68842.WeatherServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

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
        Thread.sleep(1200);
        WeatherData weatherData2 = standardWeatherCache.getWeatherData(City.MOSCOW, 650);
        assertEquals(weatherData, weatherData2);
    }

    @Test
    public void getWeatherDataFreqTest() {
        WeatherData weatherData = frequentUpdateWeatherCache.getWeatherData(City.MOSCOW, 500);
        WeatherData weatherData2 = frequentUpdateWeatherCache.getWeatherData(City.MOSCOW, 77000);
        assertNotEquals(weatherData, weatherData2);
    }

    @Test
    public void clearExpiredCacheTest() throws InterruptedException {
        WeatherData weatherData = standardWeatherCache.getWeatherData(City.MOSCOW, 1000);
        System.out.println(weatherData);
        WeatherData weatherData2 = standardWeatherCache.getWeatherData(City.NY, 500);
        System.out.println(weatherData2);
        Thread.sleep(1000);
        standardWeatherCache.clearExpiredCache(1800);
        WeatherData weatherData3 = standardWeatherCache.getWeatherData(City.MOSCOW, 1000);
        System.out.println(weatherData3);
        WeatherData weatherData4 = standardWeatherCache.getWeatherData(City.NY, 500);
        System.out.println(weatherData4);
        assertNotEquals(weatherData, weatherData3);
        assertNotEquals(weatherData2, weatherData4);
    }
}
