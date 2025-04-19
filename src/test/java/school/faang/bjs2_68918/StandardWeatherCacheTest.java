package school.faang.bjs2_68918;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class StandardWeatherCacheTest {
    private StandardWeatherCache standardWeatherCache;
    WeatherData weatherData1;
    WeatherData weatherData2;
    WeatherData weatherData3;
    WeatherData weatherData4;
    WeatherData weatherData5;

    @BeforeEach
    void setUp() {
        standardWeatherCache = new StandardWeatherCache();
    }

    @Test
    void testGetWeatherData() throws InterruptedException {
        /*
         * Второй вызов метода через 50мс после первого (раньше TTL кэша) - результат из кэша
         * Третий вызов метода через 150мс после первого (позже TTL кэша) - чистый вызов провайдера
         */
        weatherData1 = standardWeatherCache.getWeatherData("Москва", 0);
        TimeUnit.MILLISECONDS.sleep(50);
        weatherData2 = standardWeatherCache.getWeatherData("Москва", 100);
        TimeUnit.MILLISECONDS.sleep(100);
        weatherData3 = standardWeatherCache.getWeatherData("Москва", 100);

        //проверяем что второе значение вернулось из кэша
        assertEquals(weatherData1, weatherData2);
        //проверяем что третье значение получено от провайдера
        assertNotEquals(weatherData1, weatherData3);
    }

    @Test
    void testClearExpiredCache() throws InterruptedException {
        /*
         * Второй вызов метода через 50мс после первого (раньше TTL кэша) - результат из кэша
         * Третий вызов метода через 200мс после первого (раньше TTL кэша), после очистки кэша - чистый вызов провайдера
         */
        weatherData1 = standardWeatherCache.getWeatherData("Москва", 1);
        TimeUnit.MILLISECONDS.sleep(50);
        weatherData2 = standardWeatherCache.getWeatherData("Москва", 1000);
        TimeUnit.MILLISECONDS.sleep(100);
        weatherData4 = standardWeatherCache.getWeatherData("Санкт-Петербург", 1);
        standardWeatherCache.clearExpiredCache(50);
        weatherData3 = standardWeatherCache.getWeatherData("Москва", 1000);
        weatherData5 = standardWeatherCache.getWeatherData("Санкт-Петербург", 1000);

        //проверяем что второе значение вернулось из кэша
        assertEquals(weatherData1, weatherData2);
        //проверяем что третье значение получено от провайдера
        assertNotEquals(weatherData1, weatherData3);
        //проверяем что, был удален только истекший кэш для Москвы
        assertEquals(weatherData4, weatherData5);
    }
}
