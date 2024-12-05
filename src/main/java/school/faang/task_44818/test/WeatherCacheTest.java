package school.faang.task_44818.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.task_44818.*;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherCacheTest {

    private WeatherProvider weatherService;

    @BeforeEach
    void setUp() {
        weatherService = new WeatherService();
    }

    @Test
    void testStandardWeatherCache() {
        WeatherCacheTemplate cache = new StandardWeatherCache(weatherService);

        // Получаем данные для города "Moscow"
        WeatherData data1 = cache.getWeatherData("Moscow", 1000);
        assertNotNull(data1);
        assertEquals("Moscow", data1.getCity());

        // Данные не обновятся, так как они актуальны в течение 1 секунды
        WeatherData data2 = cache.getWeatherData("Moscow", 1000);
        assertEquals(data1.getTemperature(), data2.getTemperature());

        // Ждем больше 1 секунды, чтобы данные устарели
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            //
        }

        // Теперь данные должны обновиться
        WeatherData data3 = cache.getWeatherData("Moscow", 1000);
        assertNotEquals(data1.getTemperature(), data3.getTemperature());
    }

    @Test
    void testFrequentUpdateWeatherCache() {
        WeatherCacheTemplate cache = new FrequentUpdateWeatherCache(weatherService);

        // Получаем данные для города "London"
        WeatherData data1 = cache.getWeatherData("London", 1000);
        assertNotNull(data1);

        // Данные обновляются каждый раз
        WeatherData data2 = cache.getWeatherData("London", 1000);
        assertNotEquals(data1.getTemperature(), data2.getTemperature());
    }

    @Test
    void testClearExpiredCache() {
        WeatherCacheTemplate cache = new StandardWeatherCache(weatherService);

        // Получаем данные для города "Paris"
        cache.getWeatherData("Paris", 1000);

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            //
        }
        // Должны очистить устаревшие данные
        cache.clearExpiredCache(1000);

        // После очистки данных в кэше не будет
        assertNull(cache.getCache().get("Paris"));
    }
}