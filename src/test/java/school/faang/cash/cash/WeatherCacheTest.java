package school.faang.cash.cash;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherCacheTest {

    private WeatherProvider weatherProvider;
    private StandardWeatherCache standardCache;
    private FrequentUpdateWeatherCache frequentCache;

    @BeforeEach
    void setUp() {
        weatherProvider = new WeatherService();
        standardCache = new StandardWeatherCache(weatherProvider);
        frequentCache = new FrequentUpdateWeatherCache(weatherProvider);
    }

    @Test
    void testWeatherServiceReturnsValidData() {
        WeatherData data = weatherProvider.fetchWeatherData("Moscow");

        assertNotNull(data, "Данные о погоде не должны быть null");
        assertEquals("Moscow", data.city(), "Город должен соответствовать запрошенному");
        assertTrue(data.temperature() >= -10.0 && data.temperature() <= 35.0,
                "Температура должна быть в диапазоне от -10 до 35");
        assertTrue(data.humidity() >= 10 && data.humidity() <= 100,
                "Влажность должна быть в диапазоне от 10 до 100");
        assertTrue(data.timestamp() > 0, "Временная метка должна быть положительной");
    }

    @Test
    void testStandardCacheCachesData() {
        String city = "London";

        WeatherData firstCall = standardCache.getWeatherData(city, 5000);
        WeatherData secondCall = standardCache.getWeatherData(city, 5000);

        assertSame(firstCall, secondCall, "При повторном запросе должен возвращаться кэшированный объект");
        assertEquals(firstCall.temperature(), secondCall.temperature(), 0.01,
                "Температура должна быть одинаковой");
        assertEquals(firstCall.humidity(), secondCall.humidity(), 0.01,
                "Влажность должна быть одинаковой");
    }

    @Test
    void testStandardCacheExpires() throws InterruptedException {
        String city = "Paris";
        long shortCacheTime = 100;

        WeatherData firstCall = standardCache.getWeatherData(city, shortCacheTime);
        TimeUnit.MILLISECONDS.sleep(150);
        WeatherData secondCall = standardCache.getWeatherData(city, shortCacheTime);

        assertNotSame(firstCall, secondCall, "После истечения срока кэша должен возвращаться новый объект");
    }

    @Test
    void testFrequentCacheAlwaysFetchesNewData() {
        String city = "Berlin";

        WeatherData firstCall = frequentCache.getWeatherData(city, 5000);
        WeatherData secondCall = frequentCache.getWeatherData(city, 5000);

        assertNotSame(firstCall, secondCall, "Частый кэш всегда должен возвращать новые данные");
    }

    @Test
    void testForceUpdateWeather() {
        String city = "Tokyo";

        WeatherData firstCall = standardCache.getWeatherData(city, 5000);
        WeatherData forcedUpdate = standardCache.forceUpdateWeather(city);
        WeatherData secondCall = standardCache.getWeatherData(city, 5000);

        assertNotSame(firstCall, forcedUpdate, "Принудительное обновление должно возвращать новые данные");
        assertSame(forcedUpdate, secondCall, "После принудительного обновления данные должны кэшироваться");
    }

    @Test
    void testClearExpiredCache() {
        WeatherService weatherService = new WeatherService();
        StandardWeatherCache cache = new StandardWeatherCache(weatherService);

        long currentTime = System.currentTimeMillis();
        WeatherData expiredData = new WeatherData("City1", 20.0, 50.0, currentTime - 10000);
        WeatherData freshData = new WeatherData("City2", 25.0, 60.0, currentTime - 1000);

        cache.weatherCache.put("City1", expiredData);
        cache.weatherCache.put("City2", freshData);

        cache.clearExpiredCache(5000);

        assertEquals(1, cache.weatherCache.size());
        assertTrue(cache.weatherCache.containsValue(freshData));
        assertFalse(cache.weatherCache.containsValue(expiredData));
    }

    @Test
    void testIntegrationWithDifferentCities() {
        long longCacheTime = 5000;
        WeatherData moscowData = standardCache.getWeatherData("Moscow", longCacheTime);
        WeatherData londonData = standardCache.getWeatherData("London", longCacheTime);
        WeatherData moscowDataAgain = standardCache.getWeatherData("Moscow", longCacheTime);
        WeatherData londonDataAgain = standardCache.getWeatherData("London", longCacheTime);

        assertSame(moscowData, moscowDataAgain, "Данные для Москвы должны быть закэшированы");
        assertSame(londonData, londonDataAgain, "Данные для Лондона должны быть закэшированы");
        assertNotSame(moscowData, londonData, "Данные для разных городов должны быть разными");
    }
}
