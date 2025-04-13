import cachecache.FrequentUpdateWeatherCache;
import cachecache.StandardWeatherCache;
import cachecache.WeatherCacheTemplate;
import cachecache.WeatherData;
import cachecache.WeatherProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

public class WeatherCacheTest {
    private WeatherProvider testProvider;

    @BeforeEach
    void setUp() {
        testProvider = city -> new WeatherData(city, 25.0, 50.0, System.currentTimeMillis());
    }

    @Test
    void testStandardCache_UsesCachedDataWhenFresh() throws InterruptedException {
        WeatherCacheTemplate cache = new StandardWeatherCache(testProvider);

        WeatherData data1 = cache.getWeatherData("London", 10000);
        Thread.sleep(100);
        WeatherData data2 = cache.getWeatherData("London", 10000);

        assertSame(data1, data2, "Должны быть возвращены те же данные из кэша");
    }

    @Test
    void testStandardCache_RefreshesWhenExpired() throws InterruptedException {
        WeatherCacheTemplate cache = new StandardWeatherCache(testProvider);

        WeatherData data1 = cache.getWeatherData("London", 100);
        Thread.sleep(200);
        WeatherData data2 = cache.getWeatherData("London", 100);

        assertNotSame(data1, data2, "Должны быть получены новые данные после истечения срока");
    }

    @Test
    void testFrequentCache_AlwaysRefreshes() {
        WeatherCacheTemplate cache = new FrequentUpdateWeatherCache(testProvider);

        WeatherData data1 = cache.getWeatherData("London", 10000);
        WeatherData data2 = cache.getWeatherData("London", 10000);

        assertNotSame(data1, data2, "FrequentUpdateCache всегда должен запрашивать новые данные");
    }

    @Test
    void testForceUpdateWeather() {
        WeatherCacheTemplate cache = new StandardWeatherCache(testProvider);

        WeatherData data1 = cache.getWeatherData("London", 10000);
        cache.forceUpdateWeather("London");
        WeatherData data2 = cache.getWeatherData("London", 10000);

        assertNotSame(data1, data2, "forceUpdate должен принудительно обновлять данные");
    }

    @Test
    void testClearExpiredCache_RemovesOnlyExpired() throws InterruptedException {
        WeatherCacheTemplate cache = new StandardWeatherCache(testProvider);

        cache.getWeatherData("London", 10000);
        Thread.sleep(5);
        cache.getWeatherData("Paris", 1);

        Thread.sleep(10);
        cache.clearExpiredCache(5);

        WeatherData london = cache.getWeatherData("London", 10000);
        WeatherData paris = cache.getWeatherData("Paris", 10000);

        assertNotNull(london);
        assertNotNull(paris);
        assertNotSame(london, paris, "Париж должен быть заново загружен после очистки кэша");
    }


}
