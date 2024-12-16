package faang.school.godbless.sprint_2.task_44862.weather_cache;

import faang.school.godbless.sprint_2.task_44862.WeatherData;
import faang.school.godbless.sprint_2.task_44862.WeatherService;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class StandardWeatherCacheTest {

    public final Map<String, WeatherData> weatherDataTest = new HashMap<>() {{
            put("Moscow", new WeatherService().fetchWeatherData("Moscow"));
            put("Samara", new WeatherService().fetchWeatherData("Samara"));
        }};

    private final StandardWeatherCache standardWeatherCache = new StandardWeatherCache();

    @Test
    void testGetWeatherData() {
        assertEquals(0, standardWeatherCache.getWeatherData().size());

        WeatherData moscowWeatherData = standardWeatherCache.getWeatherData("Moscow", null);
        WeatherData samaraWeatherData = standardWeatherCache.getWeatherData("Samara", null);

        assertEquals(weatherDataTest.get("Moscow").getCity(), moscowWeatherData.getCity());
        assertEquals(weatherDataTest.get("Samara").getCity(), samaraWeatherData.getCity());

        try {
            Thread.sleep(4_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WeatherData newMoscowWeatherData = standardWeatherCache.getWeatherData("Moscow", null);
        WeatherData newSamaraWeatherData = standardWeatherCache.getWeatherData("Samara", null);

        assertNotEquals(moscowWeatherData, newMoscowWeatherData);
        assertNotEquals(samaraWeatherData, newSamaraWeatherData);
        assertEquals(2, standardWeatherCache.getWeatherData().size());
    }
}