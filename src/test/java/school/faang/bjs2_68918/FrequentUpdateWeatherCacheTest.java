package school.faang.bjs2_68918;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

class FrequentUpdateWeatherCacheTest {
    private FrequentUpdateWeatherCache standardWeatherCache;
    WeatherData weatherData1;
    WeatherData weatherData2;


    @BeforeEach
    void setUp() {
        standardWeatherCache = new FrequentUpdateWeatherCache();
    }

    @Test
    void testGetWeatherData() throws InterruptedException {
        /*
         * Второй вызов метода через 50мс после первого (раньше TTL кэша) - чистый запрос из провайдера
         */
        weatherData1 = standardWeatherCache.getWeatherData("Москва", 0);
        TimeUnit.MILLISECONDS.sleep(50);
        weatherData2 = standardWeatherCache.getWeatherData("Москва", 100);

        //проверяем что второе значение вернулось не из кэша
        assertNotEquals(weatherData1, weatherData2);
    }
}
