package school.faang.cache.cachetemplate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.cache.WeatherData;
import school.faang.cache.WeatherService;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StandardWeatherCacheTest {
    private WeatherCacheTemplate weatherCacheTemplate;

    @BeforeEach
    void setUp() {
        weatherCacheTemplate = new StandardWeatherCache(new WeatherService());
    }

    @Test
    public void shouldCorrectlyAddDataIfDataNotExist() {
        weatherCacheTemplate.getWeatherData("Toronto", 10000);

        assertTrue(weatherCacheTemplate.getCityWeathers().containsKey("Toronto"));
    }

    @Test
    public void shouldCacheNotBeExpired() {
        WeatherData data = weatherCacheTemplate.getWeatherData("Toronto", 100000);

        assertFalse(weatherCacheTemplate.isCacheExpired(data, 100000));
    }

    @Test
    public void shouldCacheBeExpiredIfTimeoutIsOver() {
        WeatherData data = weatherCacheTemplate.getWeatherData("Toronto", -1);

        assertTrue(weatherCacheTemplate.isCacheExpired(data, -1));
    }

    @Test
    public void shouldClearExpiredCache() {
        WeatherData data = weatherCacheTemplate.getWeatherData("Toronto", -1);

        weatherCacheTemplate.clearExpiredCache(-1);

        assertFalse(weatherCacheTemplate.getCityWeathers().containsKey(data.getCity()));
    }

    @Test
    public void shouldNotClearNotExpiredCache() {
        WeatherData data = weatherCacheTemplate.getWeatherData("Toronto", 10000);

        weatherCacheTemplate.clearExpiredCache(10000);

        assertTrue(weatherCacheTemplate.getCityWeathers().containsKey(data.getCity()));
        assertTrue(weatherCacheTemplate.getCityWeathers().get(data.getCity()).equals(data));
    }

    @Test
    public void shouldUpdateIfDataExpired() {
        WeatherData data = weatherCacheTemplate.getWeatherData("Toronto", -1);
        WeatherData newData = weatherCacheTemplate.getWeatherData("Toronto", -1);

        assertNotEquals(data.getTemperature(), newData.getTemperature());
        assertNotEquals(data.getHumidity(), newData.getHumidity());
    }
}