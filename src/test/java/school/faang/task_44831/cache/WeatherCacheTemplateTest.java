package school.faang.task_44831.cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import school.faang.task_44831.entity.WeatherData;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class WeatherCacheTemplateTest {
    private WeatherCacheTemplate weatherCacheTemplate;

    @BeforeEach
    void setUp() {
        //тут следовало бы использовать мокито, но пока не готов разбиратся в нем,
        //поэтому пусть будет простенькая заглушка
        weatherCacheTemplate = new WeatherCacheTemplate() {
            @Override
            public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
                return null;
            }
        };
    }

    @Test
    void testGenerateAndSaveWeatherData() {
        String city = "San Francisco";

        WeatherData weatherData = weatherCacheTemplate.generateAndSaveWeatherData(city);

        assertNotNull(weatherData);
        assertEquals(city, weatherData.getCity());
    }

    @Test
    void testIsCacheExpired_cacheNotExpired() {
        WeatherData weatherData = new WeatherData("Sunny");
        weatherData.setTimestamp(System.currentTimeMillis());

        boolean expired = weatherCacheTemplate.isCacheExpired(weatherData, TimeUnit.MINUTES.toMillis(5));

        assertFalse(expired, "Cache should not be expired");
    }

    @Test
    void testIsCacheExpired_cacheExpired() {
        WeatherData weatherData = new WeatherData("Rainy");
        weatherData.setTimestamp(System.currentTimeMillis() - TimeUnit.MINUTES.toMillis(10));

        boolean expired = weatherCacheTemplate.isCacheExpired(weatherData, TimeUnit.MINUTES.toMillis(5));

        assertTrue(expired, "Cache should be expired");
    }

    @Test
    void testClearExpiredCache() {
        //Не уверен на сколько хорошо пользоваться protected полем, но в данном случае это самый простой вариант
        WeatherData weatherData1 = new WeatherData("City1");
        weatherData1.setTimestamp(System.currentTimeMillis() - TimeUnit.MINUTES.toMillis(10));
        WeatherData weatherData2 = new WeatherData("City2");
        weatherData2.setTimestamp(System.currentTimeMillis());

        weatherCacheTemplate.weatherDataCache.put("City1", weatherData1);
        weatherCacheTemplate.weatherDataCache.put("City2", weatherData2);

        weatherCacheTemplate.clearExpiredCache(TimeUnit.MINUTES.toMillis(5));

        assertFalse(weatherCacheTemplate.weatherDataCache.containsKey("City1"), "Expired cache should be removed.");
        assertTrue(weatherCacheTemplate.weatherDataCache.containsKey("City2"), "Non-expired cache should remain.");
    }
}