package school.faang.cache.cachetemplate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.cache.WeatherData;
import school.faang.cache.WeatherService;

import static org.junit.jupiter.api.Assertions.*;

class FrequentUpdateWeatherCacheTest {
    private WeatherCacheTemplate weatherCacheTemplate;

    @BeforeEach
    void setUp() {
        weatherCacheTemplate = new FrequentUpdateWeatherCache(new WeatherService());
    }

    @Test
    public void shouldCorrectlyAddDataIfDataNotExist() {
        weatherCacheTemplate.getWeatherData("Toronto", 10000);

        assertTrue(weatherCacheTemplate.getCityWeathers().containsKey("Toronto"));
    }

    @Test
    public void shouldCacheAlwaysBeExpired() {
        WeatherData data = weatherCacheTemplate.getWeatherData("Toronto", 1000000);

        assertTrue(weatherCacheTemplate.isCacheExpired(data, 1000000));
    }

    @Test
    public void shouldClearExpiredCache() {
        WeatherData data = weatherCacheTemplate.getWeatherData("Toronto", 1000000);

        weatherCacheTemplate.clearExpiredCache(1000000);

        assertFalse(weatherCacheTemplate.getCityWeathers().containsKey(data.getCity()));
    }

    @Test
    public void shouldUpdateIfDataExpired() {
        WeatherData data = weatherCacheTemplate.getWeatherData("Toronto", 1000000);
        WeatherData newData = weatherCacheTemplate.getWeatherData("Toronto", 1000000);

        assertNotEquals(data.getTemperature(), newData.getTemperature());
        assertNotEquals(data.getHumidity(), newData.getHumidity());
    }
}