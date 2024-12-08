import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.bjs244827.cache.FrequentUpdateWeatherCache;
import school.faang.bjs244827.cache.StandardWeatherCache;
import school.faang.bjs244827.cache.WeatherCacheTemplate;
import school.faang.bjs244827.model.WeatherData;
import school.faang.bjs244827.service.WeatherProvider;
import school.faang.bjs244827.service.WeatherService;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherCacheTest {

    private WeatherProvider weatherService;

    @BeforeEach
    void setUp() {
        weatherService = new WeatherService();
    }

    @Test
    public void test_StandardWeatherCache() {
        WeatherCacheTemplate cache = new StandardWeatherCache(weatherService);

        WeatherData data1 = cache.getWeatherData("Tashkent", 1000);
        assertNotNull(data1);
        assertEquals(data1, cache.getCache().get("Tashkent"));

        // Данные не обновятся, так как они актуальны в течение 1 секунды
        WeatherData data2 = cache.getWeatherData("Tashkent", 1000);
        assertEquals(data1.temp(), data2.temp());

        // Ждем больше 1 секунды, чтобы данные устарели
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            //
        }

        // Теперь данные должны обновиться
        WeatherData data3 = cache.getWeatherData("Tashkent", 1000);
        assertNotEquals(data1.temp(), data3.temp());

    }

    @Test
    public void test_clearCache() {
        WeatherCacheTemplate cache = new StandardWeatherCache(weatherService);
        cache.getWeatherData("Tashkent", 1000);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        cache.clearExpiredCache(1000);
        assertTrue(cache.getCache().isEmpty());
    }

    @Test
    public void test_FrequentUpdateWeatherCache() {
        FrequentUpdateWeatherCache cache = new FrequentUpdateWeatherCache(weatherService);

        WeatherData data1 = cache.getWeatherData("Tashkent", 1000);
        assertEquals(data1, cache.getCache().get("Tashkent"));

        WeatherData data2 = cache.getWeatherData("Tashkent", 1000);
        assertNotEquals(data1.temp(), data2.temp());
    }


}
