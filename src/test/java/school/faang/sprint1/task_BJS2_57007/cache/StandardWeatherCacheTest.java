package school.faang.sprint1.task_BJS2_57007.cache;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import school.faang.sprint1.task_BJS2_57007.data.WeatherData;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class StandardWeatherCacheTest {
    private WeatherCacheTemplate standardWeatherCache = new StandardWeatherCache();
    private long timestamp;
    private String city = "Moskow";
    private long maxCacheAgeMillis = 1200L;
    private final long minValueOfMaxCache = 0L;

    @Test
    @DisplayName("Проверка получения верных данных")
    public void getWeatherData_rightWeatherData() {
        timestamp = Instant.now().toEpochMilli();
        WeatherData weatherData = standardWeatherCache.getWeatherData(city, maxCacheAgeMillis);
        assertEquals(city, weatherData.getCity());
        assertTrue(weatherData.getTimestamp() - timestamp < maxCacheAgeMillis);
    }

    @Test
    @DisplayName("Проверка получения одинаковых данных для одного города")
    public void getWeatherData_sameData() {
        timestamp = Instant.now().toEpochMilli();
        WeatherData data = standardWeatherCache.getWeatherData(city, maxCacheAgeMillis);
        WeatherData sameData = standardWeatherCache.getWeatherData(city, maxCacheAgeMillis);
        assertEquals(data, sameData);
    }

    @Test
    @DisplayName("Проверка получения разных данных для одного города")
    public void getWeatherData_anotherData() throws InterruptedException {
        timestamp = Instant.now().toEpochMilli();
        WeatherData data = standardWeatherCache.getWeatherData(city, maxCacheAgeMillis);
        Thread.sleep(maxCacheAgeMillis + 1);
        WeatherData sameData = standardWeatherCache.getWeatherData(city, maxCacheAgeMillis);
        assertNotEquals(data, sameData);
    }

    @Test
    @DisplayName("Проверка получения исключения при пустом имени города")
    public void getWeatherData_emptyCity() {
        assertThrows(IllegalArgumentException.class,
                () -> standardWeatherCache.getWeatherData(" ", maxCacheAgeMillis));
    }

    @Test
    @DisplayName("Проверка получения исключения при null имени города")
    public void getWeatherData_nullCity() {
        assertThrows(IllegalArgumentException.class,
                () -> standardWeatherCache.getWeatherData(null, maxCacheAgeMillis));
    }

    @Test
    @DisplayName("Проверка получения исключения при отрицательном времени хранения в кэше")
    public void getWeatherData_WrongMaxCacheAgeMillis() {
        assertThrows(IllegalArgumentException.class,
                () -> standardWeatherCache.getWeatherData(city, minValueOfMaxCache - 1));
    }
}