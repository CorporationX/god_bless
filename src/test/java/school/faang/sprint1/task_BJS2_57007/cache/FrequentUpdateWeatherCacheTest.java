package school.faang.sprint1.task_BJS2_57007.cache;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import school.faang.sprint1.task_BJS2_57007.data.WeatherData;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тест класса FrequentUpdateWeatherCache")
class FrequentUpdateWeatherCacheTest {
    private WeatherCacheTemplate frequentUpdateWeatherCache = new FrequentUpdateWeatherCache();
    private long timestamp;
    private String city = "Moskow";
    private final long defaultCacheAgeMillis = 0L;

    @Test
    @DisplayName("Проверка получения верных данных")
    public void getWeatherData_rightWeatherData() {
        timestamp = Instant.now().toEpochMilli();
        WeatherData weatherData = frequentUpdateWeatherCache.getWeatherData(city, defaultCacheAgeMillis);
        assertEquals(city, weatherData.getCity());
        assertTrue(weatherData.getTimestamp() - timestamp < 5);
    }

    @Test
    @DisplayName("Проверка получения разных данных для одного города")
    public void getWeatherData_sameData() {
        timestamp = Instant.now().toEpochMilli();
        WeatherData data = frequentUpdateWeatherCache.getWeatherData(city, defaultCacheAgeMillis);
        WeatherData sameData = frequentUpdateWeatherCache.getWeatherData(city, defaultCacheAgeMillis);
        assertNotEquals(data, sameData);
    }


    @Test
    @DisplayName("Проверка получения исключения при пустом имени города")
    public void getWeatherData_emptyCity() {
        assertThrows(IllegalArgumentException.class,
                () -> frequentUpdateWeatherCache.getWeatherData(" ", defaultCacheAgeMillis));
    }

    @Test
    @DisplayName("Проверка получения исключения при null имени города")
    public void getWeatherData_nullCity() {
        assertThrows(IllegalArgumentException.class,
                () -> frequentUpdateWeatherCache.getWeatherData(null, defaultCacheAgeMillis));
    }
}