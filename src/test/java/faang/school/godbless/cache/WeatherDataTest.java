package faang.school.godbless.cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WeatherDataTest {
    @BeforeEach
    void setUp() {
        Main.weatherDataMap.put("london", new WeatherData("London", 21.5, 56));
        Main.weatherDataMap.put("los angeles", new WeatherData("Los Angeles", 19.6, 87));
        Main.weatherDataMap.put("amsterdam", new WeatherData("Amsterdam", 23.1, 48));
        Main.weatherDataMap.put("moscow", new WeatherData("Moscow", 21.9, 63));
    }

    @Test
    void updateCacheDataTest() {
        WeatherData previousData = new WeatherData("london", 21.5, 56);
        Main.updateCache("london");
        assertNotEquals(previousData, Main.getWeatherData("london"));
    }

    @Test
    void deleteCacheDataTest() {
        Main.deleteWeatherData("Moscow");
        assertFalse(Main.weatherDataMap.containsKey("moscow"));
    }

    @Test
    void getCitesInCache() {
        Main.getCacheInfo();
    }
}