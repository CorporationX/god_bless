package school.faang.bjs2_56865;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

class WeatherCacheTest {
    private WeatherProvider weatherProvider;
    private StandardWeatherCache standardCache;
    private FrequentUpdateWeatherCache frequentCache;

    @BeforeEach
    void setUp() {
        weatherProvider = city -> new WeatherData(city, 25.0, 60.0, System.currentTimeMillis());
        standardCache = new StandardWeatherCache(weatherProvider);
        frequentCache = new FrequentUpdateWeatherCache(weatherProvider);
    }

    @Test
    void getWeatherDataShouldReturnCachedDataIfNotExpired() {
        String city = "London";
        long cacheAgeMillis = TimeUnit.MINUTES.toMillis(5);

        WeatherData firstCall = standardCache.getWeatherData(city, cacheAgeMillis);
        WeatherData secondCall = standardCache.getWeatherData(city, cacheAgeMillis);

        assertEquals(firstCall, secondCall, "Данные должны быть одинаковыми, так как они не устарели");
    }

    @Test
    void getWeatherDataShouldUpdateDataIfExpired() throws InterruptedException {
        String city = "Paris";
        long cacheAgeMillis = 1000;

        WeatherData firstCall = standardCache.getWeatherData(city, cacheAgeMillis);
        Thread.sleep(1500);
        WeatherData secondCall = standardCache.getWeatherData(city, cacheAgeMillis);

        assertNotEquals(firstCall, secondCall, "Данные должны обновиться, так как срок кэша истек");
    }

    @Test
    void getWeatherDataFrequentUpdateCacheShouldAlwaysReturnNewData() {
        String city = "Berlin";
        long cacheAgeMillis = TimeUnit.MINUTES.toMillis(5);

        WeatherData firstCall = frequentCache.getWeatherData(city, cacheAgeMillis);
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        WeatherData secondCall = frequentCache.getWeatherData(city, cacheAgeMillis);

        assertNotEquals(firstCall, secondCall, "Часто обновляемый кэш должен всегда выдавать новые данные");
    }

    @Test
    void getWeatherDataShouldThrowExceptionWhenProviderReturnsNull() {
        WeatherProvider failingProvider = city -> null;
        StandardWeatherCache failingCache = new StandardWeatherCache(failingProvider);
        String city = "UnknownCity";
        long cacheAgeMillis = TimeUnit.MINUTES.toMillis(5);

        assertThrows(IllegalStateException.class, () -> failingCache.getWeatherData(city, cacheAgeMillis),
                "Ожидается исключение, если провайдер возвращает null");
    }


}

