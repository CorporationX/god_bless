package school.faang.task_44825;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StandardWeatherCacheTest {
    private final Map<String, WeatherData> data = DataInitializerUtils.initData();
    private final WeatherCacheTemplate standardWeatherCache = new StandardWeatherCache(
            data, new WeatherService()
    );

    @Test
    void shouldGetWeatherData() {
        WeatherData actualData = standardWeatherCache.getWeatherData("Moscow", 5);

        WeatherData expectedData = data.get("Moscow");

        assertEquals(expectedData, actualData);
    }
}