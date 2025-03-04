package school.faang.сache_cache.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.cache_cache.FrequentUpdateWeatherCache;
import school.faang.cache_cache.StandardWeatherCache;
import school.faang.cache_cache.WeatherCacheTemplate;
import school.faang.cache_cache.WeatherData;
import school.faang.cache_cache.WeatherProvider;
import school.faang.cache_cache.WeatherService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StandartWeatherCacheTest {
    WeatherCacheTemplate standSysCache;
    WeatherProvider weatherProvider;

    @BeforeEach
    void setUp(){
        //assign
        weatherProvider = new WeatherService();
        standSysCache = new StandardWeatherCache(weatherProvider);
    }

    @Test
    void testUpdateWeatherData_standCacheSys() {
        //assign
        String city = "New York";

        // act
        WeatherData updatedWeatherData = standSysCache.updateWeatherData(city);

        // assert
        assertNotNull(updatedWeatherData, "Weather data should not be null");
        assertEquals(city, updatedWeatherData.getCity(), "City name should match");
        assertTrue(updatedWeatherData.getTemperature() >= -30 && updatedWeatherData.getTemperature() <= 30, "Temperature should be within valid range");
        assertTrue(updatedWeatherData.getHumidity() >= 10 && updatedWeatherData.getHumidity() <= 90, "Humidity should be within valid range");
        assertTrue(updatedWeatherData.getTimestamp() > 0, "Timestamp should be a valid time");
    }

    @Test
    void testUpdateWeatherData_CaheIsExpired() {
        //assign
        String city = "Moscow";
        long updateTime = 1000;

        //act
        WeatherData data1 = standSysCache.getWeatherData(city, updateTime);
        assertNotNull(data1);
        WeatherData data2 =  standSysCache.getWeatherData(city, updateTime);

        //assert
        assertNotNull(data1);
        assertEquals(data1, data2);

        //act
        try {
            Thread.sleep(1000 * 2);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
        data1 = standSysCache.getWeatherData(city, updateTime);
        assertNotEquals(data1, data2);
    }

    @Test
    void testUpdateWeatherData_FreqCacheSys() {
        String city = "Tadg-Mahaal";
        WeatherCacheTemplate freqCache = new FrequentUpdateWeatherCache(weatherProvider);
        WeatherData data1 = freqCache.updateWeatherData(city);
        System.out.println(data1);
        WeatherData data2 = freqCache.updateWeatherData(city);
        System.out.println(data2);
    }

    @Test
    void testUpdateWeatherData_differentCitiesInHashMap() {
        //todo
    }
}
