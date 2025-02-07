package school.faang.sprint1.task_BJS2_57007.cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import school.faang.sprint1.task_BJS2_57007.data.WeatherData;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class FrequentUpdateWeatherCacheTest {
    private WeatherCacheTemplate frequentUpdateWeatherCache;
    private long timestamp;
    private String city;
    private final long defaultCacheAgeMillis = 0L;

    @BeforeEach
    public void setUp() {
        frequentUpdateWeatherCache = new FrequentUpdateWeatherCache();
        city = "Moskow";
    }

    @Test
    @DisplayName("Проверка получения верных данных")
    public void getWeatherData_rightWeatherData() {
        timestamp = Instant.now().toEpochMilli();
        WeatherData weatherData = frequentUpdateWeatherCache.getWeatherData(city, defaultCacheAgeMillis);
        assertEquals(city, weatherData.getCity());
        assertEquals(defaultCacheAgeMillis, weatherData.getTimestamp() - timestamp);
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
    public void getWeatherData_emptyString() {
        assertThrows(IllegalArgumentException.class,
                () -> frequentUpdateWeatherCache.getWeatherData(" ", defaultCacheAgeMillis));
    }

    @Test
    @DisplayName("Проверка получения исключения при null имени города")
    public void getWeatherData_nullString() {
        assertThrows(NullPointerException.class,
                () -> frequentUpdateWeatherCache.getWeatherData(null, defaultCacheAgeMillis));
    }
}