package school.faang.bjs2_79765;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MyTest {

    @Mock
    private WeatherService weatherService;

    @InjectMocks
    private StandardWeatherCache standardCache;

    @InjectMocks
    private FrequentUpdateWeatherCache frequentCache;

    @Test
    public void shouldReturnWeatherDataWhenInCache() {
        long maxCacheAgeMillis = 10000L;
        long fixedTime = System.currentTimeMillis();
        String city = "Петергоф";

        WeatherData generateData = new WeatherData(city, 15, 60, fixedTime);

        standardCache.getWeatherInCity().put(city, generateData);
        WeatherData result = standardCache.getWeatherData(city, maxCacheAgeMillis);

        assertEquals(generateData, result);
        verify(weatherService, never()).fetchWeatherData(eq(city));

    }

    @Test
    public void shouldReturnWeatherDataWhenCacheIsEmpty() {
        long maxCacheAgeMillis = 10000L;
        long fixedTime = System.currentTimeMillis();

        String city = "Петергоф";
        WeatherData generateData = new WeatherData(city, 15, 60, fixedTime);

        when(weatherService.fetchWeatherData(city)).thenReturn(generateData);

        WeatherData result = standardCache.getWeatherData(city, maxCacheAgeMillis);

        assertNotNull(result);
        assertEquals(generateData, result);
        verify(weatherService, times(1)).fetchWeatherData(eq(city));
        assertEquals(generateData, standardCache.getWeatherInCity().get(city));
    }

    @Test
    public void shouldReturnWeatherDataWhenNotExpired() {
        long maxCacheAgeMillis = 10_000L;
        long fixedTime = System.currentTimeMillis();

        String city = "Петергоф";
        WeatherData generateData = new WeatherData(city, 15, 60, fixedTime);

        standardCache.getWeatherInCity().put(city, generateData);

        WeatherData result = standardCache.getWeatherData(city, maxCacheAgeMillis);

        assertEquals(generateData, result);
        verify(weatherService, never()).fetchWeatherData(city);
    }

    @Test
    public void shouldReturnWeatherDataWhenExpired() {
        long maxCacheAgeMillis = 10L;
        long fixedTime = System.currentTimeMillis() - 5_000;

        String city = "Петергоф";
        WeatherData generateData = new WeatherData(city, 15, 60, fixedTime);
        WeatherData freshData = new WeatherData(city, 20, 65, System.currentTimeMillis());

        when(weatherService.fetchWeatherData(city)).thenReturn(freshData);
        standardCache.getWeatherInCity().put(city, generateData);

        WeatherData result = standardCache.getWeatherData(city, maxCacheAgeMillis);

        assertEquals(freshData, result);
        verify(weatherService, times(1)).fetchWeatherData(city);
        assertEquals(freshData, standardCache.getWeatherInCity().get(city));
    }

    @Test
    public void shouldAlwaysUpdateForFrequentCache() {
        long maxCacheAgeMillis = 10L;
        long fixedTime = System.currentTimeMillis();

        String city = "Петергоф";
        WeatherData generateData = new WeatherData(city, 15, 60, fixedTime);
        WeatherData freshData = new WeatherData(city, 20, 65, System.currentTimeMillis());

        when(weatherService.fetchWeatherData(city)).thenReturn(freshData);
        frequentCache.getWeatherInCity().put(city, generateData);

        WeatherData result = frequentCache.getWeatherData(city, maxCacheAgeMillis);

        assertEquals(freshData, result);
        verify(weatherService, times(1)).fetchWeatherData(city);
        assertEquals(freshData, frequentCache.getWeatherInCity().get(city));
    }

    @Test
    public void shouldUpdateWhenCacheExactlyExpired() {
        long maxCacheAgeMillis = 10L;
        long fixedTime = System.currentTimeMillis() - maxCacheAgeMillis;

        String city = "Петергоф";
        WeatherData generateData = new WeatherData(city, 15, 60, fixedTime);

        standardCache.getWeatherInCity().put(city, generateData);

        WeatherData result = standardCache.getWeatherData(city, maxCacheAgeMillis);

        assertEquals(generateData, result);
        verify(weatherService, never()).fetchWeatherData(city);
    }

    @Test
    public void shouldClearExpiredCache() {
        long maxCacheAgeMillis = 10_000L;
        long fixedTime = System.currentTimeMillis();

        String city1 = "Петергоф";
        String city2 = "Санкт-Петербург";

        WeatherData expiredData = new WeatherData(city1, 14, 60, fixedTime - 15_000);
        WeatherData validData = new WeatherData(city2, 16, 65, fixedTime);

        standardCache.getWeatherInCity().put(city1, expiredData);
        standardCache.getWeatherInCity().put(city2, validData);

        standardCache.clearExpiredCache(maxCacheAgeMillis);

        assertNull(standardCache.getWeatherInCity().get(city1));
        assertNotNull(standardCache.getWeatherInCity().get(city2));
    }

    @Test
    public void shouldClearExpiredEmptyCache() {
        long maxCacheAgeMillis = 10_000L;

        standardCache.clearExpiredCache(maxCacheAgeMillis);

        assertTrue(standardCache.getWeatherInCity().isEmpty());
    }
}
